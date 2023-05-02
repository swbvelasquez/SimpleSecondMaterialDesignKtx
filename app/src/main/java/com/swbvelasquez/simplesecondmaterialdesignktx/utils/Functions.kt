package com.swbvelasquez.simplesecondmaterialdesignktx.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.swbvelasquez.simplesecondmaterialdesignktx.fragments.BottomNavigationBarFragment
import com.swbvelasquez.simplesecondmaterialdesignktx.fragments.ButtonFragment

object Functions {
    fun setFragment(activity:AppCompatActivity,fragmentName:String,contentRes:Int){
        val fragment = getFragmentById(fragmentName)

        fragment?.let {
            activity.supportFragmentManager
                .beginTransaction()
                .add(contentRes,it)
                .commit()
        }
    }

    private fun getFragmentById(fragmentName:String):Fragment?{
        var fragment : Fragment? = null

        when(fragmentName){
            ButtonFragment.TAG -> fragment = ButtonFragment.newInstance()
            BottomNavigationBarFragment.TAG -> fragment = BottomNavigationBarFragment.newInstance()
        }

        return fragment
    }
}