import drawing.AwtDrawingApi;
import drawing.DrawingApi;
import drawing.JavaFxDrawingApi;
import graph.MatrixGraph;

public class Main {
    public static void main(String[] args) {
        DrawingApi drawingApi = getApi(args[0]);
        new MatrixGraph(drawingApi, null).drawGraph();
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
}
