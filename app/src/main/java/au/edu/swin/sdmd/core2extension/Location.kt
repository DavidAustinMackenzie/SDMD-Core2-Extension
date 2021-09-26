package au.edu.swin.sdmd.core2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    var country: String, var city: String,
    var date:String, var rating: Float, val picture:Int
): Parcelable {
}