package com.example.myfirstapp.coroutine_class

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineDemo : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var btnAction: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coroutine_demo)
        tvResult = findViewById(R.id.tvResult)
        btnAction = findViewById(R.id.btnAction)


        btnAction.setOnClickListener {
            GlobalScope.launch {
                showUpdate("Wait for some time...")
                val token = fetchLatestToken()
                showUpdate(token)
                val userId = fetchUserId(token)
                showUpdate(userId)
                val profileInfo = fetchProfileInfo(userId)
                showUpdate(profileInfo)
            }

//            fetchLatestToken { token ->
//                showUpdate(token)
//                fetchUserId(token) { userId ->
//                    showUpdate(userId)
//                    fetchProfileInfo(userId) { profileInfo ->
//                        showUpdate(profileInfo)
//                    }
//                }
//            }
        }
    }

    private fun showUpdate(value: String) {
        runOnUiThread {
            tvResult.text = value
        }
    }

//    private fun fetchLatestToken(callback: (String) -> Unit) {
//        // Simulate a long running task
//        Thread {
//            Thread.sleep(3000)
//            callback("Token value is 2342")
//        }.start()
//    }
//
//    private fun fetchUserId(token: String, callback: (String) -> Unit) {
//        // Simulate a long running task
//        Thread {
//            Thread.sleep(3000)
//            callback("User ID 123")
//        }.start()
//    }
//
//    private fun fetchProfileInfo(userId: String, callback: (String) -> Unit) {
//        // Simulate a long running task
//        Thread {
//            Thread.sleep(3000)
//            callback("This is profile info")
//        }.start()
//    }

    suspend fun fetchLatestToken(): String {
        // Simulate a long running task
        delay(3000)
        return "Token value is 2342"
    }

    suspend fun fetchUserId(token: String): String {
        // Simulate a long running task
        delay(3000)
        return "User ID 123"
    }

    suspend fun fetchProfileInfo(userId: String): String {
        // Simulate a long running task
        delay(3000)
        return "This is profile info"
    }
}

