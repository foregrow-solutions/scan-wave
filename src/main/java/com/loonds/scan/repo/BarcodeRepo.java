package com.loonds.scan.repo;

import com.loonds.scan.model.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeRepo extends JpaRepository<Barcode, String> {
}
