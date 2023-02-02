package com.example.tipcalculatorv1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.android.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tipCalc= TipCalculator(0.0f,0.0, 1)
    var money = NumberFormat.getCurrencyInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.amountBill.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) { calculate() }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        //YOUR CODE TO FOR THE TEXT CHANGE HANDLING EVENT FOR TIP PERCENTAGE INPUT
        binding.amountTipPercent.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) { calculate() }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

        binding.amountPartySize.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) { calculate() }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
    }
    fun calculate() {
        // billAmount value set based on amountBill TextView value
        var billAmount: Double = 0.0
        var billTip: Float = 0.0f
        var partySize: Int = 0

        // For Bill
        val amountBill1 = binding.amountBill
        val stringBillAmount = amountBill1.text.toString()

        if (stringBillAmount.isEmpty())
            billAmount = 0.0
        else
            billAmount = stringBillAmount.toDouble()
        tipCalc.bill=billAmount

        //YOUR CODE TO DETERMINE THE AMOUNT OF TIP, AMOUNT TOTAL AND DISPLAY
        //THEM IN THE TEXTBOX
        //Determine the amount of tip and convert it to string

        // For Tip
        val amountTip1 = binding.amountTipPercent
        val stringTipPercent = amountTip1.text.toString()

        if (stringTipPercent.isEmpty())
            billTip = 0.0f
        else
            billTip = stringTipPercent.toFloat()
        tipCalc.tip=.01f * billTip

        // For Party Size
        val partySize1 = binding.amountPartySize
        val stringPartySize = partySize1.text.toString()

        if (stringPartySize.isEmpty())
            partySize = 1
        else
            partySize = stringPartySize.toInt()
        tipCalc.size=partySize

        val amountTip: String = money.format(tipCalc.tipAmount()).toString()

        //Determine the total and convert it to string
        val amountTotal: String = money.format(tipCalc.totalAmount()).toString()

        // Display in the TextView
        binding.amountTip.text = amountTip
        binding.amountTotal.text = amountTotal
    }
}