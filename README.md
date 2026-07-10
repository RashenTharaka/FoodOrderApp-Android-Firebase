# FoodOrderApp

FoodOrderApp is an academic Android food ordering application built with Java, Firebase Realtime Database, and Android ViewBinding. It includes an intro screen, category listing, food listing by category, food details, cart management, and basic price calculation.

## Features

- Intro / welcome screen
- Home screen with banner slider
- Food categories loaded from Firebase Realtime Database
- Food list filtered by category
- Food detail page
- Add to cart
- Increase, decrease, and remove cart items
- Cart total, tax, delivery fee, and final total calculation
- Image loading with Glide
- Bottom navigation UI

## Technologies Used

- Java
- Android SDK
- Gradle
- Firebase Realtime Database
- Firebase Analytics
- ViewBinding
- Glide
- Gson
- Chip Navigation Bar
- Material Components
- ConstraintLayout

## Project Structure

```text
FoodOrderApp/
├── app/
│   ├── src/main/java/com/example/foodorderapp/
│   │   ├── Activity/
│   │   ├── Adapter/
│   │   ├── Domain/
│   │   └── Helper/
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

## Important Firebase Note

This public repository includes a placeholder `app/google-services.json` file only to keep the project structure complete. To run the app with live Firebase data, create your own Firebase Android app and replace the placeholder file with your own `google-services.json`.

The app expects these Firebase Realtime Database nodes:

```text
Banners
Category
Foods
```

A sample database file is included here:

```text
firebase/sample-realtime-database.json
```

## How to Run

1. Download or clone this repository.
2. Open the project folder in Android Studio.
3. Let Gradle sync finish.
4. Create a Firebase project and Android app using package name:

```text
com.example.foodorderapp
```

5. Download Firebase `google-services.json`.
6. Replace this placeholder file:

```text
app/google-services.json
```

7. In Firebase Realtime Database, import:

```text
firebase/sample-realtime-database.json
```

8. Run the app on an Android emulator or Android device.

Full setup instructions are available in [`docs/INSTALLATION.md`](docs/INSTALLATION.md).

## Default Package Name

```text
com.example.foodorderapp
```

If you change the package name, update it in:

- `app/build.gradle`
- Firebase Android app settings
- `app/google-services.json`

## Notes

This is an academic project. It focuses on the mobile app UI, Firebase data loading, and cart logic. It does not include real payment processing, user authentication, or order tracking.
