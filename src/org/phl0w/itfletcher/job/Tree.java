package org.phl0w.itfletcher.job;

import org.phl0w.itfletcher.job.exception.ChangeException;
import org.phl0w.itfletcher.job.exception.TreeException;
import org.phl0w.itfletcher.job.state.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Tree {

    private List<Node> nodeList = Collections.synchronizedList(new LinkedList<Node>());
    private static final Logger log = Logger.getLogger("Tree");
    private static final boolean debug = false;

    public Tree(final Node... nodes) {
        try {
            if (nodes.length > 0) {
                Collections.addAll(nodeList, nodes);
            } else {
                throw new TreeException("Tree must contain at least 1 node!");
            }
        } catch (final TreeException te) {
            te.printStackTrace();
        }
    }

    public synchronized void addNode(final Node n) {
        if (n != null) {
            try {
                if (!nodeList.contains(n)) {
                    nodeList.add(n);
                } else {
                    throw new ChangeException("Node list already contains node: " + n.toString());
                }
            } catch (final ChangeException ce) {
                ce.printStackTrace();
            }
        }
    }

    public synchronized void removeNode(final Node n) {
        if (n != null) {
            try {
                if (nodeList.contains(n)) {
                    nodeList.remove(n);
                } else {
                    throw new ChangeException("Node list does not contain node: " + n.toString());
                }
            } catch (final ChangeException ce) {
                ce.printStackTrace();
            }
        }
    }

    public void run() {
        for (final Node n : nodeList) {
            if (n.activate()) {
                if (debug)
                    log.info("Executing " + n.toString());
                n.execute();
            }
        }
    }
}
