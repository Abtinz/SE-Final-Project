package com.siliconvalley.bilito.commonServices.ui.coroutineBased

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/*
 * this class will implement our CoroutineScope with our Fragment
 */
abstract class BaseFragmentCoroutineClass:Fragment(),CoroutineScope {

    private lateinit var job : Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}