package com.bmk.daggerproject.di.module

data class EncodedString(
    private val data: String
) {
    override fun toString(): String {
        return data
    }
}