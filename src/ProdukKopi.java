public class ProdukKopi {
    private String nama;
    private double harga;
    private int stok;

    private static int jumlahProduk = 0;

    public ProdukKopi(String nama, double harga, int stok) {
        this.nama = nama;
        this.setHarga(harga);
        this.setStok(stok);
        jumlahProduk++;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama produk tidak boleh kosong.");
        }
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih dari 0.");
            this.harga = 0;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif.");
            this.stok = 0;
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("Harga : Rp" + harga);
        System.out.println("Stok  : " + stok);
    }

    public boolean cariProduk(String nama) {
        return this.nama.equalsIgnoreCase(nama);
    }

    public boolean cariProduk(double harga) {
        return this.harga == harga;
    }

    public static int getJumlahProduk() {
        return jumlahProduk;
    }
}