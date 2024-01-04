package ru.vorona.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.vorona.entity.Bill;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@AllArgsConstructor
@Getter
public class BillResponseDTO {
    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationTime;

    private Boolean overdraftEnabled;

    public BillResponseDTO(Bill bill) {
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getIsDefault();
        creationTime = bill.getCreationTime();
        overdraftEnabled = bill.getOverdraftEnabled();
    }

}
