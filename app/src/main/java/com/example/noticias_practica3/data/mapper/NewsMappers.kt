package com.example.noticias_practica3.data.mapper

import com.example.noticias_practica3.data.NewsDto
import com.example.noticias_practica3.data.model.AuthorBo
import com.example.noticias_practica3.data.model.BlogBo
import com.example.noticias_practica3.data.model.InterestBo
import com.example.noticias_practica3.data.model.NewsBo

const val DEFAULT_STRING_VALUE = ""
const val DEFAULT_INT_VALUE = 0

fun NewsDto.toAuthorBo(): AuthorBo {
    return AuthorBo(
        id = "auth-${this.id ?: DEFAULT_STRING_VALUE}",
        name = this.authorFirstName ?: DEFAULT_STRING_VALUE,
        surname = this.authorLastName ?: DEFAULT_STRING_VALUE,
        avatarRes = this.authorImage ?: DEFAULT_INT_VALUE
    )
}

fun NewsDto.toBlogBo(): BlogBo {
    return BlogBo(
        id = DEFAULT_STRING_VALUE,
        title = DEFAULT_STRING_VALUE,
        url = DEFAULT_STRING_VALUE
    )
}

fun NewsDto.toBo(): NewsBo {
    return NewsBo(
        id = this.id ?: DEFAULT_STRING_VALUE,
        title = this.title ?: DEFAULT_STRING_VALUE,
        description = this.subtitle ?: DEFAULT_STRING_VALUE,
        content = this.body ?: DEFAULT_STRING_VALUE,
        date = this.date ?: DEFAULT_STRING_VALUE,
        imageRes = this.imageRes ?: DEFAULT_INT_VALUE,

        author = this.toAuthorBo(),
        blog = this.toBlogBo(),

        interests = emptyList()
    )
}