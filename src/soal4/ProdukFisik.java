package soal4;

/**
 * Produk berwujud fisik dengan tambahan ongkos kirim.
 */
public class ProdukFisik extends Produk {
    public static final double ONGKIR_PER_KG = 10000.0;
    private double beratKg;

    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        this.beratKg = beratKg;
    }

    @Override
    public double hitungHargaAkhir() {
        return hargaDasar + (beratKg * ONGKIR_PER_KG);
    }

    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }

    public double getBeratKg() {
        return beratKg;
    }
}