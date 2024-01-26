package com.example.step08example

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.step08example.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var adapter2: ArrayAdapter<String>
    private lateinit var notices: MutableList<String>
    private lateinit var galleries: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // view binding을 이용해 화면 구성
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 모델
        notices = mutableListOf()
        galleries = mutableListOf()
        // ListView에 연결할 어댑터
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notices)
        adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, galleries)
        // ListView에 어댑터 연결
        binding.listView.adapter = adapter
        binding.listView2.adapter = adapter2

        // 버튼에 리스너 등록
        binding.getBtn.setOnClickListener {
            val url = "http://192.168.0.148:9000/boot09/api/notices"
            lifecycleScope.launch(Dispatchers.Main) {
                // 요청을 하고 json 문자열을 결과로 받아오기
                val json = makeHttpRequest(url)

                // Toast.makeText(this@MainActivity, json, Toast.LENGTH_LONG).show()
                printToListView(json)
            }
        }

        binding.getBtn2.setOnClickListener {
            val url = "http://192.168.0.148:9000/boot09/api/galleries"
            lifecycleScope.launch(Dispatchers.Main) {
                // 요청을 하고 json 문자열을 결과로 받아오기
                val json = makeHttpRequest(url)

                printToListView2(json)
            }
        }

    }

    private fun printToListView(json: String) {
        // [] 형식의 문자열이므로 JSONArray 객체 생성
        val arr = JSONArray(json)

        // 반복문 돌면서
        for (i in 0..<arr.length()) {
            // i번 째 문자열 추출
            val tmp = arr.getString(i)
            // 모델에 아이템 추가
             notices.add(tmp)
        }
        // 모델에 변경이 생겼다고 어댑터에 알려 ListView 업데이트
        adapter.notifyDataSetChanged()
    }
    private fun printToListView2(json: String) {
        val arr = JSONArray(json)

        for (i in 0..<arr.length()) {
            // Array 안에 객체가 들어있으므로 .getJSONObject(Index)이다.
            val tmp = arr.getJSONObject(i)
            // {"num": x, "writer": "xxx", "caption": "xxx" ...}
            val num = tmp.getInt("num")
            val writer = tmp.getString("writer")
            val caption = tmp.getString("caption")
            galleries.add("번호: $num 작성자: $writer 설명: $caption")
        }
        adapter.notifyDataSetChanged()
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