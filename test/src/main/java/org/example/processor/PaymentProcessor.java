package org.example.processor;

/*
* 2. Implement a `PaymentProcessor` class with methods to:
- Add a new payment.
- Retrieve all payments.
- Retrieve payments filtered by status.
- Calculate statistics:
- Total number of payments.
- Total amount of successful payments.
- Average amount of successful payments.
* 4. Bonus (if time allows):
    - Sort payments by amount (descending).
    - Use Java Streams to implement filtering and statistics.
    - Add a simple concurrency simulation: process payments in parallel using `CompletableFuture` or `parallelStream()`.
	"
* */

import org.example.model.Payment;
import org.example.model.StatusEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentProcessor {

    private List<Payment> paymentList = new ArrayList<>();

    public Payment addNew(String id, BigDecimal amount, String currency, StatusEnum status) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setId(id);
        payment.setStatus(status);
        paymentList.add(payment);
        return payment;
    }

    public List<Payment> retrieveAll() {
        return paymentList;
    }

    public int totalNumberofPayments() {
        return paymentList.size();
    }

    public int totalAmountOfSuccessfulPayments() {
        List<Payment> sucessful = paymentList.stream()
                .filter(p -> p.getStatus().equals(StatusEnum.SUCCESS))
                .collect(Collectors.toList());
        return sucessful.size();
    }

    public double averageAmountOfSuccessfulPayments() {
        return  (double) totalAmountOfSuccessfulPayments() / totalNumberofPayments();
    }

    public void sort() {
        paymentList = paymentList.stream().sorted((a, b) ->
                a.getAmount().compareTo(b.getAmount()) * -1)
                .collect(Collectors.toList());
    }
}
