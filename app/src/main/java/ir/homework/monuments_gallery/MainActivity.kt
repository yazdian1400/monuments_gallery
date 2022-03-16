package ir.homework.monuments_gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.homework.monuments_gallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}