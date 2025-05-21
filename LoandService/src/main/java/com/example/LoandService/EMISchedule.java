package com.example.LoandService;

public class EMISchedule {
    private int month;
    private double emi;
    private double interest;
    private double principalComponent;
    private double balance;
    

    public EMISchedule(int month, double emi, double interest, double principalComponent, double balance) {
        this.month = month;
        this.emi = emi;
        this.interest = interest;
        this.principalComponent = principalComponent;
        this.balance = balance;
    }

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getPrincipalComponent() {
		return principalComponent;
	}

	public void setPrincipalComponent(double principalComponent) {
		this.principalComponent = principalComponent;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    

    // Getters and Setters
}
