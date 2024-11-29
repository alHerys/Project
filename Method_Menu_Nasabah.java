package Bank_Sampah;

import java.text.NumberFormat;
import java.util.Locale;

public class Method_Menu_Nasabah {

    // Variabel global
    private static int subtotal[] = new int[5];
    private static int berat[] = new int[5];
    private static int Berat_Subtotal [] = new int[5];
    private static int [] HargaSampahPerKg = {300,500,700,400,600};
    private static int totalPendapatan = 0;
    private static String JenisSampah [] = {"Organik" , "Anorganik", "Sampah Daur Ulang", "B3", "Residu"};

/**
 * <p>Metode yang dijalankan saat pengguna memilih opsi nasabah.</p>
 * 
 * <p>Fitur utama:</p>
 *   <ol>
 *     <li><b> Menabung</b>: Mengakses fitur menabung melalui metode <code>NasabahMenabung</code>.</li>
 *     <li><b> Informasi Akun</b>: Menampilkan informasi akun nasabah menggunakan metode <code>InformasiAkun</code>.</li>
 *     <li><b> Kembali ke menu utama</b>: Keluar dari menu nasabah.</li>
 *   </ol>
 * 
 * <p>Proses yang dilakukan:</p>
 * <ol>
 *   <li> Meminta input nama nasabah.</li>
 *   <li> Memvalidasi NIM nasabah untuk memastikan panjangnya minimal 15 karakter. Input NIM tidak boleh di bawah 15 karakter karena menggunakan metode
 *        <code>.substring</code> yang dimana jika NIM yang diinput di bawah 15 karakter maka akan terjadi error pada program.</li>
 *   <li> Menampilkan menu pilihan dengan opsi sesuai kebutuhan nasabah.</li>
 *   <li> Mengelola input nasabah dan mengarahkan ke fitur yang sesuai.</li>
 * </ol>
 */
    public static void MenuNasabah() {
        System.out.println("\nSilahkan isi data diri anda:");
        System.out.print("Nama : ");
        Main_BankSampah.Nama = Main_BankSampah.scan.nextLine();
        String NIM;
        do {
            System.out.print("NIM  : ");
            NIM = Main_BankSampah.scan.nextLine();
            if (NIM.length() < 15) {
                System.out.println("NIM anda tidak valid, isi dengan benar yah\n");
                continue;
            }
            break;
        } while (true);

        do {
            System.out.printf("""
                    \n---------------- MENU NASABAH ----------------
                    Haloo %s
                    Silahkan pilih opsi menurut kebutuhan anda
                    1. Menabung
                    2. Informasi Akun
                    3. Kembali ke menu utama
                    """,Main_BankSampah.Nama);
            System.out.print("Pilihan (1/2/3): ");
            Main_BankSampah.Pilihan = Main_BankSampah.scan.nextInt();
            Main_BankSampah.scan.nextLine();

            if (Main_BankSampah.Pilihan > 3 || Main_BankSampah.Pilihan < 1) {
                System.out.print("Sepertinya ada yang tidak beres");
                Main_BankSampah.Loading(500);
                System.out.println("Ternyata pilihan tidak ada, pastikan pilihan anda benar yah");
                continue;
            }

            switch (Main_BankSampah.Pilihan) {
                case 1:
                    NasabahMenabung();
                    System.out.println();
                    break;
                case 2:
                    InformasiAkun(NIM);
                    System.out.println();
                    break;
            }

            if (Main_BankSampah.Pilihan == 3) {
                System.out.print("\nKembali");
                Main_BankSampah.Loading(600);
                break;
            }
        } while (true);              
    }

