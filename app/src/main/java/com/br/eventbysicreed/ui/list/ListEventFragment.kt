package com.br.eventbysicreed.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.eventbysicreed.R
import com.br.eventbysicreed.databinding.FragmentListEventBinding
import com.br.eventbysicreed.ui.adapters.EventAdapter
import com.br.eventbysicreed.ui.base.BaseFragment
import com.br.eventbysicreed.ui.state.ResourceState
import com.br.eventbysicreed.util.hide
import com.br.eventbysicreed.util.show
import com.br.eventbysicreed.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class ListEventFragment : BaseFragment<FragmentListEventBinding, ListEventViewModel>() {

    override val viewModel: ListEventViewModel by viewModels()
    private val eventAdapter by lazy { EventAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        clickAdapter()
        collectObserver()
    }

    private fun collectObserver() = lifecycleScope.launch{
        viewModel.list.collect{ resource ->
            when(resource){
                is ResourceState.Sucess -> {
                    resource.data?.let { values ->
                        binding.progressCircular.hide()
                        eventAdapter.events = values.toList()                    }
                }
                is ResourceState.Error -> {
                    binding.progressCircular.hide()
                    resource.message?.let { message ->
                        toast(getString(R.string.an_error_occurred))
                        Timber.tag("ListCharacterFragment").e("Error -> $message")
                    }
                }
                is ResourceState.Loading -> {
                    binding.progressCircular.show()
                }
                else -> {}

            }
        }

    }

    private fun clickAdapter() {
        eventAdapter.setOnClickListener { eventModel ->
            val action = ListEventFragmentDirections
                .actionListEventFragmentToDetailsEventFragment(eventModel)
            findNavController().navigate(action)
        }
    }

    private fun setupRecyclerView() = with(binding) {
        rvEvent.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListEventBinding = FragmentListEventBinding.inflate(
        inflater, container,false)
}