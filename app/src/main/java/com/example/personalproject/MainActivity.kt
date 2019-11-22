package com.example.personalproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.personalproject.adapter.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getNotes().observe(this, Observer {result ->

            result.onSuccess {
                text.text = this.getString(R.string.note_size_title, it.size.toString())
                noteRecyclerView.adapter = NoteAdapter(baseContext, it)
            }

            result.onFailure {
                Toast.makeText(this, R.string.error_text, Toast.LENGTH_LONG).show()
            }

        })
    }
}
