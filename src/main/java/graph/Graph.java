package graph;

import drawing.DrawingApi;

public abstract class Graph {
    protected final DrawingApi drawingApi;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
    }

    public abstract void drawGraph();
}
