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

Request permission in Kotlin:


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

Request permission in Java:


```java
Permissions.check(MainActivityJava.this, 
        new String[]{Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE}, null, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                Toast.makeText(MainActivityJava.this, "Permission granted!", Toast.LENGTH_SHORT).show();
            }
    
            @Override
            public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                super.onDenied(context, deniedPermissions);
                Toast.makeText(MainActivityJava.this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }
        });
```