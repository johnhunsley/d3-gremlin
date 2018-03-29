package com.johnhunsley.graph.repo;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     Executes Graph Traversal Queries on a provided {@link GraphTraversalSource} to return  {@link GraphTraversal}
 *     instances which can be iterated
 * </p>
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 21/03/2018
 */
@Component
public class GremlinRepository {

    @Autowired
    private GraphTraversalSource g;


    public GraphTraversal getAllNodes() {
        return  g.V();
    }

    public GraphTraversal getAllEdges() {
        return g.E();
    }

    /**
     * <p>
     *      g.V().has("desc","nodeName").bothE()
     * </p>
     * @param nodeName
     * @return
     */
    public GraphTraversal getLevelOneRelationships(String nodeName) {
        return g.V().has("desc", nodeName).bothE();
    }
}
