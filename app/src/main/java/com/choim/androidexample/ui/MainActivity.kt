package com.choim.androidexample.ui


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.choim.androidexample.R
import com.choim.androidexample.viewmodel.MainViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.getUser().observe {
            tv_name.text = it?.name
            tv_age.text = String.format("%d", it?.age)
            tv_address.text = it?.address
        }

        btn_save.setOnClickListener {
            viewModel.updateUserProperty(
                    name = et_name.text.toString(),
                    age = et_age.text.toString().toInt(),
                    address = et_address.text.toString()
            )
        }
    }

    inline fun <T> LiveData<T>.observe(crossinline observer: (T?) -> Unit) {
        observe(this@MainActivity, Observer { observer.invoke(it) })
    }
}
