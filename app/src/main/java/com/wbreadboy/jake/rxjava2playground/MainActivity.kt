package com.wbreadboy.jake.rxjava2playground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Flowable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        // buffer (used bufferSupplier: Callable<U>)
        val bufferList = mutableListOf<String>("1", "2", "3", "4", "5")
        Flowable.fromIterable(bufferList)
                .buffer(2, { mutableListOf<String>() })
                .subscribe {
                    Log.e("buffer(count, callable)", "$it")
                }
    }
}
