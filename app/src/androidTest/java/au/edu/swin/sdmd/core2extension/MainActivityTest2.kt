package au.edu.swin.sdmd.core2extension


import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest2 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest2() {
        onView(allOf(withId(R.id.imgViewAbuDhabi))).perform(click())

        onView(allOf(withId(R.id.editDate))).perform(replaceText(""))

        pressBack()

        onView(allOf(withId(R.id.editDateLayout))).check(ViewAssertions.matches(withText("Please enter a valid date e.g. 20/10/2021")))
    }
}
