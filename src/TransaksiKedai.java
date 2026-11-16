
public class TransaksiKedai {

    public void prosesTransaksi(Pelanggan pelanggan, ProdukKopi produk) {
        if (pelanggan == null || produk == null) {
            System.out.println("Transaksi gagal! Data tidak ditemukan.");
            return;
        }

        System.out.println("\n=== TRANSAKSI KEDAI KOPI ===");
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Produk yang dipesan:");

        produk.tampilkanInfo();

        System.out.println("Status: Transaksi berhasil diproses.");
    }
}

