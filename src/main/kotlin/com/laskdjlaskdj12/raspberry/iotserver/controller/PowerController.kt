package com.laskdjlaskdj12.raspberry.iotserver.controller

import com.laskdjlaskdj12.raspberry.iotserver.service.PowerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/power")
class PowerController(
        private val powerService: PowerService) {

    @GetMapping("/status")
    fun powerStatus(): Boolean {
        return powerService.status
    }

    @GetMapping("/on")
    fun powerOn(): String {
        powerService.powerOn()
        return "Done"
    }

    @GetMapping("/off")
    fun powerOff(): String {
        powerService.powerOff()
        return "Done"
    }
}