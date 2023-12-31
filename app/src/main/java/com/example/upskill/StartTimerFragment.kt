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
        viewModel = ViewModelProvider(this, StartTimerViewModel.Factory(requireContext().applicationContext))[StartTimerViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentTime.observe(viewLifecycleOwner) {
            val timeString = getString(R.string.time_template, it)
            binding.timer.text = timeString
        }
        viewModel.timerState.observe(viewLifecycleOwner) {state ->
            when(state) {
                TimerState.RUNNING -> {
                    binding.startTimerBtn.visibility = View.GONE
                    binding.continueTimerBtn.visibility = View.GONE
                    binding.pauseTimerBtn.visibility = View.VISIBLE
                    binding.stopTimerBtn.isEnabled = true
                }
                TimerState.PAUSED -> {
                    binding.startTimerBtn.visibility = View.GONE
                    binding.continueTimerBtn.visibility = View.VISIBLE
                    binding.pauseTimerBtn.visibility = View.GONE
                    binding.stopTimerBtn.isEnabled = true
                }
                TimerState.INITIALIZED -> {
                    binding.startTimerBtn.visibility = View.VISIBLE
                    binding.continueTimerBtn.visibility = View.GONE
                    binding.pauseTimerBtn.visibility = View.GONE
                    binding.stopTimerBtn.isEnabled = false
                    binding.pauseTimerBtn.isEnabled = true
                }
                TimerState.FINISHED -> {
                    binding.startTimerBtn.visibility = View.GONE
                    binding.continueTimerBtn.visibility = View.GONE
                    binding.pauseTimerBtn.visibility = View.VISIBLE
                    binding.stopTimerBtn.isEnabled = true
                    binding.pauseTimerBtn.isEnabled = false
                }
            }
        }

        binding.startTimerBtn.setOnClickListener {
            viewModel.startTimer()
        }

        binding.pauseTimerBtn.setOnClickListener {
            viewModel.pauseTimer()
        }

        binding.continueTimerBtn.setOnClickListener {
            viewModel.continueTimer()
        }

        binding.stopTimerBtn.setOnClickListener {
            viewModel.stopTimer()
        }
    }
}