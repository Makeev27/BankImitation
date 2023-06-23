package com.example.bankimitation.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.bankimitation.R
import com.example.bankimitation.adapter.NewsAdapter
import com.example.bankimitation.database.UserDatabase
import com.example.bankimitation.services.CardService
import com.google.android.material.bottomnavigation.BottomNavigationView

@SuppressLint("StaticFieldLeak")
private lateinit var searchView: SearchView
@SuppressLint("StaticFieldLeak")
private lateinit var userImage: ImageView
private lateinit var bottomNavigationMenu: BottomNavigationView
@SuppressLint("StaticFieldLeak")
private lateinit var userName: TextView
private lateinit var newsAdapter: NewsAdapter
private lateinit var recyclerViewCards: RecyclerView
private val cardService = CardService


private lateinit var userDatabase: UserDatabase



class BankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_activity)
        userDatabase = UserDatabase.getInstance(application)
        initViews()
        loadFromDb()

        val manager = LinearLayoutManager(this, HORIZONTAL, false)
        newsAdapter = NewsAdapter()
        newsAdapter.data = cardService.cards
        recyclerViewCards.layoutManager = manager
        recyclerViewCards.adapter = newsAdapter

    }

        fun newIntent(context: Context): Intent {
            return Intent(context, BankActivity::class.java)
        }

    private fun initViews() {
        searchView = findViewById(R.id.searchView)
        userImage = findViewById(R.id.userImage)
        bottomNavigationMenu = findViewById(R.id.bottomNavigationMenu)
        userName = findViewById(R.id.userName)
        recyclerViewCards = findViewById(R.id.recyclerViewCards)
    }

    private fun loadFromDb () {
        Thread {
            userName.text = userDatabase.userDao().getName()
        }.start()
    }
}