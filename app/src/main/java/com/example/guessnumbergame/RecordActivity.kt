package com.example.guessnumbergame

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guessnumbergame.databinding.ActivityRecordBinding

class RecordActivity : AppCompatActivity() {

    private var count = 0

    private lateinit var viewBinding: ActivityRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        count = intent.getIntExtra("COUNT", 0)
        viewBinding.tvCountResult.setText(count.toString())

        viewBinding.button.setOnClickListener {
            val name = viewBinding.tieRecord.text.toString()

            if (!name.equals("")) {
                getSharedPreferences("Record", MODE_PRIVATE)
                    .edit()
                    .putInt("RECORD", count)
                    .putString("NAME", name)
                    .apply()

                var intent = Intent()
                intent.putExtra("RESULT", name)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                AlertDialog.Builder(this@RecordActivity)
                    .setMessage(getString(R.string.yournameplease))
                    .setPositiveButton(getString(R.string.OK), null).show()
            }
        }
    }

}