package com.example.bankimitation.classes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var password: Int,
    var money: Int,
    var cardType: String


)




