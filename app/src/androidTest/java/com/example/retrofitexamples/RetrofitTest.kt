package com.example.retrofitexamples

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class RetrofitTest {
    companion object {
        private val latch = CountDownLatch(1)
        var textViewData = "my test"
    }

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before              //register your Idling Resource
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(IdlingResource.getIdlingResource())
        //IdlingPolicies.setMasterPolicyTimeout(4000, TimeUnit.MILLISECONDS);
        // IdlingPolicies.setIdlingResourceTimeout(4000, TimeUnit.MILLISECONDS)
    }

    // Unregister your Idling Resource
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(IdlingResource.getIdlingResource())
    }

    @Test                         // IdlingResource implementation
    fun retrofitIdlingResource() {
        IdlingResource.increment()
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView))
                .check(matches(withText(textViewData)))
        IdlingResource.decrement()

    }

    @Test                               // Using Thread.sleep
    fun retrofitThreadSleep() {
        Thread.sleep(7000)
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView))
                .check(matches(withText(textViewData)))
    }

    @Test                                // Using countdownLatch
    fun retrofitCountdownLatch() {

        latch.await(4000, TimeUnit.MILLISECONDS)
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView))
                .check(matches(withText(textViewData)))

    }

}




