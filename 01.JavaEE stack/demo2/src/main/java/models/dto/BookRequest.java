package models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookRequest {
    private String tittle;
    private int author_id;
    private  int public_year;
}
