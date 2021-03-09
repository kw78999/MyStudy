package com.example.plan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var c1 = findViewById<CheckBox>(R.id.c1)
        var c2 = findViewById<CheckBox>(R.id.c2)
        var c3 = findViewById<CheckBox>(R.id.c3)
        var c4 = findViewById<CheckBox>(R.id.c4)

        var ed0 = findViewById<EditText>(R.id.ed)
        var ed1 = findViewById<EditText>(R.id.ed1)
        var ed2 = findViewById<EditText>(R.id.ed2)
        var ed3 = findViewById<EditText>(R.id.ed3)
        var ed4= findViewById<EditText>(R.id.ed4)

        var i1 = findViewById<ImageView>(R.id.i1)
        var i2 = findViewById<ImageView>(R.id.i2)
        var i3 = findViewById<ImageView>(R.id.i3)
        var i4 = findViewById<ImageView>(R.id.i4)

        var sp1 = arrayOf("외모","능력","성격","가문","신앙")
        var sp =findViewById<Spinner>(R.id.sp)
        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,sp1)
        sp.adapter = adapter
        var btn = findViewById<Button>(R.id.go)
        var ed = findViewById<TextView>(R.id.goed)




        btn.setOnClickListener {
            var cnt =0

            if(ed0.text.length==0){
                var dlg  = AlertDialog.Builder(this@MainActivity)
                dlg.setTitle("수면 시간")
                dlg.setMessage("수면시간을\n 넣어주세요!")
                dlg.setIcon(R.drawable.s)
                dlg.show()










            }else{
                ed.setText("1. 나는 "+ed0.text.toString()+" 시간을 잡니다.\n")
                if(c1.isChecked){
                   cnt =cnt + Integer.parseInt(ed1.text.toString())
                    i1.setImageResource(R.drawable.a)
                }else{
                    i1.setImageResource(0)
                }
                if(c2.isChecked){
                    cnt =cnt + Integer.parseInt(ed2.text.toString())
                    i2.setImageResource(R.drawable.b)
                }else{
                    i2.setImageResource(0)
                }
                if(c3.isChecked){
                    cnt =cnt + Integer.parseInt(ed3.text.toString())
                    i3.setImageResource(R.drawable.c)
                }else{
                    i3.setImageResource(0)
                }
                if(c4.isChecked){
                    cnt =cnt + Integer.parseInt(ed4.text.toString())
                    i4.setImageResource(R.drawable.d)
                    }else{
                    i4.setImageResource(0)
                }
                ed.setText(ed.text.toString()+"2. 나는 꿈을위해 "+cnt+" 시간 투자합니다.\n")




                ed.setText(ed.text.toString()+"3.나의 이상형은 "+sp.selectedItem+"입니다.")

            }





        }








    }
}