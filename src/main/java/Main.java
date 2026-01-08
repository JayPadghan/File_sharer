import controller.FileController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        try {
            // Start the API server on port 8080
            FileController fileController = new FileController(8080);
            fileController.start();

            System.out.println("FileMesh server started on port 8080");
            System.out.println("UI available at http://localhost:3000");

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down server...");
                fileController.stop();
            }));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            new Thread(() -> {
                try {
                    while (true) {
                        String line = reader.readLine();
                        if ("exit".equalsIgnoreCase(line)) {
                            System.out.println("Stopping server...");
                            fileController.stop();
                            System.exit(0);
                        }
                    }
                } catch (IOException ignored) {}
            }).start();

        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
