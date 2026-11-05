package com.shivam.vpn

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(8, 9, 13)
        window.navigationBarColor = Color.rgb(8, 9, 13)
        buildScreen()
    }

    private fun buildScreen() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 32, 28, 32)
            setBackgroundColor(Color.rgb(8, 9, 13))
        }

        val title = TextView(this).apply {
            text = "SHIVAM VPN"
            textSize = 30f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            letterSpacing = 0.08f
        }

        status = TextView(this).apply {
            text = "DISCONNECTED"
            textSize = 22f
            setTextColor(Color.rgb(235, 238, 242))
            gravity = Gravity.CENTER
            setPadding(0, 70, 0, 20)
        }

        val connect = Button(this).apply {
            text = "CONNECT"
            textSize = 17f
            setOnClickListener { requestVpnPermission() }
        }

        val note = TextView(this).apply {
            text = "SECURE NETWORK PANEL\n\nVPN server configuration is not added yet.\nPermission approval alone does not create a VPN connection."
            textSize = 14f
            setTextColor(Color.rgb(160, 170, 180))
            gravity = Gravity.CENTER
            setPadding(12, 42, 12, 0)
        }

        val metrics = TextView(this).apply {
            text = "PING   -- ms       DOWNLOAD   --       UPLOAD   --"
            textSize = 12f
            setTextColor(Color.rgb(50, 214, 154))
            gravity = Gravity.CENTER
            setPadding(0, 48, 0, 0)
        }

        root.addView(title)
        root.addView(status)
        root.addView(connect)
        root.addView(note)
        root.addView(metrics)
        setContentView(root)
    }

    private fun requestVpnPermission() {
        val intent = VpnService.prepare(this)
        if (intent != null) {
            @Suppress("DEPRECATION")
            startActivityForResult(intent, VPN_REQUEST)
        } else {
            status.text = "PERMISSION GRANTED — SERVER NEEDED"
            Toast.makeText(this, "VPN permission is ready. Add a real VPN tunnel configuration next.", Toast.LENGTH_LONG).show()
        }
    }

    @Deprecated("Deprecated by Android API; retained for broad compatibility in this starter.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VPN_REQUEST) {
            status.text = if (resultCode == RESULT_OK) {
                "PERMISSION GRANTED — SERVER NEEDED"
            } else {
                "PERMISSION NOT GRANTED"
            }
        }
    }

    companion object {
        private const val VPN_REQUEST = 1001
    }
}
