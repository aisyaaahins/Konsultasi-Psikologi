import java.util.List; // Mengimpor antarmuka List untuk menampung data

// KonsultasiService adalah interface untuk mendefinisikan kontrak layanan konsultasi
public interface KonsultasiService {

    // Deklarasi metode untuk menambahkan data konsultasi
    void addKonsultasi(Konsultasi konsultasi);
    // Metode ini akan menerima objek Konsultasi dan bertugas untuk menambahkan data ke penyimpanan (database).

    // Deklarasi metode untuk mengambil semua data konsultasi
    List<Konsultasi> getAllKonsultasi();
    // Metode ini akan mengembalikan daftar (list) semua data konsultasi yang tersimpan di penyimpanan.

    // Deklarasi metode untuk memperbarui data konsultasi berdasarkan ID
    void updateKonsultasi(int id, Konsultasi konsultasi);
    // Metode ini akan menerima ID untuk menentukan data yang akan diperbarui,
    // dan objek Konsultasi baru yang berisi data pengganti.

    // Deklarasi metode untuk menghapus data konsultasi berdasarkan ID
    void deleteKonsultasi(int id);
    // Metode ini akan menerima ID untuk menentukan data yang akan dihapus dari penyimpanan.
}
