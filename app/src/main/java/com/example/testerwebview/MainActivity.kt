package com.example.testerwebview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.testerwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val KEY_URL = "URL_WEBVIEW"
    }

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click clear edit text
        binding.btClearUrl.setOnClickListener {
            binding.etUrl.clearFocus()
            binding.etUrl.setText("")
            hideKeyboard()
            binding.tvError.visibility = View.GONE
        }

        //Click run webview
        binding.btRunWebview.setOnClickListener {
            if(!binding.etUrl.text.isNullOrEmpty())
            {
                var intent = Intent(this,WebViewActivity::class.java)
                intent.putExtra(KEY_URL,binding.etUrl.text.toString())
                startActivity(intent)
            }else {
                binding.tvError.visibility = View.VISIBLE
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }
}