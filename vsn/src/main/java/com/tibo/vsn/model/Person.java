package com.tibo.vsn.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Thibault on 12/18/13.
 */
@Entity
@DiscriminatorValue("PER")
public class Person extends Node {
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(long identifier) {
        super(identifier);
    }

    public Person(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
