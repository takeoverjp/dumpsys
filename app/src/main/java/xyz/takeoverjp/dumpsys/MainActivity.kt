package xyz.takeoverjp.dumpsys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var services = Dumpsys.list()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, services)
        this.serviceList.adapter = adapter
        serviceList.visibility = View.VISIBLE
        dumpText.visibility = View.INVISIBLE
        serviceList.setOnItemClickListener { _, view, _, _ ->
            val textView = view.findViewById<TextView>(android.R.id.text1)
            val dump = Dumpsys.dump("${textView.text}")
            dumpText.text = dump
            serviceList.visibility = View.INVISIBLE
            dumpText.visibility = View.VISIBLE
        }
    }
    fun refresh(view: View) {
        serviceList.visibility = View.VISIBLE
        dumpText.visibility = View.INVISIBLE
        services = Dumpsys.list()
    }
}
