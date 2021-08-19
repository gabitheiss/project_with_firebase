package com.example.mvvm_whith_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.databinding.DetailsFragmentBinding
import com.example.mvvm_whith_firebase.model.Conta
import com.example.mvvm_whith_firebase.model.Conta.Companion.fromDocument
import com.example.mvvm_whith_firebase.model.Navigation
import com.example.mvvm_whith_firebase.view_model.DetailsViewModel
import com.google.android.material.snackbar.Snackbar

class DetailsFragment(val interfaceNavigate: Navigation, val conta: Conta) :
    Fragment(R.layout.details_fragment) {


    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding

    private val observerDelete = Observer<Boolean> {
        if (it) {
            interfaceNavigate.goToFragment(LogadoFragment(interfaceNavigate))
        } else {
            //root chama o "pai" não precisa implementar a view por exemplo
            Snackbar.make(binding.root, "Erro de conexão, registro não apagado!", Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //carregar o bind com a (view) que ja temos - caso contrario é layoutInflater
        binding = DetailsFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        viewModel.deleteSuccess.observe(viewLifecycleOwner, observerDelete)

        //nao precisamos mais do findViewById
        binding.buttonDelete.setOnClickListener {
            conta.uid?.let { id ->
                viewModel.deleteItem(id)
            }
        }
        //preenchendo os campos de detalhes conforme a Conta (vindo do Firebase)
        binding.textContaDetails.text = conta.nome

        binding.textValorDetails.text = conta.valor.toString()
    }

}

