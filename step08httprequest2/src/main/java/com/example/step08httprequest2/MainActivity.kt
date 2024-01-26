package com.example.step08httprequest2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.step08httprequest2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root) // setContentView(binding.getRoot());

        // 요청 버튼을 눌렀을 떄 동작
        binding.requestBtn.setOnClickListener {
            // 입력한 url 읽어오기
            val url = binding.inputUrl.text.toString(); // .getText().toString()

            /* : Main Thread이지만, 병렬로 처리되는 부분 : */
            // kotlin의 coroutine의 기능을 이용해서 요청 처리하기
            // GlobalScope.launch(Dispatchers.Main) { // App당 유일한 Scope
            // 액티비티 생명주기 안에서만 동작하는 작업 Scope
            lifecycleScope.launch(Dispatchers.Main) {
                val result = makeHttpRequest(url)
                // 결과 문자열을 EditText에 출력하기
                binding.editText.setText(result)
            }
        }
    }

    // suspend fun => 중단 함수. 리턴되는데 시간이 걸릴 가능성이 있는 함수이다.
    suspend fun makeHttpRequest(url: String): String {
        /*
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