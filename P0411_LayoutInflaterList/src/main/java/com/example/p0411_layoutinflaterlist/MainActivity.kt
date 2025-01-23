package com.example.p0411_layoutinflaterlist


import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView


class MainActivity : Activity() {
    var name: Array<String> = arrayOf(
        "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
        "Костя", "Игорь"
    )
    var position: Array<String> = arrayOf(
        "Программер", "Бухгалтер", "Программер",
        "Программер", "Бухгалтер", "Директор", "Программер", "Охранник"
    )
    var salary: IntArray = intArrayOf(13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000)

    var colors: IntArray = IntArray(2)

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colors[0] = Color.parseColor("#559966CC")
        colors[1] = Color.parseColor("#55336699")

        val linLayout = findViewById<View>(R.id.linLayout) as LinearLayout

        val ltInflater = layoutInflater

        for (i in name.indices) {
            Log.d("myLogs", "i = $i")
            val item: View = ltInflater.inflate(R.layout.item, linLayout, false)
            val tvName = item.findViewById<View>(R.id.tvName) as TextView
            tvName.text = name[i]
            val tvPosition = item.findViewById<View>(R.id.tvPosition) as TextView
            tvPosition.text = "Должность: " + position[i]
            val tvSalary = item.findViewById<View>(R.id.tvSalary) as TextView
            tvSalary.text = "Оклад: " + salary[i].toString()
            item.layoutParams.width = LayoutParams.MATCH_PARENT
            item.setBackgroundColor(colors[i % 2])
            linLayout.addView(item)
        }
    }
}