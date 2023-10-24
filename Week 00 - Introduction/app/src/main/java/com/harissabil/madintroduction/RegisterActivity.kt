package com.harissabil.madintroduction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    // Deklarasi variabel untuk elemen tampilan
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvLogin: TextView
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Menghubungkan variabel dengan elemen-elemen dalam layout XML
        etFullName = findViewById(R.id.et_full_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        btnRegister = findViewById(R.id.btn_register)
        tvLogin = findViewById(R.id.tv_login)
        ivBack = findViewById(R.id.iv_back)

        // Mengatur tindakan yang akan dilakukan saat tombol "Daftar" ditekan
        btnRegister.setOnClickListener {
            // Mengambil teks dari elemen-elemen input
            val fullName = etFullName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Memeriksa apakah semua kolom telah diisi
            if (fullName.isEmpty()) {
                etFullName.error = "Nama lengkap tidak boleh kosong"
            } else if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
            } else if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
            } else if (confirmPassword.isEmpty()) {
                etConfirmPassword.error = "Konfirmasi password tidak boleh kosong"
            } else if (password != confirmPassword) {
                etConfirmPassword.error = "Konfirmasi password tidak sesuai"
            } else {
                // Jika semua data telah diisi dengan benar, tampilkan pesan sukses menggunakan Toast
                Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
                // Selesaikan aktivitas pendaftaran dan kembali ke aktivitas sebelumnya
                finish()
            }
        }

        // Mengatur tindakan yang akan dilakukan saat teks "Login" ditekan
        tvLogin.setOnClickListener {
            // Membuat objek intent untuk mengarahkan ke LoginActivity)\
            val intent = Intent(this, LoginActivity::class.java)
            // Memulai LoginActivity
            startActivity(intent)
        }

        // Mengatur tindakan yang akan dilakukan saat elemen ivBack (tombol kembali) ditekan
        ivBack.setOnClickListener {
            // Memicu aksi kembali seperti saat tombol kembali di sistem ditekan
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
