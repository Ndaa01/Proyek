import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * SistemKompensasi
 */
public class SistemKompensasi {
    private static String[][] akun = {{"user1", "pass1"}, {"user2", "pass2"}, {"user3", "pass3"}};
    private static int[][] jamAlfa = new int[50][8];
    private static String dataFile = "data.txt";
    private static String[] prodiMahasiswa = new String[50];
    public static void setJamAlfa(int[][] JamAlfaData) {
        jamAlfa = jamAlfaSemester;
    }
    private static String[] namaLengkap = new String[50];
    private static String[] nim = new String[50];
    private static String[] jurusan = new String[50];
    private static String[] prodi = new String[50];
    private static int[] waktu = new int[50];
    private static String[] tugas = new String[50];
    private static int[][] jamAlfaSemester = new int[50][8];
    private static int jumlahMahasiswa = 0;
    public static int[][] getJamAlfa() {
        return jamAlfa;
    }

    public static void hapusJamAlfa() {
        Scanner input = new Scanner(System.in);

        // Menampilkan daftar mahasiswa
        System.out.println("=====================================");
        System.out.println("|     DAFTAR MAHASISWA TERDAFTAR    |");
        System.out.println("=====================================");
        tampilMahasiswa(namaLengkap, nim, jurusan, prodi, waktu, tugas, jumlahMahasiswa);

        // Pilih mahasiswa
        System.out.print("Pilih Mahasiswa (1-" + jumlahMahasiswa + "): ");
        int pilihMahasiswa = input.nextInt();
        input.nextLine();

        // Validasi pilihan mahasiswa
        if (pilihMahasiswa >= 1 && pilihMahasiswa <= jumlahMahasiswa) {
            int indeksMahasiswa = pilihMahasiswa - 1;

            // Menampilkan riwayat jam alfa
            displayRiwayatTugasDanJamAlfa(jamAlfaSemester, indeksMahasiswa, indeksMahasiswa);

            // Meminta input semester yang akan dihapus jam alfa
            System.out.print("Pilih Semester (1-8) untuk menghapus jam alfa: ");
            int semesterHapus = input.nextInt();
            input.nextLine();

            // Validasi pilihan semester
            if (semesterHapus >= 1 && semesterHapus <= 8) {
                // Meminta input jumlah jam alfa yang akan dihapus
                System.out.print("Masukkan jumlah jam alfa yang akan dihapus: ");
                int jamAlfaHapus = input.nextInt();
                input.nextLine();

                // Validasi input jam alfa yang akan dihapus
                if (jamAlfaHapus >= 0 && jamAlfaHapus <= jamAlfaSemester[indeksMahasiswa][semesterHapus - 1]) {
                    // Menghapus jam alfa
                    jamAlfaSemester[indeksMahasiswa][semesterHapus - 1] -= jamAlfaHapus;
                    System.out.println("Jam alfa berhasil dihapus.");
                } else {
                    System.out.println("Jumlah jam alfa yang dimasukkan tidak valid.");
                }
            } else {
                System.out.println("Pilihan semester tidak valid.");
            }
        } else {
            System.out.println("Pilihan mahasiswa tidak valid.");
        }
    }


    public static void main(String[] args) {
        loadData();

       Scanner input = new Scanner(System.in);
        int pemilihan;

        outerLoop:
        do {
            System.out.println("===================================");
            System.out.println("|        PILIH PROFESI ANDA       |");
            System.out.println("===================================");
            do {
                System.out.println("===================================");
                System.out.println("| 1. Admin                        |");
                System.out.println("| 2. Mahasiswa                    |");
                System.out.println("| 3. Keluar                       |");
                System.out.println("===================================");
                System.out.print("Masukkan pilihan : ");
                pemilihan = input.nextInt();

                switch (pemilihan) {
                    case 1:
                        System.out.println("Anda memilih peran Admin.");
                        adminMenu();
                        break;
                    case 2:
                        System.out.println("Anda memilih peran Mahasiswa.");
                        mahasiswaMenu();
                        break;
                    case 3:
                        System.out.println("Terima kasih & Sampai Jumpa!");
                        break outerLoop;
                    default:
                        System.out.println("Pilihan tidak valid. Silahkan pilih 1 (Admin), 2 (Mahasiswa), atau 3 (Keluar) -_-");
                }
            } while (pemilihan != 1 && pemilihan != 2);
        } while (true);
        saveData();
    }

