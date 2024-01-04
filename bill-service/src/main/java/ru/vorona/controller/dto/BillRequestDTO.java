package ru.vorona.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Getter
@AllArgsConstructor
public class BillRequestDTO {
    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationTime;

    private Boolean overdraftEnabled;
}
