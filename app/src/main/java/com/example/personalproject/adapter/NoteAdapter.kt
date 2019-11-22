package com.example.personalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.models.Note
import com.example.personalproject.R
import kotlinx.android.extensions.LayoutContainer

class NoteAdapter(private val context: Context, private val notes: List<Note>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false))

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = (holder as NoteViewHolder).bind((notes[position]))

    inner class NoteViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(note: Note) {

        }
    }

}