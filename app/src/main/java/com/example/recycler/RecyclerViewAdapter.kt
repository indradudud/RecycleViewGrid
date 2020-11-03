package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_view.view.*

class RecyclerViewAdapter(private val context: MainActivity, private val carList:
ArrayList<CarModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.list_item_view, parent, false))
    }
    override fun getItemCount(): Int {
        return carList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(carList[position])
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val carLogo = view.imgCarLogo
        val carName = view.txtCarName
        fun bindItems(data : CarModel){
            carLogo?.setImageBitmap(data.logo)
            carName?.text = data.nama
            itemView.setOnClickListener {
                val text = data.nama
                Toast.makeText(itemView.context, text,
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}