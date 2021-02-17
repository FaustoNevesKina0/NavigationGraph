package br.com.fausto.basicnavcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = bottomNavBar
        val navController = findNavController(R.id.hostFragment)
        val appBarConfigurationObject = AppBarConfiguration(setOf(R.id.firstScreen, R.id.secondFragment, R.id.lastFragment))
        setupActionBarWithNavController(navController, appBarConfigurationObject)

        bottomNavigationView.setupWithNavController(navController)
    }
}