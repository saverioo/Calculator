package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    // FLAG
    private var canAddOperation = false
    private var canAddDecimal = true
    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ID
        val operands = findViewById<TextView>(R.id.tvOperands)
        val result = findViewById<TextView>(R.id.tvResult)

        // SETUP NUMBER BUTTONS

        val b0 = findViewById<Button>(R.id.b0)
        b0.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b0), findViewById<TextView>(R.id.tvOperands))
        }

        val b1 = findViewById<Button>(R.id.b1)
        b1.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b1), findViewById<TextView>(R.id.tvOperands))
        }

        val b2 = findViewById<Button>(R.id.b2)
        b2.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b2), findViewById<TextView>(R.id.tvOperands))
        }

        val b3 = findViewById<Button>(R.id.b3)
        b3.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b3), findViewById<TextView>(R.id.tvOperands))
        }

        val b4 = findViewById<Button>(R.id.b4)
        b4.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b4), findViewById<TextView>(R.id.tvOperands))
        }

        val b5 = findViewById<Button>(R.id.b5)
        b5.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b5), findViewById<TextView>(R.id.tvOperands))
        }

        val b6 = findViewById<Button>(R.id.b6)
        b6.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b6), findViewById<TextView>(R.id.tvOperands))
        }

        val b7 = findViewById<Button>(R.id.b7)
        b7.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b7), findViewById<TextView>(R.id.tvOperands))
        }

        val b8 = findViewById<Button>(R.id.b8)
        b8.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b8), findViewById<TextView>(R.id.tvOperands))
        }

        val b9 = findViewById<Button>(R.id.b9)
        b9.setOnClickListener() {
            operands.text = buttonNumber(findViewById<Button>(R.id.b9), findViewById<TextView>(R.id.tvOperands))
        }

        // SETUP OPERATION BUTTONS

        val bsum = findViewById<Button>(R.id.bSum)
        bsum.setOnClickListener() {
            operands.text = buttonOperation(findViewById<Button>(R.id.bSum), findViewById<TextView>(R.id.tvOperands))
        }

        val bsub = findViewById<Button>(R.id.bSubtraction)
        bsub.setOnClickListener() {
            operands.text = buttonOperation(findViewById<Button>(R.id.bSubtraction), findViewById<TextView>(R.id.tvOperands))
        }

        val bmul = findViewById<Button>(R.id.bMultiplication)
        bmul.setOnClickListener() {
            operands.text = buttonOperation(findViewById<Button>(R.id.bMultiplication), findViewById<TextView>(R.id.tvOperands))
        }

        val bdiv = findViewById<Button>(R.id.bDivision)
        bdiv.setOnClickListener() {
            operands.text = buttonOperation(findViewById<Button>(R.id.bDivision), findViewById<TextView>(R.id.tvOperands))
        }

        val bcomma = findViewById<Button>(R.id.bComma)
        bcomma.setOnClickListener() {
            operands.text = buttonOperation(findViewById<Button>(R.id.bComma), findViewById<TextView>(R.id.tvOperands))
        }

        val bperc = findViewById<Button>(R.id.bPercentage)
        bperc.setOnClickListener(){
            operands.text = buttonOperation(findViewById<Button>(R.id.bPercentage), findViewById<TextView>(R.id.tvOperands))
        }

        // SETUP ALL CLEAR BUTTON
        val bac = findViewById<Button>(R.id.bAllClear)
        bac.setOnClickListener() {
            operands.text = ""
            result.text = ""
            canAddOperation = false
        }

        //SETUP BACKSPACE BUTTON
        val bbs = findViewById<Button>(R.id.bBackSpace)
        bbs.setOnClickListener() {
            val length = operands.text.length
            if (length > 1) {
                val l: String
                l = operands.text.toString()
                val c = l[length-2]
                operands.text = operands.text.subSequence(0, length - 1)
                //canAddOperation è false se c è = a uno di quei caratteri
                canAddOperation = !(c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '.')
            }
            else {
                canAddOperation = false
                operands.text = ""
                result.text = ""
            }
        }
        //SETUP EQUALS BUTTON WITH MATHS API

        val bequ = findViewById<Button>(R.id.bEquals)
        bequ.setOnClickListener() {
            val queue = Volley.newRequestQueue(this)
            val str = URLEncoder.encode(operands.text.toString(),"UTF-8")
            val url = "https://api.mathjs.org/v4/?expr=${str}"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    result.text = response
                },
                Response.ErrorListener { result.text = "That didn't work!" })

// Add the request to the RequestQueue.
            queue.add(stringRequest)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun buttonNumber(b: Button, op: TextView): String {
            //if (op.text == ".") {
                if (canAddDecimal) {
                    when (b.text) {
                        "0" -> op.text = op.text.toString() + "0"
                        "1" -> op.text = op.text.toString() + "1"
                        "2" -> op.text = op.text.toString() + "2"
                        "3" -> op.text = op.text.toString() + "3"
                        "4" -> op.text = op.text.toString() + "4"
                        "5" -> op.text = op.text.toString() + "5"
                        "6" -> op.text = op.text.toString() + "6"
                        "7" -> op.text = op.text.toString() + "7"
                        "8" -> op.text = op.text.toString() + "8"
                        "9" -> op.text = op.text.toString() + "9"
                    }
                }
               // canAddDecimal = false
           // } else
                //op.text = op.text.toString() + b.text
            canAddOperation = true
            return op.text.toString()
        }
        @SuppressLint("SetTextI18n")
        private fun buttonOperation(b: Button, op: TextView): String{
            if (canAddOperation) {
                when (b.text) {
                    "+" -> op.text = op.text.toString() + "+"
                    "-" -> op.text = op.text.toString() + "-"
                    "*" -> op.text = op.text.toString() + "*"
                    "/" -> op.text = op.text.toString() + "/"
                    "%" -> op.text = op.text.toString() + "%"
                    "." -> op.text = op.text.toString() + "."
                }
                canAddOperation = false
                canAddDecimal = true
            }
            return op.text.toString()
        }
}

