import java.util.Scanner;

/**
 * SistemKompensasi
 */
public class SistemKompensasi {
    private static String[][] akun = {{"user1", "pass1"}, {"user2", "pass2"}, {"user3", "pass3"}};
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("|        PILIH PROFESI ANDA       |");
        System.out.println("===================================");
        int pemilihan;

       do {
        System.out.println("| 1. Admin                        |");
        System.out.println("| 2. Mahasiswa                    |");
        System.out.println("===================================");
        System.out.print("Masukkan pilihan : ");
        pemilihan = input.nextInt();

       if (pemilihan == 1) {
        System.out.println("Anda memilih peran Admin.");
        adminMenu();
       } else if (pemilihan == 2) {
        System.out.println("Anda memilih peran Mahasiswa.");
        mahasiswaMenu();
       } else {
        System.out.println("Pilihan tidak valid. Silahkan pilih 1 (Admin) atau 2 (Mahasiswa) -_-");
       } 
    } while (pemilihan != 1 && pemilihan != 2);
    }
    private static void adminMenu() {
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001B[1m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

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

        while (!loggedIn) {
            System.out.print("Masukkan Nama Pengguna: ");
            String username = input.nextLine();
            System.out.print("Masukkan kata sandi: ");
            String password = input.nextLine();

            for (int i = 0; i < akun.length; i++) {
                if (username.equals(akun[i][0]) && password.equals(akun[i][1])) {
                    loggedIn = true;
                    System.out.println("======================================================");
                    System.out.println("| Login berhasil. Selamat datang, " + username + " v!  |");
                    System.out.println("======================================================");
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
        int milihan;
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        String[] namaLengkap = new String[50];
        String[] nim = new String[50];
        String[] jurusan = new String[50];
        String[] prodi = new String[50];
        
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
            System.out.println("Pemberian Jam kompen dan Tugas");
            double[] keputusan_jam_kompen = new double[3];
             int[] waktu = new int[3];
             String[] NamaLengkap = new String[3];
             String[] Nim = new String[3];
             String[] Jurusan = new String[3];
             String[] Prodi = new String[3]; 

            System.out.println("==================================");
            System.out.println("|     Masukan Data Mahasiswa     |");
            System.out.println("==================================");
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("Masukkan biodata mahasiswa ke-" + (jumlahMahasiswa + 1));
            System.out.print("Nama Lengkap: ");
            namaLengkap[jumlahMahasiswa] = sc.nextLine();
            System.out.print("NIM: ");
            nim[jumlahMahasiswa] = sc.nextLine();
            System.out.print("Jurusan: ");
            jurusan[jumlahMahasiswa] = sc.nextLine();

            do {
                System.out.println("==================================================");
                System.out.println("|           PILIHAN DAFTAR PROGRAM STUDI         |");
                System.out.println("==================================================");
                System.out.println("| 1. D-IV Teknologi Informasi                    |");
                System.out.println("| 2. D-IV Sistem Informasi Bisnis                |");
                System.out.println("| 3. D-II Fast Track                             |");
                System.out.println("==================================================");
                System.out.print("Pilihan :  ");
                milihan = sc.nextInt();
          
                sc.nextLine();
          
               switch (milihan) {
                case 1:
                  System.out.println("D-IV Teknologi Informasi");
                  break;
               case 2:
                System.out.println("D-IV Sistem Informasi Bisnis");
                break;
                case 3:
                System.out.println("D-II Fast Track");
                break;
               }
            } while (milihan !=1 && milihan !=2 && milihan !=3 );
        
            double ketentuan_kompen = 2.0;
            System.out.print("Masukkan Jam Alfa: ");
            waktu[jumlahMahasiswa] = sc.nextInt();

            sc.nextLine();

            keputusan_jam_kompen[jumlahMahasiswa] = waktu[jumlahMahasiswa] * ketentuan_kompen;

            jumlahMahasiswa++;

            System.out.print("Tambahkan biodata mahasiswa lainnya? (Y/T): ");
            String pilihan = sc.nextLine();
            if (pilihan.equalsIgnoreCase("T")) {
                lanjut = false;
            }
        }
        tampilMahasiswa(namaLengkap, nim, jurusan, prodi,waktu, jumlahMahasiswa);
        break;

    case 2:
    System.out.println("Penghapusan Jam Kompen");
        break;
}

    } while (pilih != 4); 
        System.out.println("===============================");
        System.out.println("| Terima kasih & Sampai Jumpa |");
        System.out.println("===============================");
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
    
        public static void tampilMahasiswa(String[] namaLengkap, String[] nim, String[] jurusan, String[] prodi, int[] waktu, int jumlahMahasiswa) {
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
    private static void mahasiswaMenu() { 
        String[][] akun = {
            {"ivansyah", "2341720126"},
            {"cindy", "2341720038"},
            {"nanda", "2341720132"}
        };
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001B[1m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

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
        
        while (!loggedIn) {
            System.out.print("Masukkan Nama Pengguna: ");
            String username = input.nextLine();
            System.out.print("Masukkan Kata Sandi: ");
            String password = input.nextLine();

            for (int i = 0; i < akun.length; i++) {
                if (username.equals(akun[i][0]) && password.equals(akun[i][1])) {
                    loggedIn = true;
                    System.out.println("===============================================");
                    System.out.println(" Login berhasil. Selamat datang, " + username );
                    System.out.println("===============================================");
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("===============================================================");
                System.out.println("Login gagal. Nama pengguna atau kata sandi salah. Coba lagi -_-");
                System.out.println("===============================================================");
            }
        }
        
        Scanner scanner3 = new Scanner(System.in);

        double angka1, angka2, hasil;

        String[] tugas = new String[50];
        int jmlTgs = 0;

        int Pilihan = 0;
        int milih;

        do {
            System.out.println("=====================================");
            System.out.println("|         PILIHAN DAFTAR MENU       |");
            System.out.println("=====================================");
            System.out.println("1. Cek Jam Kompen dan Tugas");
            System.out.println("2. Riwayat Tugas");
            System.out.println("3. Keluar");
            System.out.print("Pilihan : ");
            milih = input.nextInt();

            switch (milih) {
                case 1:
                    System.out.println("=================================");
                    System.out.println("|  PENGHITUNGAN JAM KOMPENSASI  |");
                    System.out.println("================================");
                    int jam_alfa;
                    double ketentuan_kompensasi = 2.0, keputusan_jam_kompensasi;
                    

                    System.out.print("Masukkan Jam Alfa: ");
                    jam_alfa = input.nextInt();
                    keputusan_jam_kompensasi = jam_alfa * ketentuan_kompensasi;
                    System.out.println("Keputusan Jam Kompensasi: " + keputusan_jam_kompensasi);

                    System.out.println("===========================");
                    System.out.println("|       DAFTAR TUGAS      |");
                    System.out.println("===========================");

                    int[] kuotaTugas = {2, 2, 2, 2};
                    Scanner sc = new Scanner(System.in);
                    int daftarPilihan;

                    do {
                        System.out.println("   Silahkan Pilih Daftar Tugas : ");
                        System.out.println("1. Menjaga Kantin");
                        System.out.println("2. Membantu Dosen");
                        System.out.println("3. Membantu OB");
                        System.out.println("4. Membersihkan kamar mandi");
                        System.out.print("Pilih daftar tugas : ");
                        daftarPilihan = sc.nextInt();

                        if (daftarPilihan >= 1 && daftarPilihan <= 4 && kuotaTugas[daftarPilihan - 1] > 0) {
                            String tugaspilih ="";
                            switch (daftarPilihan) {
                                case 1:
                                    tugaspilih = "Menjaga Kantin" + daftarPilihan;
                                    break;
                                case 2:
                                  tugaspilih = "Membantu Dosen" + daftarPilihan;
                                  break;
                                case 3:
                                  tugaspilih = "Membantu OB" + daftarPilihan;
                                  break;
                                case 4:
                                  tugaspilih = "Membersihkan Kamar Mandi" + daftarPilihan;
                                  break;
                            }
                            System.out.println("Anda memilih " + daftarPilihan);
                        } else {
                            System.out.println("===========================================================");
                            System.out.println("    PILIHAN TIDAK VALID. SILAHKAN PILIH DAFTAR DI ATAS _-  ");
                            System.out.println("===========================================================");
                        }
                    } while (daftarPilihan < 1 || daftarPilihan > 4);
                    break;
                
                case 2:
                    Scanner scanner4 = new Scanner(System.in); {
                int jam;
                double ketentuan_kompen = 2.0, keputusan_jam_kompen;
                    System.out.print("Masukkan jam kompen : ");
                jam = scanner4.nextInt();
                    keputusan_jam_kompen = jam * ketentuan_kompen;
                    System.out.println("Sisa Jam Kompen anda : " + keputusan_jam_kompen + " jam ");
                int pilihandaftar;
                do {
                    System.out.println(" Anda memiliki tugas yang masih belum diselesaikan. Segera diselesaikan !");
                    System.out.println("====================");
                    System.out.println("PILIHAN DAFTAR TUGAS");
                    System.out.println("====================");
                    System.out.println("1. Menjaga Kantin");
                    System.out.println("2. Membantu Dosen");
                    System.out.println("3. Membantu OB");
                    System.out.println("4. Membersihkan kamar mandi");
                    System.out.print("Pilih tugas yang akan diselesaikan : ");
                    pilihandaftar = scanner4.nextInt();
            
                    if (pilihandaftar >= 1 && pilihandaftar <= 4) {
                        String tugasTerpilih = "";
                        switch (pilihandaftar) {
                            case 1:
                                tugasTerpilih = "tugas menjaga kantin. SILAHKAN DISELESAIKAN !";
                                break;
                            case 2:
                                tugasTerpilih = "tugas membantu dosen. SILAHKAN DISELESAIKAN !";
                                break;
                            case 3:
                                tugasTerpilih = "tugas membantu OB. SILAHKAN DISELESAIKAN !";
                                break;
                            case 4:
                                tugasTerpilih = "tugas membersihkan kamar mandi. SILAHKAN DISELESAIKAN !";
                                break;
                        }
                        System.out.println("Anda memilih " + tugasTerpilih);
                    } else {
                        System.out.println("Pilihan tidak valid. Silahkan pilih daftar tugas di atas !");
                    }
                } while (pilihandaftar < 1 || pilihandaftar > 4);
                break;
            }
                case 3:
                    System.out.println("===================================================");
                    System.out.println("|                  TERIMA KASIH                   |");
                    System.out.println("===================================================");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (milih != 3);
}
}
