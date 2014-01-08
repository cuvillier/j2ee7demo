package com.tibo.vsn.model;

import javax.persistence.*;

/**
 * Created by Thibault on 12/17/13.
 */
@Entity
@DiscriminatorColumn(
        name="clazz",
        discriminatorType= DiscriminatorType.STRING
)
public abstract class Edge extends BaseEntity {

    private long timestamp;

    @ManyToOne(fetch= FetchType.LAZY)
    private Node initialNode;

    @ManyToOne(fetch= FetchType.LAZY)
    private Node finalNode;

    public Edge() {

    }

    public Edge(long identifier) {
        super(identifier);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Node getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(Node friend) {
        this.initialNode = friend;
    }

    public Node getFinalNode() {
        return finalNode;
    }

    public void setFinalNode(Node owner) {
        this.finalNode = owner;
    }
}
