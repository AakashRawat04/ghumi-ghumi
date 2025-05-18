package com.ghumi.ghumighumi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "vendors")
data class Vendor(
    @Id
    val id: String? = null,
    val name: String,
    val email: String
)