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
│   └── soal2/
│       ├── Hewan.java
│       ├── Kucing.java
│       ├── Lingkaran.java
│       ├── A.java
│       ├── B.java
│       ├── Titik.java
│       ├── TesBagianC.java
│       └── TesSoal2.java
│   └── soal3/
│       ├── Titik.java
│       ├── Garis.java
│       └── TesSoal3.java
│   └── soal4/
│       ├── Produk.java
│       ├── ProdukFisik.java
│       ├── ProdukDigital.java
│       ├── Langganan.java
│       ├── Keranjang.java
│       └── TesSoal4.java
│
├── .gitignore
└── README.md
```

## Prasyarat

Sebelum menjalankan program, pastikan perangkat sudah memiliki:

- Java Development Kit (JDK) versi 8 atau lebih baru.
- Terminal / Command Prompt atau IDE seperti IntelliJ IDEA dan Visual Studio Code.

## Cara Menjalankan Program serta Jawaban Soal dan Analisis Konsep

### Soal 1: Hierarki Perangkat Elektronik

Kompilasi dan jalankan program menggunakan perintah berikut:

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
[Output Soal 1](img/Soal1.png)

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

Soal 2 terdiri dari tiga bagian pengujian, yaitu Bagian A, B, dan C. Setiap bagian dapat dikompilasi dan dijalankan melalui terminal dengan langkah-langkah berikut.

**1. Masuk ke Direktori `src`**

Buka terminal atau Command Prompt, kemudian masuk ke folder `src`:

```bash
cd src
```

**2. Menjalankan Bagian A (`TesSoal2`)**

Kompilasi dan jalankan program menggunakan perintah berikut:

```bash
javac soal2/TesSoal2.java
java soal2.TesSoal2
```

**3. Menjalankan Bagian B (Pengujian Kelas `A` dan `B`)**

Untuk menguji urutan eksekusi constructor, buat file `TesBagianB.java` yang berisi pemanggilan objek `B` menggunakan `new B();`.

Kemudian, kompilasi dan jalankan dengan perintah:

```bash
javac soal2/TesBagianB.java
java soal2.TesBagianB
```

**4. Menjalankan Bagian C (`TesBagianC`)**

Kompilasi dan jalankan program menggunakan perintah berikut:

```bash
javac soal2/TesBagianC.java
java soal2.TesBagianC
```
[Output Soal 2 - A](img/Soal2-A.png)
[Output Soal 2 - B](img/Soal2-B.png)
[Output Soal 2 - C](img/Soal2-C.png)

### Pertanyaan
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

### Soal 3: Titik dan Garis (Composition, Aliasing, & Defensive Copy)
Untuk mengkompilasi dan menjalankan program Soal 3, gunakan langkah-langkah berikut melalui terminal:

**1. Masuk ke Direktori `src`**

Buka terminal atau Command Prompt, kemudian masuk ke folder `src`:

```bash
cd src
```

**2. Compile dan Jalankan Program**

Kompilasi dan jalankan program menggunakan perintah berikut:

```bash
javac soal3/TesSoal3.java
java soal3.TesSoal3
```
[Output Soal 3](img/Soal3.png)

### Pertanyaan
#### 1. Prediksi dan Hasil Output Baris Kedua
```java
  (100.0, 1.0) - (5.0, 5.0)
```
erjadi fenomena aliasing. Objek t direferensikan secara langsung oleh g2 pada titik awalnya. Ketika nilai t diubah dari luar menggunakan t.setX(100), titik awal pada g2 ikut berubah karena menunjuk ke alamat memori yang sama.

#### 2. Perbaikan dengan Defensive Copy
Untuk mencegah efek samping dari aliasing, constructor yang menerima objek Titik harus melakukan salinan defensif (defensive copy):
```java
  public Garis(Titik awal, Titik akhir) {
    this.awal = new Titik(awal.getX(), awal.getY());
    this.akhir = new Titik(akhir.getX(), akhir.getY());
}
```
**Output Setelah Diperbaiki:**
```java
  (1.0, 1.0) - (5.0, 5.0)
