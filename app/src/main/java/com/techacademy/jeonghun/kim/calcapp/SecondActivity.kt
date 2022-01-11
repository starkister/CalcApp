package com.techacademy.jeonghun.kim.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.techacademy.jeonghun.kim.calcapp.CalType
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_second)

                val value1 = intent.getFloatExtra("VALUE1",0F)
                val value2 = intent.getFloatExtra("VALUE2",1F)
                var type: CalType.CalculationType = CalType.CalculationType.Plus
                type = intent.getSerializableExtra("CalType") as CalType.CalculationType

        var resultStr = ""
        var resultValue: Float = 0F
        when(type){
                CalType.CalculationType.Plus -> {
                    resultValue = value1.toFloat() + value2.toFloat()
                    resultStr = "$value1 + $value2 = $resultValue"}
                CalType.CalculationType.Minus -> {
                    resultValue = value1.toFloat() - value2.toFloat()
                    resultStr = "$value1 - $value2 = $resultValue"}
                CalType.CalculationType.Multiply -> {
                    resultValue = value1.toFloat() * value2.toFloat()
                    resultStr = "$value1 * $value2 = $resultValue"}
                CalType.CalculationType.Divide -> {
                    resultValue = value1.toFloat() / value2.toFloat()
                    resultStr = "$value1 / $value2 = $resultValue"}
        }
        textViewResult.text = resultStr

    }


}