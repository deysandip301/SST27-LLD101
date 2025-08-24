public class Demo02 {
    public static void main(String[] args) {
        new Player(new UIDrawerImpl(), new FrameDecoderImpl(), new FrameCacheImpl()).play(new byte[]{1,2,3,4});
    }
}
