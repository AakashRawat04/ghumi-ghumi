package com.ghumi.ghumighumi.repository

import com.ghumi.ghumighumi.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {}
