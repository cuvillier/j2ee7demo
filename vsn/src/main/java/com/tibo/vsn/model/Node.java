package com.tibo.vsn.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Thibault on 12/17/13.
 */
@Entity
@DiscriminatorColumn(
        name="clazz",
        discriminatorType= DiscriminatorType.STRING
)
public class Node extends BaseEntity {

    @OneToMany(mappedBy = "initialNode", fetch = FetchType.LAZY)
    private List<Edge> outgoingEdges = new ArrayList();

    @OneToMany(mappedBy = "finalNode", fetch = FetchType.LAZY)
    private List<Edge> incomingEdges = new ArrayList();

    public Node() {
    }

    public Node(long identifier) {
        super(identifier);
    }

    public List<Edge> getOutgoingEdges() {
        return Collections.unmodifiableList(outgoingEdges);
    }

    public List<Edge> getIncomingEdges() {
        return Collections.unmodifiableList(incomingEdges);
    }
}
