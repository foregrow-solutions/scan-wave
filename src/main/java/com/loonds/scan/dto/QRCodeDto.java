package com.loonds.scan.dto;

import com.loonds.scan.model.QRCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QRCodeDto {
    long id;
    String data;

    public static QRCodeDto of(QRCode qrCode) {
        QRCodeDto output = new QRCodeDto();
        output.setId(output.id);
        output.setData(qrCode.getData());
        return output;
    }
}
