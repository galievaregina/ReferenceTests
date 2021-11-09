package com.example.myapplication

import android.content.pm.ActivityInfo
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Test
    fun testFragment1() {
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))

    }
    @Test
    fun testFragment2to1() {
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))

    }
    @Test
    fun testFragment2back1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment2))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment2to3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment3back2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment3))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment3to1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment1toAbout() {
        launchActivity<MainActivity>()
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment2toAbout(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment3toAbout(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testAboutBackFragment1(){
        launchActivity<MainActivity>()
        openAbout()
        Espresso
            .onView(withId(R.id.activity_about))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testAboutBackFragment2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        openAbout()
        Espresso
            .onView(withId(R.id.activity_about))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testAboutBackFragment3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso
            .onView(withId(R.id.activity_about))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientation1(){
        val activityScenario = launchActivity<MainActivity>()
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientation2(){
        val activityScenario = launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientation3(){
        val activityScenario = launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientationAbout(){
        val activityScenario = launchActivity<MainActivity>()
        openAbout()
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testStackDepth(){
        val activityScenario = launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso
            .onView(withId(R.id.activity_about))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment3))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment2))
            .perform(pressBack())
        Espresso
            .onView(withId(R.id.fragment1))
            .perform(pressBackUnconditionally())
        var isClosed = false;
        activityScenario.onActivity { activity ->
            isClosed = activity.isFinishing }
        Assert.assertEquals(true, isClosed )
    }
}