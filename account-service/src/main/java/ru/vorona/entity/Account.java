package ru.vorona.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter

@NoArgsConstructor
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long accountId;

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime creationTime;
    @ElementCollection
    private List<Long> bills;

    public Account(String name, String email, String phone, OffsetDateTime creationTime, List<Long> bills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.creationTime = creationTime;
        this.bills = bills;
    }
}
