package Bank_Sampah;

// import class scanner
import java.util.Scanner;

public class Main_BankSampah {
    
// Deklarasi variabel global yang akan digunakan di berbagai class
    public static final Scanner scan = new Scanner (System.in);
    public static int Pilihan;
    public static String Nama;

/**
 * Fungsi Main untuk aplikasi Bank Sampah FILKOM BRAWIJAYA.
 * <p>
 * Metode ini digunakan menjalankan aplikasi Bank Sampah melalui metode <code>Bank_Sampah_Start();</code>.
 * </p>
 */
    public static void main(String[] args) {
        System.out.print("\nMembuka aplikasi");
        Loading(1000);
        Bank_Sampah_Start();
    }

/**
 * Metode yang pertama kali dilaksanakan saat program dimulai.
 * <p>
 * Metode ini akan menampilkan menu awal aplikasi yang berisi opsi bagi pengguna. Opsinya terdiri dari:
 * <ul>
 *   <li>Nasabah</li>
 *   <li>Admin Bank Sampah FILKOM BRAWIJAYA</li>
 *   <li>Keluar dari aplikasi</li>
 * </ul>
 * Pengguna dapat memilih opsi yang tersedia dengan menginput nomor urut dari opsi tersebut.
 * Menu ini akan terus ditampilkan dalam loop hingga pengguna memilih opsi keluar.
 * </p>
 */
    public static void Bank_Sampah_Start() {
        boolean status = true;
        while (status) {
            System.out.print("""
                    \n========================================================
                                  BANK SAMPAH FILKOM BRAWIJAYA              
                    ========================================================
                    Opsi yang tersedia:
                    1. Nasabah
                    2. Admin Bank Sampah FILKOM BRAWIJAYA
                    3. Keluar
                    """);
            System.out.print("Masukkan angka 1, 2, atau 3 sesuai keperluan anda: ");
            Pilihan = scan.nextInt();
            scan.nextLine();
            switch (Pilihan) {
                case 1: {
                    System.out.print("\nMemproses pilihan anda");
                    Loading(500);
                    Method_Menu_Nasabah.MenuNasabah();
                }
                break;
                case 2: {
                    System.out.print("\nMemproses pilihan anda");
                    Loading(500);
                    Method_Admin_Bank_Sampah.Admin_Bank_Sampah();
                }
                break;
                case 3: {
                    System.out.print("\nKeluar dari aplikasi");
                    Loading(500);
                    scan.close();
                    status = false;
                }
                break;
                default: {
                    System.out.print("\nSepertinya ada yang tidak beres");
                    Loading(500);
                    System.out.print("\nPilihan angka tidak tersedia, pastikan pilihan anda benar\n");
                } 
                break;
            }
        }
    }

/**
 * Menampilkan animasi loading sederhana dengan mencetak titik (".").
 * 
 * <p>Metode ini dirancang untuk memberikan efek visual berupa titik-titik 
 * yang dicetak pada terminal dengan jeda waktu tertentu di antara setiap titik.
 * Jumlah titik yang ditampilkan adalah 4 dan durasi jeda waktu antara titik 
 * diatur berdasarkan parameter yang diberikan.</p>
 * 
 * <p><strong>Catatan:</strong></p>
 * <ul>
 *   <li>Jika metode ini diinterupsi atau terjadi error saat berjalan, maka 
 *       InterruptedException akan ditangkap, tetapi tidak dilakukan penanganan khusus.</li>
 *   <li>Durasi yang diberikan selalu positif.</li>
 * </ul>
 * 
 * <p><strong>Contoh Penggunaan:</strong></p>
 * <pre>
 * Loading(500); // Akan menampilkan 4 titik dengan jeda 500 milisekon setiap detiknya
 * </pre>
 * 
 * @param Durasi_dalam_Milisekon durasi jeda waktu (dalam milisekon) antara 
 *                               setiap titik yang ditampilkan.
 */
    public static void Loading(int Durasi_dalam_Milisekon) {
            for(int i = 0; i < 4; i++) {
                try {
                    System.out.print(".");
                    Thread.sleep(Durasi_dalam_Milisekon);
                }
                catch (InterruptedException error) {}
            }
        System.out.println();
    }
}