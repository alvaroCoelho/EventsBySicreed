package com.br.eventbysicreed.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.eventbysicreed.data.model.event.EventModel
import com.br.eventbysicreed.databinding.ItemEventBinding
import com.br.eventbysicreed.util.limitDescription
import com.bumptech.glide.Glide

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<EventModel>() {
        override fun areItemsTheSame(oldItem: EventModel, newItem: EventModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: EventModel, newItem: EventModel): Boolean {
            return oldItem.id == newItem.id
        }

    }

    private val differ = AsyncListDiffer(this, differCallback)
    var events: List<EventModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            ItemEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.binding.apply {
            tvTitleEvent.text = event.title
            tvDateEvent.text = event.date
            tvDescriptionEvent.text = event.description.limitDescription(100)
            tvPriceEvent.text = event.price

            Glide.with(holder.itemView.context)
                .load(event.image.toString())
                .into(imgEvent)
        }

        holder.itemView.setOnClickListener{
            onItemClickListener?.let {
                it(event)
            }
        }

    }

    private var onItemClickListener: ((EventModel) -> Unit) ?= null

    fun setOnClickListener(listener: (EventModel) -> Unit){
        onItemClickListener = listener
    }
}