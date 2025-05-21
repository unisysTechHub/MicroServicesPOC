package com.example.LoandService;

public class LoanRequest {
    private double principal;
    private double annualRate;
    private int tenureYears;
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getAnnualRate() {
		return annualRate;
	}
	public void setAnnualRate(double annualRate) {
		this.annualRate = annualRate;
	}
	public int getTenureYears() {
		return tenureYears;
	}
	public void setTenureYears(int tenureYears) {
		this.tenureYears = tenureYears;
	}

    // Getters and Setters
}
