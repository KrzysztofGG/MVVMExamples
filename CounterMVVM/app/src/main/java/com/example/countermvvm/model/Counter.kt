package com.example.simplecounter.model

class Counter {
    private var count: Int = 0

    fun increment() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}