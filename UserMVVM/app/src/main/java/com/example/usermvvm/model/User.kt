package com.example.usermvvm.model

import java.util.Date

class User {
    private var name: String = ""
    private var dateOfBirth: String = ""

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getDateOfBirth(): String {
        return dateOfBirth
    }

    fun setDateOfBirth(dateOfBirth: String) {
        this.dateOfBirth = dateOfBirth
    }
}