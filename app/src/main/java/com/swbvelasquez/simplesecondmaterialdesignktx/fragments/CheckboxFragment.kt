package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCheckboxBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class CheckboxFragment : Fragment() {
    private lateinit var binding: FragmentCheckboxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCheckboxBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "Checkbox"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_checkboxes, Constants.SCROLL)
        }

        @JvmStatic
        fun newInstance() =
            CheckboxFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}