package com.tibo.vsn.services.api;

import com.tibo.vsn.model.Person;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Thibault on 12/17/13.
 */
public interface PersonService {
    void addPerson(Person person);
    Person getPersonById(long id);
    List<Person> findPersonsByName(String firstName, String lastName);
    List<Person> getPersons();
}
