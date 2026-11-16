
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;

public class ManajemenKedai implements Serializable {

    private static final long serialVersionUID = 1L;

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

    // SERIALIZATION
    public void simpanData(String namaFile) {
        try (ObjectOutputStream output =
                new ObjectOutputStream(
                    new FileOutputStream(namaFile))) {

            ArrayList<Object> data = new ArrayList<>();
            data.add(daftarProduk);
            data.add(dataPelanggan);

            output.writeObject(data);

            System.out.println("Data berhasil disimpan ke " + namaFile);

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    // DESERIALIZATION
    @SuppressWarnings("unchecked")
    public void muatData(String namaFile) {
        try (ObjectInputStream input =
                new ObjectInputStream(
                    new FileInputStream(namaFile))) {

            ArrayList<Object> data =
                    (ArrayList<Object>) input.readObject();

            daftarProduk = (ArrayList<ProdukKopi>) data.get(0);
            dataPelanggan = (HashMap<String, Pelanggan>) data.get(1);

            System.out.println("Data berhasil dimuat dari " + namaFile);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }
}
