package com.br.eventbysicreed.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.eventbysicreed.R
import com.br.eventbysicreed.data.model.event.EventModel
import com.br.eventbysicreed.databinding.FragmentDetailsEventBinding
import com.br.eventbysicreed.ui.base.BaseFragment
import com.br.eventbysicreed.util.formatDate
import com.br.eventbysicreed.util.shareContent
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsEventFragment : BaseFragment<FragmentDetailsEventBinding, DetailsEventViewModel>() {
    override val viewModel: DetailsEventViewModel by viewModels()

    private val args: DetailsEventFragmentArgs by navArgs()
     private lateinit var eventModel: EventModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventModel = args.event
        onLoadEvent(eventModel)
        setupClickListeners()
    }

    private fun setupClickListeners() = with(binding){
        btnCheckin.setOnClickListener {
            val action = DetailsEventFragmentDirections.
            actionDetailsEventFragmentToCheckinEventFragment(eventModel)
            findNavController().navigate(action)
             }

        btnShared.setOnClickListener {
            shareContent(eventModel?.title, eventModel?.description, requireContext())
        }
    }

    private fun onLoadEvent(eventModel: EventModel)= with(binding){
        tvNameEventDetails.text = eventModel.title
        tvDescriptionEventDetails.text = eventModel.description
        tvPriceEventDetails.text = eventModel.price
        tvDateEventDetails.text = formatDate(eventModel.date.toLong())
        Glide.with(requireContext())
            .load(eventModel.image.toString())
            .error(com.br.eventbysicreed.R.drawable.event)
            .into(imgEventDetails)

    }



    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsEventBinding = FragmentDetailsEventBinding.inflate(
        inflater, container,false)
}