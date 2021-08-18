package com.example.mvvm_whith_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mvvm_whith_firebase.view.MainFragment
import com.example.mvvm_whith_firebase.view.Navigation

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment(this))
                .commitNow()
        }
    }

    override fun goToFragment(fragment: Fragment) {
        val transition: FragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
        transition.commitNow()
    }
}
