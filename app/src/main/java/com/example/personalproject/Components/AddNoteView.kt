package com.example.personalproject.Components

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.personalproject.R

class AddNoteView(context: Context) : ConstraintLayout(context) {



    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        View.inflate(context, R.layout.add_note_view, this)
    }

}