package com.project.waycircle.repository;

import com.project.waycircle.model.SaleReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleReportRepository extends JpaRepository<SaleReport, Long> {
}
