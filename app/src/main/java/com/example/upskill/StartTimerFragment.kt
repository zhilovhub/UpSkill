package com.example.upskill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upskill.databinding.FragmentStartTimerBinding

class StartTimerFragment : Fragment() {

    private lateinit var binding: FragmentStartTimerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartTimerBinding.inflate(inflater, container, false)
        return binding.root
    }
}