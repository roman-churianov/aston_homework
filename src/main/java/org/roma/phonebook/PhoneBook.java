package org.roma.phonebook;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PhoneBook {
    private Map<String, List<String>> namesPhones;

    public PhoneBook() {
        namesPhones = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (namesPhones.containsKey(name)) {
            namesPhones.get(name).add(phoneNumber);
        } else {
            namesPhones.put(name, new ArrayList<>(Arrays.asList(phoneNumber)));
        }
    }

    public List<String> get(String name) {
        return namesPhones.get(name);
    }
}
