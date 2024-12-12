package com.example.simplecounter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplecounter.model.Counter

class CounterViewModel {
    private val counter = Counter()

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    init {
        _count.value = counter.getCount()
    }

    fun incrementCounter() {
        counter.increment()
        Log.d("CounterViewModel", "Counter incremented: new count = ${counter.getCount()}")
        _count.value = counter.getCount()
    }
}