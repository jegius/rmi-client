package com.edu;

import com.edu.dto.BookRMI;
import com.edu.rmi.BookRemoteService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RmiClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BookRemoteService bookService = (BookRemoteService) registry.lookup("BookRemoteService");

            // Пример использования RMI сервиса
            List<BookRMI> books = bookService.getAllBooks(0, 100);
            books.forEach(book -> System.out.println(book.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}