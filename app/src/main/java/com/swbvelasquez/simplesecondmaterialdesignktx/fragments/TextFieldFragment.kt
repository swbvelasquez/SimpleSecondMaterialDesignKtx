package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentTextFieldBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class TextFieldFragment : Fragment() {
    private lateinit var binding: FragmentTextFieldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTextFieldBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "TextField"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_textfields_outlined_active, Constants.SCROLL)
        }

        @JvmStatic
        fun newInstance() =
            TextFieldFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}