package com.br.eventbysicreed.ui.checkin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.br.eventbysicreed.databinding.FragmentCheckinEventBinding
import com.br.eventbysicreed.ui.base.BaseFragment

class CheckinEventFragment : BaseFragment<FragmentCheckinEventBinding, CheckinEventViewModel>() {
    override val viewModel: CheckinEventViewModel by viewModels()

    override fun getViewBiding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCheckinEventBinding = FragmentCheckinEventBinding.inflate(inflater, container,
        false)
}