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

## Tutorial 7
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi melakukan validasi apakah username dan password sudah sesuai dengan yang telah tersimpan di database
otentikasi dilakukan ketika user melakukan login dan melihat apakah username dan passwordnya match. jika tidak 
maka otentikasi tidak akan diberikan atau gagal log in
Otorisasi adalah proses menentukan akses apa yang dapat diberikan kepada user. Implementasi ini dilakukan ketika
penambahan user hanya bisa dilakukan oleh admin karena user dan merchant tidak memiliki otorisasi terhadap penambahan user.

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!
BCryptPasswordEncoder adalah tool yang berguna untuk melakukan encoding password yang didapatkan dari Spring security.
BCryptPasswordEncoder ini memanfaatkan hashing agar tidak menyimpan password dalam bentuk yang asli. Cara kerjanya adalah 
dengan membuat sebuah objek BCryptPasswordEncoder yang akan memanggil method encode dan method tersebut akan melakukan
encoding terhadap password yang dimiliki user

3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java?
UUID adalah kumpulan dari 32 karakter yang berbentuk string dan dibuat secara acak dengan teknik khusus yang digunakan untuk
menjamin keunikan pada setiap data. UUID memiliki keunikan yang tinggi karena di setiap melakukan generate yang menggunakan UUID
dapat dijamin akan menghasilkan 1000 UUID yang berbeda. UUID berguna untuk keamanan password yang dimiliki user karena akan sulit 
mengacak password yang telah di enkripsi menggunakan UUID. 

4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
padahal kita sudah memiliki class UserRoleServiceImpl.java?
UserDetailsServiceImpl.java berguna untuk membangun autentikasi user. didalam class ini dilakukan extends terhadap UserServiceDetail dari spring security.
Class ini akan menghasilkan UserDetail object yang akan memberikan informasi terkait user yang terdapat dari db dan juga memberikan otorisasi
yang dimiliki user sesuai dengan role yang dimiliki. Sedangkan UserServiceImpl digunakan untuk mengatur mapping yang dilakukan user


-------------------------------------------------------------------------------
### Tutorial 8
1. Hilangkan checkbox pada item di list bagian kiri. Gunakan approach terbaik menurut Anda.
Anda hanya tidak diperbolehkan untuk membuat component Item baru.
==> Yang saya lakukan pertama-tama adalah menambahkan parameter untuk variabel boolean di dalam item.js yang menyimpan
variabel apakah checkbox perlu di hide atau di display. variabel tersebut juga ditambahkan di List.js
karena List.js mengakses item juga. kemudian ketika ingin di display, list untuk seluruh data booleannya di false
sehingga checkboxnya akan disembunyikan. berikut lampiran bukti pengerjaan saya
https://ibb.co/z2cPnyR
https://ibb.co/PjS09Pn
https://ibb.co/pr3WjyH

2. Jika kalian memilih item dari bagian kiri dan item dengan ID yang sama sudah ditambahkan
sebelumnya, maka item tersebut terhapus dari bagian kanan. Buatlah mekanisme agar bagian
kiri hanya melakukan operasi add. Berikut adalah ilustrasi behavior sekarang
==> secara garis besar hampir sama dengan nomor 1, menambahkan sebuah parameter boolean.
parameter isDelete ini melakukan pengecekan ketika card di sebelah kiri di klik, maka boolean
akan menjadi false sehingga tidak dapat menghapus dengan mengklik bagian kanan.
kemudian di dalam function handleItemClick(item, isDelete) ditambahkan parameter dan juga
melakukan conditional jika boolean true maka card dapat di delete dari favorit. 
jika conditionnya false, maka card di sebelah kanan tidak dapat dihapus jika masih berada di my fav
berikut adalah lampiran foto code
https://ibb.co/chvYt4x
https://ibb.co/JdQXCJr
https://ibb.co/fHhTnYz

3. Buatlah toggle dimana jika toggle ON, maka My Favorite ditampilkan. Jika toggle OFF, maka
sembunyikan. Tata letak toggle tidak harus sama.
Pertama membuat input checkbox dan ditandai dengan parameter checked di app.js atau appfunc.js. 
kemudian membuat constanta yang dapat mengubah parameter boolean yang diberikan. Kemudian juga
function displayFavorit di dalam appFunc.js. function ini pertama melakukan conditional apakah
size list favorit ada atau tidak jika tidak seperti di nomor 4. jika ya maka akan melakukan 
penambahan ke daftar favorit biasa.
Berikut merupakan lampiran source code 
https://ibb.co/qynXxRr
https://ibb.co/ccFCVx7
https://ibb.co/H7sjsNP

4. Jika daftar favorit kosong, maka tampilkan empty state. Hint: buat component bernama
EmptyState.
Pertama-tama membuat file emptyState dan menuliskan pesan yang ingin disampaikan. 
kemudian, didalam app.js ataupun appfunc.js ditambahkan conditional apabila panjang list
favorit masih null, maka munculkan pesan dari empty State
Berikut merupakan lampira coding mengenai emptyState
https://ibb.co/jffwdgX
https://ibb.co/C5XXdrs

-----------------------------------------------------------------------------
### Tutorial 9
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan
mengapa kalian melakukan langkah - langkah tersebut?
Pertama-tama setelah fitur add berhasil, saya menambahkan sebuah function bernama resetValue().
function ini menyimpan state yang berisi null sehingga akan mereset value yang tadinya sudah ada di state.
kemudian saya definisikan kapan fungsi ini akan dipanggil yaitu ketika restoran sudah berhasil di add.
untuk itu, saya panggil function ini di function addRestoranHandler

2. Jelaskan fungsi dari async dan await!


3. Masukkan jawaban dari TODO (Screenshot) pada Component Lifecycle pada
pertanyaan ini.


4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps,
componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”