package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            var currentCount: Int = binding.textviewFirst.text.toString().toInt()
            var action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        binding.toastButton.setOnClickListener {
            Toast.makeText(context, resources.getString(R.string.toast_msg), Toast.LENGTH_SHORT).show()
        }

        binding.countButton.setOnClickListener {
            countMe(binding.textviewFirst.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun countMe(countString: String){

        //Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        //Display the new value in the text view
        binding.textviewFirst.text = count.toString()
    }
}