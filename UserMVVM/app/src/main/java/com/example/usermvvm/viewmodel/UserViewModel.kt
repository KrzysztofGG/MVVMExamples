package com.example.usermvvm.viewmodel

import android.util.Log
import android.widget.DatePicker
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.usermvvm.model.User
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class UserViewModel : ViewModel() {

    private val user = User()

    val name = ObservableField<String>()
    var dateOfBirth : String = ""
    val userInfo = ObservableField<String>()

    fun updateUserInfo(datePicker: DatePicker) {
        this.user.setName(name.get() ?: "")

        val year = datePicker.year
        val month = datePicker.month
        val dayOfMonth = datePicker.dayOfMonth

        val formattedDate = this.formatDateToString(dayOfMonth, month, year)

        this.dateOfBirth = formattedDate

        this.user.setDateOfBirth(formattedDate)
        Log.d("UserViewModel", "Updated name: ${this.user.getName()}, date of birth: ${this.user.getDateOfBirth()}")
        updateUserInfoText()
    }

    private fun updateUserInfoText() {
        userInfo.set("Name: ${name.get()}, Date of Birth: ${dateOfBirth}")
        Log.d("UserViewModel", "Updated user info: ${userInfo.get()}")
    }

    fun formatDateToString(year: Int, month: Int, dayofMonth: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(dayofMonth, month, year)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        return dateFormat.format(calendar.time)
    }

}