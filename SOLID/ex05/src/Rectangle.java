public class Rectangle{
    protected int w,h;
    void setWidth(int w){ this.w = w; }
    void setHeight(int h){ this.h = h; }
    int area(){ return w*h; }

    public int areaAfterResize() {
        setWidth(5);
        setHeight(4);
        return area();
    }
}