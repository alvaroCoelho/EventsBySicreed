package com.br.eventbysicreed.ui.checkin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.br.eventbysicreed.R
import com.br.eventbysicreed.data.model.checkin.CheckinModel
import com.br.eventbysicreed.data.model.event.EventModel
import com.br.eventbysicreed.databinding.FragmentCheckinEventBinding
import com.br.eventbysicreed.ui.base.BaseFragment
import com.br.eventbysicreed.ui.details.DetailsEventFragmentArgs
import com.br.eventbysicreed.ui.state.ResourceState
import com.br.eventbysicreed.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CheckinEventFragment : BaseFragment<FragmentCheckinEventBinding, CheckinEventViewModel>() {

    override val viewModel: CheckinEventViewModel by viewModels()
    private lateinit var eventModel: EventModel
    private val args: DetailsEventFragmentArgs by navArgs()


    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCheckinEventBinding = FragmentCheckinEventBinding.inflate(
        inflater, container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventModel = args.event
        setupClickListeners()
        collectObserver()
    }

    private fun collectObserver() = lifecycleScope.launch{
        viewModel.checkinEvent.collect{ resource ->
            when(resource){
                is ResourceState.Sucess ->{
                    toast(getString(R.string.sucess_checkin))
                }
                is ResourceState.Error -> {
                    toast(getString(R.string.error_checkin))
                }
            }
        }
    }

    private fun setupClickListeners() = lifecycleScope.launch {

        binding.btnConfirmCheckin.setOnClickListener {

            viewModel.checkin(
                CheckinModel(
                    0, eventModel.id,
                    binding.edTextPersonName.text.toString(),
                    binding.etEmailAddress.text.toString())
            )
        }
    }
}
