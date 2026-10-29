package com.example.demo.Services;

import com.example.demo.Repositories.TransactionRepository;
import com.example.demo.models.Transaction;
import com.example.demo.models.TypeTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService service;

    @Autowired
    private TransactionRepository repository;

    @BeforeEach
    void nettoyer() {
        repository.deleteAll();
    }

    @Test
    void soldeDuMoisAvecRevenuEtDepense() {
        repository.save(transaction(TypeTransaction.REVENU, "600.00", LocalDate.of(2026, 10, 5)));
        repository.save(transaction(TypeTransaction.DEPENSE, "350.00", LocalDate.of(2026, 10, 6)));

        assertEquals(0, new BigDecimal("250.00").compareTo(service.soldeDuMois(YearMonth.of(2026, 10))));
    }

    private Transaction transaction(TypeTransaction type, String montant, LocalDate date) {
        Transaction t = new Transaction();
        t.setNom("test");
        t.setType(type);
        t.setCategorie("test");
        t.setMontant(new BigDecimal(montant));
        t.setDate(date);
        return t;
    }
}