package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentFloatingActionButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data

class FloatingActionButtonFragment : Fragment() {
    private lateinit var binding: FragmentFloatingActionButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFloatingActionButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabDefault.setOnClickListener {
            Toast.makeText(activity,R.string.message_action_success,Toast.LENGTH_SHORT).show()
        }

        binding.fabLegacy.setOnClickListener {
            binding.fabLegacy.hide()
            binding.tvLegacy.visibility = View.GONE
        }
    }

    companion object {
        const val TAG = "Fab"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_fab_default, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            FloatingActionButtonFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}