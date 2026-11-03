package soal4;

/**
 * Superclass merepresentasikan produk umum di toko digital.
 */
public abstract class Produk {
    protected String kode;
    protected String nama;
    protected double hargaDasar;

    public Produk(String kode, String nama, double hargaDasar) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif.");
        }
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    // Method abstrak yang wajib di-override oleh subclass
    public abstract double hitungHargaAkhir();
    public abstract String deskripsi();
}