package br.com.wilson.app.imersivetest

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView

/**
 * @author Wilson Moura
 *
 *  Implementação da view imersiva
 *
 */

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val ApplicationURI: String = "https://google.com.br"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView: View = window.decorView;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
        setContentView(R.layout.activity_main)

        val mHubview: WebView = findViewById(R.id.webview)
        val mHubconfig: WebSettings = mHubview.settings
        mHubconfig.javaScriptEnabled = true
        mHubconfig.setSupportZoom(false)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mHubconfig.cacheMode= WebSettings.LOAD_NO_CACHE
        }

        mHubview.loadUrl(ApplicationURI)
    }
}