package com.example.usermvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.usermvvm.databinding.ActivityMainBinding
import com.example.usermvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up DataBinding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this

        // Set initial values for user
        userViewModel.name.set("Rick Deckard")
        userViewModel.dateOfBirth.set("01/01/1990")

    }
    fun updateUserInfo(view: View) {

        val name = userViewModel.name.get()?.trim() ?: ""
        val datePicker = findViewById<DatePicker>(R.id.dateOfBirthPicker)
        Log.d("MainActivity", "Updating user info with name: $name, date of birth: ${datePicker.dayOfMonth}/${datePicker.month}/${datePicker.year}")
        userViewModel.updateUserInfo(name, datePicker)
    }
}