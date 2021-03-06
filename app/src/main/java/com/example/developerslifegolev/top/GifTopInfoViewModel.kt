package com.example.developerslifegolev.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class GifTopInfoViewModel: ViewModel() {
    val itemGifTopInfo = MutableLiveData<GifTopInfoItem>()
    private val api = RetrofitFactoryTop.new()
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val gifLatestInfo = api.getTopGif()
            itemGifTopInfo.postValue(gifLatestInfo)
        }

    }

}