package com.tibo.vsn.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Thibault on 12/18/13.
 */
@Entity
@DiscriminatorValue("FRI")
public class Friendship extends Edge {
    public Friendship() {
    }

    public Friendship(long identifier) {
        super(identifier);
    }

    public Person getInitialFriend() {
        return (Person)getInitialNode();
    }

    public Person getFinalFriend() {
        return (Person)getFinalNode();
    }
}
