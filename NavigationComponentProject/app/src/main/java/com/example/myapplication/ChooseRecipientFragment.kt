package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentChooseRecipientBinding
import com.example.myapplication.databinding.FragmentMainBinding

class ChooseRecipientFragment : Fragment() {

    private var _binding: FragmentChooseRecipientBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.nextBtn.setOnClickListener {
            if (!TextUtils.isEmpty(binding.inputRecipient.text.toString())) {
                val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment , bundle)
            }

        }
        binding.cancelBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}