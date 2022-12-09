package com.example.tictactoe

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityMainBinding
import com.example.tictactoe.databinding.ActivityPontuacoesBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;
    val jog0 = "X"
    val jog1 = "O"
    var contadorJog0 = 0
    var contadorJog1 = 0
    var contadorEmpates = 0
    lateinit var jogAtual : String
    val color = Color.parseColor("#31FF22")
    val colorOrig = Color.parseColor("#FFFF5722")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinuar.isVisible = false


        //Sortear o jogador Inicial
        sorteiaJogador()


        //Listenrs
        binding.btn11.setOnClickListener{
            if(binding.btn11.text.isBlank() || binding.btn11.text.isEmpty()) {
                binding.btn11.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn12.setOnClickListener{
            if(binding.btn12.text.isBlank() || binding.btn12.text.isEmpty()) {
                binding.btn12.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn13.setOnClickListener{
            if(binding.btn13.text.isBlank() || binding.btn13.text.isEmpty()) {
                binding.btn13.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn21.setOnClickListener{
            if(binding.btn21.text.isBlank() || binding.btn21.text.isEmpty()) {
                binding.btn21.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn22.setOnClickListener{
            if(binding.btn22.text.isBlank() || binding.btn22.text.isEmpty()) {
                binding.btn22.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn23.setOnClickListener{
            if(binding.btn23.text.isBlank() || binding.btn23.text.isEmpty()) {
                binding.btn23.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn31.setOnClickListener{
            if(binding.btn31.text.isBlank() || binding.btn31.text.isEmpty()) {
                binding.btn31.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn32.setOnClickListener{
            if(binding.btn32.text.isBlank() || binding.btn32.text.isEmpty()) {
                binding.btn32.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btn33.setOnClickListener {
            if (binding.btn33.text.isBlank() || binding.btn33.text.isEmpty()) {
                binding.btn33.text = jogAtual
                VerificaVencedor()
                trocaJogador()
            }
        }

        binding.btnContinuar.setOnClickListener{

            binding.TxtIndicaVencedor.text = ""
            binding.btnContinuar.isVisible  = false

            binding.btn11.text = ""
            binding.btn12.text = ""
            binding.btn13.text = ""
            binding.btn21.text = ""
            binding.btn22.text = ""
            binding.btn23.text = ""
            binding.btn31.text = ""
            binding.btn32.text = ""
            binding.btn33.text = ""


            binding.btn11.isEnabled = true
            binding.btn12.isEnabled = true
            binding.btn13.isEnabled = true
            binding.btn21.isEnabled = true
            binding.btn22.isEnabled = true
            binding.btn23.isEnabled = true
            binding.btn31.isEnabled = true
            binding.btn32.isEnabled = true
            binding.btn33.isEnabled = true

            binding.btn11.setTextColor(colorOrig);binding.btn12.setTextColor(colorOrig);binding.btn13.setTextColor(colorOrig);
            binding.btn21.setTextColor(colorOrig);binding.btn22.setTextColor(colorOrig);binding.btn23.setTextColor(colorOrig);
            binding.btn31.setTextColor(colorOrig);binding.btn32.setTextColor(colorOrig);binding.btn33.setTextColor(colorOrig);
        }

        binding.btnPontuacoes.setOnClickListener{
            val intent : Intent = Intent(this, Pontuacoes::class.java)
            intent.putExtra("contadorJog0", "O jogador 'x': $contadorJog0 Vitórias")
            intent.putExtra("contadorJog1", "O jogador 'o': $contadorJog1 Vitórias")
            intent.putExtra("contadorEmpates", "Empates: $contadorEmpates")
            startActivity(intent)
        }
    }

    private fun VerificaVencedor() {
        var contador : Int

        //Verificar Horizontal
        if(binding.btn11.text == jogAtual && binding.btn12.text == jogAtual && binding.btn13.text == jogAtual){
            binding.btn11.setTextColor(color); binding.btn12.setTextColor(color); binding.btn13.setTextColor(color)
            FinalizaJogo(0)
            return
        }
        if(binding.btn21.text == jogAtual && binding.btn22.text == jogAtual && binding.btn23.text == jogAtual){
            binding.btn21.setTextColor(color); binding.btn22.setTextColor(color); binding.btn23.setTextColor(color)
            FinalizaJogo(0)
            return
        }
        if(binding.btn31.text == jogAtual && binding.btn32.text == jogAtual && binding.btn33.text == jogAtual){
            binding.btn31.setTextColor(color); binding.btn32.setTextColor(color); binding.btn33.setTextColor(color)
            FinalizaJogo(0)
            return
        }


        //Verificar Vertical
        if(binding.btn11.text == jogAtual && binding.btn21.text == jogAtual && binding.btn31.text == jogAtual){
            binding.btn11.setTextColor(color); binding.btn21.setTextColor(color); binding.btn31.setTextColor(color)
            FinalizaJogo(0)
            return
        }
        if(binding.btn12.text == jogAtual && binding.btn22.text == jogAtual && binding.btn32.text == jogAtual){
            binding.btn12.setTextColor(color); binding.btn22.setTextColor(color); binding.btn32.setTextColor(color)
            FinalizaJogo(0)
            return
        }
        if(binding.btn13.text == jogAtual && binding.btn23.text == jogAtual && binding.btn33.text == jogAtual){
            binding.btn13.setTextColor(color); binding.btn23.setTextColor(color); binding.btn33.setTextColor(color)
            FinalizaJogo(0)
            return
        }


        //Verifical Diagonal
        if(binding.btn11.text == jogAtual && binding.btn22.text == jogAtual && binding.btn33.text == jogAtual){
            binding.btn11.setTextColor(color); binding.btn22.setTextColor(color); binding.btn33.setTextColor(color)
            FinalizaJogo(0)
            return
        }
        if(binding.btn13.text == jogAtual && binding.btn22.text == jogAtual && binding.btn31.text == jogAtual){
            binding.btn13.setTextColor(color); binding.btn22.setTextColor(color); binding.btn31.setTextColor(color)
            FinalizaJogo(0)
            return
        }


        //Verifica Empate
        if(binding.btn11.text != "" && binding.btn12.text != "" && binding.btn13.text != "" && binding.btn21.text != "" && binding.btn22.text != ""
            && binding.btn23.text != "" && binding.btn31.text != "" && binding.btn32.text != "" && binding.btn33.text != ""){
            binding.btn11.setTextColor(color);binding.btn12.setTextColor(color);binding.btn13.setTextColor(color);
            binding.btn21.setTextColor(color);binding.btn22.setTextColor(color);binding.btn23.setTextColor(color);
            binding.btn31.setTextColor(color);binding.btn32.setTextColor(color);binding.btn33.setTextColor(color);
            FinalizaJogo(1)
            return
        }

    }

    private fun FinalizaJogo(sinal:Int) {

        binding.btn11.isEnabled = false
        binding.btn12.isEnabled = false
        binding.btn13.isEnabled = false
        binding.btn21.isEnabled = false
        binding.btn22.isEnabled = false
        binding.btn23.isEnabled = false
        binding.btn31.isEnabled = false
        binding.btn32.isEnabled = false
        binding.btn33.isEnabled = false


        if(sinal!=1) {
            binding.TxtIndicaVencedor.text = "O vencedor é " + jogAtual

            if(jogAtual == jog0)
                contadorJog0++
            else
                contadorJog1++

        }
        else {
            binding.TxtIndicaVencedor.text = "EMPATE"

            contadorEmpates++
        }

        binding.btnContinuar.isVisible= true
    }

    private fun sorteiaJogador() {
        if(Random.nextInt(0,2)==1)
            jogAtual = jog1

        else
            jogAtual = jog0

        binding.TxtIndicador.text = jogAtual
    }

    private fun trocaJogador(){
        if(jogAtual == jog1)
            jogAtual = jog0
        else
            jogAtual = jog1

        binding.TxtIndicador.text = jogAtual
    }
}