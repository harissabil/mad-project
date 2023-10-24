package com.harissabil.madintroduction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Deklarasi tombol login dan register
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan tombol-tombol dengan elemen di layout XML
        btnLogin = findViewById(R.id.btn_login)
        btnRegister = findViewById(R.id.btn_register)

        // Mengatur tindakan yang akan dilakukan saat tombol login ditekan
        btnLogin.setOnClickListener {
            // Membuat objek intent untuk mengarahkan ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            // Memulai LoginActivity
            startActivity(intent)
        }

        // Mengatur tindakan yang akan dilakukan saat tombol register ditekan
        btnRegister.setOnClickListener {
            // Membuat objek intent untuk mengarahkan ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            // Memulai RegisterActivity
            startActivity(intent)
        }
    }
}
