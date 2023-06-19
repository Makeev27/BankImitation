package com.example.bankimitation.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.bankimitation.R
import com.example.bankimitation.classes.User
import com.example.bankimitation.database.UserDatabase

private lateinit var nameTextView: TextView
private lateinit var passwordTextView: EditText

private lateinit var zeroButton: TextView
private lateinit var oneButton: TextView
private lateinit var twoButton: TextView
private lateinit var threeButton: TextView
private lateinit var fourButton: TextView
private lateinit var fiveButton: TextView
private lateinit var sixButton: TextView
private lateinit var sevenButton: TextView
private lateinit var eightButton: TextView
private lateinit var nineButton: TextView
private lateinit var resetPassword: ImageButton
private lateinit var fingerPrintButton: ImageButton

private lateinit var userDatabase: UserDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        Thread {
            userDatabase = UserDatabase.getInstance(application)
            var userName = userDatabase.userDao().getName()
            val greetings = getString(R.string.greetings, userName)
            Handler(Looper.getMainLooper()).post() {
                nameTextView.text = greetings
            }
        }.start()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    fun initViews() {
        nameTextView = findViewById(R.id.nameTextView)
        passwordTextView = findViewById(R.id.passwordTextView)
        zeroButton = findViewById(R.id.zeroButton)
        oneButton = findViewById(R.id.oneButton)
        twoButton = findViewById(R.id.twoButton)
        threeButton = findViewById(R.id.threeButton)
        fourButton = findViewById(R.id.fourButton)
        fiveButton = findViewById(R.id.fiveButton)
        sixButton = findViewById(R.id.sixButton)
        sevenButton = findViewById(R.id.sevenButton)
        eightButton = findViewById(R.id.eightButton)
        nineButton = findViewById(R.id.nineButton)
        resetPassword = findViewById(R.id.resetPassword)
        fingerPrintButton = findViewById(R.id.fingerPrintButton)
    }


}