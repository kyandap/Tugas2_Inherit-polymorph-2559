package soal1;

/**
 * Merepresentasikan perangkat laptop yang mewarisi kelas Perangkat.
 */
public class Laptop extends Perangkat {
    private int ramGb;
    private double ukuranLayarInci;

    /**
     * Constructor untuk Laptop.
     * 
     * @param merek           merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    masa garansi
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam inci
     */
    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga promo setelah diskon persen.
     * Memanfaatkan akses protected ke atribut harga secara langsung.
     * 
     * @param diskonPersen besar diskon dalam bentuk persen (misal: 10 untuk 10%)
     * @return harga setelah diskon
     */
    public double hitungHargaPromo(double diskonPersen) {
        return harga - (harga * (diskonPersen / 100.0));
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}