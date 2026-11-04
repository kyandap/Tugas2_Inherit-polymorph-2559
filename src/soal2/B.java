package soal2;

/**
 * Kelas B yang mewarisi kelas A.
 */
public class B extends A {
    int nilai = 5;

    public B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    @Override
    public void init() {
        System.out.println("init B, nilai=" + nilai);
    }
    
    public static void main(String[] args) {
    new B();
    }
}