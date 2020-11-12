package gr.codehub.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BasketDto {

    private int customerId;
    private String customerName;
    private LocalDateTime date;

}
