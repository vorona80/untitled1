package ru.vorona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vorona.controller.dto.BillRequestDTO;
import ru.vorona.controller.dto.BillResponseDTO;
import ru.vorona.service.BillService;

@RestController
public class BillController {
    private final BillService billService;
    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }
    @GetMapping("/{billId}")
    public BillResponseDTO getBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }
    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(billRequestDTO.getAccountId(),billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(),billRequestDTO.getCreationTime(), billRequestDTO.getOverdraftEnabled());
    }
    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId, @RequestBody BillRequestDTO billRequestDTO) {
        return new BillResponseDTO(billService.updateBill(billId,billRequestDTO.getAccountId(),billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(),billRequestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId) {
    return new BillResponseDTO(billService.deleteBill(billId));
    }
}
