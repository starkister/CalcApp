package com.techacademy.jeonghun.kim.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.techacademy.jeonghun.kim.calcapp.CalType
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        var firstNumber = 0F
        var secondNumber = 0F
        //parsing
        if(editText1.text.toString() == "" || editText1.text == null){
            Snackbar.make(v, "一番目欄に数値を入力してください", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        else if(editText2.text.toString() == "" || editText2.text == null){
            Snackbar.make(v, "二番目欄に数値を入力してください", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        try{
            val num = editText1.text.toString().toFloat()
            firstNumber = num;
        }catch (e: NumberFormatException) {
            Log.d("DEBUG", "et1 input data is not number")
            return
        }
        try{
            val num = editText2.text.toString().toFloat()
            secondNumber = num;
        }catch (e: NumberFormatException) {
            Log.d("DEBUG", "et2 input data is not number")
            return
        }
        var calculationTypeSelected: CalType.CalculationType = CalType.CalculationType.Plus
        when (v.id){
            R.id.button1 -> {calculationTypeSelected = CalType.CalculationType.Plus}
                R.id.button2 -> {calculationTypeSelected = CalType.CalculationType.Minus}
                R.id.button3 -> {calculationTypeSelected = CalType.CalculationType.Multiply}
                R.id.button4 -> {
                    calculationTypeSelected = CalType.CalculationType.Divide
                    //0 check
                    if (secondNumber  == 0F) {
                        showAlertDialog()
                    return
                }
            }
            else -> {calculationTypeSelected = CalType.CalculationType.Plus}
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE1", firstNumber)
        intent.putExtra("VALUE2", secondNumber)

        intent.putExtra("CalType",calculationTypeSelected)
        startActivity(intent)
    }

    private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("数値エラー")
        alertDialogBuilder.setMessage("0では分けられません")

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}