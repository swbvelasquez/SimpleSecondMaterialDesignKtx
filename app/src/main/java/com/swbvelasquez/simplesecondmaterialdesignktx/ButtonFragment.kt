package com.swbvelasquez.simplesecondmaterialdesignktx

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class ButtonFragment : Fragment() {
    private lateinit var binding: FragmentButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "Button"

        @JvmStatic
        fun getData(): Data{
            return Data(TAG,R.drawable.img_button,Constants.SCROLL)
        }

        @JvmStatic
        fun newInstance() =
            ButtonFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}