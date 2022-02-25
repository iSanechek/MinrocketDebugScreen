package com.mintrocket.debug_screen_module.di

import org.koin.core.module.Module

typealias ModuleDeclaration = Module.() -> Unit

fun debugModule(createdAtStart: Boolean = false, moduleDeclaration: ModuleDeclaration): Module {
    val module = Module(createdAtStart)
    moduleDeclaration(module)
    return module
}