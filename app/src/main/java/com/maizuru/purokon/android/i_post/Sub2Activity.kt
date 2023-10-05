package com.maizuru.purokon.android.i_post

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Sub2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub2)

        val textList = mutableListOf<String>()

        val recyclerView: RecyclerView = findViewById(R.id.rireki2)
        val adapter = ItemAdapter(textList)

        /*val url = "https://ipost-server-eh2trxntfa-an.a.run.app/"
        getTask(url)*/

        //入力された値を送信
        val text2:EditText = findViewById(R.id.message2)
        val send:Button = findViewById(R.id.send2)
        send.setOnClickListener {
            val str = text2.text
            textList.add(str.toString())
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
            text2.setText("")
        }

        //ホーム画面に戻る
        val back:Button = findViewById(R.id.backButton)
        back.setOnClickListener {
            finish()
        }
    }

    private fun getTask(url: String) {
        lifecycleScope.launch {
            val result = backGroundTask(url)

            jsonTask(result)
        }
    }

    private suspend fun backGroundTask(url: String):String {
        val response = withContext(Dispatchers.IO) {
            var httpResult = ""
            val myUrl = URL(url)
            val connection = myUrl.openConnection() as HttpURLConnection

            try {
                val br = BufferedReader(InputStreamReader(myUrl.openStream()))
                httpResult = br.readText()

                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                connection.requestMethod = "GET"
                connection.connect()

            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            } finally {
                connection.disconnect()
            }
            return@withContext httpResult
        }
        return response
    }

    private fun jsonTask(result: String) {
        val rireki2: RecyclerView = findViewById(R.id.rireki2)
        val textList = mutableListOf<String>()
        //JSON取得
        val jsonObj = JSONObject(result)

        val messageArray = jsonObj.getJSONArray("text")

        for (i in 0 until messageArray.length()) {
            textList.add(messageArray.getString(i))
        }

        rireki2.adapter = ItemAdapter(textList)
        rireki2.layoutManager = LinearLayoutManager(this)
    }
}







        //POST
        /*fun startPostRequest() {
            val sendDataJson = "{\"id\":\"name\":\"sentence\"}"
            val bodyDate = sendDataJson.toByteArray()

            val url = URL("")
            val connection = url.openConnection() as HttpURLConnection
            try {
                connection.connectTimeout = 1000
                connection.readTimeout = 1000
                connection.requestMethod = "POST"

                connection.doOutput = true

                connection.setFixedLengthStreamingMode(bodyDate.size)
                connection.setChunkedStreamingMode(0)

                connection.setRequestProperty("Content-type", "application/json; charset=utf-8")
                connection.connect()

                val outputStream = connection.outputStream
                    outputStream.write(bodyDate)
                    outputStream.flush()
                    outputStream.close()
                
            } catch (exception: Exception) {
                Log.e("Error", exception.toString())
            } finally {
                connection.disconnect()
            }
        }*/
