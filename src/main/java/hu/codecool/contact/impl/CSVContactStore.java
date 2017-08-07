package hu.codecool.contact.impl;

import hu.codecool.contact.api.ContactStore;
import hu.codecool.contact.model.Contact;

import javax.enterprise.inject.Default;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Default
public class CSVContactStore implements ContactStore {

    public CSVContactStore() {
    }

    @Override
    public List<Contact> getAll() {
        try {
            List<Contact> result = new ArrayList<>();
            InputStream is = CSVContactStore.class.getResourceAsStream("/contacts.csv");
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if ("".equals(line.trim())) {
                    continue;
                }
                String[] fields = line.split(",", 3);
                result.add(new Contact(fields[0], fields[1], fields[2]));
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
