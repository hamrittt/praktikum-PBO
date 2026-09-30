# AmBank"

Hai
Hai Juga

---

## TODO
### 1. File `com.ambank.model.Card`
- [x] **TODO 1**: Atur semua access modifier atribut menjadi `private` (Security by Encapsulation). JANGAN buat method `getPin()`.
- [x] **TODO 2**: Lengkapi constructor `Card(String nameHolder, String pin)` dengan validasi PIN tepat 6 digit angka (`\\d{6}`).
- [x] **TODO 3**: Implementasikan method `verifyPin(String inputPin)`:
  - Cek apakah kartu terblokir.
  - Reset `failedAttempts` jika PIN benar.
  - Naikkan `failedAttempts` jika salah, dan otomatis ubah `isBlocked = true` jika salah 3 kali berturut-turut.
- [x] **TODO 4**: Implementasikan method `changePin(String oldPin, String newPin)`.
- [x] **TODO 5**: Implementasikan data masking pada `getMaskedCardNumber()` (12 digit pertama disensor `****-****-****-XXXX`).

### 2. File `com.ambank.model.Account`
- [x] **TODO 6**: Ubah `nameHolder` menjadi `private`, buat getter dan setter dengan validasi nama tidak boleh kosong.
- [x] **TODO 7**: Tambahkan atribut `private Card card;` dan getter `getCard()`.
- [x] **TODO 8**: Implementasikan method `issueCard(String pin)` untuk menginstansiasi objek `Card` dan menyimpannya ke `this.card`.
- [x] **TODO 9**: Pahami method `getTransferLimit()` yang disiapkan untuk di-override oleh kelas turunan.
- [x] **TODO 10**: Perbarui method `displayAccount()` agar mencetak informasi kartu ATM (Nomor masked dan status AKTIF/TERBLOKIR).

### 3. File `com.ambank.model.BusinessAccount`
- [x] **TODO 11**: Tambahkan konstanta `BUSINESS_TRANSFER_LIMIT = 50000000;`.
- [x] **TODO 12**: Lengkapi constructor overloading `BusinessAccount(String nameHolder, String NPWP, String noSK)` menggunakan `super(nameHolder)`.
- [x] **TODO 13**: Sediakan getter dan setter untuk atribut `NPWP` dan `noSK`.
- [x] **TODO 14**: Lakukan `@Override` pada method `getTransferLimit()` agar mengembalikan `BUSINESS_TRANSFER_LIMIT`.
- [x] **TODO 15**: Lakukan `@Override` pada method `displayAccount()`: panggil `super.displayAccount()`, lalu tampilkan informasi NPWP dan Nomor SK.

### 4. File `com.ambank.app.Transaction`
- [x] **TODO 16**: Ubah validasi batas transfer pada `makeTransaction()` agar menggunakan pemanggilan dinamis `sender.getTransferLimit()` (menerapkan Polimorfisme).
- [x] **TODO 17**: Implementasikan penarikan tunai pada method `tarikUang(Account account, int amount)`.
- [x] **TODO 18**: Implementasikan autentikasi PIN pada method `tarikUang(Account account, int amount, String pin)`.

---
