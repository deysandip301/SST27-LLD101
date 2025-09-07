package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        // Use only the facade
        VideoPipeLineFacade facade = new VideoPipeLineFacade();
        Path out = facade.process(Path.of("in.mp4"), Path.of("out.mp4"), true, 0.5, null);
        System.out.println("Wrote " + out);
    }
}
