package com.example.usermvvm.viewmodel

import android.util.Log
import android.widget.DatePicker
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class UserViewModel : ViewModel() {

    val name = ObservableField<String>()
    val dateOfBirth = ObservableField<String>()
    val userInfo = ObservableField<String>()

    fun updateUserInfo(name: String, datePicker: DatePicker) {
        this.name.set(name)

        val year = datePicker.year
        val month = datePicker.month
        val dayOfMonth = datePicker.dayOfMonth

        val formattedDate = this.formatDateToString(dayOfMonth, month, year)

        this.dateOfBirth.set(formattedDate)
        Log.d("UserViewModel", "Updated name: ${this.name.get()}, date of birth: ${dateOfBirth.get()}")
        updateUserInfoText()
    }

    private fun updateUserInfoText() {
        userInfo.set("Name: ${name.get()}, Date of Birth: ${dateOfBirth.get()}")
        Log.d("UserViewModel", "Updated user info: ${userInfo.get()}")
    }

    fun formatDateToString(year: Int, month: Int, dayofMonth: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(dayofMonth, month, year)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        return dateFormat.format(calendar.time)
    }

}