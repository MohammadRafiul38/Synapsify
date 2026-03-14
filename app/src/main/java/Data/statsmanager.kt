package com.synapsify.data

import android.content.Context
import android.content.SharedPreferences

class StatsManager(context: Context) {
    // This is the "Vault" - a small file that saves your XP on the phone
    private val prefs: SharedPreferences = context.getSharedPreferences("synapsify_vault", Context.MODE_PRIVATE)

    fun addXP(amount: Int) {
        val currentXP = getXP()
        prefs.edit().putInt("total_xp", currentXP + amount).apply()
    }

    fun getXP(): Int {
        return prefs.getInt("total_xp", 1450) // Default starting XP
    }

    fun saveFocusSession(minutes: Int) {
        // Calculation: 10 XP for every minute of focus
        val earnedXP = minutes * 10
        addXP(earnedXP)
    }
}