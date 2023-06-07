package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCheckboxBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentFullScreenDialogBinding


class FullScreenDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentFullScreenDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog) //Permite que se le aplique un estilo al crearse, ademas ayuda a que se vea como pantalla completa
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupButtons()
    }

    private fun setupButtons(){
        binding.btnSave.setOnClickListener {
            Toast.makeText(activity,R.string.message_action_success,Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    private fun setupToolbar(){
        binding.tlbDialog.apply {
            setNavigationIcon(R.drawable.ic_close)
            setNavigationOnClickListener {
                dismiss()
            }
            setTitle(R.string.dialog_full_screen)
        }
    }

    companion object {
        const val TAG = "FullScreenDialogFragment"

        @JvmStatic
        fun newInstance() =
            FullScreenDialogFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}