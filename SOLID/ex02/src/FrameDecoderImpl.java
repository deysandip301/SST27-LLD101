public class FrameDecoderImpl implements IFrameDecoder {
    @Override
    public Frame decodeFrame(byte[] data) {
        return new Frame(data);
    }
}
