public class TestReturn {
    public static int testReturn(){
        int i=0;
        return i++;
    }
    public static void main(String[] args) {
        System.out.println(testReturn());
    }
}
