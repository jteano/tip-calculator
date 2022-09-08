package com.example.tipcalculatorv1

class TipCalculator(newTip: Float=0.0f, newBill: Double=0.0) {
    var tip: Float = newTip / 100
        get() = field // getter
        set(value) { // setter
            field = value
        }
    var bill: Double=newBill

        get() = field // getter
        set(value) { // setter
            field = value
    }
    fun tipAmount(): Double {
        return bill * tip
    }
    fun totalAmount(): Double {
        return bill + tipAmount()
    }
}