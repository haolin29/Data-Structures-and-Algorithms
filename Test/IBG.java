package Test;

/**
 * Created by Haolin on 2016/11/16.
 */

class A {
    public A() {
        getid();
    }

    public void getid() {
        System.out.println(height);
    }

    public int height;
}

class B extends A {
    public B() {
        getid();
    }

    int height = 11;

    public void getid() {
        System.out.println(width);
    }

    private int width = 6;
}

public class IBG {
    public static void main(String[] args) {
        B test  = new B();
    }
}
