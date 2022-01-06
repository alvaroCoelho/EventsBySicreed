package com.br.eventbysicreed.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.br.eventbysicreed.databinding.FragmentDetailsEventBinding
import com.br.eventbysicreed.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsEventFragment : BaseFragment<FragmentDetailsEventBinding, DetailsEventViewModel>() {
    override val viewModel: DetailsEventViewModel by viewModels()

    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsEventBinding = FragmentDetailsEventBinding.inflate(
        inflater, container,false)
}