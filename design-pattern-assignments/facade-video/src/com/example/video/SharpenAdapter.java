package com.example.video;

// Adapter for LegacySharpen
public class SharpenAdapter {
    private final LegacySharpen legacy;
    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = legacy;
    }
    // Simulate conversion: Frame[] -> handle string -> Frame[]
    public Frame[] sharpen(Frame[] frames, int strength) {
        String handle = framesToHandle(frames);
        String newHandle = legacy.applySharpen(handle, strength);
        return handleToFrames(newHandle, frames);
    }
    private String framesToHandle(Frame[] frames) {
        return "HANDLE:" + frames.length;
    }
    private Frame[] handleToFrames(String handle, Frame[] orig) {
        // For demo, just return the original frames (no real sharpening)
        return orig;
    }
}