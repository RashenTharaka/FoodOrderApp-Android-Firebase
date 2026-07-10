package com.example.foodorderapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.foodorderapp.Adapter.CategoryAdapter;
import com.example.foodorderapp.Adapter.SliderAdapter;
import com.example.foodorderapp.Domain.Category;
import com.example.foodorderapp.Domain.SliderItems;
import com.example.foodorderapp.R;
import com.example.foodorderapp.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use ViewBinding for layout inflation
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Use binding.getRoot()

        // Initialize category and banner data
        initCategory();
        initBanner();
        setVariable();
    }

    private void initBanner() {
        DatabaseReference myRef=database.getReference("Banners");
        binding.progressBarBanner.setVisibility(View.VISIBLE);
        ArrayList<SliderItems> items=new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        SliderItems item = issue.getValue(SliderItems.class);
                        if (item != null) {
                            items.add(item);
                        }
                    }
                    if (!items.isEmpty()) {
                        banners(items);
                    }
                }
                binding.progressBarBanner.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                binding.progressBarBanner.setVisibility(View.GONE);
            }
        });
    }

    private void banners(ArrayList<SliderItems> items){
        binding.viewpager2.setAdapter(new SliderAdapter(items,binding.viewpager2));
        binding.viewpager2.setClipChildren(false);
        binding.viewpager2.setClipToPadding(false);
        binding.viewpager2.setOffscreenPageLimit(3);
        binding.viewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        binding.viewpager2.setPageTransformer(compositePageTransformer);
    }
    private void setVariable() {

        binding.bottomMenu.setItemSelected(R.id.home,true);
        binding.bottomMenu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                if (i==R.id.cart){
                    startActivity(new Intent(MainActivity.this,CartActivity.class));
                }
            }
        });
    }

    private void initCategory() {
        // Reference to the "Category" node in Firebase Database
        DatabaseReference myRef = database.getReference("Category");

        // Show progress bar while loading data
        binding.progressBarCategory.setVisibility(View.VISIBLE);

        ArrayList<Category> list = new ArrayList<>();

        // Add a listener for single-time data retrieval
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        Category category = issue.getValue(Category.class);
                        if (category != null) {
                            list.add(category);
                        }
                    }

                    if (!list.isEmpty()) {
                        // Set up RecyclerView with GridLayout
                        binding.categoryView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                        binding.categoryView.setAdapter(new CategoryAdapter(list));
                    }

                    // Hide progress bar once data is loaded
                    binding.progressBarCategory.setVisibility(View.GONE);
                } else {
                    // Hide progress bar if no data exists
                    binding.progressBarCategory.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Log database errors
                System.out.println("Firebase Database Error: " + error.getMessage());
                binding.progressBarCategory.setVisibility(View.GONE); // Hide progress bar
            }
        });
    }
}
