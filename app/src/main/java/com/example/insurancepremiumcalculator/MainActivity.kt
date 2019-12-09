package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var vModel : DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vModel = ViewModelProviders.of(this).get(DataModel::class.java)

        display()

        btnCalculate.setOnClickListener(){
            vModel.result = getPremium()
            display()
        }

        btnReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            rbgGender.clearCheck()
            cbSmoker.isChecked = false
            vModel.result = 0.0
            textResult.text = vModel.result.toString()
        }
    }

    fun getPremium():Double{

        return when(spinnerAge.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 + (if(radioMale.isChecked) 50.00 else 0.0) + (if(cbSmoker.isChecked) 100.00 else 0.0)
            2 -> 90.00 + (if(radioMale.isChecked) 100.00 else 0.0) + (if(cbSmoker.isChecked) 150.00 else 0.0)
            3 -> 120.00 + (if(radioMale.isChecked) 150.00 else 0.0) + (if(cbSmoker.isChecked) 200.00 else 0.0)
            4 -> 150.00 + (if(radioMale.isChecked) 200.00 else 0.0) + (if(cbSmoker.isChecked) 250.00 else 0.0)
            else -> 150.00 + (if(radioMale.isChecked) 200.00 else 0.0) + (if(cbSmoker.isChecked) 300.00 else 0.0)
        }
    }

    fun display(){
        textResult.text = vModel.result.toString()
    }
}
