package com.example.bankimitation.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.bankimitation.R
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

private var password: String = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        showGreetings()
        userDatabase = UserDatabase.getInstance(application)
        onClick(
            oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
            eightButton, nineButton, zeroButton, resetPassword
        )
        passwordTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("checkStatus", s.toString())
                Log.d("checkStatus", userDatabase.userDao().getPassword().toString())
                Thread {
                    if (userDatabase.userDao().getPassword().toString() == s.toString()) {

                        Handler(Looper.getMainLooper()).post {
                            var intent = Intent(applicationContext, BankActivitiy::class.java)
                            startActivity(intent)
                        }
                    }
                }.start()

            }

            override fun afterTextChanged(s: Editable?) {
                Thread {
                    if (userDatabase.userDao().getPassword().toString() == s.toString()) {
                        Handler(mainLooper).post {
                            var intent = Intent(application, BankActivitiy::class.java)
                            startActivity(intent)
                        }
                    }
                }.start()
            }
        })
        fingerPrintButton.setOnClickListener {
            userDatabase.userDao().nukeTable()
            var intent = Intent(this, Identification::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private fun initViews() {
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

//        setAnimation(zeroButton)
//        setAnimation(oneButton)
//        setAnimation(twoButton)
//        setAnimation(threeButton)
//        setAnimation(fourButton)
//        setAnimation(fiveButton)
//        setAnimation(sixButton)
//        setAnimation(sevenButton)
//        setAnimation(eightButton)
//        setAnimation(nineButton)
//        setAnimation(resetPassword)

    }

    private fun showGreetings() {
        Thread {
            userDatabase = UserDatabase.getInstance(application)
            var userName = userDatabase.userDao().getName()
            val greetings = getString(R.string.greetings, userName)
            Handler(Looper.getMainLooper()).post {
                nameTextView.text = greetings
            }
        }.start()
    }

    fun onClick(
        one: TextView, two: TextView, three: TextView, four: TextView,
        five: TextView, six: TextView, seven: TextView, eight: TextView,
        nine: TextView, zero: TextView, reset: ImageButton
    ) {
        one.setOnClickListener {
            password += "1"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        two.setOnClickListener {
            password += "2"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        three.setOnClickListener {
            password += "3"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        four.setOnClickListener {
            password += "4"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        five.setOnClickListener {
            password += "5"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        six.setOnClickListener {
            password += "6"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        seven.setOnClickListener {
            password += "7"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        eight.setOnClickListener {
            password += "8"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        nine.setOnClickListener {
            password += "9"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        zero.setOnClickListener {
            password += "0"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                password = ""
                passwordTextView.text.clear()
            }
        }
        reset.setOnClickListener {
            password = ""
            passwordTextView.text.clear()
        }

    }


}