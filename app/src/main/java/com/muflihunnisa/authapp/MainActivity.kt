package com.muflihunnisa.authapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object{
        fun getLaunchService(from: Context) = Intent(from, MainActivity::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    val db = FirebaseFirestore.getInstance()
    val user : MutableMap<String, Any> = HashMap()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setConvigurationUi()

    }

    private fun setConvigurationUi() {
        btn_sign_out.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        startActivity(LoginActivity.getLaunchService(this))
            FirebaseAuth.getInstance().signOut()
    }
}