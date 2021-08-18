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
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment() {

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private lateinit var recipient:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecifyAmountBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.sendBtn.setOnClickListener {
            if(!TextUtils.isEmpty(binding.inputAmount.text.toString()))
            {
                val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount)
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment , bundle)
                //findNavController().navigate(R.id.action_specifyAmountFragment_to_confirmationFragment , bundle)
                //Navigation.createNavigateOnClickListener(R.id.action_specifyAmountFragment_to_confirmationFragment , bundle)
            }

        }
        binding.cancelBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.recipient.text = "Sending Money To $recipient"
    }

}