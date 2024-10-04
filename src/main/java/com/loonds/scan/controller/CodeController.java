package com.loonds.scan.controller;

import com.loonds.scan.controller.payload.CodeGenerationPayload;
import com.loonds.scan.service.CodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Code Service APIs", description = "APIs for managing code operations")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CodeController {
    private final CodeService codeService;

    @Operation(summary = "Generate Code For Given Client")
    @PostMapping(value = "/generate-code", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateCode(@RequestBody CodeGenerationPayload payload) {
        return codeService.generateCode(payload);
    }

    @Operation(summary = "Verify Given Code")
    @GetMapping("/verify-code")
    public ResponseEntity<String> verifyCode(
            @RequestParam String scannedData,
            @RequestParam String expectedData) {
        boolean isVerified = codeService.verifyCode(scannedData, expectedData);

        String responseMessage = isVerified ? "QR code verification successful." : "QR code verification failed.";
        return ResponseEntity.status(isVerified ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(responseMessage);
    }
}
