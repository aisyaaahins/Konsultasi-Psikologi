import java.sql.*; // Untuk koneksi dan manipulasi database menggunakan JDBC
import java.util.ArrayList; // Untuk penggunaan list dinamis
import java.util.List; // Antarmuka List untuk menampung data

// Kelas KonsultasiManager mengimplementasikan interface KonsultasiService
public class KonsultasiManager implements KonsultasiService {
    private Connection connection; // Objek untuk mengelola koneksi ke database

    // Constructor untuk menginisialisasi koneksi database
    public KonsultasiManager() {
        connect(); // Memanggil metode connect() untuk membuat koneksi ke database
    }

    // Metode untuk menghubungkan aplikasi ke database
    private void connect() {
        // Ganti dengan URL, username, dan password database Anda
        String url = "jdbc:mysql://localhost:3306/db_konsultasi"; // URL database
        String user = "root"; // Username database
        String password = ""; // Password database
        try {
            // Membuat koneksi ke database menggunakan DriverManager
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Menangani jika koneksi database gagal
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
    }

    // Implementasi metode untuk menambahkan data konsultasi ke database
    @Override
    public void addKonsultasi(Konsultasi konsultasi) {
        // Query SQL untuk memasukkan data ke tabel Konsultasi
        String sql = "INSERT INTO Konsultasi (Nama, Alamat, Keluhan, Hari, Psikolog, Paket, Harga, Tanggal, Jam) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Mengisi parameter query dengan data dari objek Konsultasi
            pstmt.setString(1, konsultasi.getNama());
            pstmt.setString(2, konsultasi.getAlamat());
            pstmt.setString(3, konsultasi.getKeluhan());
            pstmt.setString(4, konsultasi.getHari());
            pstmt.setString(5, konsultasi.getPsikolog());
            pstmt.setString(6, konsultasi.getPaket());
            pstmt.setDouble(7, konsultasi.getHarga());
            pstmt.setString(8, konsultasi.getTanggal());
            pstmt.setString(9, konsultasi.getJam());
            pstmt.executeUpdate(); // Menjalankan query
        } catch (SQLException e) {
            // Menangani kesalahan jika terjadi error saat memasukkan data
            System.out.println("Error saat menambahkan konsultasi: " + e.getMessage());
        }
    }

    // Implementasi metode untuk mengambil semua data konsultasi dari database
    @Override
    public List<Konsultasi> getAllKonsultasi() {
        List<Konsultasi> konsultasiList = new ArrayList<>(); // List untuk menyimpan data konsultasi
        String sql = "SELECT * FROM Konsultasi"; // Query SQL untuk mengambil semua data
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Iterasi melalui hasil query
            while (rs.next()) {
                // Membuat objek Konsultasi dari data hasil query
                Konsultasi konsultasi = new Konsultasi(
                    rs.getInt("ID"),
                    rs.getString("Nama"),
                    rs.getString("Alamat"),
                    rs.getString("Keluhan"),
                    rs.getString("Hari"),
                    rs.getString("Psikolog"),
                    rs.getString("Paket"),
                    rs.getInt("Harga"),
                    rs.getString("Tanggal"),
                    rs.getString("Jam")
                );
                konsultasiList.add(konsultasi); // Menambahkan objek ke list
            }
        } catch (SQLException e) {
            // Menangani kesalahan jika terjadi error saat mengambil data
            System.out.println("Error saat mengambil semua konsultasi: " + e.getMessage());
        }
        return konsultasiList; // Mengembalikan list data konsultasi
    }

    // Implementasi metode untuk memperbarui data konsultasi berdasarkan ID
    @Override
    public void updateKonsultasi(int id, Konsultasi konsultasi) {
        // Query SQL untuk memperbarui data konsultasi berdasarkan ID
        String sql = "UPDATE Konsultasi SET Nama = ?, Alamat = ?, Keluhan = ?, Hari = ?, Psikolog = ?, Paket = ?, Harga = ?, Tanggal = ?, Jam = ? WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Mengisi parameter query dengan data dari objek Konsultasi
            pstmt.setString(1, konsultasi.getNama());
            pstmt.setString(2, konsultasi.getAlamat());
            pstmt.setString(3, konsultasi.getKeluhan());
            pstmt.setString(4, konsultasi.getHari());
            pstmt.setString(5, konsultasi.getPsikolog());
            pstmt.setString(6, konsultasi.getPaket());
            pstmt.setDouble(7, konsultasi.getHarga());
            pstmt.setString(8, konsultasi.getTanggal());
            pstmt.setString(9, konsultasi.getJam());
            pstmt.setInt(10, id); // Parameter ID untuk menentukan data yang diperbarui
            pstmt.executeUpdate(); // Menjalankan query
        } catch (SQLException e) {
            // Menangani kesalahan jika terjadi error saat memperbarui data
            System.out.println("Error saat memperbarui konsultasi: " + e.getMessage());
        }
    }

    // Implementasi metode untuk menghapus data konsultasi berdasarkan ID
    @Override
    public void deleteKonsultasi(int id) {
        // Query SQL untuk menghapus data konsultasi berdasarkan ID
        String sql = "DELETE FROM Konsultasi WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id); // Parameter ID untuk menentukan data yang dihapus
            pstmt.executeUpdate(); // Menjalankan query
        } catch (SQLException e) {
            // Menangani kesalahan jika terjadi error saat menghapus data
            System.out.println("Error saat menghapus konsultasi: " + e.getMessage());
        }
    }
}
