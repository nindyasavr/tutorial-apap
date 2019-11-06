# Tutorial APAP

## Authors

**Nindya Savirahandayani** - *1706074745* - *C*


## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh
menambahkan catatan apapun dibagian ini)

#### Github
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?
**Issue Tracker** berfungsi melakukan pelacakan masalah seperti dapat meminta feedback user, melaporkan adanya error atau bugs dalam code kita, dan mengkoordinasi pekerjaan yang ingin kita selesaikan. masalah yang dapat diselesaikan yaitu jika adanya bugs atau error, menemukan double issues, adanya komen yang melanggar ketentuan github

2. Apa perbedaan dari git merge dan merge --squash?
**git merge** = dalam kasus merge ke master jika menggunakan git merge saja, maka file yang akan di merge ke master hanyalah commit terakhir jadi jika merge dilakukan oleh kombinasi 2 atau lebih user maka setiap user harus memiliki file commit yang paling terbaru jika tidak maka akan fail karena filenya tidak terintegrasi.
**git merge --squash** = saat melakukan merge request perintah ini akan menggabungkan commit-commit yang ada menjadi satu kesatuan kemudian baru di merge maka kemungkinan terjadinya error lebih kecil


#### Spring

3. Apa itu library & dependency?
**library** merupakan kumpulan kode functionalitas yang dapat digunakan dalam membuat suatu program pada spring boot dan juga dapat di reuse 
**dependency** adalah ketergantungan antar functional di library terhadap program kita. sehingga apabila adanya perubahan dalam satu object, maka harus dilakukan perubahan juga pada objek yang dependent 


4. Apa itu Maven? Mengapa kita perlu menggunakan Maven?

**Maven** adalah Java Build Tools yang menggunakan konsep Project Object Model (POM). Maven dapat dibuka dengan berbagai IDE karena Maven membuat struktur project sendiri. Selain itu, Maven juga mempermudah proses build dalam suatu project. Tools ini juga mempermudah kita dalam mengatur dependency serta mengimport class yang memiliki dependency pada program kita.

5. Apa alternatif dari Maven?
Ant, Gradle

### What I did not understand

(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
 dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)

- [ ] bagaimana spring boot dan html dan java dapat bekerja secara kesatuan

- [ ] bagaimana cara kerja getmapping, @controller dan syntax-syntax baru

- [ ] Apa saja yang dapat dilakukan dengan spring boot



Karena �


(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam
 tentang penulisan README.md pada github pada link

[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))



----------------------------------------------------------------------
## **Tutorial 2**
Pertanyaan 1: Cobalah untuk menambahkan sebuah restoran dengan mengakses link
berikut:
http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%2
0Fasilkom&nomorTelepon=14022
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
link diatas tidak dapat diakses dikarenakan template html belum dibuat sehingga controller yang sudah dibuat tidak dapat merender html

Pertanyaan 2: Cobalah untuk menambahkan sebuah restoran dengan mengakses link
berikut:
http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin
%20FIK
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Karena tidak terdapat parameter untuk nomor telepon sehingga fungsi tidak dapat dijalankan karena kekurangan parameter yang dibutuhkan

Pertanyaan 3: Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus
diakses?
http://localhost:8080/restoran/view?idRestoran=1

Pertanyaan 4: Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk
mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? Sertakan
juga bukti screenshotmu.
pada link tersebut terdapat list restoran yang telah ditambahkan beserta informasi id, nama, alamat dan nomor telepon masing-masing restoran
bukti screenshot : https://ibb.co/XjX2rqp

------------------------------------------------------------------------------
## **Tutorial 3**
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari
method tersebut?
method tersebut mengambil data restoran dari database dengan mempermudah melakukan query tanpa harus membuat query terlebih dahulu

2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?
addRestoranFormPage merupakan method yang akan menampilkan form untuk informasi restoran tersebut
addRestoranSubmit merupakan method yang digunakan untuk mendapat value yang sebelumnya telah diisi di form dan menyimpannya di database

