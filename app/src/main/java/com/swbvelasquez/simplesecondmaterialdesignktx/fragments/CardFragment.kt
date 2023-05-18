package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCardBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCheckboxBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class CardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "Card"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_cards_template, Constants.SCROLL)
        }

        @JvmStatic
        fun newInstance() =
            CardFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}