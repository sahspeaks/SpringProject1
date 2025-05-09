package com.practice.SpringProject1.model;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Insurance {
	@Id
    private int policyNo;
    private String vehicleNo;
    private String vehicleType;
    private String customerName;
    private int engineNo;
    private int chasisNo;
    private String phoneNo;
    private double premiumAmount;
    private String insuranceType;
    private Date fromDate;
    private Date toDate;
    private int underwriterId;
    
    public Insurance() {
		// Default constructor
	}

//    public Insurance(String vehicleNo, String vehicleType, String customerName, int engineNo, int chasisNo,
//            String phoneNo, double premiumAmount, String insuranceType, Date fromDate, int underwriterId) {
//
//        this.policyNo = Helper.getNextPolicyNo();
//        this.vehicleNo = vehicleNo;
//        this.vehicleType = vehicleType;
//        this.customerName = customerName;
//        this.engineNo = engineNo;
//        this.chasisNo = chasisNo;
//        this.phoneNo = phoneNo;
//        this.insuranceType = insuranceType;
//        this.premiumAmount = premiumAmount;
//        this.fromDate = fromDate;
//
//        Calendar cal = Calendar.getInstance(); //give current date and time
//        cal.setTime(fromDate); //modify current date to fromDate
//        cal.add(Calendar.DAY_OF_YEAR, 365); //adds 365 to fromDate
//        this.toDate = cal.getTime(); //set modified date to toDate
//
//        this.underwriterId = underwriterId;
//
//    }
    
    public Insurance(int policyNo, String vehicleNo, String vehicleType, String customerName, int engineNo, int chasisNo,
            String phoneNo, String insuranceType, double premiumAmount, Date fromDate,Date toDate, int underwriterId) {

        this.policyNo = policyNo;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.customerName = customerName;
        this.engineNo = engineNo;
        this.chasisNo = chasisNo;
        this.phoneNo = phoneNo;
        this.insuranceType = insuranceType;
        this.premiumAmount = premiumAmount;
        this.fromDate = fromDate;
        this.toDate = toDate; 
        this.underwriterId = underwriterId;

    }

    // getter and setter for insuarnce


	public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(int engineNo) {
        this.engineNo = engineNo;
    }

    public int getChasisNo() {
        return chasisNo;
    }

    public void setChasisNo(int chasisNo) {
        this.chasisNo = chasisNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmout(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public int getUnderwriterId() {
        return underwriterId;
    }

    public void setUnderwriterId(int underwriterId) {
        this.underwriterId = underwriterId;
    }

    public Date getToDate() {
        return toDate;
    }
}


