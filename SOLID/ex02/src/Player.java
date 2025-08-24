import java.util.UUID;

public class Player {
    private String playerName;
    private IUIDrawer uiDrawer;
    private IFrameDecoder frameDecoder;
    private IFrameCache frameCache;

    public Player(IUIDrawer uiDrawer, IFrameDecoder frameDecoder, IFrameCache frameCache) {
        this.uiDrawer = uiDrawer;
        this.frameDecoder = frameDecoder;
        this.frameCache = frameCache;
        this.playerName = UUID.randomUUID().toString();
    }

    void play(byte[] fileBytes){
        // decode
        Frame f = frameDecoder.decodeFrame(fileBytes);
        frameCache.cacheFrame(f);
        // draw UI
        uiDrawer.draw(playerName,fileBytes.length);
        // cache
        frameCache.checkLastFrame();
    }
}