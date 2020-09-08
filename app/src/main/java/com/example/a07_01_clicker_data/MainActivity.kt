package com.example.a07_01_clicker_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//Save Application state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CLIKS_EXTRA, cliks)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cliks = savedInstanceState?.getInt(CLIKS_EXTRA) ?: 0 //Restore App state
        mainCounterView.text = "$cliks"

        mainButtonPush.text = getString(R.string.button_name)
        mainButtonPush.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
            cliks = cliks + 1
            mainCounterView.text = "$cliks"
            Log.i(TAG, "Pressed $cliks times")
        }

    }

    companion object{
        private const val TAG = "MainActivity"
        private var cliks: Int = 0
        private var CLIKS_EXTRA: String = "Key"
    }
}