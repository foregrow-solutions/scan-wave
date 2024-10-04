package com.loonds.scan.util;

import com.google.zxing.BarcodeFormat;

public final class CodeFormats {
    public static final BarcodeFormat QR_CODE = BarcodeFormat.QR_CODE;
    public static final BarcodeFormat CODE_128 = BarcodeFormat.CODE_128;

    // Add more code formats here if needed
    // Example:
    // public static final BarcodeFormat EAN_13 = BarcodeFormat.EAN_13;

    private CodeFormats() {
        // Private constructor to prevent instantiation
    }
}
