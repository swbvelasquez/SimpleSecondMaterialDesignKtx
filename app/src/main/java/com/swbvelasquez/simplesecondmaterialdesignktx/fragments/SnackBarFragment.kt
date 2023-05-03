package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentSnackBarBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class SnackBarFragment : Fragment() {
    private lateinit var binding: FragmentSnackBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSnackBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Snackbar.make(binding.root,R.string.message_action_success,Snackbar.LENGTH_SHORT)
            .setAction("Volver"){ //Agrega un text button al snackbar
                activity?.finish()
            }
            .show()
    }

    companion object {
        const val TAG = "Snackbar"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_singleline_action, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            SnackBarFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}