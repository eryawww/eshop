# Reflection 1

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