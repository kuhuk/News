package com.app.news.newsDetail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import com.app.news.R

class NewsDetailFragment : Fragment() {

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_news_detail, container, false)

        processBundleData()
        return view
    }

    private fun processBundleData() {
        if (arguments != null) {
            // this url contains data of news --open it in chrome custom tabs
            val url = requireArguments().get("url")

            val builder = CustomTabsIntent.Builder()
            builder.setShowTitle(true)
            val customTabsIntent : CustomTabsIntent = builder.build()
            customTabsIntent.launchUrl(requireContext(), Uri.parse(url.toString()))
        }
    }
}