3. Jelaskan apa kegunaan dari JPA Repository?
JPA Repository digunakan sebagai perantara database tempat untuk menyimpan data-data yang akan mempermudah dalam pengaksesan database tanpa harus membuat syntax query sql terlebih dahulu

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?
relasi keduanya terdapat pada :
@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restoranId", referencedColumnName = "idRestoran", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

kode diatas menandakan bahwa MenuModel akan melakukan referenced ke RestoranModel dengan memanfaatkan id restoran sebagai column referencenya

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY adalah cara mengambil data object sesuai apa yang diminta tanpa perlu memberikan data dari relasinya
CascadeType.ALL menandakan semua object yang saling berelasi akan saling berhubungan jadi ketika satu object dihapus maka semua relasinya juga akan terhapus
FetchType.EAGER adalah cara mengambil data object semua data beserta tabel yang berelasi dengannya.

--------------------------------------------------------------------------------------------------------
## Tutorial 4

1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
anda menyelesaikan latihan nomor 2
yang saya pelajari dari latihan 2
Proses saya menemukan nomor 2 adalah dengan membrowsing kasus yang sama kemudian memahami bagaimana cara kerjanya dan kemudian mengimplementasikan hal tersebut ke file saya

2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda
menyelesaikan latihan nomor 3
yang saya pelajari adalah bagaimana membuat sebuah form yang dapat menerima multiple object dengan memanfaatkan binding result. proses dalam memecahkan nomor 3 cukup panjang dengan melakukan browsing berbagai sumber kemudian bertanya kepada yang ahli mulai pertama mendapatkan cara menggunakan javascript namun hanya tersbumit object paling atas kemudian baru menemukan cara menggunakan binding result

3. Jelaskan perbedaan th:include dan th:replace
th:include adalah metode yang digunakan jika ingin menambahkan satu atau lebih object ke dalam file baru seperti menambahkan file js dan css yang banyak 
th:replace adalah metode yang digunakan jika ingin mengubah salah satu elemen yang ada di dalam object di suatu file html. seperti contohnya saat ingin meng-include navbar ada elemen yang perlu diganti sehingga membutuhkan th:replace

4. Jelaskan bagaimana penggunaan th:object beserta tujuannya
th:object berguna untuk menyimpan suatu object kedalam thymeleaf setelah dilakukan submit form


----------------------------------------------------------------------------------------------------
## Tutorial 5
1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and
then.
given : ketika pembuatan inisiasi restoranModel dilakukan hingga when
when : kondisi saat cek attribut dari model melakukan andExcpect 
andThen : ketika melakukan verify 

2. Jelaskan perbedaan line coverage dan logic coverage.
logic coverage : melakukan testing terhadap conditional expression atau logical operator dalam code
line coverage : testing terhadap statement di setiap baris didalam code 

3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa
seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin
terjadi?
idealnya unit test dibuat terlebih dahulu mengikuti prinsip tdd(test driven development). jika urutannya dibalik terdapat risiko yang terjadi seperti:
-over-engineering : keadaan dimana kita menyadari bahwa code yang kita tulis terlalu rumit dan kompleks padahal bisa disederhanakan
-Penyesuaian code : code yang sudah ditulis susah untuk di test sehingga perlu dilakukan refactor agar dapat dilakukan test
-no test : karena code sudah berhasil digunakan maka membuat kita jadi malas untuk melakukan testing sehingga sulit untuk mencari bug

-----------------------------------------------------------------------------------------------------
## Tutorial 6
1. Apa itu postman? Apa kegunaan dari postman?
Postman merupakan aplikasi yang berjalan sebagai client dan digunakan untuk melakukan uji coba REST API 


2. Apa kegunaan dari annotation @JsonIgnoreProperties?
Anotasi ini berguna untuk menekan serialisasi properti atau mengabaikan pemrosesan properti JSON yang dibaca (saat deserialisasi) 


3. Apa itu ResponseEntity dan apa kegunaannya?
ResponseEntity merupakan representasi dari respons HTTP yang berupa kode status, header dan body. Response ini digunakan untuk mengkonfigurasi seluruh respons HTTP