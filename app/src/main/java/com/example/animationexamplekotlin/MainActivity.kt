package com.example.animationexamplekotlin

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager

class MainActivity : AppCompatActivity() {
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene // this is the scene which is currently showing on the screen
    private lateinit var transition: Transition

     // This is the tutorial video : https://www.youtube.com/watch?v=B2jZ439bytI&t=708s
     // This is activity shows an example of using 'Tranisiton api' to animate layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // we will swap between scenes inside the "sceneRootFrameLayout" Frame layout. Initially we inflate scene 1 into the layout
        // observe id of common elements of scene 1 and 2 are same like id of the image view in both are same

        // Step 1: Create a Scene object for both the starting and ending layout
        var sceneRootFrameLayout = findViewById<FrameLayout>(R.id.sceneRootFrameLayout)

        scene1 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene2, this)

        scene1.enter()
        currentScene = scene1

        // Step 2: Create a Transition object to define what type of animation you want(like whether you want fade animation or slide animation etc)
        // If you don't specify the type of transition then by default ir will choose 'Auto Transition'

        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_1)

      // IMP : currently this one transition will be applied to whole view/layout , If we want different transitions to be performed for different views in a layout then we should use 'TranisitionSet' I have used it in MainActivity 2
    }

    fun onClick(view: View) { // I have mentioned this function in activity main's constraint layout's xml 'onClick' attribute
        // Step 3: Call TransitionManager.go() to run animation
        if (currentScene == scene1) {
            TransitionManager.go(scene2, transition)
            currentScene = scene2
        } else {
            TransitionManager.go(scene1, transition)
            currentScene = scene1
        }
    }

    fun onClick2(view: View) {}
}