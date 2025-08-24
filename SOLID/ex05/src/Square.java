
public class Square extends Rectangle{
    @Override void setWidth(int w){ this.w = this.h = w; }
    @Override void setHeight(int h){ this.w = this.h = h; }

    @Override
    public int areaAfterResize() {
        setWidth(4);
        return area();
    }
}