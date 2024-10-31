package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val password2 = findViewById<EditText>(R.id.password2)
        val terms = findViewById<CheckBox>(R.id.checkbox_terms)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val submit = findViewById<Button>(R.id.submit_button)

        submit.setOnClickListener {
            val name = name.text.toString().trim()
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()
            val password2 = password2.text.toString().trim()
            val genderSelected = radioGroup.checkedRadioButtonId != -1
            val terms = terms.isChecked

            if (name.isEmpty()) {
                showToast("Name Field must not be empty")
            } else if (email.isEmpty()) {
                showToast("Email Field must not be empty")
            } else if (password.isEmpty()) {
                showToast("Password is required")
            } else if (password.length < 8) {
                showToast("Password must be at least 8 characters")
            } else if (password != password2) {
                showToast("Password does not match")
            } else if (!terms) {
                showToast("Please accept terms and conditions")
            } else if (!genderSelected) {
                showToast("Please select a Gender")
            } else {
                showToast("Registration Successful")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

//    @Composable
//    fun Greeting(name: String, modifier: Modifier = Modifier) {
//        Text(
//            text = "Hello nahian $name!",
//            modifier = modifier
//        )
//    }
//
//    @Preview(showBackground = true)
//    @Composable
//    fun GreetingPreview() {
//        MyFirstAppTheme {
//            Greeting("Android")
//        }
//    }