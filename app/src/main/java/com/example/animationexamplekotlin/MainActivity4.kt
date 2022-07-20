package com.example.animationexamplekotlin

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {
    // this is to test 'Drawable Animation'
    // see the 'drawable_animation.xml' file in drawable folder

    // basically drawable animation is simply changing photos/vectors after sometime so that it creates an illusion of video being played
    lateinit var batteryAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        batteryAnimation = AnimationDrawable()
        val imageHolder = findViewById<ImageView>(R.id.imageHolder)
        imageHolder.setBackgroundResource(R.drawable.drawable_animation) // this will set the background to the animation that we made
        batteryAnimation = imageHolder.background as AnimationDrawable
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        batteryAnimation.start() // we cannot start it in onCreate because
        // this line 'batteryAnimation = imageHolder.background as AnimationDrawable' will
        // not be executed fully like I guess its a async operation so we can either
        // start animation in onClick of a button or here in 'onWindowFocusChanged'
        // this will start the animation immediately

    }
}