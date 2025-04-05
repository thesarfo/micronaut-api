package dev.thesarfo.repository

import dev.thesarfo.model.AppUser
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository

@MongoRepository
interface AppUserRepository : CrudRepository<AppUser, String> {
}