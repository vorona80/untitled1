package ru.vorona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vorona.entity.Bill;
import ru.vorona.exception.BillNotFoundException;
import ru.vorona.repository.BillRepository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class BillService {
    private final BillRepository billRepository;
    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElseThrow(
                ()-> new BillNotFoundException("Unable to find bill with id: " + billId));
    }

    public Long createBill (Long accountId, BigDecimal amount,Boolean isDefault,OffsetDateTime offsetDateTime,Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId,amount,isDefault,offsetDateTime.now(), overdraftEnabled);
        return billRepository.save(bill).getBillId();
    }

    public Bill updateBill(Long billId,Long accountId, BigDecimal amount,Boolean isDefault,Boolean overdraftEnabled) {
        Bill bill = new Bill();
        bill.setBillId(billId);
        bill.setAccountId(accountId);
        bill.setAmount(amount);
        bill.setIsDefault(isDefault);
        bill.setOverdraftEnabled(overdraftEnabled);
//        bill.setCreationTime(OffsetDateTime.now());
        return billRepository.save(bill);
    }

    public Bill deleteBill(Long billId) {
        Bill deletBill = getBillById(billId);
        billRepository.deleteById(billId);
        return deletBill;
    }
}