    /**
 * Metode ini digunakan untuk mencatat aktivitas nasabah yang menabung sampah
 * di Bank Sampah FILKOM BRAWIJAYA. Metode ini memungkinkan nasabah untuk:
 * <ul>
 *   <li>Memilih jenis sampah</li>
 *   <li>Memasukkan berat sampah</li>
 *   <li>Melihat total pendapatan dari hasil tabungan sampah</li>
 *   <li>Menerima nota sebagai bukti tabungan</li>
 * </ul>
 *
 * Metode ini akan meminta input pengguna secara berulang sampai nasabah memilih
 * untuk berhenti menambahkan sampah.
 * 
 * Langkah-langkah dalam metode ini:
 * <ol>
 *   <li>Menampilkan daftar jenis sampah yang tersedia</li>
 *   <li>Meminta pengguna memilih jenis sampah</li>
 *   <li>Meminta pengguna memasukkan berat sampah yang ingin ditabung</li>
 *   <li>Menghitung subtotal berdasarkan berat sampah dan harga per kilogram</li>
 *   <li>Menyimpan data total berat dan pendapatan</li>
 *   <li>Menampilkan nota tabungan jika pengguna memilih untuk tidak menambahkan sampah lagi</li>
 * </ol>
 *
 * Struktur data yang digunakan:
 * <ul>
 *   <li><code>JenisSampah[]</code>: Daftar jenis sampah</li>
 *   <li><code>HargaSampahPerKg[]</code>: Harga sampah per kilogram untuk setiap jenis</li>
 *   <li><code>Berat_Subtotal[]</code>: Total berat untuk setiap jenis sampah</li>
 *   <li><code>subtotal[]</code>: Total pendapatan untuk setiap jenis sampah</li>
 * </ul>
 * 
 * Nota tabungan akan ditampilkan dalam format tabel yang mencakup:
 * <ul>
 *   <li>Jenis sampah</li>
 *   <li>Harga per kilogram</li>
 *   <li>Berat total</li>
 *   <li>Subtotal pendapatan</li>
 *   <li>Total keseluruhan pendapatan</li>
 * </ul>
 *
 * <strong>Catatan:</strong>
 * <ul>
 *   <li>Metode ini bergantung pada beberapa atribut dan metode di kelas <code>Main_BankSampah</code>, 
 *       seperti <code>scan</code> untuk input, <code>Loading()</code> untuk efek pemrosesan,
 *       dan <code>Pilihan</code> untuk menyimpan input pengguna.</li>
 *   <li><code>Berat_Subtotal[]</code>,<code>subtotal[]</code>, dan <code>totalPendapatan</code> ditampilkan setelah melalui format number. Format number yang digunakan adalah Indonesia.</li>
 * </ul>
 */

