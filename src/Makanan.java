public class Makanan extends ProdukKopi {

    private String namaMakanan;
    private double hargaMakanan;
    private int stokMakanan;
    private String jenisMakanan;
    private String ukuranPorsi;

    public Makanan(String nama, double harga, int stok, String jenisMakanan, String ukuranPorsi) {
        super(nama, harga, stok);
        this.namaMakanan = nama;
        this.hargaMakanan = harga;
        this.stokMakanan = stok;
        this.jenisMakanan = jenisMakanan;
        this.ukuranPorsi = ukuranPorsi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Jenis Produk : MAKANAN");
        System.out.println("Nama         : " + namaMakanan);
        System.out.println("Harga        : Rp" + String.format("%.0f", hargaMakanan));
        System.out.println("Stok         : " + stokMakanan);
        System.out.println("Jenis Makanan: " + jenisMakanan);
        System.out.println("Ukuran Porsi : " + ukuranPorsi);
    }
}
