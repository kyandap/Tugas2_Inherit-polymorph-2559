# Tugas 2 Praktikum Pemrograman Berorientasi Objek

## Identitas Mahasiswa

| Keterangan | Informasi |
|---|---|
| Nama Lengkap | Kyandaru Annisa Putri |
| NPM | 250810701100059 |
| Kelas | A |
| Repository | [Tugas2_Inherit-polymorph-2559](https://github.com/kyandap/Tugas2_Inherit-polymorph-2559) |

## Deskripsi

Repository ini berisi penyelesaian **Tugas 2 Praktikum Pemrograman Berorientasi Objek**. Tugas ini bertujuan untuk memahami dan menerapkan beberapa konsep dasar OOP menggunakan bahasa pemrograman Java, yaitu:

- Inheritance (Pewarisan)
- Composition (Komposisi)
- Polymorphism (Polimorfisme)
- Exception Handling (Penanganan Eksepsi)

## Struktur Project

```text
Tugas2_Inherit-polymorph-2559/
│
├── src/
│   └── soal1/
│       ├── Perangkat.java
│       ├── Laptop.java
│       ├── Ponsel.java
│       ├── LaptopGaming.java
│       └── TesSoal1.java
│
├── .gitignore
└── README.md
```

## Prasyarat

Sebelum menjalankan program, pastikan perangkat sudah memiliki:

- Java Development Kit (JDK) versi 8 atau lebih baru.
- Terminal / Command Prompt atau IDE seperti IntelliJ IDEA dan Visual Studio Code.

## Cara Menjalankan Program (Soal 1)

Program dapat dijalankan melalui terminal dengan langkah-langkah berikut.

**1. Masuk ke direktori `src`:**

```bash
cd src
```

**2. Kompilasi file pengujian:**

```bash
javac soal1/TesSoal1.java
```

**3. Jalankan program:**

```bash
java soal1.TesSoal1
```

## Jawaban Soal dan Analisis Konsep

### Soal 1 – Pertanyaan Tambahan

**Pertanyaan:**

Ubah atribut `harga` menjadi `private`, kemudian lakukan kompilasi. Salin pesan error yang muncul dan jelaskan mengapa error tersebut terjadi.

**Pesan Error:**

```text
soal1/Laptop.java:33: error: harga has private access in Perangkat
        return harga - (harga * (diskonPersen / 100.0));
               ^
soal1/Laptop.java:33: error: harga has private access in Perangkat
        return harga - (harga * (diskonPersen / 100.0));
                        ^
2 errors
```

**Penjelasan:**

Error tersebut terjadi karena modifier `private` membatasi akses atribut sehingga hanya dapat diakses secara langsung dari dalam kelas tempat atribut tersebut dideklarasikan, yaitu kelas `Perangkat`.

Ketika kelas turunan `Laptop` mencoba mengakses atribut `harga` secara langsung melalui method `hitungHargaPromo()`, Java menolak akses tersebut karena atribut `private` tidak diwariskan sebagai anggota yang dapat diakses langsung oleh subclass.

Untuk mengatasi hal tersebut, modifier `protected` dapat digunakan agar atribut `harga` bisa diakses oleh kelas turunannya, seperti `Laptop`.

---
