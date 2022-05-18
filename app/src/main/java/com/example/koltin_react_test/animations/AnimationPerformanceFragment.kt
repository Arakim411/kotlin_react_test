package com.example.koltin_react_test.animations

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.koltin_react_test.R
import com.example.koltin_react_test.databinding.AnimationPerformanceFragmentBinding

class AnimationPerformanceFragment: Fragment() {

    private lateinit var  binding: AnimationPerformanceFragmentBinding

    private var count = 0
    private var maxBarsInRow = 8
    private lateinit var lastView: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnimationPerformanceFragmentBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.plus.setOnClickListener {
            binding.textView9.text = count.toString()
            addProgressBar()
            count++
        }
    }

    private fun getProgressBarView(): View = LayoutInflater.from(context).inflate(R.layout.progress_bar,null,false)

    private fun addProgressBar(){
        if(count % maxBarsInRow == 0){
            addNewRow()
        }

        lastView.addView(
            getProgressBarView()
        )

    }

    private fun addNewRow(){
        val newLayout = LayoutInflater.from(context).inflate(R.layout.horizontal_layout,null,false) as LinearLayout
        lastView = newLayout
        binding.container.addView(newLayout)
    }
}