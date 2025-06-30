package com.example.pharmacyapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.pharmacyapp.R
import java.util.concurrent.Executor

class LoginActivity : AppCompatActivity() {
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.btnLogin)

        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(applicationContext, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show()
                    // يمكنك الانتقال إلى MainActivity بعد نجاح الدخول بالبصمة
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "فشل التحقق من البصمة", Toast.LENGTH_SHORT).show()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("تسجيل الدخول")
            .setSubtitle("استخدم بصمة الإصبع للمتابعة")
            .setNegativeButtonText("إلغاء")
            .build()

        loginButton.setOnClickListener {
            val biometricManager = BiometricManager.from(this)
            if (biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS) {
                biometricPrompt.authenticate(promptInfo)
            } else {
                Toast.makeText(this, "جهازك لا يدعم البصمة أو لم يتم إعدادها", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
