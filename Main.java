package org.example;

import org.example.model.Payment;
import org.example.model.StatusEnum;
import org.example.processor.PaymentProcessor;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /*
    * 3. Demonstrate usage in a `main()` method:
    - Create a few sample payments.
    - Process them.
    - Print statistics.
    4. Bonus (if time allows):
    - Sort payments by amount (descending).
    - Use Java Streams to implement filtering and statistics.
    - Add a simple concurrency simulation: process payments in parallel using `CompletableFuture` or `parallelStream()`.
    * */
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        PaymentProcessor processor = new PaymentProcessor();

        processor.addNew("1", BigDecimal.valueOf(1), "BRL", StatusEnum.SUCCESS);
        processor.addNew("2", BigDecimal.valueOf(2), "BRL", StatusEnum.FAILED);
        processor.addNew("3", BigDecimal.valueOf(3), "USD", StatusEnum.PENDING);
        processor.addNew("4", BigDecimal.valueOf(4), "BRL", StatusEnum.SUCCESS);

        System.out.println("Total number of payments :" + processor.totalNumberofPayments());
        System.out.println("Total amount of successful payments :" + processor.totalAmountOfSuccessfulPayments());
        System.out.println("Average amount of successful payments :" + processor.averageAmountOfSuccessfulPayments());

        processor.sort();

        System.out.println(processor.retrieveAll());
    }
}