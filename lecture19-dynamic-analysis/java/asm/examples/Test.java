class Test {
  static int x;
  int k;
  
  // constructor with 2 args
  public Test( int n, int m ) {
    x = n;
    k = m;
  }
  
  public static void main(String[] args) {
    Test t1 = new Test(10, 20);
    Test t2 = new Test(30, 40);
    System.out.print(t1.x + " ");
    System.out.print(t1.k + " ");
    System.out.print(t2.x + " ");
    System.out.println(t2.k);
  }
}
