package com.example.upskill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.upskill.databinding.FragmentStartTimerBinding

class StartTimerFragment : Fragment() {

    private lateinit var binding: FragmentStartTimerBinding
    private lateinit var viewModel: StartTimerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentStartTimerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[StartTimerViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentTime.observe(viewLifecycleOwner) {
            val timeString = getString(R.string.time_template, it)
            binding.timer.text = timeString
        }
    }
}