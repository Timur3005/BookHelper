package edu.timurmakhmutov.bookhelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.timurmakhmutov.bookhelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}