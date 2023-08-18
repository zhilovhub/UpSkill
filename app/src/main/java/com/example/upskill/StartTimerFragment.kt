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
        viewModel.isRunning.observe(viewLifecycleOwner) {isRunning ->
            if (isRunning) binding.startTimerBtn.setText(R.string.stop_btn)
            else binding.startTimerBtn.setText(R.string.start_btn)
        }

        binding.startTimerBtn.setOnClickListener {
            binding.startTimerBtn.visibility = View.GONE
            viewModel.startTimer()
            binding.pauseTimerBtn.visibility = View.VISIBLE
            binding.stopTimerBtn.isEnabled = true
        }

        binding.pauseTimerBtn.setOnClickListener {
            binding.pauseTimerBtn.visibility = View.GONE
//            viewModel.startTimer()
            binding.continueTimerBtn.visibility = View.VISIBLE
        }

        binding.continueTimerBtn.setOnClickListener {
            binding.continueTimerBtn.visibility = View.GONE
//            viewModel.startTimer()
            binding.pauseTimerBtn.visibility = View.VISIBLE
        }

        binding.stopTimerBtn.setOnClickListener {
            binding.pauseTimerBtn.visibility = View.GONE
            binding.continueTimerBtn.visibility = View.GONE
//            viewModel.startTimer()
            binding.startTimerBtn.visibility = View.VISIBLE
            binding.stopTimerBtn.isEnabled = false
        }
    }
}