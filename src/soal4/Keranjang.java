package soal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Menyimpan daftar produk di dalam keranjang belanja.
 */
public class Keranjang {
    private List<Produk> daftarProduk;

    public Keranjang() {
        this.daftarProduk = new ArrayList<>();
    }

    /**
     * Menambahkan produk ke keranjang dengan validasi duplikasi kode.
     */
    public void tambah(Produk produk) {
        // Cek apakah kode produk sudah ada di keranjang
        for (Produk p : daftarProduk) {
            if (p.getKode().equalsIgnoreCase(produk.getKode())) {
                throw new IllegalStateException("Produk dengan kode " + produk.getKode() + " sudah ada di keranjang.");
            }
        }
        daftarProduk.add(produk);
    }

    /**
     * Menghitung total harga seluruh produk menggunakan polimorfisme (tanpa instanceof).
     */
    public double hitungTotal() {
        double total = 0;
        for (Produk p : daftarProduk) {
            total += p.hitungHargaAkhir();
        }
        return total;
    }

    /**
     * Mencetak struk belanja dengan format yang ditentukan.
     */
    public void cetakStruk() {
        for (Produk p : daftarProduk) {
            System.out.printf("%s | %s | %s | Rp%.0f%n", 
                p.getKode(), 
                p.getNama(), 
                p.deskripsi(), 
                p.hitungHargaAkhir());
        }
        System.out.printf("TOTAL: Rp%.0f%n", hitungTotal());
    }

    /**
     * Menghitung jumlah produk per jenis menggunakan instanceof (dengan urutan yang benar).
     */
    public void hitungPerJenis() {
        int jumlahFisik = 0;
        int jumlahDigital = 0;
        int jumlahLangganan = 0;

        for (Produk p : daftarProduk) {
            // Perhatian: Langganan adalah turunan ProdukDigital, 
            // maka pengecekan Langganan harus didahulukan daripada ProdukDigital!
            if (p instanceof Langganan) {
                jumlahLangganan++;
            } else if (p instanceof ProdukDigital) {
                jumlahDigital++;
            } else if (p instanceof ProdukFisik) {
                jumlahFisik++;
            }
        }

        System.out.printf("Fisik: %d, Digital: %d, Langganan: %d%n", 
            jumlahFisik, jumlahDigital, jumlahLangganan);
    }
}