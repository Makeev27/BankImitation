package com.example.bankimitation.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bankimitation.R
import com.example.bankimitation.classes.User
import com.example.bankimitation.database.UserDatabase

class Identification : AppCompatActivity() {

    private lateinit var enterNameAuth: EditText
    private lateinit var enterPasswordAuth: EditText
    private lateinit var nextButton: Button

    private var greyColor = 0
    private var greenColor = 0

    private lateinit var userName: String
    private lateinit var userPassword: String

    private lateinit var userDatabase: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identification)
        initView()
        userDatabase = UserDatabase.getInstance(application)
        nextButton.setOnClickListener {
            userName = enterNameAuth.text.toString()
            userPassword = enterPasswordAuth.text.toString()
            if (userName.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(applicationContext, "Введите свои данные", Toast.LENGTH_LONG).show()
            } else {
                var user: User = User(0, userName, userPassword.toInt(), 0, "" )
                userDatabase.userDao().add(user)
                val intent: Intent = newIntent(this)
                startActivity(intent)
            }

        }

    }

    private fun initView() {
        enterNameAuth = findViewById(R.id.enterNameAuth)
        enterPasswordAuth = findViewById(R.id.enterPasswordAuth)
        nextButton = findViewById(R.id.nextButton)
        greyColor = Color.parseColor("#808080")
        greenColor = Color.parseColor("#008000")
    }


    fun newIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }


}