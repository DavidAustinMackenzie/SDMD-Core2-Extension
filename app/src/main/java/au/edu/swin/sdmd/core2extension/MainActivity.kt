package au.edu.swin.sdmd.core2extension

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import au.edu.swin.sdmd.core2.Location

/*
* Images sourced from: www.formula1.com
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Used to pass data to DetailActivity
        var location: Location? = null

        //Get elements on the view
        val imgAbuDhabi = findViewById<ImageView>(R.id.imgViewAbuDhabi)
        val imgAlbertPark = findViewById<ImageView>(R.id.imgViewAlbertPark)
        val imgMonaco = findViewById<ImageView>(R.id.imgViewMonaco)
        val imgMonza = findViewById<ImageView>(R.id.imgViewMonza)
        val txtAbuDhabi = findViewById<TextView>(R.id.txtAbuDhabi)
        val txtAlbertPark = findViewById<TextView>(R.id.txtAlbertPark)
        val txtMonaco = findViewById<TextView>(R.id.txtMonaco)
        val txtMonza = findViewById<TextView>(R.id.txtMonza)
        val txtRatingAbuDhabi = findViewById<TextView>(R.id.txtRatingAbuDhabi)
        val txtRatingAlbertPark = findViewById<TextView>(R.id.txtRatingAlbertPark)
        val txtRatingMonaco = findViewById<TextView>(R.id.txtRatingMonaco)
        val txtRatingMonza = findViewById<TextView>(R.id.txtRatingMonza)

        //Create location objects
        var abuDhabiLocation = Location("Abu Dhabi","Yas Marina Circuit",
            "15/11/2018",2.0f, R.drawable.abu_dhabi)
        var albertParkLocation = Location("Australia","Albert Park Circuit",
            "12/03/2019",3.0f, R.drawable.albert_park)
        var monacoLocation = Location("Monaco","Monte Carlo Circuit",
            "03/07/2015",4.0f, R.drawable.monaco)
        var monzaLocation = Location(
            "Italy", "Monza Circuit",
            "12/06/2017", 5.0f, R.drawable.monza)

        //Set Track headings
        txtAlbertPark.text = albertParkLocation.country
        txtAbuDhabi.text = abuDhabiLocation.country
        txtMonaco.text = monacoLocation.country
        txtMonza.text = monzaLocation.country

        //Set rating values
        txtRatingAbuDhabi.text = abuDhabiLocation.rating.toString()
        txtRatingAlbertPark.text = albertParkLocation.rating.toString()
        txtRatingMonaco.text = monacoLocation.rating.toString()
        txtRatingMonza.text = monzaLocation.rating.toString()

        //Setup onClick listeners for image views
        imgAbuDhabi.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            location = abuDhabiLocation
            intent.putExtra("location", location)
            startActivity(intent)
        }
        imgAlbertPark.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            location = albertParkLocation
            intent.putExtra("location", location)
            startActivity(intent)
        }
        imgMonaco.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            location = monacoLocation
            intent.putExtra("location", location)
            startActivity(intent)
        }
        imgMonza.setOnClickListener {
            val intent = Intent(this,DetailActivity::class.java)
            location = monzaLocation
            intent.putExtra("location", location)
            startActivity(intent)
        }
    }
}