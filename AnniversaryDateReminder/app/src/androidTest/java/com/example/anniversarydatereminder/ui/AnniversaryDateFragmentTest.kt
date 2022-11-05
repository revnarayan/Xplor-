package com.example.anniversarydatereminder.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.anniversarydatereminder.MainActivity
import com.example.anniversarydatereminder.R

import org.junit.Rule
import org.junit.Test

class AnniversaryDateFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    //Test if the recyclerview comes into view
    @Test
    fun test_isAnniversaryDateFragmentVisible_onAppLaunch(){
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    //check if snackbar comes into view
    @Test
    fun test_isSnackBarVisible(){
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.welcome_message)))
    }

}