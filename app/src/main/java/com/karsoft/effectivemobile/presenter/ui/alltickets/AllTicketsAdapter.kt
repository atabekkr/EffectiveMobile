package com.karsoft.effectivemobile.presenter.ui.alltickets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karsoft.effectivemobile.databinding.ItemTicketBinding
import com.karsoft.effectivemobile.presenter.models.TicketUI

class AllTicketsAdapter : ListAdapter<TicketUI, AllTicketsAdapter.TicketViewHolder>(MyDiffUtil()) {

    inner class TicketViewHolder(private val binding: ItemTicketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(adapterPosition)

            if (item.badge != null) binding.tvBadge.text = item.badge
            else binding.tvBadge.visibility = View.GONE

            binding.tvPrice.text = item.price.value.toString() + " ₽"
            binding.tvTime.text = "${item.departure.date} - ${item.arrival.date}"
            binding.tvCodeAirport.text = item.departure.airport
            binding.tvTimePilot.text = item.arrival.airport

            if (!item.has_transfer) {
                binding.tvTimeOfFly.text = "3.5ч в пути / Без пересадок"
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder(
            ItemTicketBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind()
    }

    private class MyDiffUtil : DiffUtil.ItemCallback<TicketUI>() {
        override fun areItemsTheSame(oldItem: TicketUI, newItem: TicketUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TicketUI, newItem: TicketUI): Boolean {
            return oldItem == newItem
        }

    }
}