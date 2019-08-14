package com.example.dimanaux.animals.facts.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dimanaux.animals.facts.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment.newInstance(this)
        supportFragmentManager.beginTransaction()
            .replace(mainActivity.id, mainFragment)
            .commit()
    }
}
