# TinyDB
A simple and easy to use database library to save user data. It is very lighweight and uses on 18kb or less on the app! Also it needs minimum api level of 25 only. According to Android Studio, it will work 0n 92% devices. Isn't it amazing?

  
  
  <p align="center">
  
  <a href="https://jitpack.io/#sambhav2358/TinyDB"><img src="https://jitpack.io/v/sambhav2358/TinyDB/month.svg"/></a>
  [![API](https://img.shields.io/badge/API-25%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=25)
  [![](https://jitpack.io/v/sambhav2358/TinyDB.svg)](https://jitpack.io/#sambhav2358/TinyDB)
  </p>


## Implementation
It is a very simple library and easy to use too. But, not only that, it is also very easy to implement.

1. Add this line to your `settings.gradle` file:
```
maven { url 'https://jitpack.io'}
```

You can also view the sample `settings.gradle` file from [here](https://github.com/sambhav2358/TinyDB/blob/main/settings.gradle).


2. Add this line to your app level `build.gradle` add this line:

```
implementation 'com.github.sambhav2358:TinyDB:3.0'
```

## Why do I use this instead of Shared Preferences?

I guess I need not answer it. But I will. Just compare the lines of code for you to write
``` 
//With the library
TinyDBManger manger = TinyDB.getInstance(this);
manger.putInt("abc",new Random().nextInt(10000));
```

```
//With Shred Preferences
SharedPreferences prefs = context.getSharedPreferences("TinyDBData",Context.MODE_PRIVATE );
SharedPreferences.Editor editor = prefs.edit();
editor.putString( key, value );
editor.apply();
```

Now do you get it? Dont even worry about the app size. No more than 18kb. I have measured it.

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

## Deleting a key of data
Easy peasy just call this:
```
tinyDB.clearKey(String yourKey);
```

## Deleting all the values
Just do this
```
tinyDB.clearAll();
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

## Feature request
For everyone who wants me to add a feature, just create an issue with the feature you want.


## Author

Build with ❤️ by [Sambhav Khandelwal](https://github.com/sambhav2358)
