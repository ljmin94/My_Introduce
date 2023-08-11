package com.example.myintroduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Intent로 전달된 Extra 데이터(아이디)를 받아옴
        val userId = intent.getStringExtra("dataFrom")
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val mbti = intent.getStringExtra("mbti")

        // 받아온 아이디를 화면에 표시
        val textViewUserId = findViewById<TextView>(R.id.txt1)
        textViewUserId.text = "아이디: $userId"

        val textname = findViewById<TextView>(R.id.txt2)
        textname.text = "이름: $name"

        val textage = findViewById<TextView>(R.id.txt3)
        textage.text = "나이: $age"

        val textmbti = findViewById<TextView>(R.id.txt4)
        textmbti.text = "MBTI: $mbti"

        val iv_logo = findViewById<ImageView>(R.id.imageView2)

        val id = when((1..5).random()){
            1 -> R.drawable.ca1
            2 -> R.drawable.ca2
            3 -> R.drawable.ca3
            4 -> R.drawable.ca4
            5 -> R.drawable.ca5
            else -> R.drawable.ca1
        }

        iv_logo.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))

        val exit = findViewById<Button>(R.id.exit)

        exit.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}