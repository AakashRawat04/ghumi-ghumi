package com.ghumi.ghumighumi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "experience")
data class Experience(
    @Id
    val id: String? = null,
    val title: String,
    val description: String,
    val location: String,
    val date: LocalDateTime,
    val price: Double,
    val totalTickets: Int,
    val ticketsSold: Int = 0,
    val vendorId: String
)
