package com.example.listadetarefas

import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioDeviceCallback
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import java.util.Locale

class AudioHelper(private val context: Context) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private var tts: TextToSpeech? = null

    init {
        initializeTextToSpeech()
    }

    private fun initializeTextToSpeech() {
        tts = TextToSpeech(context) { status: Int ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts!!.setLanguage(Locale("pt", "BR"))
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "Idioma não suportado para TTS")
                    Toast.makeText(context, "Idioma para TTS não suportado", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Log.d("TTS", "TextToSpeech inicializado com sucesso em Português")
                }
            } else {
                Log.e("TTS", "Falha ao inicializar TextToSpeech")
                Toast.makeText(context, "Erro ao inicializar TTS", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun audioOutputAvailable(type: Int): Boolean {
        if (!context.packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)) {
            Log.e("AudioHelper", "Recurso de saída de áudio indisponível.")
            return false
        }

        val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        var isAvailable = false
        for (device in devices) {
            if (device.type == type) {
                isAvailable = true
                break
            }
        }

        Log.d("AudioHelper", "Saída de áudio disponível ($type): $isAvailable")
        return isAvailable
    }

    fun speak(text: String) {
        if (tts == null) {
            Log.e("AudioHelper", "Erro: TTS não inicializado.")
            Toast.makeText(context, "Erro: TTS não inicializado", Toast.LENGTH_SHORT).show()
            return
        }
        if (tts!!.isSpeaking) {
            Log.d("AudioHelper", "TTS está ocupado. Tentando falar novamente...")
        }
        Log.d("AudioHelper", "Falando texto: $text")
        val result = tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        if (result == TextToSpeech.ERROR) {
            Log.e("AudioHelper", "Erro ao reproduzir o áudio.")
        }
    }

    fun stopSpeaking() {
        if (tts != null) {
            tts!!.stop()
            Log.d("AudioHelper", "Parando o TTS.")
        }
    }

    fun release() {
        if (tts != null) {
            tts!!.shutdown()
            Log.d("AudioHelper", "Recursos do TTS liberados.")
        }
    }

    fun listAudioDevices() {
        val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        for (device in devices) {
            Log.d("AudioHelper", "Dispositivo: " + device.productName + ", Tipo: " + device.type)
        }
    }

    fun registerAudioDeviceCallback(onDeviceAdded: (Int) -> Unit) {
        audioManager.registerAudioDeviceCallback(object : AudioDeviceCallback() {
            override fun onAudioDevicesAdded(addedDevices: Array<AudioDeviceInfo>) {
                super.onAudioDevicesAdded(addedDevices)
                for (device in addedDevices) {
                    Log.d("AudioHelper", "Dispositivo de áudio conectado: " + device.type)
                    if (device.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP) {
                        onDeviceAdded(device.type)
                        Toast.makeText(
                            context,
                            "Fone de ouvido Bluetooth conectado.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onAudioDevicesRemoved(removedDevices: Array<AudioDeviceInfo>) {
                super.onAudioDevicesRemoved(removedDevices)
                for (device in removedDevices) {
                    Log.d("AudioHelper", "Dispositivo de áudio removido: " + device.type)
                    if (device.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP) {
                        Toast.makeText(
                            context,
                            "Fone de ouvido Bluetooth desconectado.",
                            Toast.LENGTH_SHORT
                        ).show()

                        if (audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)) {
                            Log.d("AudioHelper", "Mudando para o alto-falante integrado.")
                            audioManager.mode = AudioManager.MODE_NORMAL
                        }
                    }
                }
            }
        }, null)
    }
}
