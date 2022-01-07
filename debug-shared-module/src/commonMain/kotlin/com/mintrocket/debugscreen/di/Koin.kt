package com.mintrocket.debugscreen.di

import com.mintrocket.debugscreen.di.module.toggleModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(toggleModule, platformModule())
}

// for iOS
fun initKoin() = initKoin {}