package com.firstapp.rjromo.justkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat


/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-4597919722020460~5704079985")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)




    }

    var quantity: Int = 0


    fun increment(view: View) {
        quantity++
        display(quantity)
    }

    fun decrement(view: View) {
        quantity--
        display(quantity)
    }

    /**
     * This method calculate price.
     */
    private fun calculatePrice():Int{
        return quantity * 5

    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        val message: String = createOrderSummary()
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
     * This method displays a message on the screen.
     */
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = message
    }

    fun createOrderSummary():String {
        var priceMessage:String = "Rubén Romo \nQuantity: ${quantity} \nTotal: ${NumberFormat.getCurrencyInstance().format(calculatePrice())} \nThank you!"
        return priceMessage
    }


}
