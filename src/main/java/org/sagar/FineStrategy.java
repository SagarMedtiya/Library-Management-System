package org.sagar;

import java.time.LocalDate;

public interface FineStrategy {
    double calculateFine(LocalDate dueDate, LocalDate returnDate);
}
