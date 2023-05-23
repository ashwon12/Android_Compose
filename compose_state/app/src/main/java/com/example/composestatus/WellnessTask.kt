package com.example.composestatus

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//data class WellnessTask(val id: Int, val label: String)

class WellnessTask(val id: Int, val label: String, initialChecked : Boolean = false){
    var checked by mutableStateOf(initialChecked)
}