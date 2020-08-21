package xyz.kewiany.contactus.core

import com.jakewharton.rxrelay3.BehaviorRelay

fun <T> createState(): BehaviorRelay<T> = BehaviorRelay.create()
fun <T> createState(value: T): BehaviorRelay<T> = BehaviorRelay.createDefault(value)
