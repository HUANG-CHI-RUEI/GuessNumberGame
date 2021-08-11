package com.example.guessnumbergame

import android.util.Log
import kotlin.random.Random

class SecretNumber {

    private var secret = Random.nextInt(10) + 1

    private var count = 0
    private val TAG = "Ray_Secret_Number"

    constructor() {
        Log.d(TAG, "The secret number is: " + secret.toString())
    }

    private fun get(): Int {
        return 0
    }

    fun getScore(): Int {
        return secret
    }

    fun getCount(): Int {
        return count
    }

    fun getSecret(): Int {
        return secret
    }

    fun validate(guess: Int): Int {
        count++
        return guess - secret
    }

}