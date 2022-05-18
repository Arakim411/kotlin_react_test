package com.example.koltin_react_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Fragment;
import com.example.koltin_react_test.animations.AnimationPerformanceFragment
import com.example.koltin_react_test.databinding.ActivityMainBinding
import com.example.koltin_react_test.fibonacci.FibonacciFragment

class MainActivity : AppCompatActivity() {

        lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpMainNavigation()
    }


    private fun setUpMainNavigation(){
        binding.fibonacci.setOnClickListener {
        loadFragment(FibonacciFragment())
        }
        binding.animationPerformance.setOnClickListener {
            loadFragment(AnimationPerformanceFragment())
        }
    }


    private fun loadFragment(fragment: Fragment){
        fragmentManager.beginTransaction().replace(R.id.screen_container,fragment).commit()
    }
}