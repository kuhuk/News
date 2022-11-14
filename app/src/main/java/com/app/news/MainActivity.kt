package com.app.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.news.news.NewsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleHamburgerClicks()
        startNewsFragment()
    }

    private fun handleHamburgerClicks() {
        img_hamburger.setOnClickListener { drawer_layout.open() }
    }

    private fun startNewsFragment() {
        val newsFragment = NewsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.flyt_container_body, newsFragment).commit()
    }
}