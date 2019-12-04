package com.yarik.kostya.services;

import com.yarik.kostya.model.PhoneRecord;
import com.yarik.kostya.model.User;
import com.yarik.kostya.storages.PhoneRecordsStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneRecordsService {

    private final PhoneRecordsStorage phoneRecordsStorage;
    private final UserService userService;

    public PhoneRecordsService(PhoneRecordsStorage phoneRecordsStorage, UserService userService) {
        this.phoneRecordsStorage = phoneRecordsStorage;
        this.userService = userService;
    }

    public List<PhoneRecord> getRecordsById(List<Long> ids) {
        return ids.stream().map(phoneRecordsStorage::getRecordById).collect(Collectors.toList());
    }

    public void createPhoneRecord(Long id, List<PhoneRecord> phoneRecords) {
        phoneRecordsStorage.addPhoneRecords(phoneRecords);
        User user = userService.getUserById(id);
        for (PhoneRecord phoneRecord : phoneRecords) {
            user.addPhoneBookId(phoneRecord.getId());
        }
    }
}
