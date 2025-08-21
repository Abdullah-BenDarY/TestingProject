package com.example.roomtesting.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.handleState.ApiResult
import com.example.domain.models.ModelAllMeals
import com.example.domain.useCases.HomeUseCases
import com.example.roomtesting.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCases: HomeUseCases) : BaseViewModel() {

    private val _mealsData = MutableLiveData<ModelAllMeals>()
    val mealsData get() = _mealsData


     fun getMealsData(name: Char) {

        viewModelScope.launch(Dispatchers.IO){
            homeUseCases.getMealByName(name)
                .catch { e ->
                    handleError(e)
                }
                .collect { result ->

                    when (result) {
                        is ApiResult.Success -> {
                            _mealsData.postValue(result.data)
                        }
                        is ApiResult.Failure -> {
                            handleError(result.error)
                        }
                    }
                }
        }
    }

}