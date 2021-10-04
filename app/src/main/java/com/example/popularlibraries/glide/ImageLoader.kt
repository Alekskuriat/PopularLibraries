package com.example.popularlibraries.glide

interface ImageLoader<T> {
    fun loadInto(url: String, container: T)

}