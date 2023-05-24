package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCardBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentMenuBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMenuPopup.setOnClickListener {
            val popupMenu = PopupMenu(activity,it)
            popupMenu.menuInflater.inflate(R.menu.bottom_nav_menu,popupMenu.menu)
            popupMenu.show()
        }

        val courses = listOf(
                "Experto en firebase para android +MVP curso completo +30hrs",
                "Material Design/Theming Profesional para Android",
                "Kotlin 2020")
        activity?.let {
            binding.acvCourses.setAdapter(ArrayAdapter(it,R.layout.item_menu_dropdown,courses))
        }

    }

    companion object {
        const val TAG = "Menu"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_menu_list, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            MenuFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}