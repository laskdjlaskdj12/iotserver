package com.laskdjlaskdj12.raspberry.iotserver.controller

import com.laskdjlaskdj12.raspberry.iotserver.service.PowerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/power")
class PowerController(
        private val powerService: PowerService) {

    @GetMapping("/on")
    fun powerOn(): ResponseEntity<String> {
        powerService.powerOn()
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/off")
    fun powerOff(): ResponseEntity<String> {
        powerService.powerOff()
        return ResponseEntity(HttpStatus.OK)
    }
}