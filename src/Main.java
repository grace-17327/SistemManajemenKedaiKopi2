
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ManajemenKedai kedai = new ManajemenKedai();
        TransaksiKedai transaksi = new TransaksiKedai();

        kedai.tambahProduk(
            new Kopi("Kopi Latte", 25000, 10, "Large", "Arabica")
        );
        kedai.tambahProduk(
            new Kopi("Americano", 20000, 15, "Medium", "Robusta")
        );
        kedai.tambahProduk(
            new NonKopi("Matcha Latte", 22000, 8, "Latte", "Sedang")
        );
        kedai.tambahProduk(
            new NonKopi("Chocolate", 18000, 12, "Cokelat", "Manis")
        );
        kedai.tambahProduk(
            new Makanan("Croissant", 18000, 7, "Pastry", "Sedang")
        );

        kedai.tambahPelanggan(new Pelanggan("PL001", "Andi"));
        kedai.tambahPelanggan(new Pelanggan("PL002", "Siti"));
        kedai.tambahPelanggan(new Pelanggan("PL003", "Budi"));

        int pilihan = 0;

        try {
            do {
                System.out.println("\n==================================");
                System.out.println("     SISTEM MANAJEMEN KEDAI KOPI");
                System.out.println("==================================");
                System.out.println("1. Tambah Data Produk");
                System.out.println("2. Tampilkan Seluruh Produk");
                System.out.println("3. Cari Produk");
                System.out.println("4. Simulasi Proses Produk");
                System.out.println("5. Keluar");
                System.out.println("6. Beri Rating Produk");
                System.out.println("7. Proses Pesanan Produk");
                System.out.println("8. Kelola Data Pelanggan");
                System.out.println("9. Tampilkan Fasilitas Kedai");
                System.out.println("10. Simulasi Transaksi");
                System.out.println("11. Simpan Data");
                System.out.println("12. Muat Data");
                System.out.println("13. Tampilkan Log Aktivitas");
                System.out.println("==================================");
                System.out.print("Pilih menu: ");

                pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {

                    case 1:
                        System.out.print("Nama Produk: ");
                        String nama = input.nextLine();

                        ProdukKopi.validasiProduk(nama);

                        System.out.print("Harga: ");
                        double harga = input.nextDouble();

                        System.out.print("Stok: ");
                        int stok = input.nextInt();
                        input.nextLine();

                        System.out.println("1. Kopi");
                        System.out.println("2. Non Kopi");
                        System.out.println("3. Makanan");
                        System.out.print("Jenis Produk: ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Ukuran: ");
                            String ukuran = input.nextLine();

                            System.out.print("Jenis Biji Kopi: ");
                            String biji = input.nextLine();

                            kedai.tambahProduk(
                                new Kopi(nama, harga, stok, ukuran, biji)
                            );

                        } else if (jenis == 2) {
                            System.out.print("Jenis Minuman: ");
                            String minuman = input.nextLine();

                            System.out.print("Tingkat Rasa: ");
                            String rasa = input.nextLine();

                            kedai.tambahProduk(
                                new NonKopi(nama, harga, stok, minuman, rasa)
                            );

                        } else if (jenis == 3) {
                            System.out.print("Jenis Makanan: ");
                            String makanan = input.nextLine();

                            System.out.print("Ukuran Porsi: ");
                            String porsi = input.nextLine();

                            kedai.tambahProduk(
                                new Makanan(nama, harga, stok, makanan, porsi)
                            );

                        } else {
                            System.out.println("Jenis produk tidak tersedia.");
                        }
                        break;

                    case 2:
                        kedai.tampilkanProduk();
                        break;

                    case 3:
                        System.out.print("Masukkan nama produk: ");
                        String cari = input.nextLine();

                        ProdukKopi hasil = kedai.cariProduk(cari);
                        System.out.println("Produk ditemukan:");
                        hasil.tampilkanInfo();
                        break;

                    case 4:
                        System.out.println("\n=== SIMULASI PRODUK ===");
                        for (ProdukKopi produk : kedai.getDaftarProduk()) {
                            produk.tampilkanInfo();
                            System.out.println("Proses berhasil dilakukan.");
                        }
                        break;

                    case 5:
                        System.out.println("Program selesai.");
                        break;

                    case 6:
                        System.out.println("\n=== RATING PRODUK ===");
                        for (ProdukKopi produk : kedai.getDaftarProduk()) {
                            produk.tampilkanInfo();

                            if (produk instanceof DapatDinilai) {
                                ((DapatDinilai) produk).beriRating();
                            }
                        }
                        break;

                    case 7:
                        System.out.println("\n=== PROSES PESANAN ===");
                        for (ProdukKopi produk : kedai.getDaftarProduk()) {
                            produk.tampilkanInfo();

                            if (produk instanceof DapatDipesan) {
                                ((DapatDipesan) produk).prosesPesanan();
                            }
                        }
                        break;

                    case 8:
                        System.out.println("\n=== KELOLA PELANGGAN ===");
                        System.out.println("1. Tambah Pelanggan");
                        System.out.println("2. Cari Pelanggan");
                        System.out.println("3. Tampilkan Semua Pelanggan");
                        System.out.print("Pilih: ");

                        int menuPelanggan = input.nextInt();
                        input.nextLine();

                        if (menuPelanggan == 1) {
                            System.out.print("ID Pelanggan: ");
                            String id = input.nextLine();

                            System.out.print("Nama Pelanggan: ");
                            String namaPelanggan = input.nextLine();

                            if (id.trim().isEmpty()
                                    || namaPelanggan.trim().isEmpty()) {
                                System.out.println("Data tidak boleh kosong.");
                            } else if (kedai.cariPelanggan(id) != null) {
                                System.out.println("ID sudah terdaftar.");
                            } else {
                                kedai.tambahPelanggan(
                                    new Pelanggan(id, namaPelanggan)
                                );
                                System.out.println("Pelanggan berhasil ditambahkan.");
                            }

                        } else if (menuPelanggan == 2) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String id = input.nextLine();

                            Pelanggan pelanggan = kedai.cariPelanggan(id);

                            if (pelanggan != null) {
                                pelanggan.tampilkanInfo();
                            } else {
                                System.out.println("Pelanggan tidak ditemukan.");
                            }

                        } else if (menuPelanggan == 3) {
                            kedai.tampilkanPelanggan();

                        } else {
                            System.out.println("Pilihan tidak tersedia.");
                        }
                        break;

                    case 9:
                        kedai.tampilkanFasilitas();
                        break;

                    case 10:
                        System.out.print("Masukkan ID Pelanggan: ");
                        String idTransaksi = input.nextLine();

                        Pelanggan pembeli =
                            kedai.cariPelanggan(idTransaksi);

                        if (pembeli == null) {
                            System.out.println("Pelanggan tidak ditemukan.");
                            break;
                        }

                        kedai.tampilkanProduk();

                        System.out.print("Pilih nomor produk: ");
                        int nomor = input.nextInt();
                        input.nextLine();

                        ProdukKopi produkDipilih =
                            kedai.getProduk(nomor - 1);

                        if (produkDipilih == null) {
                            System.out.println("Nomor produk tidak valid.");
                        } else {
                            transaksi.prosesTransaksi(
                                pembeli, produkDipilih
                            );
                            catatLog("Transaksi diproses oleh "
                                + pembeli.getNama() + " untuk produk "
                                + produkDipilih.getNama());
                        }
                        break;

                    case 11:
                        kedai.simpanData("kedai.dat");
                        catatLog("Data produk dan pelanggan disimpan.");
                        break;

                    case 12:
                        kedai.muatData("kedai.dat");
                        break;

                    case 13:
                        tampilkanLog();
                        break;

                    default:
                        System.out.println("Pilihan menu tidak tersedia.");
                }

            } while (pilihan != 5);

        } catch (InputMismatchException e) {
            System.out.println("Kesalahan: Input harus berupa angka.");

        } catch (ProdukTidakDitemukanException e) {
            System.out.println("Pesan Error: " + e.getMessage());

        } finally {
            System.out.println("Program telah mengakhiri proses.");
            input.close();
        }
    }

    // MENULIS LOG AKTIVITAS
    public static void catatLog(String aktivitas) {
        try (FileWriter writer = new FileWriter("aktivitas.txt", true)) {
            writer.write(aktivitas + "\n");
            System.out.println("Log aktivitas berhasil dicatat.");
        } catch (IOException e) {
            System.out.println("Gagal mencatat log: " + e.getMessage());
        }
    }

    // MEMBACA LOG AKTIVITAS
    public static void tampilkanLog() {
        File file = new File("aktivitas.txt");

        if (!file.exists()) {
            System.out.println("File log belum tersedia.");
            return;
        }

        try (Scanner pembaca = new Scanner(file)) {
            System.out.println("\n=== LOG AKTIVITAS ===");

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }

        } catch (IOException e) {
            System.out.println("Gagal membaca log: " + e.getMessage());
        }
    }
}
