package com.example.retrofitexamples

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

 object IdlingResource {
     private const val resource = "GLOBAL"
        @JvmField
       val mCountingIdlingResource = CountingIdlingResource(resource)

     fun increment() {
        mCountingIdlingResource.increment()
    }

    fun decrement() {
        if (!mCountingIdlingResource.isIdleNow) {
            mCountingIdlingResource.decrement()
        }
    }

    fun getIdlingResource(): IdlingResource? {
        return mCountingIdlingResource
    }



 }