package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.swbvelasquez.simplesecondmaterialdesignktx.R
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tilCapitalLetter.setEndIconOnClickListener {
                if (etCapitalLetter.text != null) {
                    val contentStr = etCapitalLetter.text.toString()
                    etCapitalLetter.setText(contentStr.uppercase())
                }
            }

            etPrice.addTextChangedListener { text ->
                if(text.isNullOrEmpty() || text.toString().toInt() < 5){
                    etPrice.error = getString(R.string.error_price_min)
                }
            }
        }
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