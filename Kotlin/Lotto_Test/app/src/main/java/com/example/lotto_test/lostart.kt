package com.example.lotto_test

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class lostart:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logo)

        var edt : TextView = findViewById(R.id.edt1)
        var intent = intent
        var arr2 : ArrayList<Int>
        var text : TextView = findViewById(R.id.Result)
        var text2 : TextView = findViewById(R.id.Result2)
        var loset :MutableSet<Int>
        loset = mutableSetOf()

        var arr2set :MutableSet<Int>


        var str : String = ""
        var lbtn1 =findViewById<Button>(R.id.lo1)
        var lbtn2 =findViewById<Button>(R.id.lo2)
        var lbtn3 =findViewById<Button>(R.id.lo3)
        var lbtn4 =findViewById<Button>(R.id.lo4)
        var lbtn5 =findViewById<Button>(R.id.lo5)
        var lbtn6 =findViewById<Button>(R.id.lo6)
        var lbtnset = arrayOf<Button>(lbtn1,lbtn2,lbtn3,
        lbtn4,lbtn5,lbtn6)


        arr2 = intent.getIntegerArrayListExtra("arr") as ArrayList<Int>

        if (arr2 != null) {
            for(i in arr2.indices) {
                str +=  arr2.get(i).toString() + "     "
            }
            edt.text = str
        }

        arr2set = mutableSetOf(arr2.get(0),arr2.get(1),arr2.get(2),arr2.get(3),arr2.get(4),arr2.get(5))

            var cnt =0

            while(true){


                loset.add(Random().nextInt(19) + 1)
                if (loset.size==6) {
                    cnt++
                    System.out.println(cnt.toString() + "번째")


                    if (arr2set == loset) {
                        System.out.println(loset)
                        System.out.println(arr2set)
                        for (i in 0..5 step 1) {
                            lbtnset[i].text = loset.elementAt(i).toString()
                        }
                        text.text = cnt.toString() + "번째에 당첨되었습니다."

                        text2.text = (cnt/10).toString() + "만원 만에 당첨되었습니다."
                        break
                    }
                    loset.clear()
                }

            }




    }

}