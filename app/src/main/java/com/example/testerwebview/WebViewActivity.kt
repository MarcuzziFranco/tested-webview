package com.example.testerwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.testerwebview.MainActivity.Companion.KEY_URL
import com.example.testerwebview.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding
    private var url=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        url = getURL()
        loadWebview()

    }

    fun getURL(): String {
       return intent.getStringExtra(KEY_URL)?:""
    }

    private fun loadWebview(){
        binding.wbRoot.webViewClient = WebViewClient();
        binding.wbRoot.settings.javaScriptEnabled= true;
        binding.wbRoot.loadUrl(url)
    }


}