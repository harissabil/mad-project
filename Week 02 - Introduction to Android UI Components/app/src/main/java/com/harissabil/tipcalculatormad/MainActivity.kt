package com.harissabil.tipcalculatormad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan variabel dengan elemen-elemen dalam layout XML
        val etTagihan: EditText = findViewById(R.id.et_tagihan)
        val etPersentase: EditText = findViewById(R.id.et_persentase)
        val btnHitung: Button = findViewById(R.id.btn_hitung)
        val tvHitung: TextView = findViewById(R.id.tv_hasil)

        // Mengatur tindakan yang akan dilakukan saat tombol hitung ditekan
        btnHitung.setOnClickListener {
            // Dapatkan jumlah tagihan dan persentase tip dari EditText
            val tagihan = etTagihan.text.toString().toDoubleOrNull() ?: 0.0
            val persentase = etPersentase.text.toString().toDoubleOrNull() ?: 0.0

            // Hitung jumlah tip
            val jumlahTagihan = tagihan * persentase / 100

            // Format jumlah tip sebagai mata uang Rupiah
            val indonesiaRupiah = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(indonesiaRupiah).format(jumlahTagihan)

            // Tampilkan jumlah tip yang sudah diformat dengan format string yang ada di res/string
            tvHitung.text = getString(R.string.hasil_tip, formatRupiah)
        }
    }
}
