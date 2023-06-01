# SE-Final-Project <img src="app/src/main/res/drawable/icons8_cinema_tickets_67.png" alt="app-icon" width="30" height="30"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/android/android-original.svg" alt="android" width="30" height="30"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg" alt="kotlin" width="25" height="25"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jetpackcompose/jetpackcompose-original.svg" alt="compose" width="30" height="30"/>

**Bilito** is a cinema Android app for browsing movies and cinemas and booking tickets. It was developed as a Software Engineering final project in a team with [Sarvin Nami](https://github.com/srvn-nm), [Abtin Zandi](https://github.com/Abtinz) and [Ali Noruzbeigi](https://github.com/Ali-Noroozbeigy).

The app is written in Kotlin with Jetpack Compose. It talks to the project's REST backend through Retrofit and keeps movies and the user profile in a local Room database.

## Features

* **Main Menu**: featured, latest and best movies, plus a list of cinemas.
* **Movies Page**: movie details and ticket booking.
* **Cinemas**: list of cinemas and a page for each cinema.
* **Profile**: sign up or log in, and see your profile and tickets.

## Screenshots

<table>
  <tr>
    <td valign="top" align="center">
      <img src="Project%20View/main-menu-1.jpg" width="230"/><br/><sub>Main-Menu</sub><br/><br/>
      <img src="Project%20View/movie-page-1.jpg" width="230"/><br/><sub>Movies-Page</sub>
    </td>
    <td valign="top" align="center">
      <br/><br/><br/><br/><br/><br/>
      <img src="Project%20View/main-menu-2.jpg" width="230"/><br/><sub>Main-Menu</sub><br/><br/>
      <img src="Project%20View/movie-page-2.jpg" width="230"/><br/><sub>Movies-Page</sub>
    </td>
    <td valign="top" align="center">
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <img src="Project%20View/my-profile.jpg" width="230"/><br/><sub>Profile</sub>
    </td>
  </tr>
</table>

## Tech Stack

| | Library |
| --- | --- |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg" width="20"/> | Kotlin + Coroutines |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jetpackcompose/jetpackcompose-original.svg" width="20"/> | Jetpack Compose, Navigation Compose, Paging |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/android/android-original.svg" width="20"/> | ViewModel, LiveData, Room, WorkManager |
| 🌐 | Retrofit, OkHttp, Moshi |
| 🖼️ | Coil, Glide, Lottie, Accompanist Pager |
| 🎬 | ExoPlayer |

## Project Structure

```
app/src/main/java/com/siliconvalley/bilito/
├── mainmenu/        # home screen, bottom navigation, nav graph
├── movie/           # movie page, Room cache, movie API
├── cinemalist/      # cinema list and cinema page
├── profile/         # authentication, profile, user database
└── commonServices/  # shared UI, theme, Retrofit client, network checks
```

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/Abtinz/SE-Final-Project.git
   ```
2. Open it in Android Studio.
3. Run it on a device or emulator (Android 5.0+).
