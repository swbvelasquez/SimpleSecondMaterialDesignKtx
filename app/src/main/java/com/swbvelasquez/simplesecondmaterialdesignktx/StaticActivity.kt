package com.swbvelasquez.simplesecondmaterialdesignktx

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.ActivityStaticBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Functions

class StaticActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaticBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaticBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        var fragmentName : String? = null

        if(savedInstanceState == null){
            fragmentName = intent.getStringExtra(Constants.ARG_NAME)

            fragmentName?.let {
                Functions.setFragment(this,it,R.id.content_static)
            }
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = fragmentName ?: "No Title"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}