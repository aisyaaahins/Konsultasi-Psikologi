public class Konsultasi extends Person {
    private final int id;
    private final String keluhan;
    private final String hari;
    private final String psikolog;
    private final String paket;
    private final Integer harga;
    private final String tanggal;
    private final String jam;

    public Konsultasi(int id, String nama, String alamat, String keluhan, String hari, String psikolog, String paket, int harga, String tanggal, String jam) {
        super(nama, alamat); // Memanggil constructor superclass
        this.id = id;
        this.keluhan = keluhan;
        this.hari = hari;
        this.psikolog = psikolog;
        this.paket = paket;
        this.harga = harga;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    // Getters
    public int getId() { return id; }
    public String getKeluhan() { return keluhan; }
    public String getHari() { return hari; }
    public String getPsikolog() { return psikolog; }
    public String getPaket() { return paket; }
    public Integer getHarga() { return harga; }
    public String getTanggal() { return tanggal; }
    public String getJam() { return jam; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + getNama() + ", Alamat: " + getAlamat() + ", Keluhan: " + keluhan + ", Hari: " + hari + ", Psikolog: " + psikolog + ", Paket: " + paket + ", Harga: " + harga + ", Tanggal: " + tanggal + ", Jam: " + jam;
    }
}

