package com.synapsify.engine

import android.os.SystemClock

class FocusSession {
    private var startTime: Long = 0
    private var isRunning: Boolean = false

    fun startSession() {
        startTime = SystemClock.elapsedRealtime()
        isRunning = true
    }

    fun endSession(): Int {
        if (!isRunning) return 0
        
        val endTime = SystemClock.elapsedRealtime()
        val durationMinutes = ((endTime - startTime) / 60000).toInt()
        isRunning = false
        
        // Surgical XP Formula: 10 XP per minute + 50 XP bonus for completing a session
        return (durationMinutes * 10) + 50
    }

    fun getCurrentDuration(): Int {
        if (!isRunning) return 0
        return ((SystemClock.elapsedRealtime() - startTime) / 60000).toInt()
    }
}