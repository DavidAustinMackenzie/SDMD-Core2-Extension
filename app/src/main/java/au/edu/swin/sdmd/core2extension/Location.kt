package au.edu.swin.sdmd.core2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val country: String, val city: String,
    val date:String, var rating: Float, val picture:Int
): Parcelable {
}