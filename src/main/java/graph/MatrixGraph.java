package graph;

import drawing.DrawingApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixGraph extends Graph {
    private final List<List<Boolean>> matrix = new ArrayList<>();

    public MatrixGraph(DrawingApi drawingApi) {
        super(drawingApi);
    }

    @Override
    public int size() {
        return matrix.size();
    }

    @Override
    public void drawGraph() {
    }

    @Override
    public void readGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vertex:");
        int n = scanner.nextInt();
        System.out.println("Matrix:");
        for (int i = 0; i < n; ++i) {
            List<Boolean> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                int x = scanner.nextInt();
                if (x == 1) {
                    row.add(true);
                } else {
                    row.add(false);
                }
            }
            matrix.add(row);
        }
    }
}
