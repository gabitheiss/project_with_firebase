package com.example.mvvm_whith_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.view_model.LogadoViewModel

class LogadoFragment(interfaceNavigate: Navigation) : Fragment(R.layout.logado_fragment) {



    private lateinit var viewModel: LogadoViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogadoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}