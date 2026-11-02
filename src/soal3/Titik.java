package soal3;

/**
 * Merepresentasikan titik koordinat (x, y) dalam ruang 2D.
 */
public class Titik {
    private double x;
    private double y;

    // Constructor kosong (default 0,0)
    public Titik() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Constructor dengan parameter x dan y
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter dan Setter
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Menghitung jarak antara titik ini dengan titik lain.
     */
    public double jarakKe(Titik lain) {
        if (lain == null) return 0.0;
        double dx = this.x - lain.x;
        double dy = this.y - lain.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}