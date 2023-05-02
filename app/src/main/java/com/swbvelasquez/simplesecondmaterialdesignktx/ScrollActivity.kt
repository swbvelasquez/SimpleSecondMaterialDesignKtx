package com.swbvelasquez.simplesecondmaterialdesignktx

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.ActivityScrollBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Constants
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Functions

class ScrollActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        var fragmentName : String? = null

        if(savedInstanceState == null){
            fragmentName = intent.getStringExtra(Constants.ARG_NAME)

            fragmentName?.let {
                Functions.setFragment(this,it,R.id.content_scroll)
            }
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = fragmentName ?: "No Title"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}