package com.app.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.news.astronomy.AstronomyFragment
import com.app.news.news.NewsFragment
import com.app.news.weather.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_drawer.*
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

        navItemNewsContainer.setOnClickListener { startNewsFragment() }
        navItemAstronomyContainer.setOnClickListener { startAstronomyFragment() }
        navItemWeatherContainer.setOnClickListener { startWeatherFragment() }
    }

    private fun startNewsFragment() {
        val newsFragment = NewsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.flyt_container_body, newsFragment).commit()
        txt_toolbar_title.text = resources.getString(R.string.news)
        drawer_layout.close()
    }

    private fun startAstronomyFragment() {
        val astronomyFragment = AstronomyFragment()
        supportFragmentManager.beginTransaction().replace(R.id.flyt_container_body, astronomyFragment).commit()
        txt_toolbar_title.text = resources.getString(R.string.astronomy)
        drawer_layout.close()
    }

    private fun startWeatherFragment() {
        val weatherFragment = WeatherFragment()
        supportFragmentManager.beginTransaction().replace(R.id.flyt_container_body, weatherFragment).commit()
        txt_toolbar_title.text = resources.getString(R.string.weather)
        drawer_layout.close()
    }
}