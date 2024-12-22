import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KonsultasiManager implements KonsultasiService {
    private Connection connection;

    public KonsultasiManager() {
        connect();
    }

    private void connect() {
        // Ganti dengan URL, username, dan password database Anda
        String url = "jdbc:mysql://localhost:3306/db_konsultasi"; // Ganti dengan nama database Anda
        String user = "root"; // Ganti dengan username database Anda
        String password = ""; // Ganti dengan password database Anda
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
    }

    @Override
    public void addKonsultasi(Konsultasi konsultasi) {
        String sql = "INSERT INTO Konsultasi (Nama, Alamat, Keluhan, Hari, Psikolog, Paket, Harga, Tanggal, Jam) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, konsultasi.getNama());
            pstmt.setString(2, konsultasi.getAlamat());
            pstmt.setString(3, konsultasi.getKeluhan());
            pstmt.setString(4, konsultasi.getHari());
            pstmt.setString(5, konsultasi.getPsikolog());
            pstmt.setString(6, konsultasi.getPaket());
            pstmt.setDouble(7, konsultasi.getHarga());
            pstmt.setString(8, konsultasi.getTanggal());
            pstmt.setString(9, konsultasi.getJam());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saat menambahkan konsultasi: " + e.getMessage());
        }
    }

    @Override
    public List<Konsultasi> getAllKonsultasi() {
        List<Konsultasi> konsultasiList = new ArrayList<>();
        String sql = "SELECT * FROM Konsultasi";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
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
                konsultasiList.add(konsultasi);
            }
        } catch (SQLException e) {
            System.out.println("Error saat mengambil semua konsultasi: " + e.getMessage());
        }
        return konsultasiList;
    }

    @Override
    public void updateKonsultasi(int id, Konsultasi konsultasi) {
        String sql = "UPDATE Konsultasi SET Nama = ?, Alamat = ?, Keluhan = ?, Hari = ?, Psikolog = ?, Paket = ?, Harga = ?, Tanggal = ?, Jam = ? WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, konsultasi.getNama());
            pstmt.setString(2, konsultasi.getAlamat());
            pstmt.setString(3, konsultasi.getKeluhan());
            pstmt.setString(4, konsultasi.getHari());
            pstmt.setString(5, konsultasi.getPsikolog());
            pstmt.setString(6, konsultasi.getPaket());
            pstmt.setDouble(7, konsultasi.getHarga());
            pstmt.setString(8, konsultasi.getTanggal());
            pstmt.setString(9, konsultasi.getJam());
            pstmt.setInt(10, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saat memperbarui konsultasi: " + e.getMessage());
        }
    }

    @Override
    public void deleteKonsultasi(int id) {
        String sql = "DELETE FROM Konsultasi WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saat menghapus konsultasi: " + e.getMessage());
        }
    }
}
