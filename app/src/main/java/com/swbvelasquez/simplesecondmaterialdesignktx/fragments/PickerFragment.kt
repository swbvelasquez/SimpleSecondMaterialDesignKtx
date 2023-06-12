package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentPickerBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class PickerFragment : Fragment() {
    private lateinit var binding: FragmentPickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
    }

    private fun setupButtons(){
        binding.btnDialog.setOnClickListener {
            showDatePicker(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar)
        }

        binding.btnDialogFullScreen.setOnClickListener {
            showDatePicker(R.style.AppTheme_FullScreenDialogPicker)
        }


    }

    private fun showDatePicker(themeId:Int){
        activity?.let {
            val actualDate = System.currentTimeMillis()
            val dialogPicker = MaterialDatePicker
                .Builder
                .datePicker()
                .setTitleText(R.string.picker_title)
                .setTheme(themeId)
                .setSelection(actualDate)
                .build()

            dialogPicker.addOnPositiveButtonClickListener { selection ->
                Log.d("picker",selection.toString())
                Snackbar.make(binding.lyMainContainer,dialogPicker.headerText, Toast.LENGTH_SHORT).show()
            }

            dialogPicker.addOnNegativeButtonClickListener { dialog ->
                Log.d("picker",dialog.toString())
                Snackbar.make(binding.lyMainContainer,R.string.dialog_negative, Toast.LENGTH_SHORT).show()
            }

            dialogPicker.addOnCancelListener { dialogInterface ->
                Log.d("picker",dialogInterface.toString())
                Snackbar.make(binding.lyMainContainer,R.string.dialog_cancel, Toast.LENGTH_SHORT).show()
            }

            dialogPicker.show(it.supportFragmentManager,dialogPicker.toString())
        }
    }

    companion object {
        const val TAG = "Picker"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_picker, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            PickerFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}