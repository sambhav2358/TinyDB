# TinyDB
A simple and easy to use database library to save user data. It is very lighweight and uses on 18kb or less on the app! Also it needs minimum api level of 14 only. This means that all apps can add this!!

[![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![](https://jitpack.io/v/sambhav2358/TinyDB.svg)](https://jitpack.io/#sambhav2358/TinyDB)

## Implmentation
It is a very simple library and easy to use too. But, not only that, it is also very easy to implement.

1. Add this line to your `settings.gradle` file:
```
maven { url 'https://jitpack.io'}
```

You can also view the sample `settings.gradle` file from [here](https://github.com/sambhav2358/TinyDB/blob/main/settings.gradle).


2. Add this line to your app level `build.gradle` add this line:

```
implementation 'com.github.sambhav2358:TinyDB:1.0' // the version may change the it may not reflect here so please refer to the tag given above.
```


## Usage
As mentioned above, it is very easy to use.

In your class you can create the object like this
```
TinyDBManager tinyDB;
```
Then you can initialize it anywhere and then use it.
```
Context context = this;// provide the context here.

tinyDB = TinyDB.getInstance(context);
```
## Saving Data

You can just call one method provide the key and then the value. The rest happens by itself in the background.

This could be an example usage of saving data:
```
manger = TinyDB.getInstance(this);
manger.putInt("abc",new Random().nextInt(10000));
```

You can also view the activity file [here](https://github.com/sambhav2358/TinyDB/blob/main/app/src/main/java/com/sambhav2358/tinydb/MainActivity.java).

## Retriving data

It is very easy too! Just do this:

```
textView = findViewById(R.id.sampleTV);
manger = TinyDB.getInstance(this);
textView.setText(manger.getInt("abc",1) + "");
```

## Possible types

You can save these kind of formats to save
1. Int
2. Boolean
3. String
4. Float
5. List
6. And is none of them is what you want, just call `put` and save whatever you want and `get` to get a custom value.

## Thanks to
[Paper](https://github.com/pilgr/Paper)
