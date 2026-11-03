package soal4;

/**
 * Produk langganan berbasis durasi waktu (subclass dari ProdukDigital).
 */
public class Langganan extends ProdukDigital {
    public static final int BATAS_BULAN_DISKON = 12;
    public static final double DISKON_LANGGANAN = 0.20; // 20%
    private int durasiBulan;

    public Langganan(String kode, String nama, double hargaDasar, double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);
        this.durasiBulan = durasiBulan;
    }

    @Override
    public double hitungHargaAkhir() {
        double totalTanpaDiskon = hargaDasar * durasiBulan;
        if (durasiBulan >= BATAS_BULAN_DISKON) {
            return totalTanpaDiskon - (totalTanpaDiskon * DISKON_LANGGANAN);
        }
        return totalTanpaDiskon;
    }

    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }

    public int getDurasiBulan() {
        return durasiBulan;
    }
}