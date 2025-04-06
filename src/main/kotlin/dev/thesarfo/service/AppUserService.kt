package dev.thesarfo.service

import dev.thesarfo.model.AppUser
import dev.thesarfo.repository.AppUserRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton

@Singleton
class AppUserService(
    private val appUserRepository: AppUserRepository
) {

    fun create(appUser: AppUser): AppUser {
        return appUserRepository.save(appUser)
    }

    fun getAllUsers(): List<AppUser> {
        return appUserRepository.findAll().toList();
    }

    fun getSingleUserById(id: String): AppUser {
        return appUserRepository.findById(id)
            .orElseThrow { HttpStatusException(HttpStatus.NOT_FOUND, "User with id $id not found") }
    }

    fun update(id: String, appUser: AppUser): AppUser {
        val found = getSingleUserById(id);
        val updated = appUser.copy(id = found.id);

        return appUserRepository.update(updated)
    }

    fun delete(id: String) {
        appUserRepository.deleteById(id);
    }

//    fun getUserById(id: String) : AppUser{
//        return appUserRepository.findById(id).orElse
//    }
}