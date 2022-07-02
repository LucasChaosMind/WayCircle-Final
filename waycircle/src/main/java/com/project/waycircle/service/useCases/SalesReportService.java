package com.project.waycircle.service.useCases;


import com.project.waycircle.model.Orders;
import com.project.waycircle.model.SaleReport;
import com.project.waycircle.service.CRUD.SalesReportServiceCRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
public record SalesReportService(SalesReportServiceCRUD salesReportServiceCRUD) {
    static SaleReport saleReport = new SaleReport();

    public void addOrder(Orders order){
        saleReport.getBuy().add(order);
        saleReport.setTotalAmountSales(saleReport.getTotalAmountSales()+order.getValorTotal());
        salesReportServiceCRUD.update(saleReport);
    }
    public Double salesReported(SaleReport saleReport){
        Double sales = saleReport.getBuy().stream().mapToDouble(Orders::getValorTotal).sum();
        log.info("Price Reported: {}",sales);
        return sales;
    }
}
