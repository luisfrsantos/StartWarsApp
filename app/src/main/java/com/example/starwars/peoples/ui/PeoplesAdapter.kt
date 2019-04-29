package com.example.starwars.peoples.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.peoples.model.People
import kotlinx.android.synthetic.main.adapter_people_list.view.*

class PeoplesAdapter(val contex : Context, val peopleList : ArrayList<People>) : RecyclerView.Adapter<PeoplesAdapter.ListViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder  =
            ListViewHolder(LayoutInflater.from(contex).inflate(R.layout.adapter_people_list, parent, false))

    override fun getItemCount(): Int = peopleList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.view.tv_name.text = peopleList[position].name
    }

    class ListViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    companion object {
        protected val TAG = "PeoplesAdapter"
    }
}