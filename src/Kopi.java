public class Kopi extends ProdukKopi {
    private String ukuran;
    private String jenisBiji;

    public Kopi(String nama, double harga, int stok, String ukuran, String jenisBiji) {
        super(nama, harga, stok);
        this.ukuran = ukuran;
        this.jenisBiji = jenisBiji;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        if (ukuran != null && !ukuran.trim().isEmpty()) {
            this.ukuran = ukuran;
        } else {
            System.out.println("Ukuran tidak boleh kosong.");
        }
    }

    public String getJenisBiji() {
        return jenisBiji;
    }

    public void setJenisBiji(String jenisBiji) {
        if (jenisBiji != null && !jenisBiji.trim().isEmpty()) {
            this.jenisBiji = jenisBiji;
        } else {
            System.out.println("Jenis biji tidak boleh kosong.");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Jenis Produk : KOPI");
        System.out.println("Nama         : " + getNama());
        System.out.println("Harga        : Rp" + getHarga());
        System.out.println("Stok         : " + getStok());
        System.out.println("Ukuran       : " + ukuran);
        System.out.println("Jenis Biji   : " + jenisBiji);
    }
}