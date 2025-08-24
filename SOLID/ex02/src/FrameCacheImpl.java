public class FrameCacheImpl implements IFrameCache {
    private Frame lastFrame;

    @Override
    public void cacheFrame(Frame frame) {
        this.lastFrame = frame;
    }

    @Override
    public Frame getLastFrame() {
        return lastFrame;
    }

    public void checkLastFrame() {
        System.out.println("Cached last frame? " + (lastFrame != null));
    }
}