    private static void saveData() {
        try {
            FileWriter writer = new FileWriter(dataFile);
            // Menyimpan data ke file
            for (int i = 0; i < jumlahMahasiswa; i++) {
                writer.write(namaLengkap[i] + " " + nim[i] + " " + jurusan[i] + " " + prodi[i] + " " + waktu[i] + " " + prodiMahasiswa[i] + " ");
               
                for (int j = 0; j < jamAlfa.length; j++) {
                    writer.write(jamAlfaSemester[i][j] + " ");
                }
                writer.write("\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadData() {
        try {
            File file = new File(dataFile);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);

                for (int i = 0; i < jamAlfa.length && scanner.hasNextLine(); i++) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" ");
                   
                    for (int j = 0; j < parts.length; j++) {
                        jamAlfa[i][j] = Integer.parseInt(parts[j]);
                }
            }
                scanner.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void profesiMenu() {
        System.out.println("===================================");
        System.out.println("| 1. Admin                        |");
        System.out.println("| 2. Mahasiswa                    |");
        System.out.println("===================================");
    }
    public static void adminMenu() {
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001B[1m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        
        while (!loggedIn) {
            System.out.print("Masukkan Nama Pengguna: ");
            String username = input.nextLine();
            System.out.print("Masukkan kata sandi: ");
            String password = input.nextLine();

            for (int i = 0; i < akun.length; i++) {
                if (username.equals(akun[i][0]) && password.equals(akun[i][1])) {
                    loggedIn = true;
                    System.out.println("==========================================================================================================================");
                    System.out.println("|                                                                                                                        |");                                                                                                                                                                                                                        
                    System.out.println("| ███████ ███████ ██       █████  ███    ███  █████  ████████     ██████   █████  ████████  █████  ███    ██  ██████     |"); 
                    System.out.println("| ██      ██      ██      ██   ██ ████  ████ ██   ██    ██        ██   ██ ██   ██    ██    ██   ██ ████   ██ ██          |");
                    System.out.println("| ███████ █████   ██      ███████ ██ ████ ██ ███████    ██        ██   ██ ███████    ██    ███████ ██ ██  ██ ██   ███    |");
                    System.out.println("|      ██ ██      ██      ██   ██ ██  ██  ██ ██   ██    ██        ██   ██ ██   ██    ██    ██   ██ ██ ██  ██ ██    ██    |");
                    System.out.println("| ███████ ███████ ███████ ██   ██ ██      ██ ██   ██    ██        ██████  ██   ██    ██    ██   ██ ██   ████  ██████     |");
                    System.out.println("|                                                                                                                        |");                                                                                                                                                                                                                      
                    System.out.println("==========================================================================================================================");                                                                                                                                                                                                                                                                                                  
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("===================================================================");
                System.out.println("| Login gagal. Nama pengguna atau kata sandi salah. Coba lagi -_- |");
                System.out.println("===================================================================");
            }
        }
    
        int pilih;
        Scanner sc = new Scanner(System.in);
        String[] namaLengkap = new String[50];
        String[] nim = new String[50];
        String[] jurusan = new String[50];
        String[] prodi = new String[50];
        int[] waktu = new int[50];
        String [] tugas = new String[50];
        int jumlahMahasiswa = 0;

    do {
        System.out.println("=========================================");
        System.out.println("|           PILIHAN DAFTAR MENU         |");
        System.out.println("=========================================");
        System.out.println("| 1. Pemberian Jam Kompen               |");
        System.out.println("| 2. Penghapusan Jam Kompensasi         |");
        System.out.println("| 3. Riwayat Tugas                      |");
        System.out.println("| 4. Keluar                             |");
        System.out.println("=========================================");
        System.out.print("Pilihan :  ");
        pilih = sc.nextInt();
        sc.nextLine(); 
     
        switch (pilih) {
            case 1:
            inputJamAlfa();
            break;
            
            case 2:
            hapusJamAlfa();
            break;

            case 3:
            inputTampilMahasiswa();
            break;
        }
    } while (pilih != 4); 
        System.out.println("===============================");
        System.out.println("| Terima kasih & Sampai Jumpa |");
        System.out.println("===============================");
    }
    

        public static void inputJamAlfa() {
            System.out.println("Pemberian Jam kompen dan Tugas");
            Scanner sc = new Scanner(System.in);
            double[] keputusan_jam_kompen = new double[50];
            int milihan;

            System.out.println("==================================");
            System.out.println("|     Masukan Data Mahasiswa     |");
            System.out.println("==================================");
            boolean lanjut = true;
            while (lanjut && jumlahMahasiswa < 50) {
                System.out.println("Masukkan Biodata Mahasiswa");
                System.out.print("Nama Lengkap: ");
                namaLengkap[jumlahMahasiswa] = sc.nextLine();
                System.out.print("NIM: ");
                nim[jumlahMahasiswa] = sc.nextLine();
                System.out.print("Jurusan: ");
                jurusan[jumlahMahasiswa] = sc.nextLine();

                System.out.println("==================================================");
                System.out.println("|           PILIHAN DAFTAR PROGRAM STUDI         |");
                System.out.println("==================================================");
                System.out.println("| 1. D-IV Teknik Informatika                     |");
                System.out.println("| 2. D-IV Sistem Informasi Bisnis                |");
                System.out.println("| 3. D-II Fast Track                             |");
                System.out.println("==================================================");
                System.out.print("Pilihan :  ");
                milihan = sc.nextInt();
                sc.nextLine();

                switch (milihan) {
                    case 1:
                        System.out.println("D-IV Teknik Informatika");
                        prodi[jumlahMahasiswa] = "D-IV Teknik Informatika";
                        break;
                    case 2:
                        System.out.println("D-IV Sistem Informasi Bisnis");
                        prodi[jumlahMahasiswa] = "D-IV Sistem Informasi Bisnis";
                        break;
                    case 3:
                        System.out.println("D-II Fast Track");
                        prodi[jumlahMahasiswa] = "D-II Fast Track";
                        break;
                        default :
                        System.out.println("Pilihan tidak valid");
                        break;
                }

            while (lanjut) {
            System.out.print("Masukkan Jam Alfa: ");
            waktu[jumlahMahasiswa] = sc.nextInt();
            sc.nextLine();       
             int semesterPemberianJam = -1;
                    while (semesterPemberianJam < 1 || semesterPemberianJam > 8) {
                        System.out.print("Pilih Semester (1-8) untuk pemberian jam alfa: ");
                        semesterPemberianJam = sc.nextInt();
                        sc.nextLine();
                    }
                    if (semesterPemberianJam > 1 && jamAlfaSemester[jumlahMahasiswa][semesterPemberianJam - 2] > 0) {
                        jamAlfaSemester[jumlahMahasiswa][semesterPemberianJam - 1] = waktu[jumlahMahasiswa] * 2;
                    } else {
                        jamAlfaSemester[jumlahMahasiswa][semesterPemberianJam - 1] = waktu[jumlahMahasiswa];
                         prodiMahasiswa[jumlahMahasiswa] = prodi[jumlahMahasiswa];
                    }
                    jumlahMahasiswa++;
            
            System.out.print("Masukkan Tugas: ");
            tugas[jumlahMahasiswa] = sc.nextLine();
             break;
                
            }
            System.out.print("Tambahkan biodata mahasiswa lainnya? (Y/T): ");
            String pilihan = sc.nextLine();
            lanjut = pilihan.equalsIgnoreCase("Y");

        }
    }

    public static void inputTampilMahasiswa() {
    tampilMahasiswa(namaLengkap, nim, jurusan, prodi, waktu, tugas, jumlahMahasiswa);
    Scanner sc = new Scanner(System.in);
        
            // Pilih mahasiswa untuk menampilkan riwayat
            System.out.print("Pilih Mahasiswa (1-" + jumlahMahasiswa + "): ");
            int pilihMahasiswa = sc.nextInt();
            sc.nextLine();
        
            // Validasi pilihan mahasiswa
            if (pilihMahasiswa >= 1 && pilihMahasiswa <= jumlahMahasiswa) {
                int indeksMahasiswa = pilihMahasiswa - 1;
        
                // Tampilkan riwayat tugas dan jam alfa
                System.out.println("===============================================");
                System.out.println("|  RIWAYAT TUGAS DAN JAM ALFA MAHASISWA " + namaLengkap[indeksMahasiswa] + "  |");
                System.out.println("===============================================");
                System.out.printf("|   %-11s |   %-10s |   %-13s |\n", "SEMESTER", "JAM ALFA", "PERSENTASE");
                System.out.println("===============================================");
        
                for (int j = 0; j < jamAlfaSemester[indeksMahasiswa].length; j++) {
                    System.out.printf("|   %-11s |   %-10d |   %-13.2f %% |\n", "Semester " + (j + 1),
                            jamAlfaSemester[indeksMahasiswa][j], calculatePercentage(jamAlfaSemester[indeksMahasiswa][j]));
                }
                System.out.println("===============================================");
                System.out.print("Tekan Enter untuk melanjutkan ");
            new java.util.Scanner(System.in).nextLine();
            } else {
                System.out.println("Pilihan mahasiswa tidak valid.");
                
            }
            
}

        public static void inputMahasiswa(Scanner input, String[] namaLengkap, String[] nim, String[] jurusan, String[] prodi, int[] waktu, int jumlahMahasiswa) {
            System.out.println("Masukkan biodata mahasiswa ke-" + (jumlahMahasiswa + 1));
            System.out.print("Nama Lengkap: ");
            namaLengkap[jumlahMahasiswa] = input.nextLine();
            System.out.print("NIM: ");
            nim[jumlahMahasiswa] = input.nextLine();
            System.out.print("Jurusan: ");
            jurusan[jumlahMahasiswa] = input.nextLine();
            System.out.print("Prodi: ");
            prodi[jumlahMahasiswa] = input.nextLine();
            System.out.println("Total Jam Alfa: ");
            waktu[jumlahMahasiswa] = input.nextInt();
        }
    
        public static void tampilMahasiswa(String[] namaLengkap, String[] nim, String[] jurusan, String[] prodi, int[] waktu, String[] tugas, int jumlahMahasiswa) {
            System.out.println("Biodata Mahasiswa:");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                System.out.println("Mahasiswa ke-" + (i + 1));
                System.out.println("Nama Lengkap: " + namaLengkap[i]);
                System.out.println("NIM: " + nim[i]);
                System.out.println("Jurusan: " + jurusan[i]);
                System.out.println("Prodi: " + prodi[i]);
                System.out.println("Total Jam Alfa: " + waktu[i] * 2.0);
                System.out.println();
            }
        }
    public static void mahasiswaMenu() {
        String username = "", password;
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001B[1m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

        while (!loggedIn) {
            System.out.print("Masukkan Nama Pengguna: ");
            username = input.nextLine();
            System.out.print("Masukkan Kata Sandi: ");
            password = input.nextLine();

            for (int i = 0; i < akun.length; i++) {
                if (username.equals(namaLengkap[i]) && password.equals(nim[i])) {
                    loggedIn = true;
                    System.out.println("==========================================================================================================================");
                    System.out.println("|                                                                                                                        |");                                                                                                                                                                                                                        
                    System.out.println("| ███████ ███████ ██       █████  ███    ███  █████  ████████     ██████   █████  ████████  █████  ███    ██  ██████     |"); 
                    System.out.println("| ██      ██      ██      ██   ██ ████  ████ ██   ██    ██        ██   ██ ██   ██    ██    ██   ██ ████   ██ ██          |");
                    System.out.println("| ███████ █████   ██      ███████ ██ ████ ██ ███████    ██        ██   ██ ███████    ██    ███████ ██ ██  ██ ██   ███    |");
                    System.out.println("|      ██ ██      ██      ██   ██ ██  ██  ██ ██   ██    ██        ██   ██ ██   ██    ██    ██   ██ ██ ██  ██ ██    ██    |");
                    System.out.println("| ███████ ███████ ███████ ██   ██ ██      ██ ██   ██    ██        ██████  ██   ██    ██    ██   ██ ██   ████  ██████     |");
                    System.out.println("|                                                                                                                        |");                                                                                                                                                                                                                      
                    System.out.println("|                                                                                                                        |");
                    System.out.println("=========================================================================================================================="); 
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("===============================================================");
                System.out.println("Login gagal. Nama pengguna atau kata sandi salah. Coba lagi -_-");
                System.out.println("===============================================================");
            }
        }
        
        int milih;

        do {
            System.out.println("=====================================");
            System.out.println("|         PILIHAN DAFTAR MENU       |");
            System.out.println("=====================================");
            System.out.println("| 1. Riwayat Tugas                  |");
            System.out.println("| 2. Keluar                         |");
            System.out.println("=====================================");
            System.out.print("Pilihan : ");
            milih = input.nextInt();

            int indeksMahasiswa = 0;
            switch (milih) {
                case 1:

                    System.out.println("=================================");
                    System.out.println("|         RIWAYAT TUGAS         |");
                    System.out.println("=================================");

                    int semesterTampil = -1;
                    for (int i = 0; i < jumlahMahasiswa; i++) {
                        if (username.equals(namaLengkap[i])) {
                            indeksMahasiswa = i;
                            break;
                        }
                    }

                    if (indeksMahasiswa != -1) {
                    while (semesterTampil < 1 || semesterTampil > 8) {
                        System.out.print("Pilih Semester (1-8) untuk menampilkan riwayat jam alfa : ");
                        semesterTampil = input.nextInt();
                    }
                    displayRiwayatTugasDanJamAlfa(jamAlfaSemester, semesterTampil, indeksMahasiswa);
                    break;
                }
                
                case 2:
                    System.out.println("===================================================");
                    System.out.println("|                  TERIMA KASIH                   |");
                    System.out.println("===================================================");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (milih != 2);
}
    public static void displayRiwayatTugasDanJamAlfa(int[][] jamAlfaSemester, int semester, int indeksMahasiswa) {
        System.out.println("===============================================");
                System.out.println("|  RIWAYAT TUGAS DAN JAM ALFA MAHASISWA " + namaLengkap[indeksMahasiswa] + "  |");
                System.out.println("===============================================");
                System.out.printf("|   %-11s |   %-10s |   %-13s |\n", "SEMESTER", "JAM ALFA", "PERSENTASE");
                System.out.println("===============================================");
        
                for (int j = 0; j < jamAlfaSemester[indeksMahasiswa].length; j++) {
                    System.out.printf("|   %-11s |   %-10d |   %-13.2f %% |\n", "Semester " + (j + 1),
                            jamAlfaSemester[indeksMahasiswa][j], calculatePercentage(jamAlfaSemester[indeksMahasiswa][j]));
                }
                System.out.println("===============================================");
                  System.out.print("Tekan Enter untuk melanjutkan ");
            new java.util.Scanner(System.in).nextLine();
    }
    public static double calculatePercentage(int jamAlfa) {
        if (jamAlfa == 0) {
            return 100.0;
        } else {
            int totalJamKuliah = 20;
            double percentage = ((double) (totalJamKuliah - jamAlfa) / totalJamKuliah) * 100;
        return Math.max(percentage, 0);
        }
    }
}