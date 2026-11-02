package soal3;

/**
 * Merepresentasikan garis yang dibentuk oleh dua objek Titik (awal dan akhir).
 */
public class Garis {
    private Titik awal;
    private Titik akhir;

    // Constructor 1: Menerima objek Titik
    public Garis(Titik awal, Titik akhir) {
        this.awal = awal;
        this.akhir = akhir;
    }

    // Constructor 2: Constructor Overloading menggunakan this(...)
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    // Getter dan Setter
    public Titik getAwal() {
        return awal;
    }

    public void setAwal(Titik awal) {
        this.awal = awal;
    }

    public Titik getAkhir() {
        return akhir;
    }

    public void setAkhir(Titik akhir) {
        this.akhir = akhir;
    }

    /**
     * Menghitung panjang garis menggunakan method jarakKe() milik Titik.
     */
    public double getPanjang() {
        if (awal == null || akhir == null) return 0.0;
        return awal.jarakKe(akhir);
    }

    @Override
    public String toString() {
        return awal + " - " + akhir;
    }
}