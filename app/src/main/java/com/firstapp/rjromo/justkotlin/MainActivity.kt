package com.firstapp.rjromo.justkotlin

//import android.R

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.text.NumberFormat



/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    var quantity: Int = 0

    fun increment(view: View) {
        quantity++
        display(quantity)
        displayPrice( quantity * 5)
    }

    fun decrement(view: View) {
        quantity--
        display(quantity)
        displayPrice( quantity * 5)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        val message:String = "Thank you"
        displayMessage(message)
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private fun display(number: Int) {
        val quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.text = "" + number
    }

    /**
     * This method displays the given price on the screen.
     */
    private fun displayPrice(number: Int) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }
    /**
     * This method displays a message on the screen.
     */
    private fun displayMessage(message: String){
        val priceTextView = findViewById<> (R.id.price_text_view) as TextView
        priceTextView.text = message
    }



}
