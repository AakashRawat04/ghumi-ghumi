package com.ghumi.ghumighumi.service


import com.ghumi.ghumighumi.model.User
import com.ghumi.ghumighumi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUserById(id: String): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun updateUser(user: User): User {
        return userRepository.save(user)
    }
}