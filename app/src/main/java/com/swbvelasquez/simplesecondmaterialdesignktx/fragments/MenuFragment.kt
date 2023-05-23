package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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