```
*(Nilai g2 tetap aman dan tidak berubah meskipun t.setX(100) dipanggil dari luar).*

#### 3. Kapan Perilaku Sebelum vs Sesudah Perbaikan Lebih Tepat?
**Sebelum Perbaikan (Tanpa Defensive Copy):** Tepat digunakan jika kita menginginkan shared reference (ikatan langsung), di mana jika objek luar (seperti posisi objek dalam game atau grafik real-time) bergerak, garis yang dibentuknya otomatis ikut terbarui tanpa perlu memperbarui garis secara manual.
**Sesudah Perbaikan (Dengan Defensive Copy):** Tepat digunakan untuk menjaga integritas data (encapsulation), keamanan, dan menghindari side-effect yang tidak diinginkan di mana bagian luar program dapat merusak state internal objek tanpa izin.

#### 4. Analisis Desain yang muncul ditinjau dari relasi is-a dan has-a jika Garis extends Titik
Secara konseptual geometri, sebuah garis bukanlah sebuah titik (Garis is-a Titik adalah tidak logis). Garis memiliki dua buah titik (Garis has-a Titik), sehingga hubungan yang benar adalah Composition (has-a), bukan Inheritance (is-a). Jika menggunakan extends Titik, sebuah garis hanya akan memiliki satu titik (warisan dari Titik), padahal garis membutuhkan dua titik (awal dan akhir). Memaksa pewarisan tunggal untuk struktur yang membutuhkan komponen ganda akan merusak desain hierarki kelas.

### Soal 4: Mini Project Toko Digital (Inheritance, Composition, Polymorphism, & Exception Handling)

Untuk mengkompilasi dan menjalankan program Soal 3, gunakan langkah-langkah berikut melalui terminal:

**1. Masuk ke Direktori `src`**

Buka terminal atau Command Prompt, kemudian masuk ke folder `src`:

```bash
cd src
```

**2. Compile dan Jalankan Program**

Kompilasi dan jalankan program menggunakan perintah berikut:

```bash
javac soal4/TesSoal4.java
java soal4.TesSoal4
```
[Output Soal 4](img/Soal4.png)

### Bagian Analisis Konsep
#### 1. Apa perbedaan method overriding dan method overloading? Tunjukkan satu contoh masing-masing dari kode kalian dan jelaskan kaitannya dengan inheritance dan polimorfisme.
Method overloading terjadi ketika kita membuat beberapa method dengan nama sama tetapi parameter berbeda dalam satu kelas yang sama, sedangkan overriding adalah ketika subclass menulis ulang method dari superclass-nya dengan nama dan parameter yang persis sama. Contoh overloading terdapat pada constructor `Garis(Titik, Titik)` dan `Garis(double, double, double, double)` di Soal 3. Contoh overriding tampak pada method `hitungHargaAkhir()` yang diimplementasikan secara berbeda oleh `ProdukFisik` dan `ProdukDigital` di Soal 4. Overloading terkait dengan fleksibilitas pemanggilan (compile-time), sedangkan overriding berkaitan erat dengan inheritance dan dynamic dispatch (runtime polimorfisme).

#### 2. Kapan memilih inheritance dan kapan memilih composition? Beri satu contoh dari tugas ini untuk masing-masing.
Inheritance dipilih ketika terdapat hubungan hierarki murni yang bersifat is-a, di mana subclass merupakan bentuk khusus dari superclass-nya. Sebaliknya, composition dipilih ketika suatu objek "memiliki" objek lain (has-a) sebagai komponen penyusunnya tanpa harus mewarisi sifat-sifatnya. Contoh inheritance dalam tugas ini adalah `ProdukDigital` yang memperluas kelas `Produk` pada Soal 4. Contoh composition dapat dilihat pada kelas `Garis` yang dibentuk dari dua objek `Titik` pada Soal 3.

#### 3. Pada Soal 4, mengapa cetakStruk() tidak memerlukan instanceof sedangkan hitungPerJenis() memerlukannya? Mengapa downcasting tidak selalu aman?
Method `cetakStruk()` tidak memerlukan `instanceof` karena memanfaatkan polimorfisme murni, di mana setiap objek secara otomatis mengeksekusi method-nya sendiri melalui dynamic dispatch. Sebaliknya, `hitungPerJenis()` memerlukan `instanceof` dan downcasting karena kita perlu mengidentifikasi serta menghitung jumlah masing-masing jenis produk secara spesifik dari list umum bertipe `Produk`. Downcasting tidak selalu aman karena jika kita memaksa mengonversi suatu objek ke tipe subclass yang salah, program akan mengalami crash dan melempar ClassCastException saat runtime.