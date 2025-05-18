package com.ghumi.ghumighumi.controller

import com.ghumi.ghumighumi.model.User
import com.ghumi.ghumighumi.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAll(): List<User> = userService.getAllUsers()

    @PostMapping
    fun create(@RequestBody user: User): User = userService.createUser(user)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): User? = userService.getUserById(id)
}
