package ru.geekbrains.market.exeptions;

public class ResourceNotFoundExeption extends RuntimeException {
    public ResourceNotFoundExeption(String message) {
        super(message);
    }
}
