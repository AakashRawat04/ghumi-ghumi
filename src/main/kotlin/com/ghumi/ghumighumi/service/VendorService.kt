package com.ghumi.ghumighumi.service

import com.ghumi.ghumighumi.model.Vendor
import com.ghumi.ghumighumi.repository.VendorRepository
import org.springframework.stereotype.Service

@Service
class VendorService(
    private val vendorRepository: VendorRepository
) {
    fun getAllVendors(): List<Vendor> = vendorRepository.findAll()
    fun createVendor(vendor: Vendor): Vendor = vendorRepository.save(vendor)
    fun getVendorById(id: String): Vendor? = vendorRepository.findById(id).orElse(null)
}
