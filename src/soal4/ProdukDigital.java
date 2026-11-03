package soal4;

/**
 * Produk digital dengan diskon khusus digital.
 */
public class ProdukDigital extends Produk {
    public static final double DISKON_DIGITAL = 0.10; // 10%
    protected double ukuranMb;

    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);
        this.ukuranMb = ukuranMb;
    }

    @Override
    public double hitungHargaAkhir() {
        return hargaDasar - (hargaDasar * DISKON_DIGITAL);
    }

    @Override
    public String deskripsi() {
        return "digital " + ukuranMb + " MB";
    }

    public double getUkuranMb() {
        return ukuranMb;
    }
}