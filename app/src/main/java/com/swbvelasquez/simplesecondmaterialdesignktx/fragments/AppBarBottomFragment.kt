package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.snackbar.Snackbar
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentAppBarBottomBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentAppBarTopBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.BottomAppBarCutCornersTopEdge


class AppBarBottomFragment : DialogFragment() {
    private lateinit var binding: FragmentAppBarBottomBinding
    private var isCentered = false

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
        binding = FragmentAppBarBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupButtons()
    }

    private fun setupButtons(){
        binding.fabAdd.setOnClickListener {
            if(isCentered){
                binding.babMain.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }else{
                binding.babMain.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
            isCentered = !isCentered
        }
    }

    private fun setupToolbar(){
        binding.babMain.setOnMenuItemClickListener { item ->
            val idMessage = when(item.itemId){
                R.id.action_favorites -> R.string.menu_favorites
                R.id.action_profile -> R.string.menu_profile
                else -> R.string.menu_start
            }

            Snackbar.make(binding.lyMainContainer,idMessage,Toast.LENGTH_SHORT)
                .setAnchorView(binding.fabAdd) //Indica sobre quien se visualizara el snackbar
                .show()

            true
        }

        binding.babMain.setNavigationOnClickListener {
            Snackbar.make(binding.lyMainContainer,R.string.message_action_success,Toast.LENGTH_SHORT)
                .setAnchorView(binding.fabAdd) //Indica sobre quien se visualizara el snackbar
                .show()
        }

        /** Seccion utilizada unicamente para dar forma de diamante al hueco entre el fab y el bottomAppBar **/
        val topEdge = BottomAppBarCutCornersTopEdge(
            binding.babMain.fabCradleMargin,
            binding.babMain.fabCradleRoundedCornerRadius,
            binding.babMain.cradleVerticalOffset
        )

        val materialShapeDrawable = binding.babMain.background as MaterialShapeDrawable
        materialShapeDrawable.shapeAppearanceModel = materialShapeDrawable
            .shapeAppearanceModel
            .toBuilder()
            .setTopEdge(topEdge)
            .build()
        /** **/
    }

    companion object {
        const val TAG = "AppBarBottomDialogFragment"

        @JvmStatic
        fun newInstance() =
            AppBarBottomFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}