package com.example.Customers;

public class PaymentDepartment implements CustomerCare {
	
    private String department= "Payment Department";
    private String customerName;
    private String issue; 
    private double refId; 

	@Override
	public String getDepartment() {
		return this.department; 

	}

	@Override
	public void getService() {
		System.out.println("Welcome to " + this.department  + customerName + ".");
        System.out.println("How may I assist you with your payment inquiry?");

	}

	@Override
	public void setCustomerName(String name) {
		this.customerName =name; 

	}

	@Override
	public void setProblem(String problem) {
		this.issue =problem; 
		
	}

	@Override
	public void getProblem() {
		this.refId = Math.random()*(1000-1+1)+1; 
		this.refId= Math.round(refId); 
		System.out.println(" Dear " + customerName+ " your issue for " + this.issue + "has been recorded, your reference id is: " + refId);
	}

}
