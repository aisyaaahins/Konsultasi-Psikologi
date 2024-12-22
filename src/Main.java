import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KonsultasiManager manager = new KonsultasiManager();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
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

                // Validasi input angka
                while (!scanner.hasNextInt()) {
                    System.out.println("Input tidak valid. Harap masukkan angka.");
                    scanner.next();
                    System.out.print("Pilih opsi: ");
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Bersihkan buffer

                switch (choice) {
                    case 1 -> {
                        // Tambah konsultasi
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
                        
                        // Pemilihan paket
                        System.out.println("Pilih paket konsultasi:");
                        System.out.println("1. Paket Hemat (Rp80,000)");
                        System.out.println("2. Paket Fun (Rp100,000)");
                        System.out.println("3. Paket Fantastic (Rp150,000)");
                        System.out.print("Pilih paket (1-3): ");
                        int pilihanPaket = scanner.nextInt();
                        scanner.nextLine(); // Bersihkan buffer
                        
                        // Menentukan harga berdasarkan paket yang dipilih
                        int harga = 0;
                        String paket = "";
                        switch (pilihanPaket) {
                            case 1 -> {
                                paket = "Paket Hemat";
                                harga = 80000;
                            }
                            case 2 -> {
                                paket = "Paket Fun";
                                harga = 100000;
                            }
                            case 3 -> {
                                paket = "Paket Fantastic";
                                harga = 150000;
                            }
                            default -> {
                                System.out.println("Paket tidak valid, menggunakan Paket Hemat.");
                                paket = "Paket Hemat";
                                harga = 80000;
                            }
                        }

                        // Logika diskon jika hari Senin
                        if (hari.equalsIgnoreCase("Senin")) {
                            harga -= harga * 30 / 100; // Diskon 30% pada hari Senin
                            System.out.println("Diskon 30% diterapkan karena hari Senin.");
                        }

                        // Tampilkan harga total setelah diskon (jika ada)
                        System.out.println("Harga setelah diskon: Rp" + harga);

                        // Tanggal otomatis (hari ini)
                        LocalDate tanggal = LocalDate.now();
                        System.out.println("Tanggal: " + tanggal);

                        // Jam otomatis (waktu saat ini)
                        LocalTime jam = LocalTime.now();
                        System.out.println("Jam: " + jam.truncatedTo(java.time.temporal.ChronoUnit.SECONDS));

                        // Membuat objek Konsultasi dengan harga yang sudah dihitung
                        Konsultasi konsultasi = new Konsultasi(0, nama, alamat, keluhan, hari, psikolog, paket, harga, tanggal.toString(), jam.toString());
                        manager.addKonsultasi(konsultasi);
                        System.out.println("Konsultasi berhasil ditambahkan.");
                    }
                    case 2 -> {
                        // Tampilkan semua konsultasi
                        List<Konsultasi> konsultasiList = manager.getAllKonsultasi();
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
                    case 3 -> {
                        // Edit konsultasi
                        System.out.print("Masukkan ID konsultasi yang ingin diperbarui: ");
                        int idUpdate = scanner.nextInt();
                        scanner.nextLine();
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
                        Integer hargaUpdate = scanner.nextInt();
                        scanner.nextLine();

                        // Tanggal otomatis (hari ini)
                        LocalDate tanggalUpdate = LocalDate.now();
                        System.out.println("Tanggal: " + tanggalUpdate);

                        // Jam otomatis (waktu saat ini)
                        // Jam otomatis (waktu saat ini)
                        LocalTime jamUpdate = LocalTime.now();
                        System.out.println("Jam: " + jamUpdate.truncatedTo(java.time.temporal.ChronoUnit.SECONDS));

                        Konsultasi konsultasiUpdate = new Konsultasi(idUpdate, namaUpdate, alamatUpdate, keluhanUpdate, hariUpdate,
                                psikologUpdate, paketUpdate, hargaUpdate, tanggalUpdate.toString(), jamUpdate.toString());
                        manager.updateKonsultasi(idUpdate, konsultasiUpdate);
                        System.out.println("Konsultasi berhasil diperbarui.");
                    }
                    case 4 -> {
                        // Hapus konsultasi
                        System.out.print("Masukkan ID konsultasi yang ingin dihapus: ");
                        int idDelete = scanner.nextInt();
                        manager.deleteKonsultasi(idDelete);
                        System.out.println("Konsultasi berhasil dihapus.");
                    }
                    case 5 -> System.out.println("Keluar dari program. Terima kasih!");
                    default -> System.out.println("Pilihan tidak valid. Harap pilih opsi dari 1 hingga 5.");
                }
            } while (choice != 5);
        }
    }
}
