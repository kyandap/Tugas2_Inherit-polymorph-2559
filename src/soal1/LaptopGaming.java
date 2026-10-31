package soal1;

/**
 * Merepresentasikan laptop gaming yang mewarisi kelas Laptop dengan tambahan kartu grafis.
 */
public class LaptopGaming extends Laptop {
    public static final int TAMBAHAN_GARANSI_BULAN = 6;
    
    private String kartuGrafis;

    /**
     * Constructor untuk LaptopGaming.
     * Menambahkan 6 bulan ke masa garansi melalui pemanggilan super.
     * 
     * @param merek           merek laptop gaming
     * @param harga           harga laptop gaming
     * @param garansiBulan    masa garansi dasar
     * @param ramGb           kapasitas RAM
     * @param ukuranLayarInci ukuran layar
     * @param kartuGrafis     jenis kartu grafis (GPU)
     */
    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci, String kartuGrafis) {
        super(merek, harga, garansiBulan + TAMBAHAN_GARANSI_BULAN, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}