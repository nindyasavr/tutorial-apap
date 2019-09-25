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

