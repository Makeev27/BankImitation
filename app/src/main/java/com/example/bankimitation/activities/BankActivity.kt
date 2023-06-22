package com.example.bankimitation.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.SearchView
import com.example.bankimitation.R
import com.example.bankimitation.database.UserDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var searchView: SearchView
private lateinit var userImage: ImageView
private lateinit var bottomNavigationMenu: BottomNavigationView
private lateinit var userName: TextView

private lateinit var userDatabase: UserDatabase



class BankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_activity)
        userDatabase = UserDatabase.getInstance(application)
        initViews()
        loadFromDb()

    }

        fun newIntent(context: Context): Intent {
            return Intent(context, BankActivity::class.java)
        }

    private fun initViews() {
        searchView = findViewById(R.id.searchView)
        userImage = findViewById(R.id.userImage)
        bottomNavigationMenu = findViewById(R.id.bottomNavigationMenu)
        userName = findViewById(R.id.userName)
    }

    private fun loadFromDb () {
        Thread {
            userName.text = userDatabase.userDao().getName()
        }.start()
    }
}