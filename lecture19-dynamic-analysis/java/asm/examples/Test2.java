class Test2 {
  int x;
  
  public Test2(int n) {
    x = n;
  }
  
  public static void main(String[] args) {
    Test2 t1 = new Test2(Integer.parseInt(args[0]));
    Test2 t2 = new Test2(Integer.parseInt(args[1]));
    if(t1.x > t2.x) {
      System.out.println("===>" + t1.x);
    }
    else {
      System.out.println("===>" + t2.x);
    }
  }
}
