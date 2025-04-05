package dev.thesarfo.service

import dev.thesarfo.model.AppUser
import dev.thesarfo.repository.AppUserRepository
import jakarta.inject.Singleton

@Singleton
class AppUserService(
    private val appUserRepository: AppUserRepository
) {

    fun create(appUser: AppUser): AppUser {
        return appUserRepository.save(appUser)
    }
}