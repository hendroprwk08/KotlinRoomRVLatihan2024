package com.room.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.room.kotlin.databinding.ActivityDetilBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class DetilActivity : AppCompatActivity() {
    val TAG = "DetilActivity"
    private lateinit var binding: ActivityDetilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //back button
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onStart() {
        super.onStart()

        val i = intent
        val endemikId = i.getStringExtra("_id")
        val nama = i.getStringExtra("_nama")
        val deskripsi = i.getStringExtra("_deskripsi")
        val foto = i.getStringExtra("_foto")

        binding.toolbar.title = nama
        binding.tvDeskripsi.text = deskripsi
        Glide.with(this@DetilActivity)
            .load(foto)
            .into(binding.image)

        binding.btnFavorite.setOnClickListener {
            // todo: simpan
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}