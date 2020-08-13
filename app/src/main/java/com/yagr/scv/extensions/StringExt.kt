package com.yagr.scv.extensions

/**
 * Return null if the string is blank,
 * otherwise return the string
 */
fun String.nullIfBlank() = if (this.isBlank()) null else this