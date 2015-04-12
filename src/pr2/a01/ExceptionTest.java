package pr2.a01;


public class ExceptionTest {

    public static void main(String[] args) {
        for (int n = 1; n <= 3; n++) {
            try {
                met01(n);
            } catch (Exa exa) {
                System.err.println("R ex:A");
            } finally {
                System.err.println("S ----");
            }
        }
    }

    private static void met01(int n) throws Exa {
        try {
            met02(n);
            System.err.println("T ----");
        } catch (Exc exc) {
            System.err.println("U ex:C");
        } catch (Exb exb) {
            System.err.println("V ex:B");
        }
    }

    protected static void met02(int n) throws Exa {
        try {
            switch(n){
                case 1:
                    throw new Exa();
                case 2:
                    throw new Exb();
                case 3:
                    throw new Exc();
            }
        } catch (Exc exc) {
            System.err.println("W ex:C");
            throw exc;
        }
    }
}
