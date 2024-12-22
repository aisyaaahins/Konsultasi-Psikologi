// Deklarasi kelas Konsultasi yang merupakan turunan dari kelas Person
public class Konsultasi extends Person {
    // Deklarasi atribut private untuk menyimpan data spesifik konsultasi
    private final int id;           // ID unik untuk setiap konsultasi
    private final String keluhan;   // Keluhan pasien yang akan dikonsultasikan
    private final String hari;      // Hari konsultasi
    private final String psikolog;  // Nama psikolog yang menangani
    private final String paket;     // Paket layanan konsultasi yang dipilih
    private final Integer harga;    // Harga paket konsultasi
    private final String tanggal;   // Tanggal pelaksanaan konsultasi
    private final String jam;       // Waktu pelaksanaan konsultasi

    // Constructor untuk menginisialisasi semua atribut kelas
    public Konsultasi(int id, String nama, String alamat, String keluhan, String hari, String psikolog, String paket, int harga, String tanggal, String jam) {
        super(nama, alamat); // Memanggil constructor dari superclass (Person) untuk menginisialisasi atribut nama dan alamat
        this.id = id;           // Inisialisasi ID
        this.keluhan = keluhan; // Inisialisasi keluhan
        this.hari = hari;       // Inisialisasi hari konsultasi
        this.psikolog = psikolog; // Inisialisasi nama psikolog
        this.paket = paket;     // Inisialisasi paket layanan
        this.harga = harga;     // Inisialisasi harga paket
        this.tanggal = tanggal; // Inisialisasi tanggal konsultasi
        this.jam = jam;         // Inisialisasi waktu konsultasi
    }

    // Getter untuk mendapatkan ID konsultasi
    public int getId() { 
        return id; 
    }

    // Getter untuk mendapatkan keluhan
    public String getKeluhan() { 
        return keluhan; 
    }

    // Getter untuk mendapatkan hari konsultasi
    public String getHari() { 
        return hari; 
    }

    // Getter untuk mendapatkan nama psikolog
    public String getPsikolog() { 
        return psikolog; 
    }

    // Getter untuk mendapatkan paket layanan
    public String getPaket() { 
        return paket; 
    }

    // Getter untuk mendapatkan harga paket
    public Integer getHarga() { 
        return harga; 
    }

    // Getter untuk mendapatkan tanggal konsultasi
    public String getTanggal() { 
        return tanggal; 
    }

    // Getter untuk mendapatkan jam konsultasi
    public String getJam() { 
        return jam; 
    }

    // Override metode toString untuk memberikan representasi string dari objek Konsultasi
    @Override
    public String toString() {
        // Menggabungkan semua atribut menjadi string yang mudah dibaca
        return "ID: " + id 
                + ", Nama: " + getNama() // Menggunakan metode getNama() dari superclass (Person)
                + ", Alamat: " + getAlamat() // Menggunakan metode getAlamat() dari superclass (Person)
                + ", Keluhan: " + keluhan 
                + ", Hari: " + hari 
                + ", Psikolog: " + psikolog 
                + ", Paket: " + paket 
                + ", Harga: " + harga 
                + ", Tanggal: " + tanggal 
                + ", Jam: " + jam;
    }
}
