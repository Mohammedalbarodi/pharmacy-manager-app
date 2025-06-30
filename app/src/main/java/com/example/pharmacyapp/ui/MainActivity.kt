package com.example.pharmacyapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // مثال على التنقل بين الواجهات
        findViewById<Button>(R.id.btnMedicines).setOnClickListener {
            startActivity(Intent(this, MedicineListActivity::class.java))
        }
    }
}
