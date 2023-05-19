package com.example.loginsignupkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.loginsignupkotlin.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var binding:FragmentSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnRegister.setOnClickListener {
            val username=binding.edtUsername.text.toString().trim()
            val email=binding.edtEmial.text.toString().trim()
            val phone=binding.edtPhone.text.toString().trim()
            val password=binding.edtPassword.text.toString().trim()
            viewModel.signUp(1,username, email, phone, password)
            Toast.makeText(context,"yesss",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)

        }

    }


}