package com.mintrocket.featuretoggle.di

import com.mintrocket.featuretoggle.di.module.toggleModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(vararg modules: Module, appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    val m = mutableListOf<Module>().apply {
        val childs = modules.toList()
        if (childs.isNotEmpty()) {
            addAll(childs)
        }
        add(toggleModule)
        add(platformModule())
    }
    modules(m)
}

// for iOS
fun initKoin() = initKoin {}