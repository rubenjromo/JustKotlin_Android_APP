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


    fun increment(view: View) {
        var quantity:Int = 3
        display(quantity)
    }

    fun decrement(view: View) {
        var quantity:Int = 1
        display(quantity)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        var quantity:Int = 2
        display(quantity)
        displayPrice( quantity * 5)
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

}
