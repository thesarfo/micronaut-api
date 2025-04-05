package dev.thesarfo.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import sun.jvm.hotspot.debugger.Address
import javax.annotation.processing.Generated

@MappedEntity
data class AppUser(
    @field:Id
    @field:GeneratedValue
    val id: String? = null,
    val name: String,
    val email: String,
    val address: Address
)
