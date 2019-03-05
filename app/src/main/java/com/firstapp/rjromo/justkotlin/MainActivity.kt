package com.firstapp.rjromo.justkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
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

     private var quantity: Int = 2


    fun increment(view:View) {
        if (quantity == 100) {
            Toast.makeText(this,"You can not order more than 100 cups",Toast.LENGTH_SHORT).show()
            return
        }

        quantity++
        display(quantity)
    }

    fun decrement(view:View) {
        if (quantity == 1) {
            Toast.makeText(this,"You can not order less than 1 cup",Toast.LENGTH_SHORT).show()
            return
        }

        quantity--
        display(quantity)
    }

    /**
     * This method calculate price.
     */
    private fun calculatePrice():Int{
        val whippedCreamCheckBox2 = findViewById<CheckBox>(R.id.whipped_cream_checkbox)
        val chocolateCheckBox2 = findViewById<CheckBox>(R.id.chocolate_checkbox)
        return when {
            whippedCreamCheckBox2.isChecked && chocolateCheckBox2.isChecked -> quantity * (5 + 3)
            whippedCreamCheckBox2.isChecked -> quantity * (5 + 1)
            chocolateCheckBox2.isChecked -> quantity * (5 + 2)
            else -> quantity * 5
        }

    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view:View) {
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
        val orderSummaryTextView = findViewById<TextView>(R.id.order_summary_text_view)
        orderSummaryTextView.text = message
    }

    private fun createOrderSummary():String {
        val nameField = findViewById<EditText>(R.id.name_field)
        val name = nameField.text.toString()
        val whippedCreamCheckBox = findViewById<CheckBox>(R.id.whipped_cream_checkbox)
        val chocolateCheckBox = findViewById<CheckBox>(R.id.chocolate_checkbox)
        val priceMessage:String = "Name: $name \nWhipped cream: ${whippedCreamCheckBox.isChecked}" +
                "\nChocolate: ${chocolateCheckBox.isChecked} \nQuantity: $quantity" +
                "\nTotal: ${NumberFormat.getCurrencyInstance().format(calculatePrice())} \nThank you!"
        return priceMessage
    }


}
