package com.example.lab3_13_1

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEvenNumber() {
        // Nhập số 4 vào EditText
        onView(withId(R.id.editTextNumber)).perform(typeText("4"), closeSoftKeyboard())
        // Nhấn nút Check
        onView(withId(R.id.buttonCheck)).perform(click())
        // Kiểm tra nếu TextView hiển thị "Even Number"
        onView(withId(R.id.textViewResult)).check(matches(withText("Even Number")))
    }

    @Test
    fun testOddNumber() {
        // Nhập số 3 vào EditText
        onView(withId(R.id.editTextNumber)).perform(typeText("3"), closeSoftKeyboard())
        // Nhấn nút Check
        onView(withId(R.id.buttonCheck)).perform(click())
        // Kiểm tra nếu TextView hiển thị "Odd Number"
        onView(withId(R.id.textViewResult)).check(matches(withText("Odd Number")))
    }

    @Test
    fun testInvalidInput() {
        // Nhập chữ "abc" vào EditText
        onView(withId(R.id.editTextNumber)).perform(typeText("abc"), closeSoftKeyboard())
        // Nhấn nút Check
        onView(withId(R.id.buttonCheck)).perform(click())
        // Kiểm tra nếu TextView hiển thị "Invalid Input"
        onView(withId(R.id.textViewResult)).check(matches(withText("Invalid Input")))
    }
}
