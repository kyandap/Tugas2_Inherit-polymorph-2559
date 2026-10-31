# Tugas 2 Praktikum Pemrograman Berorientasi Objek

- **Nama Lengkap:** Kyandaru Annisa Putri
- **NPM:** 250810701100059
- **Kelas:** A
- **Tautan Repository:** https://github.com/kyandap/Tugas2_Inherit-polymorph-2559

---

## Deskripsi Singkat
Repository ini berisi penyelesaian Tugas 2 Praktikum Pemrograman Berorientasi Objek. Tugas ini melatih penerapan konsep Inheritance, Composition, Polimorfisme, serta penanganan Exception di dalam bahasa pemrograman Java.

---

## Struktur Project
Tugas2_Inherit-polymorph-2559/
├── src/
│   └── soal1/
│       ├── Perangkat.java
│       ├── Laptop.java
│       ├── Ponsel.java
│       ├── LaptopGaming.java
│       └── TesSoal1.java
├── .gitignore
└── README.md

---

## Prasyarat & Cara Menjalankan Program (Soal 1)

### Prasyarat
- Java Development Kit (JDK) versi 8 atau yang lebih baru.
- Terminal / Command Prompt atau IDE seperti IntelliJ IDEA / VS Code.

### Cara Menjalankan (Command Line)
1. Buka terminal, lalu masuk ke folder src:
   cd src
2. Kompilasi file uji Soal 1:
   javac soal1/TesSoal1.java
3. Jalankan program:
   java soal1.TesSoal1

---

## Jawaban Soal dan Analisis Konsep

### Soal 1: Pertanyaan Tambahan
- **Pertanyaan:** Ubah harga menjadi private lalu kompilasi. Salin pesan error yang muncul dan jelaskan mengapa error tersebut muncul.

- **Pesan Error:**
  soal1\Laptop.java:33: error: harga has private access in Perangkat
          return harga - (harga * (diskonPersen / 100.0));
                 ^
  soal1\Laptop.java:33: error: harga has private access in Perangkat
          return harga - (harga * (diskonPersen / 100.0));
                                ^
  2 errors

- **Penjelasan:**
  Error tersebut muncul karena hak akses private membatasi akses suatu atribut agar hanya bisa diakses di dalam kelas tempat atribut itu didefinisikan saja (Perangkat). Ketika kelas turunan (Laptop) mencoba mengakses atribut harga secara langsung di dalam method hitungHargaPromo(), Java menolaknya karena Laptop berada di luar cakupan kelas Perangkat. Oleh karena itu, agar kelas turunan dapat mengakses atribut dari superclass secara langsung, digunakan hak akses protected.

---
*Dokumen ini akan terus diperbarui seiring pengerjaan soal-soal berikutnya.*