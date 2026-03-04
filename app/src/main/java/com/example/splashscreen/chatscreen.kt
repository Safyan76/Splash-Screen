package com.example.splashscreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class chatscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chatscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnback = findViewById<ImageButton>(R.id.back_btn)
        btnback.setOnClickListener {
            startActivity(Intent(this, mainscreen::class.java))
        }

        val callbutton = findViewById<ImageButton>(R.id.call_btn)
        callbutton.setOnClickListener {
             val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:03235984109"))
            startActivity(intent)
            val chooser = Intent.createChooser(intent,"s")
            startActivity(chooser)
        }

    }
}