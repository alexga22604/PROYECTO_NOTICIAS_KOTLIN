package com.example.noticias_practica3.data

data class AuthorBo(
    val id: String,
    val name: String,
    val surname: String,
    val avatarRes: Int
) {
    val fullName: String get() = "$name $surname"
}