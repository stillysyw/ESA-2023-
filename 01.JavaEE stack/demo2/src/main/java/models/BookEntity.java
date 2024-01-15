package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name="author_id")
    private  int author_id;

    @Column(name="public_year")
    private  int public_year;
}
