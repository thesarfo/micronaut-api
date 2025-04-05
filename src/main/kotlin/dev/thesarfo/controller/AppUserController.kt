package dev.thesarfo.controller

import dev.thesarfo.model.Address
import dev.thesarfo.model.AppUser
import dev.thesarfo.request.AppUserRequest
import dev.thesarfo.service.AppUserService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status

@Controller("/user")
class AppUserController(
    private val appUserService: AppUserService
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body appUserRequest: AppUserRequest) =
        appUserService.create(
            appUser = appUserRequest.toModel()
        )


    private fun AppUserRequest.toModel(): AppUser =
        AppUser(
            name = this.name,
            email = this.email,
            address = Address(
                street = this.street,
                city = this.city,
                code = this.code
            )
        )

}