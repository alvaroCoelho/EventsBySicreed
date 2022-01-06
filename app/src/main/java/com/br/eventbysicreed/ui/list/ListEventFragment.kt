package com.br.eventbysicreed.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.br.eventbysicreed.databinding.FragmentListEventBinding
import com.br.eventbysicreed.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListEventFragment : BaseFragment<FragmentListEventBinding, ListEventViewModel>() {

    override val viewModel: ListEventViewModel by viewModels()


    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListEventBinding = FragmentListEventBinding.inflate(
        inflater, container,false)
}