    public static void NasabahMenabung() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("id-ID"));

        for (int i = 0; i < 5; i++) {
            subtotal[i] = 0;
            Berat_Subtotal[i] = 0;
            berat[i] = 0;
        }

        boolean status = true;

        while (status) {
            System.out.println("\nJenis sampah: ");
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d. %s\n",(i+1),JenisSampah[i]);
            }
            System.out.print("Silahkan pilih jenis sampah anda (1/2/3/4/5): ");
            Main_BankSampah.Pilihan = Main_BankSampah.scan.nextInt();
            
            if (Main_BankSampah.Pilihan < 1 || Main_BankSampah.Pilihan > 5) {
                System.out.print("\nSepertinya ada yang salah");
                Main_BankSampah.Loading(500);
                System.out.println("Pilihan tidak ada. Pastikan pilihan anda tersedia\n");
                continue;
            }
            
            System.out.print("Berat Sampah (dalam kg): ");
            switch (Main_BankSampah.Pilihan) {
                case 1:
                    Pengolahan_Sampah(Main_BankSampah.Pilihan - 1);
                    break;
                case 2:
                    Pengolahan_Sampah(Main_BankSampah.Pilihan - 1);
                    break;
                case 3:
                    Pengolahan_Sampah(Main_BankSampah.Pilihan - 1);
                    break;
                case 4:
                    Pengolahan_Sampah(Main_BankSampah.Pilihan - 1);
                    break;
                case 5:
                    Pengolahan_Sampah(Main_BankSampah.Pilihan - 1);
                    break;
            }
            do {
                System.out.print("""
                        Tambahkan Sampah Lagi?
                        1. Iya
                        2. Tidak
                        """);
                System.out.print("Pilihan (1/2): ");
                Main_BankSampah.Pilihan = Main_BankSampah.scan.nextInt();
                System.out.println();
                if (Main_BankSampah.Pilihan == 2 || Main_BankSampah.Pilihan == 1) {
                    break;
                }
                System.out.println("Pilihan tidak ada. Pastikan pilihan anda tersedia\n");
            } while (true);

            if (Main_BankSampah.Pilihan == 2) {
                System.out.print("Memproses nota anda, mohon tunggu");
                Main_BankSampah.Loading(800);
                System.out.print("""
                    \nTerima kasih telah menabung di Bank Sampah FILKOM BRAWIJAYA
                    Berikut adalah nota anda:
                    ╔═══════════════════════════════════════════════════════════╗
                    ║                 BANK SAMPAH FILKOM BRAWIJAYA              ║
                    ║                        NOTA TABUNGAN                      ║
                    ╠═══════════════════╦════════════╦═════════╦════════════════╣
                    ║   Jenis Sampah    ║  Harga/kg  ║  Berat  ║    Subtotal    ║
                    """);
                        
                for (int i = 0; i < 5; i++) {
                    System.out.printf("""
                    ╠═══════════════════╬════════════╬═════════╬════════════════╣
                    ║ %-17s ║ Rp %-7d ║ %-7s ║ Rp %-11s ║
                    """,JenisSampah[i], HargaSampahPerKg[i], (formatter.format((Berat_Subtotal[i]))+" kg"), formatter.format((subtotal[i])));
                }
                
                System.out.printf("""
                    ╚═══════════════════╩════════════╬═════════╬════════════════╣
                                                     ║  Total  ║ Rp %-11s ║
                                                     ╚═════════╩════════════════╝
                    """,formatter.format(totalPendapatan));

                Main_BankSampah.scan.nextLine();
                System.out.print("Tekan [Enter] untuk kembali ");
                Main_BankSampah.scan.nextLine();
                System.out.print("\nKembali");
                Main_BankSampah.Loading(500);
                status = false;
            }
        }
    }
    /**
 * <p>Metode ini digunakan untuk menampilkan informasi akun mahasiswa berdasarkan NIM
 * (Nomor Induk Mahasiswa) yang diberikan. </p>
 * Informasi yang ditampilkan mencakup:
 * <ul>
 *   <li>Nama mahasiswa </li>
 *   <li>Tahun angkatan</li>
 *   <li>Program studi</li>
 *   <li>Jalur masuk</li>
 *   <li>Nomor urut mahasiswa</li>
 * </ul>
 * Informasi tambahan:
 * <ul>
 *   <li>Nama mahasiswa diambil dari atribut <code>Main_BankSampah.Nama</code>.</li>
 *   <li>Input <code>NIM</code> harus sesuai dengan format standar untuk menghasilkan data yang valid.</li>
 * </ul>
 * Proses dalam metode ini meliputi:
 * <ol>
 *   <li>Memisahkan NIM menjadi bagian-bagian informasi: tahun angkatan, kode program studi, jalur masuk, dan nomor mahasiswa.</li>
 *   <li>Menentukan program studi berdasarkan <code>KodeProgramStudi</code> menggunakan <code>switch</code>.</li>
 *   <li>Menentukan jalur masuk berdasarkan <code>KodeJalurMasuk</code> menggunakan <code>switch</code>.</li>
 *   <li>Menampilkan informasi akun mahasiswa secara terformat ke layar.</li>
 *   <li>Menunggu input pengguna untuk kembali ke menu sebelumnya.</li>
 * </ol>
 
 * <strong>Catatan:</strong>
 * <ul>
 *   <li>Jika kode program studi atau jalur masuk tidak ditemukan, akan ditampilkan pesan "Prodi Ghoib" atau "Jalur Ghoib".</li>
 *   <li>Metode ini bergantung pada atribut dan metode di kelas <code>Main_BankSampah</code>, seperti <code>Nama</code>, <code>scan</code>, dan <code>Loading()</code>.</li>
 * </ul>
 *----------------
 * @param NIM mahasiswa digunakan untuk mendapatkan informasi akun. 
 *            NIM dipecah menjadi beberapa bagian untuk menampilkan informasi:
 *            <ul>
 *              <li><code>TahunAngkatan</code>: Dua digit pertama NIM (tahun masuk mahasiswa)</li>
 *              <li><code>KodeProgramStudi</code>: Tiga digit di posisi ke-6 hingga ke-8 (kode program studi mahasiswa)</li>
 *              <li><code>KodeJalurMasuk</code>: Empat digit di posisi ke-9 hingga ke-12 (kode jalur masuk mahasiswa)</li>
 *              <li><code>NomorMahasiswa</code>: Tiga digit di posisi ke-13 hingga ke-15 (nomor urut mahasiswa)</li>
 *            </ul>
 */
    public static void InformasiAkun(String NIM) {
        String TahunAngkatan = NIM.substring(0, 2);
        String KodeProgramStudi = NIM.substring(5, 8);
        String KodeJalurMasuk = NIM.substring(8, 12);
        String NomorMahasiswa = NIM.substring(12, 15);
        
        System.out.printf("\n------------- Informasi Akun -------------\nNama              : %s\n",Main_BankSampah.Nama);

        System.out.println("Angkatan          : 20" + TahunAngkatan );
        
        System.out.print("Program studi     : ");
            switch (KodeProgramStudi) {
                case "020":
                    System.out.println("Teknik Informatika");break;
                case "030":
                    System.out.println("Teknik Komputer");break;
                case "040":
                    System.out.println("Sistem Informasi");break;
                case "060":
                    System.out.println("Pendidikan Teknologi Informasi");break;
                case "070":
                    System.out.println("Teknologi Informasi");break;
                default: 
                    System.out.println("Prodi Ghoib");break;
            }

        System.out.print("Jalur masuk       : ");
            switch (KodeJalurMasuk) {
                case "1111": System.out.println("Seleksi Nasional Berdasarkan Prestasi");
                    break;
                case "0111": System.out.println("Seleksi Nasional Berdasarkan Tes");
                    break;
                case "7111": System.out.println("Mandiri");
                    break;
                default: System.out.println("Jalur Ghoib");
                    break;
            }

        System.out.printf("Nomor mahasiswa   : %s\n",NomorMahasiswa);
        System.out.println();
        System.out.print("Tekan [Enter] untuk kembali ");
        Main_BankSampah.scan.nextLine();
        System.out.print("Kembali");
        Main_BankSampah.Loading(500);
    }

    /**
 * Memproses data sampah berdasarkan pilihan pengguna.
 * 
 * <p>Metode ini mengelola data sampah yang diinput oleh pengguna, 
 * termasuk mencatat berat sampah, menghitung subtotal pendapatan per jenis sampah,
 * dan memperbarui total pendapatan keseluruhan. Selain itu, metode ini 
 * menampilkan informasi terkait sampah yang telah diproses.
 * </p>
 *
 * @param Pilihan :indeks pilihan jenis sampah yang diproses.
 *                Indeks ini mengacu pada elemen-elemen dalam array `JenisSampah`, 
 *                `HargaSampahPerKg`, `berat`, `Berat_Subtotal`, dan `subtotal`.
 *
 * <p><b>Proses:</b></p>
 * <ol>
 *   <li>Meminta input berat sampah dari pengguna menggunakan Scanner.</li>
 *   <li>Menambahkan berat sampah ke subtotal berat untuk jenis sampah tertentu.</li>
 *   <li>Menghitung subtotal pendapatan berdasarkan berat sampah dan harga per kilogram.</li>
 *   <li>Menambahkan subtotal pendapatan ke total pendapatan keseluruhan.</li>
 *   <li>Menampilkan detail jenis sampah, berat.</li>
 * </ol>
 */
    private static void Pengolahan_Sampah (int Pilihan) {
        berat [Pilihan] = Main_BankSampah.scan.nextInt();
        Berat_Subtotal [Pilihan] += berat[Pilihan];
        totalPendapatan += HargaSampahPerKg [Pilihan] * berat[Pilihan];
        subtotal[Pilihan] += HargaSampahPerKg[Pilihan] * berat[Pilihan];
        System.out.print("\nMemproses sampah anda");
        Main_BankSampah.Loading(500);
        System.out.printf("\nSampah anda : %s dengan berat %d kg", JenisSampah[Pilihan],berat[Pilihan]);
        System.out.println();
    }
}