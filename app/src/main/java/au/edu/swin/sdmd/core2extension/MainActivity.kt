package au.edu.swin.sdmd.core2extension

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import au.edu.swin.sdmd.core2.Location

/*
* Images sourced from: www.formula1.com
* */

class MainActivity : AppCompatActivity() {
    //Class level TextView variables
    lateinit var txtAbuDhabi: TextView
    lateinit var txtAlbertPark: TextView
    lateinit var txtMonaco: TextView
    lateinit var txtMonza: TextView
    lateinit var txtRatingAbuDhabi: TextView
    lateinit var txtRatingAlbertPark: TextView
    lateinit var txtRatingMonaco: TextView
    lateinit var txtRatingMonza: TextView

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

    //Used to pass data to DetailActivity
    var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get elements on the view
        val imgAbuDhabi = findViewById<ImageView>(R.id.imgViewAbuDhabi)
        val imgAlbertPark = findViewById<ImageView>(R.id.imgViewAlbertPark)
        val imgMonaco = findViewById<ImageView>(R.id.imgViewMonaco)
        val imgMonza = findViewById<ImageView>(R.id.imgViewMonza)
        txtAbuDhabi = findViewById<TextView>(R.id.txtAbuDhabi)
        txtAlbertPark = findViewById<TextView>(R.id.txtAlbertPark)
        txtMonaco = findViewById<TextView>(R.id.txtMonaco)
        txtMonza = findViewById<TextView>(R.id.txtMonza)
        txtRatingAbuDhabi = findViewById<TextView>(R.id.txtRatingAbuDhabi)
        txtRatingAlbertPark = findViewById<TextView>(R.id.txtRatingAlbertPark)
        txtRatingMonaco = findViewById<TextView>(R.id.txtRatingMonaco)
        txtRatingMonza = findViewById<TextView>(R.id.txtRatingMonza)

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
            startForResult.launch(intent)
        }
        imgAlbertPark.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            location = albertParkLocation
            intent.putExtra("location", location)
            startForResult.launch(intent)
        }
        imgMonaco.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            location = monacoLocation
            intent.putExtra("location", location)
            startForResult.launch(intent)
        }
        imgMonza.setOnClickListener {
            val intent = Intent(this,DetailActivity::class.java)
            location = monzaLocation
            intent.putExtra("location", location)
            startForResult.launch(intent)
        }
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        when(result.resultCode){
            RESULT_OK ->{
                val data = result.data
                Log.i("LOCATION",data.toString())
                val location = data?.getParcelableExtra<Location>("location")
                var imageId = 0
                location?.let{
                    imageId = location?.picture
                }

                //Update the fields of the location main activity
                when(imageId){
                    R.drawable.abu_dhabi -> {
                        location?.let{
                            abuDhabiLocation = location
                            Log.i("Country",location.country)
                            txtAbuDhabi.text = location.country
                            txtRatingAbuDhabi.text = location.rating.toString()
                        }

                    }
                    R.drawable.albert_park -> {
                        location?.let{
                            albertParkLocation = location
                            Log.i("Country",location.country)
                            txtAlbertPark.text = location.country
                            txtRatingAlbertPark.text = location.rating.toString()
                        }
                    }
                    R.drawable.monaco -> {
                        location?.let{
                            monacoLocation = location
                            Log.i("Country",location.country)
                            txtMonaco.text = location.country
                            txtRatingMonaco.text = location.rating.toString()
                        }
                    }
                    R.drawable.monza -> {
                        location?.let{
                            monzaLocation = location
                            Log.i("Country",location.country)
                            txtMonza.text = location.country
                            txtRatingMonza.text = location.rating.toString()
                        }
                    }
                }
            }
        }
    }
}