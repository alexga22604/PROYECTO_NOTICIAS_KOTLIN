package com.example.noticias_practica3.data.mapper

import com.example.noticias_practica3.data.NewsDto
import com.example.noticias_practica3.data.model.*

fun NewsDto.toBo(): NewsBo {
    return NewsBo(
        id = this.id ?: "",
        title = this.title ?: "",
        description = this.subtitle ?: "",
        content = this.body ?: "",
        date = this.date ?: "",
        imageRes = this.imageRes ?: 0,
        author = AuthorBo(
            id = "auth-${this.id}",
            name = this.authorFirstName ?: "",
            surname = this.authorLastName ?: "",
            avatarRes = this.authorImage ?: 0
        ),
        blog = BlogBo("1", "JetNews Blog", ""),
        interests = emptyList()
    )
}