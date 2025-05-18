package com.ghumi.ghumighumi.repository

import com.ghumi.ghumighumi.model.Experience
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ExperienceRepository : MongoRepository<Experience, String> {}