package com.laskdjlaskdj12.raspberry.iotserver.service

import com.pi4j.component.relay.impl.GpioRelayComponent
import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.PinState
import com.pi4j.io.gpio.RaspiPin
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class PowerService {

    //Hight = 꺼짐 Low = 켜짐
    private val gpio = GpioFactory.getInstance()
    private val pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "Relay", PinState.HIGH)
    private val relay = GpioRelayComponent(pin, PinState.LOW, PinState.HIGH)

    @Async
    fun powerOff() {
        relay.open()
        Thread.sleep(3000)
        relay.close()
    }

    @Async
    fun powerOn() {
        relay.open()
        Thread.sleep(10000)
        relay.close()
    }

    val status: Boolean
        get() {
            return relay.isOpen
        }
}