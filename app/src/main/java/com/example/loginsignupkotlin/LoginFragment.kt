package com.example.loginsignupkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.loginsignupkotlin.databinding.FragmentLoginBinding
import com.example.loginsignupkotlin.databinding.FragmentSignUpBinding


class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener {
            val email=binding.edtEmial.text.toString()
            val password=binding.edtPassword.text.toString()
            viewModel.loginUser(email, password)

        }

    }

}