package com.yarik.kostya.controllers;

import com.yarik.kostya.model.PhoneRecord;
import com.yarik.kostya.services.PhoneRecordsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phonerecord")
public class PhoneRecordController {

    private final PhoneRecordsService phoneRecordsService;

    public PhoneRecordController(PhoneRecordsService phoneRecordsService) {
        this.phoneRecordsService = phoneRecordsService;
    }

    @GetMapping("/user/{id}")
    public List<PhoneRecord> getAll(@PathVariable List<Long> id) {
        return phoneRecordsService.getRecordsById(id);
    }

    @PostMapping("/create/{userId}")
    public void createRecordForUser(@PathVariable Long userId, @RequestBody List<PhoneRecord> phoneRecords) {
        phoneRecordsService.createPhoneRecord(userId, phoneRecords);
    }
}
