package com.example.animationexamplekotlin

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity6 : AppCompatActivity() {

    // This activity implements "Animate between activities " ie. animation played when we switch activities
    // See the theme.xml file and activity_trans_anim.xml(which is present in 'transition' folder)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val btn = findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
}