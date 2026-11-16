package com.stanislavvelykoivan.murrnote

import androidx.compose.ui.window.ComposeUIViewController
import com.stanislavvelykoivan.murrnote.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }
