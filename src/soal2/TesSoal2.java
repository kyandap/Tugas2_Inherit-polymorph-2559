package soal2;

/**
 * Kelas uji untuk Bagian A Soal 2.
 */
public class TesSoal2 {
    public static void main(String[] args) {
        Hewan h = new Kucing("Tom");
        h.makan();
        h.suara();
        // h.panjat(); // Komentar ini nanti diuji pada pertanyaan nomor 2
        
        Kucing k = (Kucing) h;
        k.panjat();

        Hewan h2 = new Hewan("Generik");
        
        // Pertanyaan 3: Perbaikan dengan instanceof agar aman dari ClassCastException
        if (h2 instanceof Kucing) {
            Kucing k2 = (Kucing) h2;
            k2.panjat();
        } else {
            System.out.println("h2 bukan objek Kucing, downcasting dilewati!");
        }
    }
}