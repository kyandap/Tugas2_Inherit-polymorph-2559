package soal1;

/**
 * Merepresentasikan perangkat ponsel yang mewarisi kelas Perangkat.
 */
public class Ponsel extends Perangkat {
    private int kapasitasGb;
    private int jumlahKamera;

    /**
     * Constructor untuk Ponsel.
     * 
     * @param merek        merek ponsel
     * @param harga        harga ponsel
     * @param garansiBulan masa garansi
     * @param kapasitasGb  kapasitas penyimpanan dalam GB
     * @param jumlahKamera jumlah kamera
     */
    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}