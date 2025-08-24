public class UIDrawerImpl implements IUIDrawer {
    @Override
    public void draw(String playerName, int byteLength) {
        System.out.println(playerName + " is playing " + byteLength + " bytes");
    }
    
}
