package com.example.animationexamplekotlin

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager

class MainActivity2 : AppCompatActivity() {
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition
    // this example is also present in the same video which I refered in activity 1
    // We are continuing the type of animation used in activity 1 (ie. using Transition Api)
    // but here we are using TransitionSet which will basically club different animations in one
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var sceneRootFrameLayout2 = findViewById<FrameLayout>(R.id.sceneRootFrameLayout2)
        scene1 = Scene.getSceneForLayout(sceneRootFrameLayout2, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(sceneRootFrameLayout2, R.layout.scene2, this)

        scene1.enter()
        currentScene = scene1



        // See the example_2 file
        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2) // See example_2 xml file it has different transitions defined in it
        // by default the transitions mentioned in transition set will be executed together because by default the value passed to its 'transitionOrder' attribute is together . Though we can change it to sequential as I did in the 'example_2' xml
    }

    fun onClick2(view: View) {
        if (currentScene == scene1) {
            TransitionManager.go(scene2, transition)
            currentScene = scene2
        } else {
            TransitionManager.go(scene1, transition)
            currentScene = scene1
        }
    }
}