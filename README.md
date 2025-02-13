# Module 1: Coding Standard

Reflection 1

Ini adalah bebeberapa Clean Code dan Secure Code principle yang telah saya implementasikan pada kode saya

Clean Code

1. SRP & Separation of Concerns – Kelas dipisahkan sesuai tanggung jawabnya (Controller, Service, Repository).
2. Keterbacaan – Nama variabel dan metode deskriptif (editProductPage, ProductService).
3. Dependency Injection – Menggunakan @Autowired untuk pengelolaan dependensi.
4. Reusability – Thymeleaf digunakan sebagai template engine.

Secure Coding

1. UUID untuk ID Produk – Menghindari ID yang mudah ditebak.
2. Restriksi Metode HTTP – Gunakan GET hanya untuk membaca data, POST untuk perubahan.
3. Proteksi XSS – Thymeleaf secara otomatis melakukan escaping.
4. Redirect Setelah Operasi – Mencegah duplikasi saat refresh.

Reflection 2

1. **Perasaan Setelah Menulis Unit Test**

   Menulis unit test memberikan rasa percaya diri bahwa program berjalan sesuai harapan. Namun, perlu waktu dan usaha untuk menguji berbagai skenario.
   
   **Berapa Banyak Unit Test yang Dibutuhkan?**

   Setiap metode publik harus diuji setidaknya satu kali, ditambah pengujian untuk skenario batas (boundary), skenario negatif, dan edge cases.
   
   **Bagaimana Memastikan Unit Test Cukup?**

    - Gunakan **code coverage** (seperti Jacoco) untuk melihat persentase kode yang diuji.
    - Namun, 100% coverage **tidak berarti bebas bug**, karena logika atau jalur yang tidak diantisipasi bisa saja memiliki bug.


2. **Kebersihan Kode Pada Functional Test Baru**

   **Masalah**: Jika setiap test suite mengulangi setup yang sama, akan ada:
    - **Duplikasi kode** (misalnya, navigasi, setup driver).
    - **Kualitas kode menurun** karena sulit dirawat dan tidak efisien.
   
  **Solusi**:
  - Gunakan **Page Object Model (POM)** untuk memisahkan elemen UI dari logika test.
  - Abstraksi setup dan navigasi ke **base class** untuk menghindari pengulangan.
  - Buat **utility class** untuk aksi umum seperti klik atau input field.
  - Gunakan **parameterized test** untuk menghindari duplikasi logika skenario serupa.


