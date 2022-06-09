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