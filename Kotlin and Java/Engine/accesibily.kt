ppackage com.synapsify.engine

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.synapsify.data.StatsManager

class AppDetectorService : AccessibilityService() {
    private val engine = CoreEngine()
    private val session = FocusSession()
    private lateinit var stats: StatsManager

    override fun onServiceConnected() {
        super.onServiceConnected()
        // Initialize the XP vault
        stats = StatsManager(applicationContext)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Only run when the app window/package changes
        if (event?.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val packageName = event.packageName?.toString() ?: ""

            if (packageName == "com.synapsify.app") {
                // You're in the "Safe Zone" - Start/Resume tracking XP
                session.startSession()
            } 
            else if (engine.checkAppStatus(packageName)) {
                // Caught in a distraction! End session, save earned XP, and block
                val earnedXP = session.endSession()
                if (earnedXP > 0) {
                    stats.addXP(earnedXP)
                }
                
                // Return to Home screen immediately
                performGlobalAction(GLOBAL_ACTION_HOME)
            }
        }
    }

    override fun onInterrupt() {
        // Cleanup session if the service is stopped
        session.endSession()
    }
}