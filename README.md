# [Service master data] springboot

## 📌 Deskripsi Singkat [Backend]
"Jika API Gateway adalah resepsionis hotel, maka Service Registry adalah Buku Tamu atau Database Alamat yang selalu terupdate secara otomatis.

Dalam arsitektur microservices, alamat IP dan port server sering berubah-ubah (terutama jika menggunakan Docker atau Kubernetes di mana kontainer bisa mati dan menyala kembali dengan IP baru). Di sinilah Service Registry berperan."

## 🚀 Fitur Utama
- **[Fitur 1]:** Pendaftaran Otomatis (Service Registration)
Setiap kali sebuah microservice (seperti transaction-service) menyala, ia akan langsung "melapor" ke Service Registry:

"Halo, saya Transaction Service, alamat saya ada di 192.168.1.50 port 9092. Tolong dicatat!"

- **[Fitur 2]:** Penemuan Layanan (Service Discovery)
Ketika API Gateway ingin meneruskan data ke transaction-service, ia tidak perlu menuliskan alamat IP secara manual (hardcoded). Gateway cukup bertanya ke Service Registry:

"Di mana alamat Transaction Service sekarang?" Service Registry menjawab: "Dia ada di 192.168.1.50:9092."

- **[Fitur 3]:** Pemeriksaan Kesehatan (Health Checking)
Service Registry secara berkala akan mengecek: "Hei, kamu masih hidup?" ke setiap service yang terdaftar.

Jika sebuah service tidak merespons (mati), Service Registry akan menghapus alamat tersebut dari daftar.

Hasilnya, Gateway tidak akan mengirim trafik ke server yang sedang rusak.

- **[Fitur 4]:** Mendukung Auto-Scaling
Jika trafik membludak dan kamu menjalankan 5 instans transaction-service sekaligus, kelimanya akan terdaftar di Service Registry. Gateway kemudian bisa meminta kelima alamat tersebut untuk melakukan pembagian beban (load balancing).


## 🛠️ Depedency Properties
Daftar teknologi yang digunakan dalam proyek ini:
- [spring-cloud-starter-netflix-eureka-server]
- [spring-boot-starter-actuator]
- [lombok]
- [spring-boot-starter-test]


## Ilustrasi Arsitektur

![Service Registry Architecture](https://github.com/syaiful-scooter/api-gateway/blob/main/gateway_diakses.jpg)

Dibuat dengan ❤️ oleh syaifulscooter