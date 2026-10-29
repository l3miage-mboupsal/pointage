package com.example.demo.Services;

import com.example.demo.Repositories.TransactionRepository;
import com.example.demo.models.Transaction;
import com.example.demo.models.TypeTransaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.YearMonth;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public BigDecimal soldeDuMois(YearMonth mois) {
    BigDecimal total = BigDecimal.ZERO;
    for (Transaction t : repository.findAll()) {
        if (t.getDate() == null || !YearMonth.from(t.getDate()).equals(mois)) {
            continue;
        }
        if (t.getType() == TypeTransaction.REVENU) {
            total = total.add(t.getMontant());
        } else {
            total = total.subtract(t.getMontant());
        }
    }
    return total;
}
}