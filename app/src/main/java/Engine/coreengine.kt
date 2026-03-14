package com.synapsify.engine

class CoreEngine {
    // List of apps that trigger the glove (add your own here)
    private val distractionApps = listOf("com.instagram.android", "com.twitter.android", "com.zhiliaoapp.musically")

    fun checkAppStatus(packageName: String): Boolean {
        if (distractionApps.contains(packageName)) {
            triggerGloveSignal()
            return true // App is blocked
        }
        return false // App is safe
    }

    private fun triggerGloveSignal() {
        // This is where we will hook in the Bluetooth code for your Arduino Nano
        println("SIGNAL SENT: TRIGGER HAPTIC GLOVE")
    }
}