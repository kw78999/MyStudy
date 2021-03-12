package com.example.lotto_test

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TableRow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import java.io.Console


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var rLay : TableRow
        rLay = findViewById(R.id.rLay)

        var arr =ArrayList<Int>(0)

        var start : Button
        var btn = arrayOfNulls<Button>(45)
        var btnId = arrayOf(R.id.b1,R.id.b2,R.id.b3,
            R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,
            R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,R.id.b15,
            R.id.b16,R.id.b17,R.id.b18,R.id.b19,
            R.id.b20)

        for (i in 0..19){
            btn[i] = findViewById(btnId[i])
            btn[i]?.setBackgroundColor(Color.LTGRAY)
            btn[i]?.setTextColor(Color.BLACK)
            btn[i]!!.text = (i+1).toString()
                    btn[i]?.setOnClickListener {
                        var rbtn = Button(this)
                        if(btn[i]?.text.toString()==(i+1).toString()) {
                            if(rLay.childCount<6) {
                                btn[i]?.text = "[ "+(i+1)+" ]"
                                btn[i]?.setBackgroundColor(Color.YELLOW)
                                rbtn.text = (i + 1).toString()
                                rbtn.setBackgroundColor(Color.YELLOW)
                                rbtn.width = 30
                                rbtn.id = i+1
                                rLay.addView(rbtn)
                                arr.add(i+1)

                            }else{
                                Toast.makeText(applicationContext,"숫자는 6개만" +
                                        "선택 가능합니다.",Toast.LENGTH_SHORT).show()
                            }
                        }else{
                            btn[i]!!.text = (i+1).toString()
                            btn[i]?.setBackgroundColor(Color.LTGRAY)
                            rLay.removeView(findViewById(i+1))
                            arr.remove(i+1)
                        }

            }

        }
        start = findViewById(R.id.Start)
        start.setOnClickListener {
            if(rLay.childCount==6) {
                var intent = Intent(application,lostart::class.java)
                intent.putExtra("arr",arr)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext,
                        "숫자 6개 골라주세요",Toast.LENGTH_SHORT).show()

            }
        }


    }

}