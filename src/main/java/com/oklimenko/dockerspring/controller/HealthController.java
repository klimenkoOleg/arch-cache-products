package com.oklimenko.dockerspring.controller;

import com.oklimenko.dockerspring.dto.HealthStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HealthController {

    @GetMapping("/health")
    public HealthStatus health() {
        return new HealthStatus("OK");
    }

}