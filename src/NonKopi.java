public class NonKopi extends ProdukKopi {
    private String jenisMinuman;
    private String levelManis;

    public NonKopi(String nama, double harga, int stok, String jenisMinuman, String levelManis) {
        super(nama, harga, stok);
        this.jenisMinuman = jenisMinuman;
        this.levelManis = levelManis;
    }

    public String getJenisMinuman() {
        return jenisMinuman;
    }

    public void setJenisMinuman(String jenisMinuman) {
        if (jenisMinuman != null && !jenisMinuman.trim().isEmpty()) {
            this.jenisMinuman = jenisMinuman;
        } else {
            System.out.println("Jenis minuman tidak boleh kosong.");
        }
    }

    public String getLevelManis() {
        return levelManis;
    }

    public void setLevelManis(String levelManis) {
        if (levelManis != null && !levelManis.trim().isEmpty()) {
            this.levelManis = levelManis;
        } else {
            System.out.println("Level manis tidak boleh kosong.");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Jenis Produk : NON-KOPI");
        System.out.println("Nama         : " + getNama());
        System.out.println("Harga        : Rp" + getHarga());
        System.out.println("Stok         : " + getStok());
        System.out.println("Jenis Minuman: " + jenisMinuman);
        System.out.println("Level Manis  : " + levelManis);
    }
}