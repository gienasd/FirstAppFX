package pl.pawelprzystarz.testproject.Models.dao.impl;

import pl.pawelprzystarz.testproject.Models.MySqlConnector;
import pl.pawelprzystarz.testproject.Models.dao.ContactDao;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    private MySqlConnector connector = MySqlConnector.getInstance();

    // Uzupełnij zapytania SQL

    @Override
    public List<String> getAllContactsNames(String username) {
        return null;
    }

    @Override
    public String getNumber(String contact) {
        return null;
    }

    @Override
    public boolean addContact(String name, String number) {
        return false;
    }

    @Override
    public void removeContact(String name) {

    }

    @Override
    public boolean editContact(String name, String number) {
        return false;
    }
}
