package ru.vorona.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor

public class AccountRequestDTO {

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime creationTime;

    private List<Long> bills;
}
