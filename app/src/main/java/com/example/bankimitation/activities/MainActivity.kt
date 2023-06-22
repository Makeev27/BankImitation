package com.example.bankimitation.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.bankimitation.R
import com.example.bankimitation.constants.Const
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
                        Log.d("checkStatus", "Равны во время изменения")
                        Handler(Looper.getMainLooper()).post {
                            var intent = Intent(applicationContext, BankActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }.start()

            }

            override fun afterTextChanged(s: Editable?) {
                Thread {
                    if (userDatabase.userDao().getPassword().toString() == s.toString()) {
                        Log.d("checkStatus", "Равны после изменения изменения")
                        Handler(mainLooper).post {
                            var intent = Intent(application, BankActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }.start()
            }
        })
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
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        two.setOnClickListener {
            password += "2"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        three.setOnClickListener {
            password += "3"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        four.setOnClickListener {
            password += "4"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        five.setOnClickListener {
            password += "5"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        six.setOnClickListener {
            password += "6"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        seven.setOnClickListener {
            password += "7"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        eight.setOnClickListener {
            password += "8"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        nine.setOnClickListener {
            password += "9"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        zero.setOnClickListener {
            password += "0"
            passwordTextView.setText(password)
            if (passwordTextView.text.toList().size == 4) {
                vibratePhone()
                password = ""
                passwordTextView.text.clear()
            }
        }
        reset.setOnClickListener {
            vibratePhone()
            password = ""
            passwordTextView.text.clear()
        }
        fingerPrintButton.setOnClickListener {
            userDatabase.userDao().nukeTable()
            password = ""
            passwordTextView.text.clear()
            val intent = Intent(this, Identification::class.java)
            startActivity(intent)
        }
    }

    fun vibratePhone () {
        val vibrator = application?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(200)
        }
    }


}