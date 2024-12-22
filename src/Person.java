public class Person {

    // Deklarasi atribut yang bersifat protected
    // Atribut ini dapat diakses oleh kelas ini, subclass-nya, atau kelas dalam package yang sama
    protected String nama;   // Menyimpan nama dari objek Person
    protected String alamat; // Menyimpan alamat dari objek Person

    // Konstruktor untuk menginisialisasi objek Person
    public Person(String nama, String alamat) {
        this.nama = nama;   // Mengatur nilai atribut nama dengan parameter nama
        this.alamat = alamat; // Mengatur nilai atribut alamat dengan parameter alamat
    }

    // Getter untuk mendapatkan nilai atribut nama
    public String getNama() {
        return nama; // Mengembalikan nilai dari atribut nama
    }

    // Getter untuk mendapatkan nilai atribut alamat
    public String getAlamat() {
        return alamat; // Mengembalikan nilai dari atribut alamat
    }
}
