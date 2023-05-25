package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentAlertDialogBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class AlertDialogFragment : Fragment() {
    private lateinit var binding: FragmentAlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAlertDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnDialogInfo.setOnClickListener {
                activity?.let { context ->
                    MaterialAlertDialogBuilder(context)
                        .setTitle(R.string.card_title_demo)
                        .setMessage(R.string.card_message_demo_small)
                        .setPositiveButton(R.string.dialog_ok){ _, _ ->

                        }
                        .show()
                }
            }

            btnDialogChooser.setOnClickListener {
                activity?.let { context ->
                    val arrayAdapter = ArrayAdapter<String>(context, android.R.layout.select_dialog_item)
                    arrayAdapter.add("Opción 1")
                    arrayAdapter.add("Opción 2")
                    arrayAdapter.add("Opción 3")

                    MaterialAlertDialogBuilder(context)
                        .setTitle(R.string.card_title_demo)
                        .setAdapter(arrayAdapter){ dialog, i ->
                            Toast.makeText(context,arrayAdapter.getItem(i),Toast.LENGTH_SHORT).show()
                        }
                        .show()
                }
            }

            btnDialogConfirm.setOnClickListener {
                activity?.let { context ->
                    //Temas para dialgo:
                    //MaterialAlertDialogBuilder(context)
                    //MaterialAlertDialogBuilder(context, com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Dialog)
                    MaterialAlertDialogBuilder(context, com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                        .setTitle(R.string.dialog_confirm_title)
                        .setMessage(R.string.card_message_demo_small)
                        .setPositiveButton(R.string.dialog_ok){ _, _ ->
                            Toast.makeText(context,R.string.message_action_success,Toast.LENGTH_SHORT).show()
                        }
                        .setNegativeButton(R.string.dialog_cancel){ _, _ ->

                        }
                        .show()
                }
            }
        }
    }

    companion object {
        const val TAG = "Dialog"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_dialog_mobile_alert, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            AlertDialogFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}