package com.project.waycircle.service.CRUD;

import com.project.waycircle.model.Address;
import com.project.waycircle.model.SaleReport;
import com.project.waycircle.repository.SaleReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public record SalesReportServiceCRUD (SaleReportRepository slr){
    public SaleReport save(SaleReport saleReport){
        log.info("Salve SaleReport {}",saleReport.getId());
        return slr.saveAndFlush(saleReport);
    }
    public SaleReport update(SaleReport saleReport){
        log.info("Update in SaleReport {}",saleReport.getId());
        return slr.saveAndFlush(saleReport);
    }

    public List<SaleReport> readAll (){
        log.info("Read All SaleReport");
        return slr.findAll();
    }
    public SaleReport readById (Long id){
        log.info("Read SaleReport id: {}",id);
        SaleReport aux = slr.findById(id).get();
        if(aux == null){
            log.info("ID SaleReport not found");
        }
        return aux;
    }

}
