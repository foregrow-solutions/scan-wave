package com.loonds.scan.controller.payload;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CodeGenerationPayload(int height, int width, String data, @Enumerated(EnumType.STRING) CodeFormat codeFormat) {
}
