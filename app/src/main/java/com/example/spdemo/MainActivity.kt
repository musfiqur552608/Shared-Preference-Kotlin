package com.example.spdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameTxt: EditText
    private lateinit var ageTxt: EditText
    private lateinit var nextBtn: Button
    private lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTxt = findViewById(R.id.edname)
        ageTxt = findViewById(R.id.edage)
        nextBtn = findViewById(R.id.nextbtn)

        sp = getSharedPreferences("my_sp", MODE_PRIVATE)


    }

    override fun onPause() {
        super.onPause()
        val name = nameTxt.text.toString()
        val age = ageTxt.text.toString().toInt()
        val editor = sp.edit()
        editor.apply {
            putString("sp_name", name)
            putInt("sp_age", age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()

        val name = sp.getString("sp_name", null)
        val age = sp.getInt("sp_age", 0)

        nameTxt.setText(name)
        if (age != 0) {
            ageTxt.setText(age.toString())
        }
    }
}