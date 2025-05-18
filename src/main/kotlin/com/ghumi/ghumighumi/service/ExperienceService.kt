package com.ghumi.ghumighumi.service

import com.ghumi.ghumighumi.model.Experience
import com.ghumi.ghumighumi.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class ExperienceService(
    private val experienceRepository: ExperienceRepository
) {
    fun getAllExperiences(): List<Experience>{
        return experienceRepository.findAll()
    }

    fun createExperience(experience: Experience): Experience {
        return experienceRepository.save(experience)
    }

    fun bookExperience(userId: String, experienceId: String, tickets: Int, userService: UserService): String {
        val experience = experienceRepository.findById(experienceId).orElse(null)
            ?: return "Experience not found."

        val user = userService.getUserById(userId)
            ?: return "User not found."

        if (experience.totalTickets < tickets) {
            return "Not enough tickets available."
        }

        val totalCost = experience.price * tickets
        if (user.creditBalance < totalCost) {
            return "Insufficient credit balance."
        }

        // Deduct tickets and credit
        val updatedExperience = experience.copy(totalTickets = experience.totalTickets - tickets)
        val updatedUser = user.copy(creditBalance = user.creditBalance - totalCost)

        experienceRepository.save(updatedExperience)
        userService.updateUser(updatedUser)

        return "Booking successful for $tickets ticket(s)!"
    }

}