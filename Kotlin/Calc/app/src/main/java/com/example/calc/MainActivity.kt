package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import java.lang.Integer.parseInt
import kotlin.text.toFloat as toFloat1

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var rbtn1 : RadioButton = findViewById(R.id.p)
        var rbtn2 : RadioButton = findViewById(R.id.m)
        var rbtn3 : RadioButton = findViewById(R.id.x)
        var rbtn4 : RadioButton = findViewById(R.id.b)
        var op :TextView = findViewById(R.id.op)
        var ed1 : EditText = findViewById(R.id.ed1)
        var ed2 : EditText = findViewById(R.id.ed2)
        var ed3: EditText = findViewById(R.id.ed3)
        var btn : Button = findViewById(R.id.go)

        rbtn1.setOnClickListener{
            op.text = "+"
        }
        rbtn2.setOnClickListener{
            op.text = "-"
        }
        rbtn3.setOnClickListener{
            op.text = "*"
        }
        rbtn4.setOnClickListener{
            op.text = "/"
        }


        btn.setOnClickListener {
            if(rbtn1.isChecked){
                ed3.setText( ((ed1.text.toString()+"f").toFloat1() +(ed2.text.toString()+"f").toFloat1()).toString()  )
            }
            if(rbtn2.isChecked){
                ed3.setText( ((ed1.text.toString()+"f").toFloat1() -(ed2.text.toString()+"f").toFloat1()).toString()  )
            }
            if(rbtn3.isChecked){
                ed3.setText( ((ed1.text.toString()+"f").toFloat1() *(ed2.text.toString()+"f").toFloat1()).toString()  )
            }
            if(rbtn4.isChecked){
                ed3.setText( ((ed1.text.toString()+"f").toFloat1() /(ed2.text.toString()+"f").toFloat1()).toString()  )
            }

        }




    }
}