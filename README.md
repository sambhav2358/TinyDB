# TinyDB

[![API](https://img.shields.io/badge/API-19%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=19)
[![Latest Version](https://img.shields.io/github/v/release/sambhav2358/TinyDB.svg?label=Latest%20Version)](https://github.com/sambhav2358/TinyDB/releases)
![Repo Size](https://img.shields.io/badge/Repo%20Size-5kb-blue)
[![JitPack](https://jitpack.io/v/sambhav2358/TinyDB/month.svg)](https://jitpack.io/#sambhav2358/TinyDB)
![GitHub commits](https://img.shields.io/github/commits-since/sambhav2358/TinyDB/1.92)
![GitHub issues](https://img.shields.io/github/issues/sambhav2358/TinyDB?color=blue)
![Forks](https://img.shields.io/github/forks/sambhav2358/TinyDB?label=Forks)
![Stars](https://img.shields.io/github/stars/sambhav2358/TinyDB?label=Stars)
![State](https://img.shields.io/badge/State-working-blue)
![Code Quality](https://img.shields.io/badge/Code%20quality-A-blue)

TinyDB is a lightweight, high-performance database library for Android designed for effortless data persistence. Occupying less than **8KB**, it provides a streamlined alternative to SharedPreferences with support for multiple database instances and real-time data observers.

### Key Features
* **Ultra-Lightweight:** Minimal impact on APK size (~5KB–8KB).
* **High Compatibility:** Supports API level 19+ (covering 99.7%+ of Android devices).
* **Observer Pattern:** Built-in `ValueChangeListener` to react to data modifications.
* **Multi-Instance Support:** Maintain separate database files for different data scopes.
* **Fast Integration:** Boilerplate-free implementation.

---

## Implementation

### 1. Configure Repository

Add the JitPack repository to your `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url '[https://jitpack.io](https://jitpack.io)' }
    }
}
```

### 2. Add Dependency

Add the following line to your app-level `build.gradle`:
```gradle
dependencies {
    implementation 'com.github.sambhav2358:TinyDB:2.0.1'
}
```

### 3. Quick Start

**Initialize Database**
You can use the default instance or create a custom named database for specific use cases.

```java
// Default Instance
TinyDefaultDB defaultDB = TinyDB.getInstance().getDefaultDatabase(this);

// Custom Named Instance
TinyCustomDB customDB = TinyDB.getInstance().getCustomDatabase(this, "SettingsDB");
```

### 4. CRUD Operations

TinyDB simplifies data handling compared to the standard SharedPreferences.Editor workflow.

```java
// Saving Data (Automatic background persistence)
defaultDB.putInt("user_score", 1024);
defaultDB.putString("username", "JohnDoe");

// Retrieving Data
int score = defaultDB.getInt("user_score", 0);

// Deleting Data
defaultDB.clearKey("user_score"); // Single key
defaultDB.clearAll();             // Entire database
```

### 5. Real-time Data Observation

Implement ValueChangeListener to observe changes across your application.

```java
public class MainActivity extends AppCompatActivity implements ValueChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TinyDefaultDB db = TinyDB.getInstance().getDefaultDatabase(this);
        db.setValueChangeListener(this);
    }

    @Override
    public <E> void onValueAdded(String key, E value, String dbName) {
        // Triggered on putX() methods
    }

    @Override
    public void onKeyRemoved(String key, String dbName) {
        // Triggered on clearKey()
    }

    @Override
    public void onAllKeysRemoved(String dbName) {
        // Triggered on clearAll()
    }
}
```

### 6. Supported Data Types
---
Primitives: `Integer`, `Boolean`, `Float`, `String`

Collections: `List`

Generic Objects: Use `put()` and `get()` for custom object serialization.

### 7. Comparison: TinyDB vs. SharedPreferences
TinyDB removes the need for manual `.edit()` and `.apply()` calls, significantly reducing boilerplate code.

| Feature | Standard SharedPreferences | TinyDB |
| :--- | :--- | :--- |
| **Code Verbosity** | High (Requires Editor) | Minimal (Direct API) |
| **Change Listeners** | Manual/Complex | Native Interface |
| **Multiple Files** | Requires manual management | Instance-based |
| **Learning Curve** | Moderate | Low |

### 8. Contributions & Support

Feature Requests: Please [open](https://github.com/sambhav2358/TinyDB/issues) an Issue describing your proposed feature.

Sample App: View the [MainActivity.java](https://github.com/sambhav2358/TinyDB/blob/main/app/src/main/java/com/sambhav2358/tinydb/MainActivity.java) for a full implementation example.

### Credits

Special thanks to the [Paper](https://github.com/pilgr/Paper) project for inspiration.

### License

Free to use and modify under the terms of the project's license.

---

Built with ❤️ by [Sambhav Khandelwal](https://github.com/sambhav2358)
