package com.example.listadetarefas

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioDeviceInfo
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var audioHelper: AudioHelper
    private lateinit var speechRecognizer: SpeechRecognizer

    private val newsList = listOf(
        "A cúpula climática da ONU reforça a necessidade de ações globais para conter as mudanças climáticas.",
        "Cientistas anunciam avanços promissores no combate ao câncer com novas terapias genéticas.",
        "A economia global enfrenta desafios com a instabilidade nos mercados financeiros.",
        "Tecnologia de inteligência artificial revoluciona setores como saúde e educação em 2024.",
        "Novas missões espaciais estão sendo planejadas para explorar Marte nos próximos anos."
    )

    private val weatherList = listOf(
        "Hoje está ensolarado com temperatura máxima de 28 graus e mínima de 18 graus.",
        "Hoje o dia está nublado com chance de chuva, temperatura entre 20 e 25 graus.",
        "O clima hoje está instável, com pancadas de chuva à tarde.",
        "Hoje o dia está parcialmente nublado com temperatura máxima de 30 graus.",
        "Temperatura amena hoje, variando entre 15 e 23 graus, com céu limpo."
    )

    private val messageList = listOf(
        Pair("Carlos Almeida", "Oi, gostaria de confirmar nossa reunião para amanhã às 10 horas."),
        Pair("Ana Silva", "Não se esqueça do evento de lançamento às 15h."),
        Pair("João Pedro", "Parabéns pelo excelente trabalho no projeto!"),
        Pair("Maria Clara", "Podemos adiantar a reunião para as 9h?"),
        Pair("Lucas Mendes", "Feliz aniversário! Que você tenha um dia incrível.")
    )

    private val helpMessage = "Aqui estão as opções disponíveis: para ouvir uma notícia, diga 'notícia'. Para o clima, diga 'clima'. Para mensagens, diga 'mensagem'."

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            startVoiceRecognition()
        } else {
            Toast.makeText(this, "Permissão para uso do microfone negada.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioHelper = AudioHelper(this)

        val animation = AnimationUtils.loadAnimation(this, R.anim.button_press)

        findViewById<Button>(R.id.voiceCommandButton).setOnClickListener {
            it.startAnimation(animation)
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                startVoiceRecognition()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
            }
        }

        findViewById<Button>(R.id.weatherButton).setOnClickListener {
            it.startAnimation(animation)
            executeWeather()
        }

        findViewById<Button>(R.id.readMessageButton).setOnClickListener {
            it.startAnimation(animation)
            executeMessage()
        }

        findViewById<Button>(R.id.voiceCommandButton).setOnClickListener {
            it.startAnimation(animation)
            executeNews()
        }

        findViewById<Button>(R.id.helpButton).setOnClickListener {
            it.startAnimation(animation)
            executeHelp()
        }
    }

    private fun startVoiceRecognition() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR")
        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onError(error: Int) {
                Toast.makeText(this@MainActivity, "Erro no reconhecimento de voz: $error", Toast.LENGTH_SHORT).show()
            }

            override fun onResults(results: Bundle?) {
                val command = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)?.get(0)
                handleVoiceCommand(command ?: "")
            }

            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
        speechRecognizer.startListening(intent)
    }

    private fun handleVoiceCommand(command: String) {
        when {
            command.contains("notícia", ignoreCase = true) -> executeNews()
            command.contains("clima", ignoreCase = true) -> executeWeather()
            command.contains("mensagem", ignoreCase = true) -> executeMessage()
            command.contains("ajuda", ignoreCase = true) -> executeHelp()
            else -> Toast.makeText(this, "Comando não reconhecido.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun executeNews() {
        val randomNews = newsList.random()
        if (audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)) {
            audioHelper.speak(randomNews)
        } else {
            Toast.makeText(this, "Dispositivo de áudio não disponível.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun executeWeather() {
        val randomWeather = weatherList.random()
        if (audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)) {
            audioHelper.speak(randomWeather)
        } else {
            Toast.makeText(this, "Dispositivo de áudio não disponível.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun executeMessage() {
        val (sender, message) = messageList.random()
        val formattedMessage = "Mensagem de $sender: $message"
        if (audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)) {
            audioHelper.speak(formattedMessage)
        } else {
            Toast.makeText(this, "Dispositivo de áudio não disponível.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun executeHelp() {
        if (audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)) {
            audioHelper.speak(helpMessage)
        } else {
            Toast.makeText(this, "Dispositivo de áudio não disponível.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer.destroy()
        audioHelper.release()
    }
}
