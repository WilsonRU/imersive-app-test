package br.com.wilson.app.imersivetest

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Wilson Moura
 *
 *  Implementação da Tela de Carregamento
 */

@Suppress("DEPRECATION")
class LoadingActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_loading)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
            finish();
        }, 3000);
    }
}