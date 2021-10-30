package graph;

import drawing.DrawingApi;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListGraph extends Graph {
    private final List<Pair<Integer, Integer>> edges = new ArrayList<>();
    private int vertex = 0;

    public ListGraph(DrawingApi drawingApi) {
        super(drawingApi);
    }

    @Override
    public int size() {
        return vertex;
    }

    @Override
    public void drawGraph() {
        drawCircles();
        for (Pair<Integer, Integer> e : edges) {
            drawEdge(e.getValue() - 1, e.getKey() - 1);
        }
    }

    @Override
    public void readGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vertex:");
        vertex = scanner.nextInt();
        System.out.println("Edge number:");
        int m = scanner.nextInt();
        System.out.println("" + m + " edges:");
        for (int i = 0; i < m; ++i) {
            int v = scanner.nextInt(), u = scanner.nextInt();
            edges.add(new Pair<>(v, u));
        }
    }
}
