package com.example.inicio.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ContactActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactActivityBinding.inflate(layoutInflater)
    }
}