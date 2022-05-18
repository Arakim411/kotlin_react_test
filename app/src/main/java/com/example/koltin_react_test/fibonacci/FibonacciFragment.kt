package com.example.koltin_react_test.fibonacci

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.Fragment;
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.example.koltin_react_test.databinding.FibonacciFragmentBinding
import kotlinx.coroutines.*

class FibonacciFragment : Fragment() {

    private lateinit var binding: FibonacciFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FibonacciFragmentBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val startTime = System.currentTimeMillis()
            val numberOfWords =
                binding.editText.text.toString().toIntOrNull() ?: return@setOnClickListener

            CoroutineScope(Dispatchers.IO).launch {
                val result = fib(numberOfWords.toLong())
                withContext(Dispatchers.Main) {
                    loadResult(
                        time = System.currentTimeMillis() - startTime,
                        result = result,
                        numberOfWords = numberOfWords
                    )
                }
            }

        }
    }


    private fun fib(n: Long): Long {
        return if (n <= 1) n else fib(n - 1) + fib(n - 2)
    }

    private fun loadResult(time: Long, numberOfWords: Int, result: Long) {

        binding.numberOfResult.text = numberOfWords.toString()
        binding.result.text = result.toString()
        binding.calTime.text = time.toString().plus(" ms")
    }
}