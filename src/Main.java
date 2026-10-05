import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
            System.out.println("4. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- TAMBAH DATA PRODUK ---");
                    System.out.println("1. Kopi");
                    System.out.println("2. Non-Kopi");
                    System.out.print("Pilih tipe produk: ");
                    int tipe = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama produk: ");
                    String nama = input.nextLine();

                    System.out.print("Harga: ");
                    double harga = input.nextDouble();

                    System.out.print("Stok: ");
                    int stok = input.nextInt();
                    input.nextLine();

                    if (harga <= 0 || stok < 0) {
                        System.out.println("Data harga atau stok tidak valid.");
                        break;
                    }

                    if (tipe == 1) {
                        System.out.print("Ukuran: ");
                        String ukuran = input.nextLine();

                        System.out.print("Jenis biji: ");
                        String jenisBiji = input.nextLine();

                        daftarProduk.add(
                            new Kopi(nama, harga, stok, ukuran, jenisBiji)
                        );

                        System.out.println("Data kopi berhasil ditambahkan.");

                    } else if (tipe == 2) {
                        System.out.print("Jenis minuman: ");
                        String jenisMinuman = input.nextLine();

                        System.out.print("Level manis: ");
                        String levelManis = input.nextLine();

                        daftarProduk.add(
                            new NonKopi(nama, harga, stok, jenisMinuman, levelManis)
                        );

                        System.out.println("Data non-kopi berhasil ditambahkan.");

                    } else {
                        System.out.println("Tipe produk tidak tersedia.");
                    }
                    break;

                case 2:
                    System.out.println("\n========================================");
                    System.out.println("          DAFTAR SELURUH PRODUK");
                    System.out.println("========================================");

                    if (daftarProduk.isEmpty()) {
                        System.out.println("Belum ada data produk.");
                    } else {
                        for (ProdukKopi produk : daftarProduk) {
                            produk.tampilkanInfo();
                        }
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Total objek produk: "
                            + ProdukKopi.getJumlahProduk());
                    break;

                case 3:
                    System.out.println("\n--- PENCARIAN PRODUK ---");
                    System.out.println("1. Cari berdasarkan nama");
                    System.out.println("2. Cari berdasarkan harga");
                    System.out.print("Pilih metode pencarian: ");

                    int metode = input.nextInt();
                    input.nextLine();

                    boolean ditemukan = false;

                    if (metode == 1) {
                        System.out.print("Masukkan nama produk: ");
                        String namaCari = input.nextLine();

                        for (ProdukKopi produk : daftarProduk) {
                            if (produk.cariProduk(namaCari)) {
                                produk.tampilkanInfo();
                                ditemukan = true;
                            }
                        }

                    } else if (metode == 2) {
                        System.out.print("Masukkan harga produk: ");
                        double hargaCari = input.nextDouble();

                        for (ProdukKopi produk : daftarProduk) {
                            if (produk.cariProduk(hargaCari)) {
                                produk.tampilkanInfo();
                                ditemukan = true;
                            }
                        }

                    } else {
                        System.out.println("Metode pencarian tidak tersedia.");
                        break;
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("\nTerima kasih telah menggunakan");
                    System.out.println("Sistem Manajemen Kedai Kopi.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 4);

        input.close();
    }
}
