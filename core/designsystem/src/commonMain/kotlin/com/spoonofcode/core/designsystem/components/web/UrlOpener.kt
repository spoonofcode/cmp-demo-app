package com.spoonofcode.core.designsystem.components.web

interface UrlOpener {
    fun openUrl(url: String)
}

expect fun getUrlOpener(): UrlOpener