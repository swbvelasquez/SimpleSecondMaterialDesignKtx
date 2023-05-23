package com.swbvelasquez.simplesecondmaterialdesignktx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swbvelasquez.simplesecondmaterialdesignktx.adapters.DataAdapter
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.ActivityMainBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.fragments.*
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        dataAdapter = DataAdapter(mutableListOf()){ data ->
            val intent =
                if(data.type == Constants.SCROLL)
                    Intent(this,ScrollActivity::class.java)
                else
                    Intent(this,StaticActivity::class.java)

            intent.putExtra(Constants.ARG_NAME,data.name)
            startActivity(intent)
        }
        dataAdapter.add(ButtonFragment.getData())
        dataAdapter.add(BottomNavigationBarFragment.getData())
        dataAdapter.add(SnackBarFragment.getData())
        dataAdapter.add(TextFieldFragment.getData())
        dataAdapter.add(FloatingActionButtonFragment.getData())
        dataAdapter.add(CheckboxFragment.getData())
        dataAdapter.add(CardFragment.getData())
        dataAdapter.add(MenuFragment.getData())
        dataAdapter.reverse()

        binding.rvData.apply {
            adapter = dataAdapter
            setHasFixedSize(true)
        }
    }

}