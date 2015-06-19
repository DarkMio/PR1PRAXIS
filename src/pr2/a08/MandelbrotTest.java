package pr2.a08;

public class MandelbrotTest {

    public static void main(String[] args) {
        MandelbrotModel mm = new MandelbrotModel(-2.0, -1.3, 800, 600, 100);
        MandelbrotView mv = new MandelbrotView(mm);
        for(int i = 0; i < 100; i++) {
            mm.zoomEvent(200.396307, 299.1376010225);
            System.out.println("Tried to zoom");
        }
    }
}
