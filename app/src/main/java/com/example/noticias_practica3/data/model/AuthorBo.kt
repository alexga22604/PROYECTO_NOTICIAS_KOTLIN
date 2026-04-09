package com.example.noticias_practica3.data.model

data class AuthorBo(
    val id: String,
    val name: String,
    val surname: String,
    val avatarRes: String
) {
    val fullName: String get() = "$name $surname"
}