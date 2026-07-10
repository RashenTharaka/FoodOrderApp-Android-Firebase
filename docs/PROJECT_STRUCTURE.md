# Project Structure

```text
FoodOrderApp/
├── app/
│   ├── src/main/AndroidManifest.xml
│   ├── src/main/java/com/example/foodorderapp/
│   │   ├── Activity/
│   │   │   ├── BaseActivity.java
│   │   │   ├── IntroActivity.java
│   │   │   ├── MainActivity.java
│   │   │   ├── ListFoodActivity.java
│   │   │   ├── DetailActivity.java
│   │   │   └── CartActivity.java
│   │   ├── Adapter/
│   │   │   ├── CategoryAdapter.java
│   │   │   ├── FoodListAdapter.java
│   │   │   ├── SliderAdapter.java
│   │   │   └── CartAdapter.java
│   │   ├── Domain/
│   │   │   ├── Category.java
│   │   │   ├── Foods.java
│   │   │   └── SliderItems.java
│   │   └── Helper/
│   │       ├── ManagmentCart.java
│   │       ├── TinyDB.java
│   │       └── ChangeNumberItemsListener.java
│   ├── src/main/res/
│   ├── build.gradle
│   ├── google-services.json
│   └── google-services.example.json
├── firebase/
│   ├── sample-realtime-database.json
│   └── database-rules.example.json
├── docs/
├── gradle/
├── build.gradle
├── settings.gradle
└── README.md
```

## Main Packages

- `Activity`: Android screens.
- `Adapter`: RecyclerView and slider adapters.
- `Domain`: Data model classes used by Firebase.
- `Helper`: Cart storage and utility classes.

## Firebase Nodes

- `Banners`: Home page slider images.
- `Category`: Food category list.
- `Foods`: Food item data.
