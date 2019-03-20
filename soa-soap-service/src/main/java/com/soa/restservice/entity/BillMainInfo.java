package com.soa.restservice.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BillMainInfo {
    private String id;

    private String billNumber;

    private String billDate;

    private String buyerName;

    private String buyerDutyParagraph;

    private String buyerAddrPhone;

    private String buyerBankAccount;

    private BigDecimal totalAmount;

    private String operator;

    private String remarks;

    private String reBillNumber;

    private String printRemark;

    private String distinction;

    private String state;

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

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getBuyerDutyParagraph() {
        return buyerDutyParagraph;
    }

    public void setBuyerDutyParagraph(String buyerDutyParagraph) {
        this.buyerDutyParagraph = buyerDutyParagraph == null ? null : buyerDutyParagraph.trim();
    }

    public String getBuyerAddrPhone() {
        return buyerAddrPhone;
    }

    public void setBuyerAddrPhone(String buyerAddrPhone) {
        this.buyerAddrPhone = buyerAddrPhone == null ? null : buyerAddrPhone.trim();
    }

    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    public void setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount == null ? null : buyerBankAccount.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getReBillNumber() {
        return reBillNumber;
    }

    public void setReBillNumber(String reBillNumber) {
        this.reBillNumber = reBillNumber == null ? null : reBillNumber.trim();
    }

    public String getPrintRemark() {
        return printRemark;
    }

    public void setPrintRemark(String printRemark) {
        this.printRemark = printRemark == null ? null : printRemark.trim();
    }

    public String getDistinction() {
        return distinction;
    }

    public void setDistinction(String distinction) {
        this.distinction = distinction == null ? null : distinction.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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