package com.loonds.scan.service.impl;

import com.loonds.scan.controller.payload.CodeFormat;
import com.loonds.scan.controller.payload.CodeGenerationPayload;
import com.loonds.scan.service.CodeService;
import com.loonds.scan.util.CodeFormats;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    @Override
    public byte[] generateCode(CodeGenerationPayload payload) {
        try {
            BitMatrix bitMatrix = null;
            if(payload.codeFormat() == CodeFormat.QRCODE){
                bitMatrix = generateQRCode(payload);
            } else if (payload.codeFormat() == CodeFormat.BARCODE) {
                bitMatrix = generateBarcode(payload);
            }else {
                log.error("Unsupported code format: {}", payload.codeFormat());
            }

            if (bitMatrix != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
                return outputStream.toByteArray();
            }
        } catch (Exception e) {
            log.error("Error generating code image: {}", e.getMessage());
        }

        return new byte[0];
    }

    private BitMatrix generateBarcode(CodeGenerationPayload payload) throws Exception {
        Writer writer = new Code128Writer();
        return writer.encode(payload.data(), CodeFormats.CODE_128, payload.width(), payload.height());
    }

    private BitMatrix generateQRCode(CodeGenerationPayload payload) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        return qrCodeWriter.encode(payload.data(), CodeFormats.QR_CODE, payload.width(), payload.height());
    }

    @Override
    public boolean verifyCode(String scannedCode, String expectedData) {
        return scannedCode.equals(expectedData);
    }
}
