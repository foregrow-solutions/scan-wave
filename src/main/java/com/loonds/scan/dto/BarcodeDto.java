package com.loonds.scan.dto;

import com.loonds.scan.model.Barcode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarcodeDto {
    long id;
    String data;
    String format;

    public static BarcodeDto of(Barcode barcode) {
        BarcodeDto output = new BarcodeDto();
        output.setId(barcode.getId());
        output.setData(barcode.getData());
        output.setFormat(barcode.getFormat());
        return output;
    }
}
