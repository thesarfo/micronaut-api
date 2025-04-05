package dev.thesarfo.controller

import dev.thesarfo.model.Address
import dev.thesarfo.model.AppUser
import dev.thesarfo.request.AppUserRequest
import dev.thesarfo.service.AppUserService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

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

    @Get
    @Status(HttpStatus.OK)
    fun getUsers() =
        appUserService.getAllUsers()

    @Get("/{id}")
    fun getById(@PathVariable("id") id: String) =
        appUserService.getSingleUserById(id)

    @Put("/{id}")
    fun update(
        id: String,
        @Body request: AppUserRequest,
        @Header("X-Foo") header: String
    ): AppUser {
        println("Header: $header")
        return appUserService.update(id, request.toModel());
    }


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