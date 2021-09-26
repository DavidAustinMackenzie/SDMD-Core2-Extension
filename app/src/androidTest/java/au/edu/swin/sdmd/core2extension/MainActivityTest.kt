package au.edu.swin.sdmd.core2extension


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import au.edu.swin.sdmd.core2extension.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatImageView = onView(
allOf(withId(R.id.imgViewAbuDhabi),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
7),
isDisplayed()))
        appCompatImageView.perform(click())
        
        val textInputEditText = onView(
allOf(withId(R.id.editCountry), withText("Abu Dhabi"),
childAtPosition(
childAtPosition(
withId(R.id.editCountryLayout),
0),
1),
isDisplayed()))
        textInputEditText.perform(replaceText("A"))
        
        val textInputEditText2 = onView(
allOf(withId(R.id.editCountry), withText("A"),
childAtPosition(
childAtPosition(
withId(R.id.editCountryLayout),
0),
1),
isDisplayed()))
        textInputEditText2.perform(closeSoftKeyboard())
        
        pressBack()
        
        val textView = onView(
allOf(withId(R.id.txtAbuDhabi), withText("A"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView.check(matches(withText("A")))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
