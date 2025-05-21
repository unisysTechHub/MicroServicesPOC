package com.example.LoandService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.example.LoandService.LoanService.Product;

@Repository
public class LoanService {

    public  List<EMISchedule> generateSchedule(double principal, double annualRate, int tenureYears) {
        int months = tenureYears * 12;
        double monthlyRate = annualRate / 12 / 100; // annualRate as percentage (e.g., 10 for 10%)
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                     (Math.pow(1 + monthlyRate, months) - 1);
       
        
        return Stream.iterate(
                new State(1, principal),  state -> state.month <= months,
                state -> {
                    double interest = state.balance * monthlyRate;
                    double principalComponent = emi - interest;
                    double newBalance = state.balance - principalComponent;
                    if (state.month == months) newBalance = 0; // avoid rounding residue
                    System.out.println("Loadn service");
                    return new State(state.month + 1, newBalance);
                }
            )
            .map(state -> {
                double interest = state.balance * monthlyRate;
                double principalComponent = emi - interest;
                double balanceAfterPayment = state.balance - principalComponent;
                if (state.month == months) balanceAfterPayment = 0; // avoid rounding residue
                return new EMISchedule(
                        state.month,
                        round(emi),
                        round(interest),
                        round(principalComponent),
                        round(balanceAfterPayment)
                );
            })
            .collect(Collectors.toList());
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // Helper class to keep track of month and balance
    private static class State {
        int month;
        double balance;

        State(int month, double balance) {
            this.month = month;
            this.balance = balance;
        }
    }
    public static class Product {
    	int id;
    	String name;
    	double price;
    	Product(int id, String name, double price){
    		this.id= id;
    		this.name = name;
    		this.price = price;
      }
    	
      	
    	
    }
    
    public void test() {
    	Product p1 =new Product(1, "Laptop", 100);
    	Product p2 = new Product(2,"mobile", 100);
    	Product p3 = new Product(3,"Laptop",100);
    	
    	ArrayList<Product> products = new ArrayList();
    	products.add(p1);
    	products.add(p2);
    	products.add(p3);
    	
    	  HashMap<String, List<Product>> result =	products.stream().collect(()-> new HashMap<String,List<Product>>(), (map, product) -> map.merge(
    	        product.name,
    	        new ArrayList<>(List.of(product)),
    	        (existingList, newList) -> {
    	            existingList.addAll(newList);
    	            return existingList;
    	        } ),
    	 (map1, map2) -> { map2.forEach((key,value) -> {if(value.size() > 1)
    	 { map1.put(key,value); }} );}
    	 
    			);
    	  
    	  result.forEach( (key, v) -> {System.out.println("key " + key + "value " + v.size() );} );
    }
}   