package com.loonds.scan.service;

import com.loonds.scan.controller.payload.CodeGenerationPayload;

public interface CodeService {
    byte[] generateCode(CodeGenerationPayload payload);

    boolean verifyCode(String clientData, String expectedData);
}
