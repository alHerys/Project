package Bank_Sampah;

public class Method_Admin_Bank_Sampah {

/**
 * <p>Metode untuk memproses menu admin pada aplikasi Bank Sampah.</p>
 * 
 * <p>Saat pengguna mengakses method ini, maka akan diberikan opsi:</p>
 * <ol>
 *   <li>Laporan Pengunjung Minggu lalu.</li>
 *   <li>Kembali ke Menu Utama.</li>
 * </ol>
 * 
 * <p>Fitur utama:</p>
 * <ul>
 *   <li>Verifikasi akses admin menggunakan password.</li>
 *   <li>Menampilkan laporan statistik pengunjung mingguan.</li>
 * </ul>
 * 
 * <p>Passwordnya adalah <code>admin123</code>.</p>
 * <p>Data yang ditampilkan pada diagram adalah angka acak yang berasal dari metode <code>Math.random()</code>
 * dengan nilai minimum 3 dan maksimal 14.</p>
 * 
 */
    public static void Admin_Bank_Sampah() {

        String Password_Admin = "admin123";
        
        int Jumlah_Pengunjung[] = new int[7];
        for (int i = 0; i < 7; i++) {
            Jumlah_Pengunjung [i] = (int)(3 + (Math.random()* 12));
        }

        String []Hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

        do {
            System.out.println("\nSilahkan masukkan password"); // Passwordnya adalah admin123
            System.out.print("Password: ");
            String Password = Main_BankSampah.scan.nextLine();
            if (Password.equals(Password_Admin)) {
                System.out.print("\nSelamat datang");
                Main_BankSampah.Loading(750);
                System.out.println();
                break;
            }
            else {
                System.out.println("\nPassword salah, masukkan dengan benar yahh");
            }
        } while (true);
        
        do {
            System.out.print("""
                    \n----------------- MENU ADMIN -----------------
                    Silahkan pilih opsi menurut kebutuhan anda:
                    1. Laporan Pengunjung Minggu Lalu
                    2. Kembali ke Menu Utama
                    """);
            System.out.print("Pilihan (1/2): ");
            Main_BankSampah.Pilihan = Main_BankSampah.scan.nextInt();

            if (Main_BankSampah.Pilihan > 2 || Main_BankSampah.Pilihan < 1) {
                System.out.print("\nSepertinya ada yang tidak beres");
                Main_BankSampah.Loading(500);
                System.out.print("\nMaaf, pilihan anda tidak tersedia, pastikan pilihan anda benar ;)");
                continue;
            }
            else if (Main_BankSampah.Pilihan == 1) {
                Statistik(Jumlah_Pengunjung, Hari);
                System.out.print("\nTekan [Enter] untuk kembali ");
                Main_BankSampah.scan.nextLine();
                System.out.print("Kembali");
                Main_BankSampah.Loading(500);
            }
            else {
                System.out.print("Kembali ke menu utama");
                Main_BankSampah.Loading(600);
                break;
            }
        } while (true);
    }

    /**
 * <p>Metode untuk menampilkan laporan statistik pengunjung Bank Sampah dalam bentuk diagram batang.</p>
 * 
 * <p>Fitur utama:</p>
 * <ul>
 *   <li>Memilih jenis diagram untuk menampilkan data statistik.</li>
 *   <li>Menampilkan data jumlah pengunjung harian untuk satu minggu.</li>
 * </ul>
 * 
 * <p>Jenis diagram yang tersedia:</p>
 * <ol>
 *   <li><b>Diagram Batang Vertikal</b>: Ditampilkan menggunakan metode 
 *       <code>Diagram_Batang_Vertikal</code>.</li>
 *   <li><b>Diagram Batang Horizontal</b>: Ditampilkan menggunakan metode 
 *       <code>Diagram_Batang_Horizontal</code>.</li>
 * </ol>
 * 
 * @param Jumlah_Pengunjung array berisi jumlah pengunjung setiap hari selama satu minggu.
 * @param Hari array berisi nama-nama hari dalam seminggu.
 */
    private static void Statistik(int [] Jumlah_Pengunjung, String [] Hari) {
        do {
            System.out.print("""
            \nAnda ingin laporan ditampilkan dalam diagram apa?
            1. Diagram Batang Vertikal
            2. Diagram Batang Horizontal
            """);
            System.out.print("Pilihan (1/2): ");
            Main_BankSampah.Pilihan = Main_BankSampah.scan.nextInt();
            Main_BankSampah.scan.nextLine();

            if (Main_BankSampah.Pilihan == 2 || Main_BankSampah.Pilihan == 1) {
                break;
            }
            System.out.println("\nPilihan tidak tersedia, pastikan pilihan anda benar");
        } while (true);

        System.out.print("""
                \n------------ LAPORAN PENGUNJUNG BANK ------------
                ------------ SAMPAH FILKOM BRAWIJAYA ------------
                """);

        switch (Main_BankSampah.Pilihan) {
            case 1: Diagram_Batang_Vertikal(Jumlah_Pengunjung, Hari);
            break;
            case 2: Diagram_Batang_Horizontal(Jumlah_Pengunjung, Hari);
            break;
        }
    }
    
