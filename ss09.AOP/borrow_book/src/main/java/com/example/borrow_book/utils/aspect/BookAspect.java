package com.example.borrow_book.utils.aspect;

import com.example.borrow_book.model.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.io.*;
import java.util.Date;

@Aspect
@Component
public class BookAspect {
    private static final String PATH_LOG = "D:\\04_hoc_tap\\codegym\\c1122g1\\module04\\ss09.AOP\\borrow_book\\src\\main\\java\\com\\example\\borrow_book\\data\\log.txt";

    public static void writeFile(String message) {
        FileWriter fileReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileReader = new FileWriter(PATH_LOG, true);
            bufferedWriter = new BufferedWriter(fileReader);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterReturning("execution(* com.example.borrow_book.controller.BookController.borrowBook*(..))")
    public void logAfterBorrowBook() {
        writeFile("Có người vào mưọn sách " + new Date());
    }

    @AfterReturning("execution(* com.example.borrow_book.controller.BookUserController.returnBook*(..))")
    public void logAfterReturnBook() {
        writeFile("Có người vào trả sách " + new Date());
    }

}
