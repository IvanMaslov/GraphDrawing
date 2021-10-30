import drawing.AwtDrawingApi;
import drawing.DrawingApi;
import drawing.JavaFxDrawingApi;
import graph.Graph;
import graph.ListGraph;
import graph.MatrixGraph;

public class Main {
    public static void main(String[] args) {
        if (args == null || args.length != 2 || args[0] == null || args[1] == null) {
            System.err.println("awt|fx matrix|list");
            return;
        }
        DrawingApi drawingApi = getApi(args[0]);
        Graph graph = getGraph(args[1], drawingApi);
        graph.readGraph();
        graph.drawGraph();
        if (drawingApi instanceof JavaFxDrawingApi) {
            JavaFxDrawingApi.run();
        }
    }

    private static DrawingApi getApi(String api) {
        if ("awt".equals(api)) {
            return new AwtDrawingApi();
        }
        if ("fx".equals(api)) {
            return new JavaFxDrawingApi();
        }
        throw new RuntimeException("Unrecognized drawing api type " + api);
    }

    private static Graph getGraph(String graph, DrawingApi api) {
        if ("matrix".equals(graph)) {
            return new MatrixGraph(api);
        }
        if ("list".equals(graph)) {
            return new ListGraph(api);
        }
        throw new RuntimeException("Unrecognized drawing api type " + api);
    }
}