    /**
 * 
 * <p>Fitur utama:</p>
 * <ul>
 *   <li>Menampilkan jumlah pengunjung dalam bentuk diagram batang vertikal.</li>
 *   <li>Setiap batang menunjukkan jumlah pengunjung untuk hari tertentu.</li>
 *   <li>Menampilkan rata-rata pengunjung selama seminggu di akhir laporan.</li>
 * </ul>
 * <strong>----------------------</strong>
 * @param Jumlah_Pengunjung Array berisi jumlah pengunjung untuk setiap hari dalam seminggu.
 *                          Indeks array merepresentasikan hari dalam urutan tertentu.
 * @param Hari Array berisi nama-nama hari (misalnya: "Senin", "Selasa", dll.) yang sesuai 
 *             dengan data pada array <code>Jumlah_Pengunjung</code>.
 */
    private static void Diagram_Batang_Vertikal(int [] Jumlah_Pengunjung, String [] Hari) {
        
        int Maksimum = Pencari_Nilai_Maksimal(Jumlah_Pengunjung);
        
        System.out.println();

        for (int i = Maksimum; i >= -1; i--) {
            if (i > 0) {
                System.out.printf("%-3d %c%3c",i,'|',' ');
                for (int j = 0; j < Jumlah_Pengunjung.length; j++) {
                    if (i <= Jumlah_Pengunjung[j]) {
                        System.out.printf("%-6s","███");
                    }
                    else {
                        System.out.printf("%6c",' ');
                    }
                }
            }

            else if (i == 0) {
                System.out.printf("%7c",' ');
                for (int j = 0; j < 7; j++) {
                        System.out.printf("%s","───── ");
                }
            }

            else {
                System.out.printf("%7c",' ');
                for (int j = 0; j < Jumlah_Pengunjung.length; j++) {
                    System.out.printf("%s ", Hari[j]);
                    
                }
            }
            System.out.println();
        }
        System.out.printf("\nRata-rata pengunjung minggu terakhir adalah %d orang\n", Pencari_RataRata(Jumlah_Pengunjung));
    }

    /**
 * <p>Fitur utama:</p>
 * <ul>
 *   <li>Menampilkan jumlah pengunjung dalam bentuk diagram batang horizontal.</li>
 *   <li>Setiap batang menunjukkan jumlah pengunjung untuk hari tertentu.</li>
 *   <li>Menampilkan rata-rata pengunjung selama seminggu di akhir laporan.</li>
 * </ul>
 * --------------------
 * </ol>
 * 
 * @param Jumlah_Pengunjung array berisi jumlah pengunjung setiap hari selama satu minggu.
 * @param Hari array berisi nama-nama hari dalam seminggu.
 */
    private static void Diagram_Batang_Horizontal(int []Jumlah_Pengunjung, String [] Hari) {

        int Maksimum = Pencari_Nilai_Maksimal(Jumlah_Pengunjung);

        for (int i = 0; i < 7; i++) {
            System.out.printf("\n%-6s |  ",Hari[i]);
            for (int j = 0; j <= Maksimum; j++) {
                if (Jumlah_Pengunjung[i] > j) {
                    System.out.print("██");
                }
                else if (Jumlah_Pengunjung [i] == j) {
                    System.out.printf(" (%d)",(j));
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.printf("\nRata-rata pengunjung minggu lalu adalah %d orang\n", Pencari_RataRata(Jumlah_Pengunjung));
    }

    /**
 * <p>Metode untuk menemukan nilai maksimum dalam sebuah array integer.</p>
 * <p>Proses yang dilakukan:</p>
 * <ol>
 *   <li>Inisialisasi variabel <code>Maksimum</code> yang menyimpan elemen pertama pada <code>Array_Subjek</code>.</li>
 *   <li>Iterasi sebanyak 7 kali.</li>
 *   <li>Dilakukan pengecekan, apakah nilai <code>Array_Subjek</code> saat ini lebih besar dari nilai sebelumnya.</li>
 *   <li>Jika benar, maka variabel maksimum akan diperbaharui dengan nilai <code>Array_Subjek</code> saat ini.</li>
 * </ol>
 * @param Array_Subjek array integer yang akan diproses untuk menemukan nilai maksimum.
 * @return Nilai maksimum bertipe integer yang ditemukan dalam array.
 */
    private static int Pencari_Nilai_Maksimal (int [] Array_Subjek) {
        int Maksimum = Array_Subjek[0];
        for (int i = 0; i < 7; i++) {
            if (Array_Subjek[i] >= Maksimum) {
                Maksimum = Array_Subjek[i];
            }
        }
        return Maksimum;
    }

    /**
 * <p>Metode untuk menghitung rata-rata dari elemen-elemen dalam sebuah array integer.</p>
 *
 * <p>Proses yang dilakukan:</p>
 * <ol>
 *   <li>Inisialisasi variabel <code>total</code> untuk menyimpan jumlah semua elemen dalam array. Mula-mula, variabel <code>total</code> akan disimpan nilai 0.</li>
 *   <li>Iterasi melalui elemen-elemen array untuk menghitung total.</li>
 *   <li>Menghitung rata-rata dengan membagi total dengan jumlah elemen dalam array (dalam kasus ini, 7).</li>
 * </ol>
 * 
 * @param Array_Jumlah_Pengunjung array integer yang berisi data jumlah pengunjung untuk dihitung rata-ratanya.
 * @return Rata-rata dari elemen-elemen dalam array sebagai bilangan bulat.
 */
    private static int Pencari_RataRata (int []Array_Jumlah_Pengunjung) {
        int total = 0;
        for (int i = 0; i < 7; i++) {
            total += Array_Jumlah_Pengunjung[i];
        }
        int rata_rata = total/7;
        return rata_rata;
    }
}    