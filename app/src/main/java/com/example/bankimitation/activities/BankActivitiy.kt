package com.example.bankimitation.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankimitation.R

class BankActivitiy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_activitiy)
    }


    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, BankActivitiy::class.java)
        }

    }
}