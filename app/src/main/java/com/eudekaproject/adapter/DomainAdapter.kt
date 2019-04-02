package com.eudekaproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eudekaproject.R
import com.eudekaproject.model.DomainsItem
import com.eudekaproject.utils.formatList
import kotlinx.android.synthetic.main.domain_list.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class DomainAdapter(
    private val context: Context?,
    private val data: List<DomainsItem?>,
    private val listener: (DomainsItem?) -> Unit
) : RecyclerView.Adapter<DomainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.domain_list, parent, false))


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position])
        holder.itemView.txt_domain_name.onClick { listener(data[position]) }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: DomainsItem?) {
            itemView.txt_domain_name.text = data?.domain
            itemView.txt_domain_status.formatList(data?.A.toString())
        }
    }
}