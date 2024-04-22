package com.karsoft.effectivemobile.presenter.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.karsoft.effectivemobile.R
import com.karsoft.effectivemobile.databinding.ItemOfferBinding
import com.karsoft.effectivemobile.presenter.models.OfferUI

class OffersAdapter : ListAdapter<OfferUI, OffersAdapter.OfferViewHolder>(MyDiffUtil()) {

    inner class OfferViewHolder(private val binding: ItemOfferBinding) : ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(adapterPosition)

            binding.tvTitle.text = item.title
            binding.tvTown.text = item.town
            binding.tvPrice.text = "от ${item.price.value} ₽"

            when (item.id) {
                1 -> {
                    binding.shapeableIvOffer.setImageDrawable(binding.root.context.getDrawable(R.drawable.pic_offer_1))
                }

                2 -> {
                    binding.shapeableIvOffer.setImageDrawable(binding.root.context.getDrawable(R.drawable.pic_offer_2))
                }

                3 -> {
                    binding.shapeableIvOffer.setImageDrawable(binding.root.context.getDrawable(R.drawable.pic_offer_3))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(
            ItemOfferBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind()
    }

    private class MyDiffUtil : DiffUtil.ItemCallback<OfferUI>() {
        override fun areItemsTheSame(oldItem: OfferUI, newItem: OfferUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OfferUI, newItem: OfferUI): Boolean {
            return oldItem == newItem
        }

    }
}