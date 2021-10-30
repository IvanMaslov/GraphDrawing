package graph;

import drawing.DrawingApi;

import java.util.List;

public class MatrixGraph extends Graph {
    public MatrixGraph(DrawingApi drawingApi, List<List<Boolean>> matrix) {
        super(drawingApi);
    }

    @Override
    public void drawGraph() {
        drawingApi.drawCircle(100, 100, 1);
        drawingApi.drawCircle(300, 300, 1);
        drawingApi.drawLine(100 , 100, 300, 300);
    }
}
