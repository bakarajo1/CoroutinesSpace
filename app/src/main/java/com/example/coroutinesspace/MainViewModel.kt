package com.example.coroutinesspace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

     fun decideOddity(number:Int):Boolean{
        return number%2 != 0

    }

     fun calculateOdds(number:Int): String {
         var tempBoolean=true
         viewModelScope.launch {
            tempBoolean=decideOddity(number)

        }
         return if(tempBoolean){
             "Odd"
         }else{
             "Even"
         }



    }


}