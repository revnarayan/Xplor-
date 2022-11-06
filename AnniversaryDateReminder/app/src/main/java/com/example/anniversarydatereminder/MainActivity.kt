package com.example.anniversarydatereminder

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.anniversarydatereminder.ui.AnniversaryDateFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parentLayout: View = findViewById(android.R.id.content)
        Snackbar.make(parentLayout, getString(R.string.welcome_message), Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(applicationContext,R.color.gold))
            .setBackgroundTint(ContextCompat.getColor(applicationContext,R.color.black))
            .show()
        val anniversaryDateFragment = AnniversaryDateFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fm_mainActivity, anniversaryDateFragment).commit()
    }


}