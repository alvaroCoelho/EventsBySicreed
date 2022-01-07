package com.br.eventbysicreed.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.br.eventbysicreed.data.model.event.EventModel
import com.br.eventbysicreed.databinding.FragmentDetailsEventBinding
import com.br.eventbysicreed.ui.base.BaseFragment
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
    }

    private fun onLoadEvent(eventModel: EventModel)= with(binding){
        tvNameEventDetails.text = eventModel.title

    }

    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsEventBinding = FragmentDetailsEventBinding.inflate(
        inflater, container,false)
}