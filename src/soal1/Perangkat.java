package soal1;

/**
 * Merepresentasikan perangkat elektronik dasar dengan merek, harga, dan masa garansi.
 */
public class Perangkat {
    private String merek;
    protected double harga;
    private int garansiBulan;
    
    public static final double TARIF_PAJAK = 0.10;

    /**
     * Constructor untuk inisialisasi Perangkat.
     * 
     * @param merek        merek perangkat (tidak boleh kosong)
     * @param harga        harga perangkat (harus positif)
     * @param garansiBulan masa garansi dalam bulan
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */
    public Perangkat(String merek, double harga, int garansiBulan) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong.");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    /**
     * Mengembalikan merek perangkat.
     * @return merek
     */
    public String getMerek() {
        return merek;
    }

    /**
     * Mengembalikan masa garansi perangkat.
     * @return garansi dalam bulan
     */
    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Menghitung pajak perangkat berdasarkan tarif pajak.
     * @return nilai pajak
     */
    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    /**
     * Menghasilkan informasi singkat perangkat.
     * @return string informasi singkat
     */
    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}