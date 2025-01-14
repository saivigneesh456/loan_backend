package com.example.loan_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan_backend.models.Loan;
import com.example.loan_backend.repositories.LoanRepository;

@Service
public class LoanService {
    @Autowired private LoanRepository loanrepo;
    //returns list of loans
    public List<Loan> getAllLoans(){
        List<Loan>loans = new ArrayList<>();
        Iterable<Loan>itl =  loanrepo.findAll();
        itl.forEach(loans::add);
        return loans;
    }
    //save loan
    public void saveLoan(Loan l){
        loanrepo.save(l);
    }
    //get loan by id
    public Optional<Loan> getLoanById(UUID id){
        return loanrepo.findById(id);
    }
    //delete loan by id
    public void deleteLoanById(UUID id){
        loanrepo.deleteById(id);
    }
}
