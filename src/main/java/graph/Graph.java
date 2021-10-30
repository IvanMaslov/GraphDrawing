package graph;

import drawing.DrawingApi;

public abstract class Graph {
    protected final DrawingApi drawingApi;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
    }

    public abstract void drawGraph();

    public abstract void readGraph();

    public abstract int size();

    private long getCircleXPos(long width, long height, int v) {
        long r = Math.min(width, height) / 4;
        long wC = width / 2;
        double angle = 2 * Math.PI * v / size();
        return wC + (long) (r * Math.cos(angle));
    }

    private long getCircleYPos(long width, long height, int v) {
        long r = Math.min(width, height) / 4;
        long hC = height / 2;
        double angle = 2 * Math.PI * v / size();
        return hC + (long) (r * Math.sin(angle));
    }

    protected void drawCircles() {
        long width = drawingApi.getDrawingAreaWidth();
        long height = drawingApi.getDrawingAreaHeight();
        long circleRadius = Math.min(width, height) / (8L * size());
        for (int i = 0; i < size(); ++i) {
            drawingApi.drawCircle(
                    getCircleXPos(width, height, i),
                    getCircleYPos(width, height, i),
                    circleRadius);
        }
    }

    protected void drawEdge(int v, int u) {
        long width = drawingApi.getDrawingAreaWidth();
        long height = drawingApi.getDrawingAreaHeight();
        drawingApi.drawLine(getCircleXPos(width, height, v),
                getCircleYPos(width, height, v),
                getCircleXPos(width, height, u),
                getCircleYPos(width, height, u));
    }
}
