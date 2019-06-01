package com.deliverytracking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()/*, PlaceSelectionListener*/ {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*    val autocompleteFragmentFrom = fragmentManager.findFragmentById(R.id.autocomplete_fragmentFrom)
                    as PlaceAutocompleteFragment
            autocompleteFragmentFrom.setOnPlaceSelectedListener(this)
            val autocompleteFragmentTo = fragmentManager.findFragmentById(R.id.autocomplete_fragmentFrom)
                    as PlaceAutocompleteFragment
            autocompleteFragmentTo.setOnPlaceSelectedListener(this)*/

    }

    /*  override fun onPlaceSelected(p0: Place?) {

          Toast.makeText(applicationContext, "" + p0!!.name + p0.latLng, Toast.LENGTH_LONG).show()
      }

      override fun onError(status: Status) {
          Toast.makeText(applicationContext, "" + status.toString(), Toast.LENGTH_LONG).show()
      }
  */
}