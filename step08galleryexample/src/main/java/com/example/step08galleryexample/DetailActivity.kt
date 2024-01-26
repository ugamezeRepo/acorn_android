package com.example.step08galleryexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.step08galleryexample.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DetailActivity : AppCompatActivity() {
    val INDEX_URL = "http://192.168.0.148:9000/boot09/"
    val GALLERY_URL = INDEX_URL + "api/gallery/"
    val UPLOAD_URL = INDEX_URL + "upload/images/"
    lateinit var binding: ActivityDetailBinding
    lateinit var url: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MainActivity에서 전달된 Gallery의 PK 얻어내기
        var num = intent.getLongExtra("id", 0)

        lifecycleScope.launch(Dispatchers.Main) {
            url = GALLERY_URL + num

            // json()은 {} 형식의 문자열이다. (Gallery 하나의 정보)
            var json = makeHttpRequest(url)
            printToLayout(json)
        }
    }

    fun printToLayout(json: String) {
        // json은 {} 형식의 문자열이므로 JSONObject() 객체 생성
        val obj = JSONObject(json)

        // 작성자를 읽어와서 TextView에 출력
        binding.writer.text = obj.getString("writer")
        // 설명을 읽어와서 TextView에 출력
        binding.caption.text = obj.getString("caption")
        // 등록일을 읽어와서 TextView에 출력
        binding.regdate.text = obj.getString("regdate")

        // 이미지는 Glide 이용
        Glide.with(this)
            // .load(url)
            .load(UPLOAD_URL + obj.getString("saveFileName"))
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageView)
    }

    private suspend fun makeHttpRequest(url: String): String {/*
            : 새로운 스레드(Sub Thread)이면서 병렬로 처리되는 부분 :

            IO(Input Output) 입출력 처리를 하기에 적합한 스레드를 시작시켜서 작업을 한다.
            withContext() {} 블럭 내부는 UI 스레드가 아니다.
            블럭의 가장 아랫부분에 남긴 값이 리턴된다.
         */
        val result = withContext(Dispatchers.IO) {
            // 이 곳도 새로운 스레드

            // 문자열을 누적할 객체
            // StringBuilder builder  = new StringBuilder();
            val builder = StringBuilder()
            try {
                // 요청 url을 생성자의 인자로 전달하면서 URL 객체를 생성한다.
                val url = URL(url);
                // URLConnection 객체를 원래 type(자식 type)으로 casting해서 받는다.
                val conn = url.openConnection() as HttpURLConnection

                if (conn != null) {
                    conn.connectTimeout = 20000 // 응답을 기다리는 최대 대기 시간
                    conn.requestMethod = "GET" // 요청 메서드 설정 (Default는 GET)
                    conn.useCaches = false // 캐시 사용 여부

                    // 응답 코드를 읽어온다.
                    val responeseCode: Int = conn.responseCode;
                    if (responeseCode == HttpURLConnection.HTTP_OK) { // 정상 응답이라면 (200)
                        // 문자열을 읽어들일 수 있는 객체의 참조값 얻어오기
                        val br = BufferedReader(InputStreamReader(conn.inputStream))
                        // 반복문 돌면서
                        while (true) {
                            // 문자열을 한 줄씩 읽어들인다.
                            val line = br.readLine() ?: break;
                            // StringBuilder 객체에 누적시키기
                            builder.append(line);
                        }
                    }
                }
            } catch (e: Exception) {
                e.message?.let { Log.e("MainActivity", it) };
            }

            // 누적된 문자열 리턴
            builder.toString()
        }

        return result
    }

}