import java.time.LocalDate; // Untuk mendapatkan tanggal saat ini
import java.time.LocalTime; // Untuk mendapatkan waktu saat ini
import java.util.List;      // Untuk bekerja dengan daftar data
import java.util.Scanner;   // Untuk membaca input dari pengguna

public class Main {
    public static void main(String[] args) {
        KonsultasiManager manager = new KonsultasiManager(); // Membuat objek untuk mengelola data konsultasi

        try (Scanner scanner = new Scanner(System.in)) { // Membuka scanner untuk membaca input
            int choice; // Variabel untuk menyimpan pilihan menu pengguna

            do {
                // Menampilkan menu utama
                System.out.println("====================================");
                System.out.println("     Sistem Konsultasi Psikolog     ");
                System.out.println("====================================");
                System.out.println("              MENU                  ");
                System.out.println("1. Tambah Konsultasi");
                System.out.println("2. Tampilkan Semua Konsultasi");
                System.out.println("3. Edit Konsultasi");
                System.out.println("4. Hapus Konsultasi");
                System.out.println("5. Keluar");
                System.out.println("====================================");
                System.out.print("Pilih opsi: ");

                // Validasi input agar hanya menerima angka
                while (!scanner.hasNextInt()) {
                    System.out.println("Input tidak valid. Harap masukkan angka.");
                    scanner.next(); // Membersihkan input yang tidak valid
                    System.out.print("Pilih opsi: ");
                }
                choice = scanner.nextInt(); // Membaca pilihan pengguna
                scanner.nextLine(); // Membersihkan buffer input

                switch (choice) {
                    case 1 -> { // Tambah konsultasi
                        System.out.println("Tambah Konsultasi:");
                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Alamat: ");
                        String alamat = scanner.nextLine();
                        System.out.print("Keluhan: ");
                        String keluhan = scanner.nextLine();
                        System.out.print("Hari: ");
                        String hari = scanner.nextLine();
                        System.out.print("Psikolog: ");
                        String psikolog = scanner.nextLine();

                        // Pemilihan paket konsultasi
                        System.out.println("Pilih paket konsultasi:");
                        System.out.println("1. Paket Hemat (Rp80,000)");
                        System.out.println("2. Paket Fun (Rp100,000)");
                        System.out.println("3. Paket Fantastic (Rp150,000)");
                        System.out.print("Pilih paket (1-3): ");
                        int pilihanPaket = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer input

                        int harga = 0; // Harga default
                        String paket = ""; // Nama paket default
                        switch (pilihanPaket) {
                            case 1 -> { paket = "Paket Hemat"; harga = 80000; }
                            case 2 -> { paket = "Paket Fun"; harga = 100000; }
                            case 3 -> { paket = "Paket Fantastic"; harga = 150000; }
                            default -> { 
                                System.out.println("Paket tidak valid, menggunakan Paket Hemat."); 
                                paket = "Paket Hemat"; 
                                harga = 80000; 
                            }
                        }

                        // Memberikan diskon 30% jika hari Senin
                        if (hari.equalsIgnoreCase("Senin")) {
                            harga -= harga * 30 / 100; // Hitung diskon
                            System.out.println("Diskon 30% diterapkan karena hari Senin.");
                        }

                        System.out.println("Harga setelah diskon: Rp" + harga);

                        // Mendapatkan tanggal dan jam saat ini
                        LocalDate tanggal = LocalDate.now(); 
                        LocalTime jam = LocalTime.now(); 

                        // Membuat objek Konsultasi
                        Konsultasi konsultasi = new Konsultasi(0, nama, alamat, keluhan, hari, psikolog, paket, harga, tanggal.toString(), jam.toString());
                        manager.addKonsultasi(konsultasi); // Menambahkan konsultasi ke database
                        System.out.println("Konsultasi berhasil ditambahkan.");
                    }
                    case 2 -> { // Tampilkan semua konsultasi
                        List<Konsultasi> konsultasiList = manager.getAllKonsultasi(); // Mengambil data dari database
                        if (konsultasiList.isEmpty()) {
                            System.out.println("Tidak ada data konsultasi yang tersedia.");
                        } else {
                            System.out.println("\n====================================================================================================================");
                            System.out.println("                                               Daftar Semua Konsultasi                                              ");
                            System.out.println("====================================================================================================================");
                            System.out.printf("| %-3s | %-15s | %-20s | %-15s | %-5s | %-10s | %-15s | %-10s | %-10s | %-8s |\n",
                                    "ID", "Nama", "Alamat", "Keluhan", "Hari", "Psikolog", "Paket", "Harga", "Tanggal", "Jam");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------");

                            for (Konsultasi k : konsultasiList) {
                                System.out.printf("| %-3d | %-15s | %-20s | %-15s | %-5s | %-10s | %-15s | %-10d | %-10s | %-8s |\n",
                                        k.getId(), k.getNama(), k.getAlamat(), k.getKeluhan(), k.getHari(), k.getPsikolog(),
                                        k.getPaket(), k.getHarga(), k.getTanggal(), k.getJam());
                            }
                            System.out.println("====================================================================================================================\n");
                        }
                    }
                    case 3 -> { // Edit konsultasi
                        System.out.print("Masukkan ID konsultasi yang ingin diperbarui: ");
                        int idUpdate = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer input

                        // Meminta data baru untuk diperbarui
                        System.out.print("Nama: ");
                        String namaUpdate = scanner.nextLine();
                        System.out.print("Alamat: ");
                        String alamatUpdate = scanner.nextLine();
                        System.out.print("Keluhan: ");
                        String keluhanUpdate = scanner.nextLine();
                        System.out.print("Hari: ");
                        String hariUpdate = scanner.nextLine();
                        System.out.print("Psikolog: ");
                        String psikologUpdate = scanner.nextLine();
                        System.out.print("Paket: ");
                        String paketUpdate = scanner.nextLine();
                        System.out.print("Harga: ");
                        int hargaUpdate = scanner.nextInt();
                        scanner.nextLine();

                        // Mendapatkan tanggal dan jam saat ini
                        LocalDate tanggalUpdate = LocalDate.now();
                        LocalTime jamUpdate = LocalTime.now();

                        // Membuat objek Konsultasi yang diperbarui
                        Konsultasi konsultasiUpdate = new Konsultasi(idUpdate, namaUpdate, alamatUpdate, keluhanUpdate, hariUpdate, psikologUpdate, paketUpdate, hargaUpdate, tanggalUpdate.toString(), jamUpdate.toString());
                        manager.updateKonsultasi(idUpdate, konsultasiUpdate); // Memperbarui data di database
                        System.out.println("Konsultasi berhasil diperbarui.");
                    }
                    case 4 -> { // Hapus konsultasi
                        System.out.print("Masukkan ID konsultasi yang ingin dihapus: ");
                        int idDelete = scanner.nextInt();
                        manager.deleteKonsultasi(idDelete); // Menghapus data berdasarkan ID
                        System.out.println("Konsultasi berhasil dihapus.");
                    }
                    case 5 -> System.out.println("Keluar dari program. Terima kasih!"); // Keluar dari program
                    default -> System.out.println("Pilihan tidak valid. Harap pilih opsi dari 1 hingga 5.");
                }
            } while (choice != 5); // Ulangi menu selama pilihan bukan 5
        }
    }
}
