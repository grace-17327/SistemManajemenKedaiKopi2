
import java.util.ArrayList;
import java.util.HashMap;

public class ManajemenKedai {

    // Composition
    private FasilitasKedai fasilitas;

    // Aggregation
    private ArrayList<ProdukKopi> daftarProduk;
    private HashMap<String, Pelanggan> dataPelanggan;

    public ManajemenKedai() {
        fasilitas = new FasilitasKedai("Ruang Kedai Kopi", 30);
        daftarProduk = new ArrayList<>();
        dataPelanggan = new HashMap<>();
    }

    public void tampilkanFasilitas() {
        System.out.println("\n=== FASILITAS KEDAI ===");
        fasilitas.tampilkanInfo();
    }

    public void tambahProduk(ProdukKopi produk) {
        daftarProduk.add(produk);
    }

    public void tampilkanProduk() {
        System.out.println("\n=== DAFTAR PRODUK ===");

        for (ProdukKopi produk : daftarProduk) {
            produk.tampilkanInfo();
        }

        System.out.println("Total produk: " + daftarProduk.size());
    }

    public ArrayList<ProdukKopi> getDaftarProduk() {
        return daftarProduk;
    }

    public ProdukKopi cariProduk(String nama)
            throws ProdukTidakDitemukanException {

        ProdukKopi.validasiProduk(nama);

        for (ProdukKopi produk : daftarProduk) {
            if (produk.cariProduk(nama)) {
                return produk;
            }
        }

        throw new ProdukTidakDitemukanException(
            "Produk dengan nama " + nama + " tidak ditemukan."
        );
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        dataPelanggan.put(pelanggan.getIdPelanggan(), pelanggan);
    }

    public Pelanggan cariPelanggan(String id) {
        return dataPelanggan.get(id);
    }

    public void tampilkanPelanggan() {
        System.out.println("\n=== DATA PELANGGAN ===");

        for (Pelanggan pelanggan : dataPelanggan.values()) {
            pelanggan.tampilkanInfo();
        }

        System.out.println("Total pelanggan: " + dataPelanggan.size());
    }

    public ProdukKopi getProduk(int index) {
        if (index >= 0 && index < daftarProduk.size()) {
            return daftarProduk.get(index);
        }

        return null;
    }

    public int getJumlahProduk() {
        return daftarProduk.size();
    }
}

