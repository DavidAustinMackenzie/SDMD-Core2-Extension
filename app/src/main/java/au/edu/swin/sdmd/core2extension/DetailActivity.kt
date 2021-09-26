package au.edu.swin.sdmd.core2extension

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import au.edu.swin.sdmd.core2.Location
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import java.util.regex.Pattern

class DetailActivity : AppCompatActivity() {
    //Class variables
    private var location: Location?  = null
    lateinit var ratTrack: RatingBar
    lateinit var txtCountry: TextView
    lateinit var txtLocation: TextView
    lateinit var txtDate: TextView
    lateinit var editCountryLayout: TextInputLayout
    lateinit var editLocationLayout: TextInputLayout
    lateinit var editDateLayout: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Get Edit Text Layouts
        editCountryLayout = findViewById<TextInputLayout>(R.id.editCountryLayout)
        editLocationLayout = findViewById<TextInputLayout>(R.id.editLocationLayout)
        editDateLayout = findViewById<TextInputLayout>(R.id.editDateLayout)

        location = intent.getParcelableExtra<Location>("location")

        //Get all the variables passed in from parceable object
        location?.let {
            txtCountry = findViewById<TextView>(R.id.editCountry)
            txtCountry.text = it.country

            txtLocation = findViewById<TextView>(R.id.editLocation)
            txtLocation.text = it.city

            txtDate = findViewById<TextView>(R.id.editDate)
            txtDate.text = it.date

            ratTrack = findViewById<RatingBar>(R.id.ratTrack)
            ratTrack.rating = it.rating

            val imgTrack = findViewById<ImageView>(R.id.imgViewTrack)
            imgTrack.setImageResource(it.picture)
        }
    }
    override fun onBackPressed(){
        //Get input values
        val country = txtCountry.text.toString()
        val city = txtLocation.text.toString()
        val rating = ratTrack.rating
        val date = txtDate.text.toString()

        //Validate Country
        if(validateLocation((country))){
            editCountryLayout.error = null
        }else{
            editCountryLayout.error = "Please enter a country with letters and spaces only"
        }

        //Validate Location
        if(validateLocation((city))){
            editLocationLayout.error = null
        }else{
            editLocationLayout.error = "Please enter a city with letters and spaces only"
        }

        //Validate date
        if(validateDate((date))){
            editDateLayout.error = null
        }else{
            editDateLayout.error = "Please enter a valid date e.g. 20/10/2021"
        }

        //Validate all inputs to allow data to be sent to previous activity
        if(validateLocation(country) && validateLocation(city) && validateDate(date)){
            //Reset form errors
            editCountryLayout.error = null
            editLocationLayout.error = null
            editDateLayout.error = null

            //Update Location object properties
            location?.country = country
            location?.city = city
            location?.rating = rating
            location?.date = date

            val i = intent.apply{
                putExtra("location",location)
            }
            setResult(Activity.RESULT_OK,i)
            super.onBackPressed()
            Toast.makeText(this, "$country updated!",Toast.LENGTH_SHORT).show()
        }

    }

    //Checks for empty space, letters and spaces only, no special characters or numbers allowed
    private fun validateLocation(input: String):Boolean{
        val testLocation = Regex(pattern = """^[a-zA-Z\s]+$""")
        if(input.isEmpty()) {
            return false
        } else if(!testLocation.matches(input) ){
            return false
        }
        return true
    }

    //Checks for valid date format "dd/mm/yyyy"
    private fun validateDate(input: String): Boolean{
        val testDate = Regex(pattern = """\d{2}/\d{2}/\d{4}""")
        return testDate.matches(input)
    }
}