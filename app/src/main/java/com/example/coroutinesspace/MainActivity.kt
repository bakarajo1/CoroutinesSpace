package com.example.coroutinesspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.coroutinesspace.databinding.ActivityMainBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonListener()
    }

    private fun buttonListener() {
        binding.buttonEvaluate.setOnClickListener {
            lifecycleScope.launch() {binding.textView.text=viewModel.calculateOdds(binding.editTextTextPersonName.text.toString())            }
        }
    }


}