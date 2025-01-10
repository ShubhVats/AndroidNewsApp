# Android News App

## Description

This Android application fetches and displays news articles from various sources. It leverages modern Android development practices, including Jetpack Compose for UI and Kotlin Coroutines for asynchronous operations.

## Features

* Displays a list of news articles.
* Allows navigation to individual article details using the `NewsArticleScreen` composable.
* Utilizes Kotlin serialization for data handling.

## Screenshots

<img src="https://github.com/user-attachments/assets/af08946d-23ca-4b8c-b3a1-43f19a5584a7" alt="Screenshot_20250110_155308_Android Weather App" width="200">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/user-attachments/assets/1ef25368-b5fa-4672-a7bd-f7a196399542" alt="Screenshot_20250110_155251_Android Weather App" width="200">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/b3eda380-c26c-400a-ba79-2b347fa133a3" alt="Screenshot_20250110_155308_Android Weather App" width="200">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/user-attachments/assets/8a5676d1-dc45-4850-8df1-70e3193a2943" alt="Screenshot_20250110_155251_Android Weather App" width="200">


## Technical Details

* **Jetpack Compose:** Used for building a declarative UI.
* **Kotlin Serialization:** Enables efficient serialization and deserialization of data objects like `NewsArticleScreen`.
* **Navigation:** Implements navigation between screens, likely using Jetpack Compose Navigation.
* **Coroutines:** Facilitates asynchronous operations for fetching and displaying news data.

## Project Structure

The project includes:

* `HomePageScreen`: Represents the main screen displaying the news article list.
* `NewsArticleScreen`: Displays details of a specific news article, accessed via a URL.
* `Route.kt`: Defines data classes for navigation routes, including `HomePageScreen` and `NewsArticleScreen`.

## Dependencies

The project utilizes various Jetpack libraries, including:

* `androidx.compose.ui`
* `androidx.compose.runtime`
* `androidx.compose.material3`
* `androidx.navigation:navigation-compose`
* `androidx.lifecycle:lifecycle-viewmodel-compose`

## Potential Enhancements

* Implement error handling and loading states for network requests.
* Add user authentication or personalization features.
* Integrate with a specific news API for fetching real-time data.
* Enhance UI with animations and transitions.

## Setup

1. Clone the repository: `(https://github.com/ShubhVats/AndroidNewsApp)`
2. Open the project in Android Studio.
3. Build and run the app on an emulator or device.

## Contributing

Contributions are welcome! Please feel free to submit pull requests for bug fixes, new features, or improvements.

## License

This project is licensed under the [MIT License](LICENSE).
