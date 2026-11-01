package soal2;

/**
 * Kelas A untuk analisis constructor dan method overriding.
 */
public class A {
    public A() {
        System.out.println("A dibuat");
        init();
    }

    public void init() {
        System.out.println("init A");
    }
}