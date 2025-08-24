public interface IFrameCache {
    void cacheFrame(Frame frame);
    Frame getLastFrame();
    void checkLastFrame();
}
