
# TinyDB
A simple and easy to use database library to save user data. It is very lighweight and uses on 8kb or less on the app! Also it needs minimum api level of 25 only. According to Android Studio, it will work 0n 92% devices. Isn't it amazing?
      
  [![API](https://img.shields.io/badge/API-19%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=19)
  [![API](https://img.shields.io/github/v/release/sambhav2358/TinyDB.svg?label=Latest%20Version)](https://img.shields.io/github/v/release/sambhav2358/TinyDB.svg?label=Latest%20Version)
  <img src="https://img.shields.io/badge/Repo%20Size-5kb-blue"/>
  <a href="https://jitpack.io/#sambhav2358/TinyDB"><img src="https://jitpack.io/v/sambhav2358/TinyDB/month.svg"/></a>
  <img src="https://img.shields.io/github/commits-since/sambhav2358/TinyDB/1.92"/>
  <img alt="GitHub issues" src="https://img.shields.io/github/issues/sambhav2358/TinyDB?color=blue">
  <a href="https://github.com/sambhav2358/TinyDB/network"><img alt="GitHub forks" src="https://img.shields.io/github/forks/sambhav2358/TinyDB?label=Forks"></a>
  <a href="https://github.com/sambhav2358/TinyDB/stargazers"><img alt="GitHub stars" src="https://img.shields.io/github/stars/sambhav2358/TinyDB?label=Stars"></a>
  <img src="https://img.shields.io/badge/State-working-blue"/>
  <img src="https://img.shields.io/badge/Code%20quality-A-blue"/>
  <img src="https://img.shields.io/badge/Built%20using-Android%20Studio-blue"/>
  <img src="https://img.shields.io/badge/Top%20language-Java-blue"/>  
  
## Recent updates

A VERY MAJOR UPDATE

You can now create multiple databases. To use the default Datatabse, just call this:
```java
public class MainActivity extends AppCompatActivity implements ValueChangeListener{

    TextView textView;
    TextView textView2;
    TinyDefaultDB defaultDB;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.sampleTV);
        textView2 = findViewById(R.id.sampleTV2);

        defaultDB = TinyDB.getInstance().getDefaultDatabase(this);

        defaultDB.setValueChangeListener(this); // this will trigger when a value will be modified ot deleted
        defaultDB.putInt("abc",new Random().nextInt(10000));
        textView.setText(defaultDB.getInt("abc",1)+ "");
    }

    @Override
    public <E> void onValueAdded(String key, E value, String dbName) {
    }

    @Override
    public void onKeyRemoved(String key, String dbName) {
    }

    @Override
    public void onAllKeysRemoved(String dbName) {
    }
}
```

This will store the values in the default database, but, you want to store the different values in the same key right, so, for that, create another custom database like this:
```java
public class MainActivity extends AppCompatActivity implements ValueChangeListener{

    TextView textView;
    TextView textView2;
    TinyCustomDB customDB;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.sampleTV);
        textView2 = findViewById(R.id.sampleTV2);

        customDB = TinyDB.getInstance().getCustomDatabase(this, "MyCustomDBName");

        customDB.setValueChangeListener(this); // this will trigger when a value will be modified ot deleted
        customDB.putInt("abc",new Random().nextInt(67));
        textView2.setText(customDB.getInt("abc",1)+ "");
    }

    @Override
    public <E> void onValueAdded(String key, E value, String dbName) {
    }

    @Override
    public void onKeyRemoved(String key, String dbName) {
    }

    @Override
    public void onAllKeysRemoved(String dbName) {
    }
}
```

You can also view the sample app on how it works

  
## Implementation
It is a very simple library and easy to use too. But, not only that, it is also very easy to implement.

1. Add this line to your `settings.gradle` file:
```
maven { url 'https://jitpack.io'}
```

You can also view the sample `settings.gradle` file from [here](https://github.com/sambhav2358/TinyDB/blob/main/settings.gradle).


2. Add this line to your app level `build.gradle` add this line:

```
implementation 'com.github.sambhav2358:TinyDB:1.91'
```

## Why do I use this instead of Shared Preferences?

I guess I need not answer it. But I will. Just compare the lines of code for you to write. But any which way, the llibraray does the very same thing in the background
``` 
//With the library
TinyDBManger manger = TinyDB.getInstance(this);
manger.putInt("abc",new Random().nextInt(10000));
```

```
//With Shred Preferences
SharedPreferences prefs = context.getSharedPreferences("MyAppData",Context.MODE_PRIVATE );
SharedPreferences.Editor editor = prefs.edit();
editor.putString( key, value );
editor.apply();
```

Now do you get it? Dont even worry about the app size. No more than 8kb. I have measured it.

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

## Knwoing when a value was added, deleted, or all values are deleted
You have listener for data change, removal and etc...

See this:
```
public class MainActivity extends AppCompatActivity implements ValueChangeListener{

    TextView textView;
    TinyDefaultDB defaultDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultDB = TinyDB.getInstance().getDefaultDatabase(this);
        defaultDB.setValueChangeListener(this); // this will trigger when a value will be modified ot deleted
    }

    @Override
    public <E> void onValueAdded(String key, E value, String dbName) {

    }

    @Override
    public void onKeyRemoved(String key, String dbName) {

    }

    @Override
    public void onAllKeysRemoved(String dbName) {

    }
}
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

## License
Free to use and modify the code.
## Author

Build with ❤️ by [Sambhav Khandelwal](https://github.com/sambhav2358)


[Stack overflow](https://stackoverflow.com/users/17133283/sambhav-k)
