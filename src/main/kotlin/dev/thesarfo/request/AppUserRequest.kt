package dev.thesarfo.request

import io.micronaut.serde.annotation.Serdeable
import io.micronaut.serde.annotation.Serdeable.Deserializable

@Serdeable.Serializable
@Deserializable
data class AppUserRequest(
    val name: String,
    val email: String,
    val street: String,
    val city: String,
    val code: Int
)
