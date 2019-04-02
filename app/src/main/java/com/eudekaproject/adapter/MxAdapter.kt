package com.eudekaproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eudekaproject.R
import com.eudekaproject.model.MXItem
import kotlinx.android.synthetic.main.mx_list.view.*

class MxAdapter(
    private val context: Context?,
    private val data: List<MXItem?>
) : RecyclerView.Adapter<MxAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MxAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.mx_list, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: MXItem?) {
            itemView.tv_list_exchange.text = data?.exchange
            itemView.tv_list_priority.text = data?.priority.toString()
        }
    }
}