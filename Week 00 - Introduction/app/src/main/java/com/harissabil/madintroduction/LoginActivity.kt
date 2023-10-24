package com.harissabil.madintroduction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Deklarasi variabel untuk elemen tampilan
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Menghubungkan variabel dengan elemen-elemen dalam layout XML
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        tvRegister = findViewById(R.id.tv_register)
        ivBack = findViewById(R.id.iv_back)

        // Mengatur tindakan yang akan dilakukan saat tombol login ditekan
        btnLogin.setOnClickListener {
            // Mendapatkan teks dari elemen email dan password
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Memeriksa apakah email atau password kosong
            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
            } else if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
            } else {
                // Jika email dan password terisi, menampilkan pesan sukses dengan Toast
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
            }
        }

        // Mengatur tindakan yang akan dilakukan saat teks "Register" ditekan
        tvRegister.setOnClickListener {
            // Membuat objek intent untuk mengarahkan ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            // Memulai RegisterActivity
            startActivity(intent)
        }

        // Mengatur tindakan yang akan dilakukan saat elemen ivBack (tombol kembali) ditekan
        ivBack.setOnClickListener {
            // Memicu aksi kembali seperti saat tombol kembali di sistem ditekan
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
