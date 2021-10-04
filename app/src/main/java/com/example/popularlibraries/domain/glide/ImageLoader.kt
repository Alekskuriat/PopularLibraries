package com.example.popularlibraries.domain.glide

interface ImageLoader<T> {
    fun loadInto(url: String, container: T)

}