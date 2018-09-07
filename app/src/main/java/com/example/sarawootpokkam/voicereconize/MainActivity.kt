package com.example.sarawootpokkam.voicereconize

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSpeech.setOnClickListener {
            intentSpeech()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        requestCode.takeIf { it == REQUEST_CODE }?.apply {
            showText(Model(data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)))
        }
    }

    private fun showText(model: Model?) {
        tvResult.text = model?.text()
    }

    private fun intentSpeech() {
        startActivityForResult(
            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_RESULTS, "th-TH")
            }
            ,
            REQUEST_CODE
        )
    }
}