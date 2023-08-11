package com.example.myintroduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val et_name = findViewById<EditText>(R.id.name)
        val et_id = findViewById<EditText>(R.id.up_id)
        val et_pw = findViewById<EditText>(R.id.up_pass)

        val btn_signUp = findViewById<Button>(R.id.upbtn)

        btn_signUp.setOnClickListener {
            if (et_name.text.toString().trim().isEmpty() || et_id.text.toString().trim().isEmpty() || et_pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this,SignInActivity::class.java).apply {
                putExtra("id", et_id.text.toString())
                putExtra("pw", et_pw.text.toString())
            }
            setResult(RESULT_OK, intent)

            if (!isFinishing) {
                finish()
            }
        }
    }
}