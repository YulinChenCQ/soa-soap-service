package com.soa.restservice.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

public class BillDetailInfo {
    private String id;

    private String billNumber;

    private String tradeName;

    private String specificationsAndModel;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal priceExcludingTax;

    private BigDecimal priceIncludingTax;

    private BigDecimal sumExcludingTax;

    private BigDecimal sumIncludingTax;

    private BigDecimal taxRate;

    private BigDecimal discount;

    private BigDecimal tax;

    private Long serialNumber;

    private String taxClassCode;

    private String standby1;

    private String standby2;

    private String standby3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber == null ? null : billNumber.trim();
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName == null ? null : tradeName.trim();
    }

    public String getSpecificationsAndModel() {
        return specificationsAndModel;
    }

    public void setSpecificationsAndModel(String specificationsAndModel) {
        this.specificationsAndModel = specificationsAndModel == null ? null : specificationsAndModel.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceExcludingTax() {
        return priceExcludingTax;
    }

    public void setPriceExcludingTax(BigDecimal priceExcludingTax) {
        this.priceExcludingTax = priceExcludingTax;
    }

    public BigDecimal getPriceIncludingTax() {
        return priceIncludingTax;
    }

    public void setPriceIncludingTax(BigDecimal priceIncludingTax) {
        this.priceIncludingTax = priceIncludingTax;
    }

    public BigDecimal getSumExcludingTax() {
        return sumExcludingTax;
    }

    public void setSumExcludingTax(BigDecimal sumExcludingTax) {
        this.sumExcludingTax = sumExcludingTax;
    }

    public BigDecimal getSumIncludingTax() {
        return sumIncludingTax;
    }

    public void setSumIncludingTax(BigDecimal sumIncludingTax) {
        this.sumIncludingTax = sumIncludingTax;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTaxClassCode() {
        return taxClassCode;
    }

    public void setTaxClassCode(String taxClassCode) {
        this.taxClassCode = taxClassCode == null ? null : taxClassCode.trim();
    }

    public String getStandby1() {
        return standby1;
    }

    public void setStandby1(String standby1) {
        this.standby1 = standby1 == null ? null : standby1.trim();
    }

    public String getStandby2() {
        return standby2;
    }

    public void setStandby2(String standby2) {
        this.standby2 = standby2 == null ? null : standby2.trim();
    }

    public String getStandby3() {
        return standby3;
    }

    public void setStandby3(String standby3) {
        this.standby3 = standby3 == null ? null : standby3.trim();
    }
}