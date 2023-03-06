package com.example.myshared

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val sharedPreFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences:SharedPreferences=this.getSharedPreferences(sharedPreFile,Context.MODE_PRIVATE)
        btnSave.setOnClickListener {
            val id : Int = Integer.parseInt(etInputId.text.toString())
            val name : String = etInputName.text.toString()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("id_key",id)
            editor.putString("name_key",name)
            editor.apply()
            Toast.makeText(this@MainActivity, "Data saved", Toast.LENGTH_SHORT).show()
        }
        btnView.setOnClickListener {
            val sharedIdValue = sharedPreferences.getInt("id_key",0)
            val sharedNameValue = sharedPreferences.getString("name_key","defaultname")
            if (sharedIdValue.equals(0)&& sharedNameValue.equals("defaultname")){
                tvShowName.setText("defaul name  :${sharedNameValue}").toString()
                tvShowId.setText("default id :${sharedNameValue.toString()}")
                Toast.makeText(this@MainActivity, "Data View Kosong", Toast.LENGTH_SHORT).show()
            }else {
                tvShowName.setText(sharedNameValue).toString()
                tvShowId.setText(sharedIdValue.toString())
                Toast.makeText(this@MainActivity, "Data View Ditampilkan ", Toast.LENGTH_SHORT).show()
            }
            btnView.setOnClickListener {
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                tvShowName .setText("")
                tvShowId.setText("")
                Toast.makeText(this@MainActivity, "Data Clear", Toast.LENGTH_SHORT).show()
            }
        }

    }
}