package com.ghumi.ghumighumi.repository

import com.ghumi.ghumighumi.model.Vendor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface VendorRepository : MongoRepository<Vendor, String>
