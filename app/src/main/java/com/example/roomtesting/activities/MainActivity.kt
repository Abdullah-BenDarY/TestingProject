package com.example.roomtesting.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.roomtesting.R
import com.example.roomtesting.base.BaseActivity
import com.example.roomtesting.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        linkNavHostWithBottomNavigation()
    }

    private fun linkNavHostWithBottomNavigation() {
        val navController = findNavController(R.id.navHost)
        binding.navView.setupWithNavController(navController)
    }

}