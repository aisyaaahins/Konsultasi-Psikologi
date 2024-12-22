// KonsultasiService.java
import java.util.List;

public interface KonsultasiService {
    void addKonsultasi(Konsultasi konsultasi);
    List<Konsultasi> getAllKonsultasi();
    void updateKonsultasi(int id, Konsultasi konsultasi);
    void deleteKonsultasi(int id);
}