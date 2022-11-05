package com.example.anniversarydatereminder.ui

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.anniversarydatereminder.MainActivity
import com.example.anniversarydatereminder.R
import org.hamcrest.CoreMatchers.allOf

import org.junit.Rule
import org.junit.Test

class AnniversaryDateFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    //Test if the recyclerview comes into view
    @Test
    fun test_isAnniversaryDateFragmentVisible_onAppLaunch(){
        onView(withId(R.id.rvMain)).check(matches(isDisplayed()))
    }
}