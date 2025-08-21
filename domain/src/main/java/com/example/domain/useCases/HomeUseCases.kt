package com.example.domain.useCases

import com.example.domain.repo.HomeRepo
import javax.inject.Inject

class HomeUseCases @Inject constructor(private val homeRepo : HomeRepo) {
    fun getMealByName(name : Char) = homeRepo.getMealByName(name)
}