<div align="center">

# 🐾 MurrNote

**Voice-first notes for Android & iOS — speak, get text, let on-device AI file it under the right topic.**

[![Kotlin](https://img.shields.io/badge/Kotlin-2.4-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.12-4285F4?logo=jetpackcompose&logoColor=white)](https://www.jetbrains.com/compose-multiplatform/)
![Android](https://img.shields.io/badge/Android-26%2B-3DDC84?logo=android&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-arm64-000000?logo=apple&logoColor=white)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

</div>

> 🚧 **Work in progress.** The project is in active development — see the [roadmap](#-roadmap).

## ✨ Idea

1. 🎙️ **Record** a voice note.
2. 📝 **Transcribe** it to text with Whisper.
3. 💾 **Save** the note locally.
4. 🧠 **Suggest a topic** from your existing ones using a small on-device language model — no data leaves the phone.

## 🧰 Tech stack

| Area | Library |
|---|---|
| UI | Compose Multiplatform, Material 3 |
| Architecture | MVI, JetBrains Lifecycle ViewModel |
| Navigation | Navigation Compose (type-safe, kotlinx-serialization) |
| Persistence | Room KMP + bundled SQLite |
| DI | Koin |
| Async | Kotlin Coroutines & Flow |
| Date/time | kotlinx-datetime |
| On-device ML | MediaPipe Tasks (audio classification, LLM inference) |
| Logging | Kermit |
| Testing | kotlin-test, kotlinx-coroutines-test, Turbine, koin-test |

## 🏗️ Architecture

Almost all code — including the UI — lives in the shared Kotlin Multiplatform module. Platform apps are thin shells.

```
androidApp ──┐                    ┌── commonMain   UI, ViewModels, Room, Koin modules
             ├──► shared ─────────┼── androidMain  Android-specific actuals, MediaPipe
iosApp ──────┘                    └── iosMain      iOS-specific actuals
```

Platform differences are isolated behind `expect`/`actual` declarations, e.g. `DatabaseFactory` decides **where** the database file lives, while the shared Koin module decides **how** it is built (bundled SQLite driver, queries on `Dispatchers.IO`).

```
Screen → ViewModel → Repository → NoteDao → Room → SQLite
                    (all wired by Koin)
```

## 📁 Project structure

```
MurrNote/
├── androidApp/        Android application (Application + MainActivity)
├── iosApp/            iOS application (SwiftUI host for the shared UI)
├── shared/
│   ├── schemas/       Exported Room schemas
│   └── src/
│       ├── commonMain/    Shared code
│       ├── androidMain/   Android actuals
│       ├── iosMain/       iOS actuals
│       └── commonTest/    Shared tests
└── gradle/libs.versions.toml   Version catalog
```

## 🚀 Getting started

**Requirements:** Android Studio (latest), JDK 17+, Xcode (for iOS).

```bash
# Android
./gradlew :androidApp:assembleDebug

# Tests
./gradlew :shared:testAndroidHostTest      # shared + Android host tests
./gradlew :shared:iosSimulatorArm64Test    # iOS simulator tests
```

**iOS:** open `iosApp/iosApp.xcodeproj` in Xcode and run.

## 🗺️ Roadmap

- [x] Kotlin Multiplatform project setup (Android + iOS)
- [x] Local database (Room) and dependency injection (Koin)
- [ ] Notes list & editor (MVI)
- [ ] Voice recording
- [ ] Speech-to-text with Whisper
- [ ] Topics
- [ ] On-device AI topic suggestions (Android)
- [ ] On-device AI topic suggestions (iOS)

## 📄 License

Distributed under the MIT License. See [`LICENSE`](LICENSE) for details.
