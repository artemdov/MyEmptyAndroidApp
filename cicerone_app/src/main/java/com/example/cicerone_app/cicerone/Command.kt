package com.example.cicerone_app.cicerone

sealed interface Command {
    class Forward(val screen: Screen): Command
    class Backward(val screen: Screen): Command
}