/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial10;

import java.util.ArrayList;

/**
 *
 * @author muham
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayGraph<String, Double> graph = new ArrayGraph<>(20);
        System.out.println("Creating a graph with 7 vertices and 7 edges");
        for (char i = 'A'; i < 'H'; i++) {
            graph.addVertice(i + "");
        }
        graph.addEdge("A", "B", 0.4);
        graph.addEdge("A", "C", 0.3);
        graph.addEdge("B", "C", 0.1);
        graph.addEdge("B", "D", 0.2);
        graph.addEdge("B", "E", 0.7);
        graph.addEdge("C", "F", 0.3);
        graph.addEdge("F", "G", 0.4);
        graph.showGraph();
        System.out.println("Remove edge from B to C");
        graph.deleteEdge("B", "C");
        graph.showGraph();
        System.out.println("The weightage from C to F: " + graph.getWeight("C", "F"));
        System.out.print("The adjacent of B : ");
        ArrayList a = graph.getAdjacent("B");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }
}
