package com.example.contadordepontos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.contadordepontos.ui.theme.ContadorDePontosTheme

class MainActivity : ComponentActivity() {
    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0

    private lateinit var pTimeA: TextView
    private lateinit var pTimeB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        val tiroLivreTimeA: Button = findViewById(R.id.tiroLivreA)
        val doisPontosTimeA: Button = findViewById(R.id.doisPontosA)
        val tresPontosTimeA: Button = findViewById(R.id.tresPontosA)

        tresPontosTimeA.setBackgroundColor(getColor(R.color.white))
        tresPontosTimeA.setTextColor(getColor(android.R.color.black))

        doisPontosTimeA.setBackgroundColor(getColor(R.color.white))
        doisPontosTimeA.setTextColor(getColor(android.R.color.black))

        tiroLivreTimeA.setBackgroundColor(getColor(R.color.white))
        tiroLivreTimeA.setTextColor(getColor(android.R.color.black))

        val tiroLivreTimeB: Button = findViewById(R.id.tiroLivreB)
        val doisPontosTimeB: Button = findViewById(R.id.doisPontosB)
        val tresPontosTimeB : Button = findViewById(R.id.tresPontosB)

        tresPontosTimeB.setBackgroundColor(getColor(R.color.white))
        tresPontosTimeB.setTextColor(getColor(android.R.color.black))

        doisPontosTimeB.setBackgroundColor(getColor(R.color.white))
        doisPontosTimeB.setTextColor(getColor(android.R.color.black))

        tiroLivreTimeB.setBackgroundColor(getColor(R.color.white))
        tiroLivreTimeB.setTextColor(getColor(android.R.color.black))

        val reiniciar: Button = findViewById(R.id.reiniciarPartida)
        reiniciar.setBackgroundColor(getColor(R.color.black))
        reiniciar.setTextColor(getColor(R.color.white))

        tiroLivreTimeA.setOnClickListener { adicionarPontos(1, "A") }
        doisPontosTimeA.setOnClickListener { adicionarPontos(2, "A") }
        tresPontosTimeA.setOnClickListener { adicionarPontos(3, "A") }

        tiroLivreTimeB.setOnClickListener { adicionarPontos(1, "B") }
        doisPontosTimeB.setOnClickListener { adicionarPontos(2, "B") }
        tresPontosTimeB.setOnClickListener { adicionarPontos(3, "B") }

        reiniciar.setOnClickListener { reiniciarPartida() }
    }

    fun adicionarPontos(pontos: Int, time: String) {
        if(time == "A") {
            pontuacaoTimeA += pontos
        } else {
            pontuacaoTimeB += pontos
        }

        atualizarPlacar(time)
    }

    fun atualizarPlacar (time: String) {
        if(time == "A") {
            pTimeA.setText(pontuacaoTimeA.toString())
        } else {
            pTimeB.setText(pontuacaoTimeB.toString())
        }
    }

    fun reiniciarPartida() {
        pontuacaoTimeA = 0
        pTimeA.setText(pontuacaoTimeA.toString())

        pontuacaoTimeB = 0
        pTimeB.setText(pontuacaoTimeB.toString())

        Toast.makeText(
            this,
            "Placar Reiniciado",
            Toast.LENGTH_SHORT
        ).show()
    }
}


