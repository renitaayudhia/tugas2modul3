package tugas1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Program untuk melakukan pemesanan buah dengan menampilkan menu buah beserta harga,
 * memungkinkan pengguna memesan buah yang diinginkan dan menampilkan total harga.
 */
public class PemesananBuah {

    // Daftar buah dan harga per buah
    private static final Map<String, Integer> menuBuah = new HashMap<>();

    /**
     * Metode utama yang menjalankan program.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        initMenu();
        prosesPemesanan();
    }

    /**
     * Menginisialisasi daftar buah beserta harga per buah ke dalam menu.
     */
    private static void initMenu() {
        menuBuah.put("Apel", 15000);
        menuBuah.put("Jeruk", 12000);
        menuBuah.put("Mangga", 18000);
        menuBuah.put("Pisang", 10000);
    }

    /**
     * Menampilkan daftar buah beserta harganya ke layar.
     */
    private static void tampilkanMenu() {
        System.out.println("Daftar Buah dan Harganya:");
        for (Map.Entry<String, Integer> entry : menuBuah.entrySet()) {
            System.out.println(entry.getKey() + ": Rp " + entry.getValue());
        }
    }

    /**
     * Memproses pemesanan buah oleh pengguna. Metode ini menampilkan menu,
     * meminta input pengguna untuk nama buah dan jumlah, serta mengakumulasi
     * total harga hingga pengguna selesai memesan.
     */
    private static void prosesPemesanan() {
        Scanner scanner = new Scanner(System.in);
        int totalHarga = 0;
        String pesanLagi;

        tampilkanMenu();

        do {
            String namaBuah = inputNamaBuah(scanner);

            if (menuBuah.containsKey(namaBuah)) {
                int jumlah = inputJumlahPesanan(scanner);
                totalHarga += hitungTotalHarga(namaBuah, jumlah);
                System.out.println("Buah berhasil dipesan.");
            } else {
                System.out.println("Buah tidak tersedia.");
            }

            pesanLagi = inputPesanLagi(scanner);
        } while (pesanLagi.equalsIgnoreCase("y"));

        tampilkanTotalHarga(totalHarga);
        scanner.close();
    }

    /**
     * Meminta input dari pengguna untuk nama buah yang ingin dipesan.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return nama buah yang diinput oleh pengguna
     */
    private static String inputNamaBuah(Scanner scanner) {
        System.out.print("\nMasukkan nama buah yang ingin dipesan: ");
        return scanner.nextLine();
    }

    /**
     * Meminta input dari pengguna untuk jumlah pesanan buah.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return jumlah buah yang dipesan
     */
    private static int inputJumlahPesanan(Scanner scanner) {
        System.out.print("Masukkan jumlah pesanan: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline
        return jumlah;
    }

    /**
     * Menghitung total harga untuk satu jenis buah berdasarkan jumlah yang dipesan.
     *
     * @param namaBuah nama buah yang dipesan
     * @param jumlah jumlah buah yang dipesan
     * @return total harga untuk buah tersebut
     */
    private static int hitungTotalHarga(String namaBuah, int jumlah) {
        return menuBuah.get(namaBuah) * jumlah;
    }

    /**
     * Meminta input dari pengguna apakah ingin memesan buah lagi atau tidak.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return "y" jika pengguna ingin memesan lagi, "n" jika tidak
     */
    private static String inputPesanLagi(Scanner scanner) {
        System.out.print("Ingin pesan lagi? (y/n): ");
        return scanner.nextLine();
    }

    /**
     * Menampilkan total harga yang harus dibayar oleh pengguna.
     *
     * @param totalHarga total harga semua buah yang dipesan
     */
    private static void tampilkanTotalHarga(int totalHarga) {
        System.out.println("Total harga yang harus dibayar: Rp " + totalHarga);
    }
}
