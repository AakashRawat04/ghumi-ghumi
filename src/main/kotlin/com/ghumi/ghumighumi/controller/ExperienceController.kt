package com.ghumi.ghumighumi.controller

import com.ghumi.ghumighumi.model.Experience
import com.ghumi.ghumighumi.service.ExperienceService
import com.ghumi.ghumighumi.service.UserService
import com.ghumi.ghumighumi.service.VendorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/experiences")
class ExperienceController(
    private val experienceService: ExperienceService,
    private val userService: UserService,
    private val vendorService: VendorService
) {
    @GetMapping
    fun getAll(): List<Experience> {
        // log the request
        println("Get all experiences request")
        return experienceService.getAllExperiences()
    }

    @PostMapping
    fun create(@RequestBody experience: Experience): Experience {
        // log the request
        println("Create experience request: $experience")
        return experienceService.createExperience(experience)
    }

    @PostMapping("/{experienceId}/book")
    fun bookExperience(
        @PathVariable experienceId: String,
        @RequestParam userId: String,
        @RequestParam tickets: Int
    ): String {
        return experienceService.bookExperience(userId, experienceId, tickets, userService)
    }

    @PostMapping("/vendor/{vendorId}")
    fun createByVendor(
        @PathVariable vendorId: String,
        @RequestBody experience: Experience
    ): Any {
        // log the request
        println("Create experience by vendor request: $experience for vendorId: $vendorId")
        val vendor = vendorService.getVendorById(vendorId)
        if (vendor == null) return "Vendor not found."

        val experienceWithVendor = experience.copy(vendorId = vendorId)
        return experienceService.createExperience(experienceWithVendor)
    }


}