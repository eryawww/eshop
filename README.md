Link: https://tutorial1-eryaw.koyeb.app

# Tutorial 4

1. Menurut saya, framework Percival (2017) tidak begitu cocok untuk saya. Menurut saya, konsep ini akan efektif jika terdapat prosedur perancangan yang sangat strict. Adanya prosedur desain seperti uml diagram akan memperkuat konsep ini. Namun, untuk rapid development yang tidak menerapkan prosedur uml yang strict, framework ini hanya akan menyusahkan dan memperlambat proses pengembangan perangkat lunak. Hal ini dikarenakan pengembangan test secara buta yang dapat menyebabkan banyak kesalahan itu sendiri. Pengembangan test tanpa code intelligence sendiri akan memicu banyak error yang memerlukan revisi disaat implementasi fitur, yang mana kontradiksi dengan penulisan test di awal.  

2.
Fast: Pemanfaatan stubbing pada Payment membuat test berjalan lebih cepat.
Isolated/Independent: Test yang dibuat tidak mempengaruhi satu sama lain dengan adanya set up.
Repeatable: Penggunaan test yang konsisten dan modular mendukung konsep repeatable yang simpel untuk dijalankan pada tiap waktu. 
Self-Validating: Penggunaan assertions mendukung prinsip ini, unittest akan otomatis mendeteksi mana yang benar dan mana yang salah.
Thorough/Timely: Prinsip ini sangat mirip dengan konsep code coverage, yang mana sudah cukup tinggi saya implementasikan.

# Tutorial 3
## Principles applied
Saya menggunakan prinsip Single Responsibility Principle
(SRP), Open-Closed Principle (OCP), dan Dependency Inversions Principle
(DIP). 
1. SRP, satu kelas hanya memiliki satu tanggung jawab. Lebih spesifiknya, saya memisahkan CarController dan ProductController untuk memastikan masing-masing memiliki tanggung jawab yang jelas.
2. OCP, CarRepository dan ProductRepository memiliki banyak persamaan. Keduanya sama-sama repository yang mengatur create, delete, dan sebagainya. Sehingga generalisasi interface repository diperlukan agar kedepannya penambahan fitur repository lain bisa dilakukan konsisten dan cepat.
3. DIP, prinsip ini menekankan untuk menggunakan abstraksi dibandingkan implementasi konkrit. Ini merupakan alasan lain saya memecah CarController dan ProductController.

## Advantages of applying SOLID

Konvensi SOLID menurut saya bertugas untuk menyatukan mindset para programmer agar berpikir pada satu jalan yang bersih. Beberapa keuntungan dari penggunakan SOLID adalah.
1. Panjang kode yang teratur membuat proses debugging, reading, dan testing menjadi lebih cepat. Pemecahan pada kelas CarController dan ProductControlller adalah salah satu contoh.
2. Suatu fungsi hanya memiliki satu tanggung jawab membuat kita tau apa isinya hanya dengan melihat nama fungsinya. Pemecahan pada kelas CarController dan ProductControlller adalah salah satu contoh juga.
3. Multilevel inheritance atau inheritance pada kelas konkrit akan membuat kita terbinggung-binggung attribut-attribut yang dimiliki oleh tiap kelas. Pemecahan pada kelas CarController yang sebelumnya inherit ProductControlller adalah contoh, CarController tidak memerlukan apa apa dari ProductController. Hierarki car controller tidak seharusnya berada sebaga child Product Controller.
4. Pengembangan fitur baru menjadi lebih mudah, tidak menghancurkan kode dan test dari kode lama. Pembuatan interface baru untuk beberapa kelas yang seragam merupakan sahal satu contoh. Sehingga kedepannya interface tersebut dapat diimplementasikan dan dibandingkan untuk suatu fitur baru.
5. Child dapat dianggap sebagai parent. Hal ini diperlukan karena pada dasarnya parent adalah bentuk general dari child, sehingga semua child harus memiliki properti parentnya juga. jika B inherit A dan kita ingin membandingkan sesama A, maka kita harus bisa menggunakan B dalam perbandingan tersebut.
6. Menekankan pada intuisi dibandingkan panjang kode. Konsep ISP menjelaskan bahwa panjang kode tidak menjadi masalah, intuisi awal ketika melihat nama kelas/fungsi harus segera terbentuk untuk mengetahui apa kelas/fungsi tersebut lakukan. Suatu interface yang memiliki 4 method dapat dipecah menjadi 2 method dengan nama yang lebih representatif menggambarkan fungsi-fungsi di dalamnya.

## Disadvantages of not applying SOLID principles.

1. Panjang fungsi yang terlalu panjang dapat menurunkan produktivitas developer. Membaca suatu fungsi kompleks yang panjang sudah membuat kita malas terlebih dahulu bahkan sebelum membacanya.
2. Modifikasi kode lama mungkin terjadi. Memodifikasi kode lama dapat memicu modifikasi test, merusak, dan menghapus jaminan fitur yang sudah jalan.
3. Pemahaman kode yang lebih lama. Dikarenakan panjangnya suatu fungsi, nama dari fungsi tersebut memiliki potensi untuk tidak intuitif sehingga menuntut developer untuk membaca isinya.
4. Penambahan fitur yang susah. Penambahan fitur dapat memicu modifikasi kode lama. Selain itu, penambahan fitur mungkin memerlukan banyak repetisi kode.

