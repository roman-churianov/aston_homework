package org.roma.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> namesPhones;

    public PhoneBook() {
        namesPhones = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (namesPhones.containsKey(name)) {
            namesPhones.get(name).add(phoneNumber);
        } else {
            namesPhones.put(name, new ArrayList<>());
            namesPhones.get(name).add(phoneNumber);
        }
    }

    public List<String> get(String name) {
        return namesPhones.get(name);
    }
}
