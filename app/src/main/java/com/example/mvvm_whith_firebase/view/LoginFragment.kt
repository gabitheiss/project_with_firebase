package com.example.mvvm_whith_firebase.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.model.Navigation
import com.example.mvvm_whith_firebase.view_model.LoginViewModel
import com.google.firebase.auth.FirebaseUser

class LoginFragment(val interfaceNavigate: Navigation) : Fragment(R.layout.login_fragment) {


    private lateinit var viewModel: LoginViewModel


    val observerLogin = Observer<FirebaseUser> { user ->
        interfaceNavigate.goToFragment(LogadoFragment(interfaceNavigate))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.usuario.observe(viewLifecycleOwner, observerLogin)

        view.findViewById<Button>(R.id.buttonEntrar)?.apply {
            setOnClickListener {
                val inputEmailLogin = view.findViewById<EditText>(R.id.inputEmailLogin)
                val inputSenhaLogin = view.findViewById<EditText>(R.id.inputSenhaLogin)
                if (!inputEmailLogin.text.isNullOrEmpty() && !inputSenhaLogin.text.isNullOrEmpty()) {
                    viewModel.signIn(
                        inputEmailLogin.text.toString(),
                        inputSenhaLogin.text.toString()
                    )

                }
            }
        }
    }

}