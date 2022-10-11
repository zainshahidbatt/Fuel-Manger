package com.example.activity.ui.old_record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.activity.databinding.CardViewDesignBinding
import com.example.activity.model.Record

class RecordAdapter : ListAdapter<Record, RecordAdapter.RecordViewHolder>(
    DiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val binding =
            CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecordViewHolder(private val binding: CardViewDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Record) {
            binding.apply {
                tvLitter.text = item.litters.toString()
                tvAmount.text = item.totalAmount.toString()
                tvPricePerLitter.text = item.price.toString()
                tvReading.text = item.meterReading
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Record>() {
        override fun areItemsTheSame(
            oldItem: Record,
            newItem: Record
        ) = false

        override fun areContentsTheSame(
            oldItem: Record,
            newItem: Record
        ) = false
    }
}