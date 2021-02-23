# NavigationGraph

This is not a serious app! Its just a basic template of Navigation Components (Bottom Nav Bar + Fragments)
Explanation: first, you create a regular menu XML file. Then, you pass this menu as an "app:menu" attribute in the widget BottomNavigationView. Now you have your bottom navigation bar. Then, we create a fragment host in our activity. This fragment needs to have the "app:defaultNavHost="true"" attribute and, for convention, this host fragments will ALWAYS have word "host" in its id (like: fragmentHost, fragHost, mainFragHost, you get the idea), so you'll never forget about this among any other fragments that we'll eventually create. After this, create an package called navigation in your resources and create an Navigation Resource File XML in it, open it and within design layout, create your fragments in it. These fragments must have an very specific ID (its with these IDs that we'll relate the navigation itself with the BottomNavigationView widget!). Here's how we do it: remember our menu xml file? It has menu items in it, right? These items also have IDs in it, and these IDs must have to be IDENTICAL with the IDs that our previous created fragments in the Navigation Resource File. EXAMPLE: Lets say that our menu file has 3 items: first with ID "home", second with ID "setup" and the last with ID "preferences". These IDs must be identical with the fragments that we created inside our navigation graph.

Now, lets make the code. I don't like to write findViewByID. Instead I use kotlin synthetics so I can just call the widget for its ID. To do the same, just add this in your gradle file: 
```
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-android-extensions' // <<<THIS ONE DOES THE JOB
}
```
Now, lets write the code that handles the navigation.
First, lets reference our host fragment wich will be responsible for manage the navigation and the BottomNavigationView widget:
```
val navController = findNavController(R.id.hostFragment)
val bottomNavigationView = bottomNavBar
```

Our Bottom Navigation View has a very specific method wich will take our fragment host as an argument:
```
bottomNavigationView.setupWithNavController(navController)
```
Now, what it does? According to the documentation:
```
/**
 * Sets up a [BottomNavigationView] for use with a [NavController]. This will call
 * [android.view.MenuItem.onNavDestinationSelected] when a menu item is selected.
 *
 * The selected item in the NavigationView will automatically be updated when the destination
 * changes.
 */
 ```
 
 With this, you are now able to navigation through your fragments by just selecting any item in your bottom navigation bar.
 
 BONUS:
 If you want to customize your appBar (that thing that's in the up part of the screen) according to the current screen, we can do this:
 ```
 val appBarConfigurationObject = AppBarConfiguration(setOf(R.id.firstScreen, R.id.secondFragment, R.id.lastFragment))
 ```
 What it does? It's a function that takes our available destinations and we pass this in an object (appBarConfigurationObject).
 Now that this object is created, lets use it:
 ```
 setupActionBarWithNavController(navController, appBarConfigurationObject)
 ```
 Now, everytime that we navigate through our screens, the title of the appBar will change. But wait, how do we select the text? The text is available in our navigation graph.
 The fragments inside our navigation graphs has an attribute called ```android:label="your_label_here"```
 This is the text that will be showed in the appBar according to the current screen!
 
 
 Remember: this code is pretty much boilerplate code, it doens't need a lot of creativity (at first!)
 Sorry for any grammar mistakes (still working on my english skills). I hope you enjoyed it, have a nice day!
