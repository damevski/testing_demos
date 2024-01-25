public class Calculator {

    public int divide(int x, int y)
    {
        return x / y;
    }

    public static void main(String [] args) {
        Calculator c = new Calculator();
        System.out.println("Hello " + c.divide(6,5));
    }

}
