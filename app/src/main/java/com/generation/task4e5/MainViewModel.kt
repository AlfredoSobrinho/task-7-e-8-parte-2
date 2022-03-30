package com.generation.task4e5

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.task4e5.model.Post
import com.generation.task4e5.model.Temas
import com.generation.task4e5.reporitory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    val repository: Repository
) : ViewModel() {

    private val _myTemasResponse =
        MutableLiveData<Response<List<Temas>>>()

    val myTemasResponse: LiveData<Response<List<Temas>>> = _myTemasResponse


    private val _myPostResponse = MutableLiveData<Response<List<Post>>>()

    
    val myPostResponse: LiveData<Response<List<Post>>> =
        _myPostResponse


    init {


        listTemas()

    }


    fun listTemas() {
        viewModelScope.launch {
            try {
                val response = repository.listTemas()
                _myTemasResponse.value = response

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())

            }
        }
    }
    
    
    fun listPost(){
        viewModelScope.launch { 
            
            try{
                val response = repository.listPost()
                _myPostResponse.value = response 
            }catch (e: Exception){

                Log.e("Developer", "Error", e)

            }
            
            
        }
        
        
        
    }

    fun addPost(post: Post) {
        viewModelScope.launch {
            try {
                repository.addPost(post)
                listPost()
            } catch (e: java.lang.Exception) {
                Log.d("Erro", e.message.toString())


            }


        }

    }


}





