package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;
import org.graphstream.graph.Graph;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BFSExample {

    static List<UserNode> users;


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bfsExampleUnit");
        EntityManager em = emf.createEntityManager();

        em.clear();
        populateDB(em);
        int graphV = users.size();
        String sourceNode = Long.toString(users.get(3).getId());
        String destinationNode = Long.toString(users.get(20).getId());
        Graph currentGraph = GraphPlotter.plot(users);
        System.out.println(shortestPathLength(currentGraph, sourceNode, destinationNode, graphV));
    }


    public static void populateDB(EntityManager em) {

        RandomDataGenerator generator = new RandomDataGenerator();
        users = generator.generate();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (UserNode user : users) {
            em.persist(user);
        }
        transaction.commit();
    }


    public static int shortestPathLength(Graph graph, String source, String destination, int V) {
        graph.
    }
}
