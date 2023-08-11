package com.example.myintroduction

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btn = findViewById<Button>(R.id.btn)

        val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("id") ?: ""
                    val user_pw = it.data?.getStringExtra("pw") ?: ""
                    et_id.setText(user_id)
                    et_pw.setText(user_pw)
                }
            }

        btnLogin.setOnClickListener {
            login()
        }

        btn.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }

    private fun login() {
        val userid = findViewById<EditText>(R.id.et_id)
        val userpass = findViewById<EditText>(R.id.et_pass)

        if (userid.text.toString().isEmpty() || userpass.text.toString().isEmpty()){
            Toast.makeText(this, "아이디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "로그인 성공",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("dataFrom", userid.text.toString())
            intent.putExtra("name","이 종 민")
            intent.putExtra("age","29")
            intent.putExtra("mbti","ISFP")
            startActivity(intent)
        }
    }
}