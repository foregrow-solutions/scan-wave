package com.loonds.scan.repo;

import com.loonds.scan.model.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepo extends JpaRepository<QRCode,Long> {
}
