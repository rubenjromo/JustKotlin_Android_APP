package com.firstapp.rjromo.justkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.text.NumberFormat


/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var mAdView : AdView


        MobileAds.initialize(this, "ca-app-pub-4597919722020460~5704079985")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)




    }

    var quantity: Int = 0

    private fun calculatePrice(view: View):Int{
        var price = quantity * 5
        return price
    }

    fun increment(view: View) {
        quantity++
        display(quantity)
        displayPrice(calculatePrice())
    }

    fun decrement(view: View) {
        quantity--
        display(quantity)
        displayPrice(calculatePrice())
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        val message: String = "Total: ${NumberFormat.getCurrencyInstance().format(calculatePrice())} \nThank you"
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
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = message
    }


}
