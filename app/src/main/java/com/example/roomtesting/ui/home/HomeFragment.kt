package com.example.roomtesting.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.roomtesting.base.BaseFragment
import com.example.roomtesting.databinding.FragmentHomeBinding
import com.example.roomtesting.utils.showMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun inflateViewModel(): HomeViewModel = homeViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getMealsData('a')
        observe()
    }


    override fun initClicks() {
        TODO("Not yet implemented")
    }

    override fun observe() {

        viewModel.uiMessage.observe(viewLifecycleOwner) { uiMessage ->
            uiMessage?.let {
                showMessage(uiMessage)
            }
        }

        homeViewModel.mealsData.observe(viewLifecycleOwner){ meals ->
            showMessage(meals.meals?.get(0)?.strMeal.toString())
        }
    }

}