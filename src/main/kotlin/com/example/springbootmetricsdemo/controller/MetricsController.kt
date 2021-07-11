package com.example.springbootmetricsdemo.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration

@RestController
@RequestMapping("/metrics")
class MetricsController {
    @GetMapping("/{type}")
    fun metricsTest(@PathVariable type: String) : ResponseEntity<Response> {
        if (type == "slow") {
            Thread.sleep(Duration.ofMinutes(1).toMillis())
        }

        return ResponseEntity.ok(Response("Hello!"))
    }
}

data class Response(val message: String)
