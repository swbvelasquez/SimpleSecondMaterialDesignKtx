package com.swbvelasquez.simplesecondmaterialdesignktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCardBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.FragmentCheckboxBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data


class CardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide
            .with(this)
            .load("https://www.cnet.com/a/img/resize/69256d2623afcbaa911f08edc45fb2d3f6a8e172/hub/2023/02/03/afedd3ee-671d-4189-bf39-4f312248fb27/gettyimages-1042132904.jpg?auto=webp&fit=crop&height=675&width=1200")
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imvCardLarge)

        setupChips()
    }

    private fun setupChips(){
        with(binding){
            chpFirst.setOnClickListener {
                Toast.makeText(activity,"First Chip",Toast.LENGTH_SHORT).show()
            }

            chpSecond.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    Toast.makeText(activity,"Second Chip Checked",Toast.LENGTH_SHORT).show()
                }
            }

            chpThird.setOnCloseIconClickListener {
                chpThird.visibility = View.GONE
            }
        }
    }

    companion object {
        const val TAG = "Card"

        @JvmStatic
        fun getData(): Data {
            return Data(TAG, R.drawable.img_cards_template, Constants.SCROLL)
        }

        @JvmStatic
        fun newInstance() =
            CardFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}