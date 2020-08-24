package xyz.kewiany.contactus.domain

import java.util.*

data class Topic(
    val id: String = UUID.randomUUID().toString(),
    val name: String
)
