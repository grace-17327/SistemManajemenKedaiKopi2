import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void simulasiProduk(ProdukKopi produk) {
        System.out.println("\n=== SIMULASI PROSES PRODUK ===");
        produk.tampilkanInfo();
        System.out.println("Proses berhasil dilakukan.");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<ProdukKopi> daftarProduk = new ArrayList<>();

        daftarProduk.add(new Kopi("Kopi Latte", 25000, 10, "Large", "Arabica"));
        daftarProduk.add(new Kopi("Americano", 20000, 15, "Medium", "Robusta"));
        daftarProduk.add(new NonKopi("Matcha Latte", 22000, 8, "Latte", "Sedang"));
        daftarProduk.add(new NonKopi("Chocolate", 18000, 12, "Cokelat", "Manis"));
        daftarProduk.add(new Makanan("Croissant", 18000, 7, "Pastry", "Sedang"));

        int pilihan;

        do {
            System.out.println("\n========================================");
            System.out.println("       SISTEM MANAJEMEN KEDAI KOPI");
            System.out.println("========================================");
            System.out.println("1. Tambah Data Baru");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Cari Produk");
            System.out.println("4. Simulasi Proses Produk");
            System.out.println("5. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    System.out.println("\n=== TAMBAH DATA BARU ===");
                    System.out.print("Nama Produk: ");
                    String nama = input.nextLine();

                    System.out.print("Harga: ");
                    double harga = input.nextDouble();

                    System.out.print("Stok: ");
                    int stok = input.nextInt();
                    input.nextLine();

                    System.out.println("Pilih Jenis Produk:");
                    System.out.println("1. Kopi");
                    System.out.println("2. Non Kopi");
                    System.out.println("3. Makanan");
                    System.out.print("Pilihan: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {
                        System.out.print("Ukuran: ");
                        String ukuran = input.nextLine();

                        System.out.print("Jenis Biji Kopi: ");
                        String jenisBiji = input.nextLine();

                        daftarProduk.add(
                            new Kopi(nama, harga, stok, ukuran, jenisBiji)
                        );

                    } else if (jenis == 2) {
                        System.out.print("Jenis Minuman: ");
                        String jenisMinuman = input.nextLine();

                        System.out.print("Tingkat Rasa: ");
                        String tingkatRasa = input.nextLine();

                        daftarProduk.add(
                            new NonKopi(nama, harga, stok, jenisMinuman, tingkatRasa)
                        );

                    } else if (jenis == 3) {
                        System.out.print("Jenis Makanan: ");
                        String jenisMakanan = input.nextLine();

                        System.out.print("Ukuran Porsi: ");
                        String ukuranPorsi = input.nextLine();

                        daftarProduk.add(
                            new Makanan(nama, harga, stok, jenisMakanan, ukuranPorsi)
                        );

                    } else {
                        System.out.println("Jenis produk tidak tersedia.");
                    }

                    break;

                case 2:
                    System.out.println("\n=== SELURUH DATA PRODUK ===");

                    ProdukKopi[] daftarArray =
                            daftarProduk.toArray(new ProdukKopi[0]);

                    for (ProdukKopi produk : daftarArray) {
                        produk.tampilkanInfo();
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Total objek produk: "
                            + ProdukKopi.getJumlahProduk());

                    break;

                case 3:
                    System.out.println("\n=== CARI PRODUK ===");
                    System.out.println("1. Cari berdasarkan nama");
                    System.out.println("2. Cari berdasarkan harga");
                    System.out.print("Pilih: ");
                    int pilihanCari = input.nextInt();
                    input.nextLine();

                    if (pilihanCari == 1) {

                        System.out.print("Masukkan nama produk: ");
                        String namaCari = input.nextLine();

                        boolean ditemukan = false;

                        for (ProdukKopi produk : daftarProduk) {
                            if (produk.cariProduk(namaCari)) {
                                produk.tampilkanInfo();
                                ditemukan = true;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Produk tidak ditemukan.");
                        }

                    } else if (pilihanCari == 2) {

                        System.out.print("Masukkan harga produk: ");
                        double hargaCari = input.nextDouble();

                        boolean ditemukan = false;

                        for (ProdukKopi produk : daftarProduk) {
                            if (produk.cariProduk(hargaCari)) {
                                produk.tampilkanInfo();
                                ditemukan = true;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Produk tidak ditemukan.");
                        }

                    } else {
                        System.out.println("Pilihan tidak tersedia.");
                    }

                    break;

                case 4:
                    System.out.println("\n=== SIMULASI PROSES PRODUK ===");

                    ProdukKopi[] arraySimulasi =
                            daftarProduk.toArray(new ProdukKopi[0]);

                    for (ProdukKopi produk : arraySimulasi) {
                        simulasiProduk(produk);
                    }

                    break;

                case 5:
                    System.out.println("\nProgram selesai.");
                    break;

                default:
                    System.out.println("\nPilihan menu tidak tersedia.");
            }

        } while (pilihan != 5);

        input.close();
    }
}
