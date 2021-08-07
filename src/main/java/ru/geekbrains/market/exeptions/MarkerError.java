package ru.geekbrains.market.exeptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MarkerError {
    private String message;
    private Date timestamp;

    public MarkerError(String message) {
        this.message = message;
        this.timestamp = new Date();
    }
}
