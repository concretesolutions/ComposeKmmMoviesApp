package br.com.concrete.components.recyclerviewlazycolumn.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.concrete.components.R

class Adapter (
    private val minhalista : List<ListaRecycleView>):
    RecyclerView.Adapter<Adapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_card,
            parent, false)

        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val posicaoItem = minhalista[position]
        //holder.imageView1.setImageResource(posicaoItem.poster)
        holder.imageView1.loadImageUrl(posicaoItem.poster.toString())
        holder.textView1.text = posicaoItem.title
        holder.textView2.text = posicaoItem.year
        holder.textView3.text = posicaoItem.synopsis
    }

    override fun getItemCount() = minhalista.size

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1: ImageView = itemView.findViewById(R.id.imageRecycler)
        val textView1: TextView = itemView.findViewById(R.id.titleRecycler)
        val textView2: TextView = itemView.findViewById(R.id.yearRecycler)
        val textView3: TextView = itemView.findViewById(R.id.synopsisMultiLineRecycler)
    }


}