
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void simulasiProduk(ProdukKopi produk) {
        System.out.println("\n=== SIMULASI PROSES PRODUK ===");
        produk.tampilkanInfo();
        System.out.println("Proses berhasil dilakukan.");
    }

    public static ProdukKopi cariProduk(
            ArrayList<ProdukKopi> daftarProduk, String nama)
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

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<ProdukKopi> daftarProduk = new ArrayList<>();

        HashMap<String, String> dataPelanggan = new HashMap<>();

        daftarProduk.add(new Kopi("Kopi Latte", 25000, 10, "Large", "Arabica"));
        daftarProduk.add(new Kopi("Americano", 20000, 15, "Medium", "Robusta"));
        daftarProduk.add(new NonKopi("Matcha Latte", 22000, 8, "Latte", "Sedang"));
        daftarProduk.add(new NonKopi("Chocolate", 18000, 12, "Cokelat", "Manis"));
        daftarProduk.add(new Makanan("Croissant", 18000, 7, "Pastry", "Sedang"));

        dataPelanggan.put("PL001", "Andi");
        dataPelanggan.put("PL002", "Siti");
        dataPelanggan.put("PL003", "Budi");

        int pilihan = 0;

        try {

            do {
                System.out.println("\n========================================");
                System.out.println("       SISTEM MANAJEMEN KEDAI KOPI");
                System.out.println("========================================");
                System.out.println("1. Tambah Data Produk");
                System.out.println("2. Tampilkan Seluruh Produk");
                System.out.println("3. Cari Produk");
                System.out.println("4. Simulasi Proses Produk");
                System.out.println("5. Keluar");
                System.out.println("6. Beri Rating Produk");
                System.out.println("7. Proses Pesanan Produk");
                System.out.println("8. Kelola Data Pelanggan");
                System.out.println("========================================");
                System.out.print("Pilih menu: ");

                pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {

                    case 1: {
                        System.out.println("\n=== TAMBAH DATA PRODUK ===");

                        System.out.print("Nama Produk: ");
                        String nama = input.nextLine();

                        ProdukKopi.validasiProduk(nama);

                        System.out.print("Harga: ");
                        double harga = input.nextDouble();

                        System.out.print("Stok: ");
                        int stok = input.nextInt();
                        input.nextLine();

                        System.out.println("Jenis Produk:");
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
                                new NonKopi(nama, harga, stok,
                                    jenisMinuman, tingkatRasa)
                            );

                        } else if (jenis == 3) {
                            System.out.print("Jenis Makanan: ");
                            String jenisMakanan = input.nextLine();

                            System.out.print("Ukuran Porsi: ");
                            String ukuranPorsi = input.nextLine();

                            daftarProduk.add(
                                new Makanan(nama, harga, stok,
                                    jenisMakanan, ukuranPorsi)
                            );

                        } else {
                            System.out.println("Jenis produk tidak tersedia.");
                        }

                        break;
                    }

                    case 2: {
                        System.out.println("\n=== SELURUH DATA PRODUK ===");

                        if (daftarProduk.isEmpty()) {
                            System.out.println("Belum ada data produk.");
                        } else {
                            for (int i = 0; i < daftarProduk.size(); i++) {
                                daftarProduk.get(i).tampilkanInfo();
                            }
                        }

                        System.out.println("--------------------------------");
                        System.out.println(
                            "Total produk: " + daftarProduk.size()
                        );

                        break;
                    }

                    case 3: {
                        System.out.println("\n=== CARI PRODUK ===");
                        System.out.print("Masukkan nama produk: ");

                        String namaCari = input.nextLine();

                        ProdukKopi hasil = cariProduk(
                            daftarProduk, namaCari
                        );

                        System.out.println("Produk ditemukan:");
                        hasil.tampilkanInfo();

                        break;
                    }

                    case 4: {
                        System.out.println("\n=== SIMULASI PROSES PRODUK ===");

                        if (daftarProduk.isEmpty()) {
                            System.out.println("Belum ada produk.");
                        } else {
                            for (ProdukKopi produk : daftarProduk) {
                                simulasiProduk(produk);
                            }
                        }

                        break;
                    }

                    case 5: {
                        System.out.println("\nProgram selesai.");
                        break;
                    }

                    case 6: {
                        System.out.println("\n=== RATING PRODUK ===");

                        for (ProdukKopi produk : daftarProduk) {
                            produk.tampilkanInfo();

                            if (produk instanceof DapatDinilai) {
                                ((DapatDinilai) produk).beriRating();
                            }
                        }

                        break;
                    }

                    case 7: {
                        System.out.println("\n=== PROSES PESANAN ===");

                        for (ProdukKopi produk : daftarProduk) {
                            produk.tampilkanInfo();

                            if (produk instanceof DapatDipesan) {
                                ((DapatDipesan) produk).prosesPesanan();
                            }
                        }

                        break;
                    }

                    case 8: {
                        System.out.println("\n=== KELOLA DATA PELANGGAN ===");
                        System.out.println("1. Tambah Pelanggan");
                        System.out.println("2. Cari Pelanggan");
                        System.out.println("3. Tampilkan Semua Pelanggan");
                        System.out.print("Pilih: ");

                        int pilihanPelanggan = input.nextInt();
                        input.nextLine();

                        if (pilihanPelanggan == 1) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String id = input.nextLine();

                            System.out.print("Masukkan Nama Pelanggan: ");
                            String nama = input.nextLine();

                            if (id.trim().isEmpty() || nama.trim().isEmpty()) {
                                System.out.println(
                                    "ID dan nama tidak boleh kosong."
                                );
                            } else if (dataPelanggan.containsKey(id)) {
                                System.out.println(
                                    "ID pelanggan sudah terdaftar."
                                );
                            } else {
                                dataPelanggan.put(id, nama);
                                System.out.println(
                                    "Data pelanggan berhasil ditambahkan."
                                );
                            }

                        } else if (pilihanPelanggan == 2) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String id = input.nextLine();

                            if (dataPelanggan.containsKey(id)) {
                                System.out.println(
                                    "Nama Pelanggan: " + dataPelanggan.get(id)
                                );
                            } else {
                                System.out.println(
                                    "Pelanggan tidak ditemukan."
                                );
                            }

                        } else if (pilihanPelanggan == 3) {
                            System.out.println("\n=== DAFTAR PELANGGAN ===");
                            System.out.println(
                                "Jumlah pelanggan: " + dataPelanggan.size()
                            );

                            for (String id : dataPelanggan.keySet()) {
                                System.out.println(
                                    id + " - " + dataPelanggan.get(id)
                                );
                            }

                        } else {
                            System.out.println("Pilihan tidak tersedia.");
                        }

                        break;
                    }

                    default:
                        System.out.println("Pilihan menu tidak tersedia.");
                }

            } while (pilihan != 5);

        } catch (InputMismatchException e) {
            System.out.println(
                "\nKesalahan: Input harus menggunakan tipe data yang benar."
            );

        } catch (ProdukTidakDitemukanException e) {
            System.out.println("\nPesan Error: " + e.getMessage());

        } finally {
            System.out.println("\nBlok finally: Program telah mengakhiri proses.");
            input.close();
        }
    }
}
