package com.example.animationexamplekotlin

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

class MainActivity5 : AppCompatActivity() {

    // This activity implements 'Physics Based Animation'
    // there are 2 types I guess , Spring and Fling animation
    // In this example I have used Spring animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val imageView = findViewById<ImageView>(R.id.imageViewToAnimate)
        imageView.setOnClickListener {
            // initially view will be at 0f and when user click on image it will go to 1200f and if its already in 1200f then it will not do anything

            mySpringAnimation(it, 1200f) // this will move it to 1200f from 0f
            mySpringAnimation(it, 0f) // this will move it back to 0f from 1200f
        }
    }

    fun mySpringAnimation(view: View, position: Float) {
        // we sort of create our own spring which we attach to the view which will be pulling our view
        val springAnimation = SpringAnimation(view, DynamicAnimation.TRANSLATION_Y)
        val springForce = SpringForce()
        springForce.setStiffness(SpringForce.STIFFNESS_LOW) // this refers to the stiffness of the spring
        springForce.setFinalPosition(position)
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)
        springAnimation.setSpring(springForce)
        springAnimation.start()
    }
}