package com.arifahmadalfian.thesportsdb.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.thesportsdb.core.R
import com.arifahmadalfian.thesportsdb.core.databinding.ItemListSportBinding
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.bumptech.glide.Glide

class SportAdapter: RecyclerView.Adapter<SportAdapter.ListViewHolder>() {

    private var listData = ArrayList<Sport>()
    var onItemClick: ((Sport) -> Unit)? = null

    fun setData(newItem: List<Sport>?) {
        if (newItem == null) return
        listData.clear()
        listData.addAll(newItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_list_sport, parent, false)
        return ListViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListSportBinding.bind(itemView)
        fun bind(data: Sport) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(data.strSportThumb)
                        .into(ivItemImage)
                tvItemTitle.text = data.strSport
                tvItemSubtitle.text = data.strFormat
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}