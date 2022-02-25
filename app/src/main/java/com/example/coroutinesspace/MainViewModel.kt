package com.example.coroutinesspace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {



     suspend fun calculateOdds(message:String): String {

         var tempBoolean: Boolean

         if (message.length<6){
             jobLessThanSix(message)
             tempBoolean=true


         }else{
             jobMoreThanSix(message)
             tempBoolean=false

         }

         return if(tempBoolean){
             "Less than six"
         }else{
             "More than six"
         }



    }

    private suspend fun jobLessThanSix(string: String): Boolean {
        val job= viewModelScope.async {
            Regex(DIGITS).containsMatchIn(string)

        }

        return job.await()
    }

    private suspend fun jobMoreThanSix(string: String) :String{
        val job= viewModelScope.async {
            string.uppercase()
        }
        return job.await()
    }

companion object{
    val DIGITS="[0-9]"
}
}