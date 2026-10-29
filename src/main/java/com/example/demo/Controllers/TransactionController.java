package com.example.demo.Controllers;

import com.example.demo.Repositories.TransactionRepository;
import com.example.demo.Services.TransactionService;
import com.example.demo.models.Transaction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository repository;
    private final TransactionService service;

    public TransactionController(TransactionRepository repository, TransactionService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Transaction> lister() {
        return repository.findAll();
    }

    @GetMapping("/solde")
    public BigDecimal solde(@RequestParam String mois) {
        return service.soldeDuMois(YearMonth.parse(mois));
    }

    @PostMapping
    public Transaction ajouter(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}