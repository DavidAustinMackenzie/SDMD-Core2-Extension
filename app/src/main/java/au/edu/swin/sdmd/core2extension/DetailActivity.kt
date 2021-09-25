package au.edu.swin.sdmd.core2extension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import au.edu.swin.sdmd.core2.Location

class DetailActivity : AppCompatActivity() {
    //Class variables
    private var location: Location?  = null
    lateinit var ratTrack: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        location = intent.getParcelableExtra<Location>("location")

        //Get all the variables passed in from parceable object
        location?.let {
            val txtCountry = findViewById<TextView>(R.id.txtCountry)
            txtCountry.text = it.country

            val txtLocation = findViewById<TextView>(R.id.txtLocation)
            txtLocation.text = it.city

            val txtDate = findViewById<TextView>(R.id.txtDate)
            txtDate.text = it.date

            ratTrack = findViewById<RatingBar>(R.id.ratTrack)
            ratTrack.rating = it.rating

            val imgTrack = findViewById<ImageView>(R.id.imgViewTrack)
            imgTrack.setImageResource(it.picture)
        }
    }
}