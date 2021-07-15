package com.example.guessnumbergame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.guessnumbergame.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var random: Int = nextInt(1, 100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.textView.text = "Please enter your guess:"


        binding.imageButtonCheck.setOnClickListener { playGame() }

        binding.imageButtonReset.setOnClickListener {
            reset()
        }

        binding.enterNumber.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    private fun playGame() {
        val guess = binding.enterNumber
        val guessNum = guess.text.toString().toInt()
        when {
            guessNum < random -> {
                binding.textView.text = getString(R.string.wrong_low)
                guess.text?.clear()

            }
            guessNum > random -> {
                binding.textView.text = getString(R.string.wrong_hi)
                guess.text?.clear()
            }
            else -> {
                binding.textView.text = getString(R.string.congratuation)
                guess.text?.clear()
            }
        }
    }

    private fun reset() {
        random = nextInt(1, 100)
        binding.textView.text = getString(R.string.guessWhat)
        binding.enterNumber.text?.clear()
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}