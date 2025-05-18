package com.ghumi.ghumighumi.controller

import com.ghumi.ghumighumi.model.Vendor
import com.ghumi.ghumighumi.service.VendorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vendors")
class VendorController(
    private val vendorService: VendorService
) {

    @GetMapping
    fun getAll(): List<Vendor> = vendorService.getAllVendors()

    @PostMapping
    fun create(@RequestBody vendor: Vendor): Vendor = vendorService.createVendor(vendor)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Vendor? = vendorService.getVendorById(id)
}