# Tutorial 2
## Code Quality Issue(s)
Beberapa code quality issue yang saya dapat dari PMD adalah
1. Penamaan fungsi yang tidak sesuai

`The JUnit 5 test method name 'pageTitle_isCorrect' doesn't match '[a-z][a-zA-Z0-9]*'` Adalah annotation yang dihasilkan PMD untuk memberi tahu bahwa nama fungsi yang diberikan tidak sesuai dengan konfensi java.  

2. Import yang tidak digunakan

`Unused import 'java.util.List'` dan `Unused import 'org.springframework.web.bind.annotation.*':` merupakan contoh output yang diberikan PMD ketika suatu import dinilai tidak penting. Terlihat bahwa PMD menganjurkan import suatu kelas secara spesifik dibandingkan menggunakan `*` yang mana memang benar best practice yang ada.

3. Modifier public pada kelas interface yang tidak diperlukan

`Unnecessary modifier 'public' on method 'create': the method is declared in an interface type:` adalah output yang diberikan PMD ketika terdapat sebuah modifier publik pada sebuah method yang sebenarnya tidak diperlukan dikarenakan memang seharusnya begitu implicitly. 

## Current implementation met the definition of Continuous Integration and Continuous Deployment?
Menurut saya, implementasi yang saya lakukan pada github ini sudah mendukung Continuous Integration (CI) and Continuous Deployment (CD). Continous atau berkelanjutan dapat diartikan sebagai autonomous atau automatis. Test dan deployment otomatis sudah saya implementasikan pada tutorial ini dengan bantuan github workflow yang melakukan testing dan checking untuk setiap push / pull request yang dilakukan. Hal ini membuat proses development menjadi lebih efisien, mudah dilacak dan memenuhi standar yang diberikan.

## Coverage Test (Bonus)



# Tutorial 1

## Meaningful Names

Menggunakan nama variabel yang deskriptif. Cara berpikir yang saya gunakan adalah diharapkan hanya dengan membaca nama variabel, developer lain dapat mengetahui dan menebak apa yang disimpan dari variabel tersebut. Penamaan variabel juga harus sesuai dengan konvensi bahasa yang digunakan, seperti snake_case untuk bahasa python dan camelCase untuk bahasa Java. Penamaan variabel juga tidak seharusnya panjang untuk menjaga panjang satu line. 
## Functions

Cara berpikir saya saat membuat fungsi adalah "Fungsi hanya memiliki satu tanggung jawab.". Selain itu, fungsi juga tidak seharusnya panjang-panjang. Jika suatu algoritma memanglah panjang, fungsi implementasinya pasti dapat dipecah menjadi beberapa bagian/subproblem. Lalu yang terakhir, fungsi seharusnya tidak memberi efek apapun di luar scope-nya. Fungsi tidak seharusnya meribah variabel global kecuali pada kasus-kasus tertentu yang sudah menjadi konvensi (fungsi set_up saat menggunakan suatu library).

## Comments
   
Menggunakan prinsip "Jangan memberikan komentar pada kode yang kotor". Dengan begini, komentar seharusnya lebih sedikit, sisanya biarlah kode bersih yang menjelaskan. Penulisan komentas biasanya berkaitan erat dengan algoritma dan keterbatasan-keterbatasan yang dilakukan, bukan untuk fokus untuk menjelaskan kenapa begini kenapa begitu. 

## Objects and Data Structure

Ini adalah prinsip yang paling susah menurut saya. Hierarki objek menjadi sangat challenging ketika sudah menjadi kompleks, dan biasanya ketika berurusan dengan library. Seperti pada konsep ini, *saya melakukan kesalahan penulisan sehingga saya perlu melakukan refactoring untuk memperbaiki kesalahan tersebut*. Kesalahan saya ada pada ketidak pahaman saya akan hierarki Repository, Service Interface, dan Service Implementation. Pada step testing baru saya menyadari perbedaan antara repository dan service implement itu sendiri.

# Reflection 2

Setelah menulis test, saya jadi semakin yakin akan kebenaran kode saya. Code coverage dari yang saya tau adalah seberapa "terkover" suatu fungsi terhadap sebuah test. Salah satu fitur utama code coverage adalah dapat dilakukan secara otomatis. Code coverage 100% tidak berarti kode tidak memiliki bugs dan error, bisa saya kebetulan test yang kita buat adalah test yang terlalu mudah dan program kita lulus test tersebut.

Pada functional test, saya merasa dapat terjadi banyak sekali potensi perulangan kode. Hal ini terjadi pada diri saya sendiri. Jika kita melakukan rule satu file testing sama dengan satu page, akan terjadi perulangan kode pada page yang saling bergantung. Dalam hal ini, sebuah rule yang lebih baik perlu ditegakkan. Yaitu satu file testing sama dengan satu file kontroller. Saya kira kemungkinan ketergantungannya akan lebih kecil dengan cost satu file test yang akan menjadi panjang.  