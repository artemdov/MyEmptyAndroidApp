package com.example.cicerone_app.cicerone

interface Screen {
    fun screenKey() = this::class.java
}