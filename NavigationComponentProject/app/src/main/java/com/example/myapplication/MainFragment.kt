package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() , View.OnClickListener{

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.viewTransactionsBtn.setOnClickListener(this)
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.view_transactions_btn -> navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.view_balance_btn -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
            R.id.send_money_btn -> navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}