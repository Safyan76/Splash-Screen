package com.example.splashscreen

import android.content.Intent
import android.content.pm.ModuleInfo
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.splashscreen.databinding.ActivityMainscreenBinding
import nl.joery.animatedbottombar.AnimatedBottomBar

class mainscreen : AppCompatActivity() {

    private val binding : ActivityMainscreenBinding by lazy {
        ActivityMainscreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars())

        val binding = binding.bottomBar as AnimatedBottomBar
        val bottomBar = findViewById<AnimatedBottomBar>(R.id.bottom_bar)

        val btn_go= findViewById<Button>(R.id.button_go)
        btn_go.setOnClickListener {
            val intent = Intent(this, chatscreen::class.java)
            startActivity(intent)
        }

    }
}
