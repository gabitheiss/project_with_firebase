package com.example.mvvm_whith_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser

class MainFragment(private val interfaceNavigate : Navigation) : Fragment(R.layout.main_fragment) {


    private lateinit var viewModel: MainViewModel
    private val observeUser = Observer<FirebaseUser?>{
        Snackbar.make(requireView(), "CADASTRO REALIZADO!", Snackbar.LENGTH_LONG).show()
    }

    //comunica com view model
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.usuario.observe(viewLifecycleOwner,observeUser)


        view.findViewById<Button>(R.id.buttonJaTenhoCadastro)?.apply {
            setOnClickListener {
                interfaceNavigate.goToFragment(LoginFragment(interfaceNavigate))
            }
        }


        view.findViewById<Button>(R.id.buttonCadastrar).setOnClickListener{
            val inputEmail = view.findViewById<TextView>(R.id.inputEmail)
            val inputSenha = view.findViewById<TextView>(R.id.inputSenha)
            if (!inputEmail.text.isNullOrEmpty() && !inputSenha.text.isNullOrEmpty()){
                viewModel.criarNovoUser(
                    inputEmail.text.toString(), inputSenha.text.toString()
                )
            }
        }
    }


}