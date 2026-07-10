# Installation Guide

This guide explains how another developer can download and run the FoodOrderApp project.

## Requirements

- Android Studio
- JDK 17 or Android Studio bundled JBR
- Android SDK Platform 34 or newer
- Android emulator or Android phone
- Firebase account
- Internet connection for Gradle dependencies and Firebase

## Step 1: Open Project

1. Download the project ZIP from GitHub.
2. Extract it.
3. Open Android Studio.
4. Select **File > Open**.
5. Select the root project folder named `FoodOrderApp`.
6. Wait for Gradle sync to finish.

Do not open only the `app` folder. Open the full root project folder.

## Step 2: Firebase Project Setup

1. Go to Firebase Console.
2. Create a new Firebase project.
3. Add an Android app.
4. Use this package name:

```text
com.example.foodorderapp
```

5. Download the generated `google-services.json` file.
6. Replace the placeholder file in:

```text
app/google-services.json
```

## Step 3: Realtime Database Setup

1. Open Firebase Console.
2. Go to **Build > Realtime Database**.
3. Create a Realtime Database.
4. Use test mode for development, or apply the sample rules from:

```text
firebase/database-rules.example.json
```

5. Go to the **Data** tab.
6. Import this sample database file:

```text
firebase/sample-realtime-database.json
```

The app reads these nodes:

```text
Banners
Category
Foods
```

## Step 4: Run the App

1. Start an Android emulator or connect an Android phone.
2. Click **Run** in Android Studio.
3. The app should open from `IntroActivity`.

## Common Problems

### Gradle sync fails because google-services.json is missing

Make sure this file exists:

```text
app/google-services.json
```

Replace the placeholder with the Firebase file generated for your own Firebase project.

### App opens but food/category data is empty

Check these points:

- Realtime Database is created.
- `firebase/sample-realtime-database.json` is imported.
- Database rules allow read access during development.
- `google-services.json` belongs to the same Firebase project.
- Device/emulator has internet access.

### Firebase package name mismatch

Firebase package name must match:

```text
com.example.foodorderapp
```

If the package name is changed in code, create a new Firebase Android app with the updated package name and replace `google-services.json` again.
