package ru.vorona.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.vorona.entity.Account;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponseDTO {
    private Long accountId;

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime creationTime;

    private List<Long> bills;

    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        phone = account.getPhone();
        creationTime = account.getCreationTime();
        bills = account.getBills();
    }
}
