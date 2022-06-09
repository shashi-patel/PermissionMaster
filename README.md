Runtime Permission
================
[![](https://jitpack.io/v/shashi-patel/PermissionMaster.svg)](https://jitpack.io/#shashi-patel/PermissionMaster)

Gradle
------
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
        implementation 'com.github.shashi-patel:PermissionMaster:Tag'
}
```
Maven
-----
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependency>
    <groupId>com.github.shashi-patel</groupId>
    <artifactId>PermissionMaster</artifactId>
    <version>Tag</version>
</dependency>
```
Usage
-----

Declare permissions in manifest file:


```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.CAMERA" />
```

Request single runtime permission at a time:


```kotlin
Permissions.check(
        this@MainActivityKotlin,
        arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ),
        null,
        null,
        object : PermissionHandler() {
            override fun onGranted() {
                // do your task.
                Toast.makeText(this@MainActivityKotlin, "Permission granted!", Toast.LENGTH_SHORT).show()
            }

            override fun onDenied(
                context: Context?,
                deniedPermissions: java.util.ArrayList<String>?
                ) {
                    super.onDenied(context, deniedPermissions)
                    // do your task.
                    Toast.makeText(this@MainActivityKotlin, "Permission denied!", Toast.LENGTH_SHORT).show()
                }
        })
```