# TUGAS RECYCLEVIEW
📱 Aplikasi RecyclerView – Menampilkan Data dari API

## 📄 Penjelasan RecyclerView
RecyclerView adalah komponen Android yang digunakan untuk menampilkan data dalam bentuk list atau grid dengan lebih efisien. RecyclerView sering dipakai saat menampilkan data yang banyak, misalnya data dari API, karena sudah mendukung penghematan memori melalui proses recycle pada item yang tampil.

## 👥 Tim
1. Andika AndroMeda (03)
2. Anzilul Nur Rohma (04)
3. Arrumi Asna Salsabilla (05)
4. Erikza Assyifia Ahmad (13)
5. Kirana Alifa Ummah (19)

## 🔄 Penjelasan Alur Data
Ketika aplikasi pertama kali dijalankan, sistem akan memuat SplashScreen dengan menampilkan layout yang berisi logo aplikasi. Proses ini biasanya berlangsung beberapa detik sambil mempersiapkan resource atau melakukan inisialisasi awal. Setelah selesai, aplikasi akan diarahkan ke halaman utama yang berisi data dari API. Jadi, alur data dimulai dari pemanggilan layout SplashScreen → menampilkan logo → berpindah ke aktivitas utama.

## ⚙️ Fitur Aplikasi
- Menampilkan tampilan awal berupa SplashScreen dengan logo aplikasi.
- Memberikan transisi sebelum masuk ke halaman utama.
- Membuat pengalaman pengguna lebih menarik dan profesional saat pertama membuka aplikasi.

## 🔧 Teknologi
- Android Studio
- Kotlin
- RecyclerView
- LinearLayout untuk mengatur tata letak komponen di layar.
- ImageView untuk menampilkan logo aplikasi.
- Resource Drawable (@drawable/logotunas) sebagai gambar logo yang ditampilkan.
- Tools Context (tools:context=".SplashScreen") untuk menghubungkan layout dengan Activity SplashScreen.

## 💻 Penjelasan Code Penting
1. dependencies
<img width="1396" height="632" alt="carbon (16)" src="https://github.com/user-attachments/assets/d6642cb7-6ff5-478c-af37-15f4662b3804" />
Pada proyek aplikasi ini digunakan beberapa library penting yang ditambahkan melalui dependencies. Library RecyclerView digunakan untuk menampilkan data dalam bentuk list yang lebih efisien, sedangkan CardView berfungsi memberikan tampilan berbentuk kartu agar data lebih rapi dan menarik. Untuk komunikasi dengan API digunakan Retrofit, yang dipadukan dengan Converter-Gson agar data berformat JSON dapat dengan mudah diubah menjadi objek Kotlin. Selain itu, library Glide dipakai untuk menampilkan gambar dari URL dengan cepat, efisien, dan mendukung caching sehingga performa aplikasi tetap terjaga.


2. permission
<img width="1346" height="410" alt="carbon (17)" src="https://github.com/user-attachments/assets/dece75af-bef2-476f-ac69-657df4d774aa" />
Agar aplikasi dapat mengambil data dari API melalui jaringan, pada file AndroidManifest.xml ditambahkan permission <uses-permission android:name="android.permission.INTERNET" />. Permission ini sangat penting karena tanpa izin akses internet, aplikasi tidak bisa melakukan komunikasi dengan server atau memuat data dari API secara online.


3. interface ApiService
<img width="1092" height="744" alt="carbon (18)" src="https://github.com/user-attachments/assets/fdd3641a-663e-433a-a8cf-5c838f580e90" />
Pada bagian ini dibuat sebuah interface ApiService yang berfungsi sebagai penghubung antara aplikasi dengan API menggunakan Retrofit. Di dalamnya terdapat sebuah method getBuku() yang diberi anotasi @GET("buku"). Anotasi ini menandakan bahwa aplikasi akan melakukan permintaan data (request) ke endpoint buku pada server API. Method tersebut mengembalikan sebuah objek Call<List<Buku>>, yang artinya data yang diterima dari API akan berupa daftar (list) objek Buku sesuai dengan model yang telah dibuat. Dengan adanya ApiService, proses pemanggilan API menjadi lebih terstruktur, mudah digunakan, dan terintegrasi langsung dengan Retrofit.

4. RetrofitClient
<img width="1362" height="1006" alt="carbon (19)" src="https://github.com/user-attachments/assets/4c20b046-7bde-43b0-9ba9-2c0f73c1dbe2" />
Pada bagian ini dibuat sebuah object RetrofitClient yang berfungsi sebagai konfigurasi utama untuk melakukan komunikasi dengan API. Di dalamnya terdapat konstanta BASE_URL yang digunakan sebagai alamat dasar (endpoint utama) dari server API yang akan diakses. Kemudian, Retrofit diinisialisasi menggunakan Retrofit.Builder() dengan menambahkan baseUrl(BASE_URL) serta GsonConverterFactory.create() agar data JSON yang diterima dari API bisa langsung diubah menjadi objek Kotlin. Selanjutnya, Retrofit membangun instance dari ApiService dengan menggunakan retrofit.create(ApiService::class.java). Objek ini disediakan secara singleton melalui properti instance sehingga dapat digunakan di berbagai bagian aplikasi tanpa perlu membuat ulang koneksi, sehingga lebih efisien dan mudah dikelola.

5. SplashScreen
<img width="1514" height="1042" alt="carbon (20)" src="https://github.com/user-attachments/assets/c2f5438f-bdf3-42d3-a385-62a23fee7d4c" />
Kode di atas merupakan file layout untuk SplashScreen pada aplikasi. Layout menggunakan LinearLayout dengan orientasi vertikal, posisi konten diatur ke tengah melalui atribut android:gravity="center", serta latar belakang diberi warna putih. Di dalamnya terdapat sebuah ImageView dengan ukuran 200dp x 200dp yang menampilkan gambar logo aplikasi melalui android:src="@drawable/logotunas". Komponen ini juga memiliki id imgSplash agar dapat dipanggil dan digunakan dalam class SplashScreen di bagian kode program. Dengan desain sederhana ini, tampilan awal aplikasi akan langsung menampilkan logo sebelum masuk ke halaman utama.







