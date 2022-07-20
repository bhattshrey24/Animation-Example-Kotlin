package com.example.animationexamplekotlin

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Property
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    // Here we are basically trying to implement 'View animation' using ObjectAnimator
    // There is another way to implement 'View animation' ie. by using 'ValueAnimator' try this too some other time
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var button = findViewById<Button>(R.id.button1)
        var box = findViewById<View>(R.id.box)
        button.setOnClickListener {
            // here we are trying to move our box (which is a 'view') in y direction with some animation ie. vertically with some animation and not suddenly

            //This is my function
            animateMyViewUsingObjectAnimator(
                box,
                View.TRANSLATION_Y,
                box.translationY,
                box.translationY + 200f,
                500,
                AccelerateDecelerateInterpolator()
            )

        }

        // We can aslo do it normally by calling '.animate()' on box like this-
        // box.animate().translationY(box.translationY + 200f).setInterpolator(AccelerateDecelerateInterpolator())
        // but I guess '.animate()' does not give as many features as 'ObjectAnimator' like changing the color of view using 'ARGB()' etc
    }

    // now the 1st argument which we passed below is the view that we want to animate ,
    // 2nd argument is the type of animation ie. we want view to move in Y direction therefore ' View.TRANSLATION_Y'
    // 3rd argument is the current 'y' position of the view which can be easily found out by using '.translationY' property
    // 4th argument is the new 'y' position where we want our view to go when user clicks the button so here its simply 100 pixels below the current position of the box therefore 'box.translationY + 100f'
    private fun animateMyViewUsingObjectAnimator(
        box: View?,
        typeOfAnimation: Property<View, Float>?,
        startPoint: Float,
        endPoint: Float,
        duration: Long,
        interpolator: AccelerateDecelerateInterpolator
    ) {
        // we used '.ofFloat()' cause the value that will be changing ie. the y position of box is in float , if we want to change color of box then we can use 'ofARGB()' instead
        val ty = ObjectAnimator.ofFloat(
            box, typeOfAnimation, startPoint, endPoint
        )
        ty.duration = duration // Its in miliseconds
        ty.interpolator = interpolator

        ty.start() // this starts the animation
    }
}