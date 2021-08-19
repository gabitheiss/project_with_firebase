package com.example.mvvm_whith_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.system.Os.bind
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.model.Conta
import com.example.mvvm_whith_firebase.model.Navigation
import com.example.mvvm_whith_firebase.repository.ContasRepository
import com.example.mvvm_whith_firebase.view_model.DetailsViewModel

class DetailsFragment(val interfaceNavigate: Navigation, val conta: Conta) :
    Fragment(R.layout.details_fragment) {


    private lateinit var viewModel: DetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        conta.uid?.let {
//
        }


    }


}