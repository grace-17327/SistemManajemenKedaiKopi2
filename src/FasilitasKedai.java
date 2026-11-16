
public class FasilitasKedai {
    private String namaFasilitas;
    private int kapasitas;

    public FasilitasKedai(String namaFasilitas, int kapasitas) {
        this.namaFasilitas = namaFasilitas;
        this.kapasitas = kapasitas;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Fasilitas: " + namaFasilitas);
        System.out.println("Kapasitas: " + kapasitas + " orang");
    }
}
