package com.yarik.kostya.storages;

import com.yarik.kostya.model.PhoneRecord;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PhoneRecordsStorage {

    private long counterOfIds;
    private Map<Long, PhoneRecord> storage;


    public PhoneRecordsStorage() {
        this.counterOfIds = 0;
        this.storage = new HashMap<>();
    }

    private long getNextId() {
        return ++counterOfIds;
    }

    public void addPhoneRecords(List<PhoneRecord> phoneRecords) {
        storage.putAll(phoneRecords.stream().collect(
                Collectors.toMap(it -> getNextId(), Function.identity())
        ));
    }

//    public Set getAllPhoneRecords() {
//        return storage.entrySet();
//    }

    public PhoneRecord getRecordById(Long id) {
        return storage.get(id);
    }
}
