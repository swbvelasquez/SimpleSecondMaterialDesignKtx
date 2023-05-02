package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentBottomNavigationBarBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentButtonBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class BottomNavigationBarFragment : Fragment() {
    private lateinit var binding: FragmentBottomNavigationBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBottomNavigationBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Badge es la etiqueta que indica el numero de nuevas actualizaciones o notificaciones
        binding.bnvMain.getOrCreateBadge(R.id.action_home)

        binding.bnvMain.getOrCreateBadge(R.id.action_favorites).number = 21

        binding.bnvMain.getOrCreateBadge(R.id.action_profile).apply {
            number = 999
            maxCharacterCount = 3 //Indica la cantidad maxima de caracteres a verse (si es 3 -> 99+)
            backgroundColor = Color.CYAN // Color de etiqueta
            badgeTextColor = Color.MAGENTA //Color de letra
        }
    }

    companion object {
        const val TAG = "Bottom_Navigation"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_bottomnav_mobile_portrait, Constants.STATIC)
        }

        @JvmStatic
        fun newInstance() =
            BottomNavigationBarFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}