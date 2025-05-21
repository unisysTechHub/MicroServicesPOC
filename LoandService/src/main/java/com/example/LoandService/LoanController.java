package com.example.LoandService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:4200"})

public class LoanController {

	@Autowired
	LoanService loanService;

    @PostMapping("/schedule")
    public List<EMISchedule> calculateLoanSchedule(@RequestBody LoanRequest request) {
        return loanService.generateSchedule(request.getPrincipal(), request.getAnnualRate(), request.getTenureYears());
    }
}
