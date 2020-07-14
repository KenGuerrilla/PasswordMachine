package com.itl.kg.passwordmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.itl.kg.passwordmachine.utilities.InjectorUtils
import com.itl.kg.passwordmachine.utilities.hideKeyboard
import com.itl.kg.passwordmachine.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels {
        InjectorUtils.provideMainActivityViewModelFactory(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        subscribeUi()

    }

    private fun subscribeUi() {
        viewModel.getResultLiveData().observe(this, Observer {
            mainActivity_output_textView.text = it
        })
    }

    private fun initView() {

        mainActivity_convert_button.setOnClickListener {
            val input = mainActivity_input_textInputLayout.editText?.text.toString()
            viewModel.convert(input)
            hideKeyboard(this)
        }

        mainActivity_clean_button.setOnClickListener {
            mainActivity_input_textInputLayout.editText?.setText("")
            mainActivity_output_textView.text = ""
        }

        mainActivity_copy_button.setOnClickListener {
            viewModel.copyToClipboard(mainActivity_output_textView.text.toString())
        }

    }
}