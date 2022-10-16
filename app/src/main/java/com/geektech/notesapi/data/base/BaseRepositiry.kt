package com.geektech.notesapi.data.base

import com.geektech.notesapi.domain.utills.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {
    protected fun <T> doRequest(request: suspend () -> T )= flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage as String))
        }
    }
}