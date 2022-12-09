package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityPontuacoesBinding

class Pontuacoes : AppCompatActivity() {

    private lateinit var binding : ActivityPontuacoesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPontuacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contadorJog0 = intent.getStringExtra("contadorJog0")
        val contadorJog1 = intent.getStringExtra("contadorJog1")
        val contadorEmpates = intent.getStringExtra("contadorEmpates")

        binding.tfJog1.text = contadorJog0
        binding.tfJog2.text = contadorJog1
        binding.tfEmpates.text = contadorEmpates

        val actionBar = supportActionBar

            actionBar!!.title = "Pontuações"

            actionBar.setDisplayHomeAsUpEnabled(true)

        binding.btnRetroceder.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}



