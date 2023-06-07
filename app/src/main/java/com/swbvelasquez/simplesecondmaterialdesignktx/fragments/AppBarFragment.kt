package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentAppBarBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class AppBarFragment : Fragment() {
    private lateinit var binding: FragmentAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAppBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
    }

    private fun setupButtons(){
        binding.btnTop.setOnClickListener {
            activity?.let {
                val fragment = AppBarTopFragment.newInstance()
                fragment.show(it.supportFragmentManager, AppBarTopFragment.TAG)
            }
        }

        binding.btnBottom.setOnClickListener {
            activity?.let {
                val fragment = FullScreenDialogFragment.newInstance()
                fragment.show(it.supportFragmentManager, FullScreenDialogFragment.TAG)
            }
        }
    }

    companion object {
        const val TAG = "AppBar"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_app_bar, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            AppBarFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}