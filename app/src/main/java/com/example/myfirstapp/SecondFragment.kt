package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.databinding.FragmentSecondBinding
import com.example.myfirstapp.model.CountViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null

    private val sharedViewModel: CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val fragmentBinding = FragmentSecondBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            secondFragment = this@SecondFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    /**
     * Reset counter when previous button is clicked
     */
    fun goToStart(){
        sharedViewModel.resetCount()
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
}