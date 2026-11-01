# Tugas 2 Praktikum Pemrograman Berorientasi Objek

## Identitas Mahasiswa

| Keterangan | Informasi |
|---|---|
| Nama Lengkap | Kyandaru Annisa Putri |
| NPM | 250810701100059 |
| Mata Kuliah | Praktikum Pemrograman Berorientasi Objek A |
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

### Jawaban Soal dan Analisis Konsep

#### Soal 1 – Pertanyaan Tambahan

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
### Soal 2: Analisis Output, Error, dan Polimorfisme

#### A. Polimorfisme, Upcasting, Downcasting, dan `instanceof`

**1. Output Lengkap Program**

```text
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
h2 bukan objek Kucing, downcasting dilewati!
```

**2. Jika Komentar pada Baris `h.panjat();` Dihapus**

- **Jenis Error:** Terjadi *compile-time error* (error saat kompilasi).
- **Penyebab:** Variabel `h` dideklarasikan dengan tipe statis `Hewan`. Meskipun objek aslinya adalah `Kucing`, compiler hanya mengenali method yang tersedia pada kelas `Hewan`. Karena kelas `Hewan` tidak memiliki method `panjat()`, pemanggilan tersebut menyebabkan error saat kompilasi.

**3. Baris Penyebab `ClassCastException` dan Perbaikannya**

- **Baris penyebab:**

  ```java
  Kucing k2 = (Kucing) h2;
  ```

- **Penyebab:** Variabel `h2` merupakan objek `Hewan` yang dibuat menggunakan `new Hewan("Generik")`, bukan objek `Kucing`. Oleh karena itu, proses downcasting secara langsung akan menyebabkan `ClassCastException`.

- **Perbaikan menggunakan `instanceof`:**

  ```java
  if (h2 instanceof Kucing) {
      Kucing k2 = (Kucing) h2;
      k2.panjat();
  } else {
      System.out.println("h2 bukan objek Kucing, downcasting dilewati!");
  }
  ```

  Operator `instanceof` digunakan untuk memeriksa tipe objek sebelum melakukan downcasting sehingga kesalahan konversi tipe dapat dihindari.

**4. Method `suara()` Mana yang Dijalankan pada `h.makan()`?**

Method `suara()` milik kelas **`Kucing`** yang dijalankan.

**Penjelasan:** Variabel `h` memiliki tipe statis `Hewan`, tetapi tipe dinamisnya adalah `Kucing` karena diinisialisasi menggunakan `new Kucing("Tom")`. Melalui mekanisme *dynamic method dispatch*, Java akan menjalankan method yang telah di-*override* sesuai dengan tipe objek sebenarnya saat runtime. Oleh karena itu, method `suara()` milik kelas `Kucing` yang dipanggil.

---

#### B. Constructor dan Urutan Eksekusi (`new B()`)

**5. Prediksi Output dan Analisis**

**Output:**

```text
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

**Mengapa nilai pada `init B` bukan 5?**

Ketika objek `B` dibuat menggunakan `new B()`, constructor kelas `A` dijalankan terlebih dahulu melalui pemanggilan `super()`. Di dalam constructor `A`, method `init()` dipanggil.

Karena menerapkan polimorfisme, method `init()` milik kelas `B` yang dieksekusi. Namun, pada tahap tersebut, atribut `nilai` milik kelas `B` belum diinisialisasi sehingga masih memiliki nilai default `0`.

Setelah proses constructor superclass selesai, inisialisasi atribut dan constructor kelas `B` dilanjutkan sehingga nilai `nilai` menjadi `5`.

**Risiko Memanggil Method yang Dapat Di-Override dari Constructor**

Memanggil method yang dapat di-*override* dari dalam constructor berisiko karena method milik subclass bisa dijalankan sebelum proses inisialisasi subclass selesai. Akibatnya, method tersebut dapat mengakses atribut yang masih memiliki nilai default seperti `0` atau `null`, sehingga berpotensi menimbulkan *bug* yang sulit dideteksi.

---

#### C. Relasi *Is-A* dan Inkonsistensi Hierarki

**6. Analisis Output `l3.luas()` dan Prinsip OOP**

**Mengapa `l3.luas()` menghasilkan `0.0`?**

Hasil `0.0` muncul karena mekanisme *dynamic method dispatch*. Variabel `l3` bertipe `Lingkaran`, tetapi merujuk pada objek `Titik` yang meng-*override* method `luas()` sehingga menghasilkan nilai `0.0`.

**Apakah hubungan "Titik adalah sebuah Lingkaran" masuk akal?**

Secara konseptual matematis, hubungan tersebut tidak tepat dan berpotensi melanggar **Liskov Substitution Principle (LSP)**. Hal ini karena titik tidak memiliki jari-jari maupun luas seperti lingkaran pada umumnya, sehingga tidak dapat sepenuhnya menggantikan perilaku objek `Lingkaran`.

**Konsekuensi dari Inkonsistensi Hierarki**

Method atau sistem lain yang mengharapkan objek `Lingkaran` memiliki luas lebih dari nol dapat mengalami kesalahan logika ketika menerima objek `Titik`. Contohnya, operasi pembagian dengan luas dapat menyebabkan pembagian dengan nol (*division by zero*).