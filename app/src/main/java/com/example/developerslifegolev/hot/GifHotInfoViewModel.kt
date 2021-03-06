package com.example.developerslifegolev.hot

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class GifHotInfoViewModel: ViewModel() {
    val itemGifTopInfo = MutableLiveData<GifHotInfoItem>()
    private val api = RetrofitFactoryHot.new()
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val gifLatestInfo = api.getHotGif()
            itemGifTopInfo.postValue(gifLatestInfo)
        }

    }

}