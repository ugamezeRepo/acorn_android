package com.example.step06customlistview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() { // extends App CompatActivity
    // onCreate() 메서드 오버라이드
    override fun onCreate(savedInstanceState: Bundle?) { // Bundle? nullable type
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        // Detail 액티비티에 전달된 Intent 객체
        val i: Intent = intent // getIntent(). Activity의 메서드
        val dto: CountryDto = i.getSerializableExtra("dto") as CountryDto

        // ImageView의 참조 값 얻기
        // val imageView = findViewById<ImageView>(R.id.imageView) // generic type 명시도 가능
        val imageView: ImageView = findViewById(R.id.imageView)
        val textName: TextView = findViewById(R.id.textName)
        val textContent: TextView = findViewById(R.id.textContent)
        // CountryDto에 있는 정보 UI에 출력
        imageView.setImageResource(dto.resId)
        // textName.setText(dto.getName())
        textName.text = dto.name
        textContent.text = dto.content

        val confirmBtn: Button = findViewById(R.id.confirmBtn)
        // 버튼에 클릭 리스너 등록
        confirmBtn.setOnClickListener {
            // 액티비티의 finish() 메서드 호출
            finish()
        }
    }
}