package com.vasquez.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vasquez.calculator.databinding.ActivityMainBinding

/**
 * @author Jhonatan Vasquez
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSum.setOnClickListener(this)
        binding.btnMin.setOnClickListener(this)
        binding.btnMult.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)
    }
    override fun onClick(view: View?) = with(binding) {
        var a = edt1.text.toString().toInt()
        var b = edt2.text.toString().toInt()
        when (view?.id){
            btnSum.id -> tvresult.text = (a mas b).toString()
            btnMin.id -> tvresult.text = (a menos b).toString()
            btnMult.id -> tvresult.text = (a por b).toString()
            else -> tvresult.text = (a entre b).toString()
        }
    }
    // Infix
    private infix fun Int.mas(y: Int) = this + y
    private infix fun Int.menos(y: Int) = this - y
    private infix fun Int.por(y: Int) = this * y
    private infix fun Int.entre(y: Int) = this / y

}