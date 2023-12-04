import java.util.Scanner;

/**
 * SistemKompensasi
 */
public class SistemKompensasi {

    private static double[] keputusan_jam_kompen = new double[50];
    private static String[][] akun = {{"user1", "pass1"}, {"user2", "pass2"}, {"user3", "pass3"}};
    private static String[] namaLengkap = new String[50];
    private static String[] nim = new String[50];
    private static String[] jurusan = new String[50];
    private static String[] prodi = new String[50];
    private static int[] waktu = new int[50];
    private static int jumlahMahasiswa = 0;
    private static String [] tugas = new String[50];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean loggedIn = login(input);

        if (loggedIn) {
            int pilihan;

            do {
                System.out.println("===============================");
                System.out.println("|   Selamat datang, Admin!    |");
                System.out.println("===============================");
                System.out.println("| 1. Input Data Mahasiswa     |");
                System.out.println("| 2. Tampilkan Data Mahasiswa |");
                System.out.println("| 3. Keluar                    |");
                System.out.println("===============================");
                System.out.print("Pilih menu (1/2/3): ");
                
                pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        inputMahasiswa(input);
                        break;
                    case 2:
                        if (jumlahMahasiswa > 0) {
                            tampilMahasiswa();
                        } else {
                            System.out.println("Belum ada data mahasiswa yang diinput.");
                        }
                        break;
                    case 3:
                        System.out.println("===============================");
                        System.out.println("| Terima kasih & Sampai Jumpa |");
                        System.out.println("===============================");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
                }

            } while (pilihan != 3);
        } else {
            System.out.println("Login gagal. Nama pengguna atau kata sandi salah.");
        }
    }

    private static boolean login(Scanner input) {
        boolean loggedIn = false;

        System.out.println("================================================================");
        System.out.println("| SELAMAT DATANG DI SISTEM KOMPENSASI POLITEKNIK NEGERI MALANG |");
        System.out.println("================================================================");
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        for (String[] account : akun) {
            if (username.equals(account[0]) && password.equals(account[1])) {
                loggedIn = true;
                break;
            }
        }

        return loggedIn;
    }

    private static void inputMahasiswa(Scanner input) {
        boolean lanjut = true;

        while (lanjut && jumlahMahasiswa < 50) {
            System.out.println("Masukkan biodata mahasiswa ke-" + (jumlahMahasiswa + 1));
            System.out.print("Nama Lengkap: ");
            namaLengkap[jumlahMahasiswa] = input.nextLine();
            input.nextLine();
            System.out.print("NIM: ");
            nim[jumlahMahasiswa] = input.nextLine();
            System.out.print("Jurusan: ");
            jurusan[jumlahMahasiswa] = input.nextLine();
            System.out.print("Prodi: ");
            prodi[jumlahMahasiswa] = input.nextLine();
            double ketentuan_kompen = 2.0;
            System.out.print("Masukkan Jam Alfa: ");
            waktu[jumlahMahasiswa] = input.nextInt();
            System.out.print("Tugas: ");
            tugas[jumlahMahasiswa] = input.nextLine();


            input.nextLine();

            keputusan_jam_kompen[jumlahMahasiswa] = waktu[jumlahMahasiswa] * ketentuan_kompen;

            jumlahMahasiswa++;

            System.out.print("Lanjut input data mahasiswa? (y/n): ");
            String response = input.nextLine().toLowerCase();
            lanjut = response.equals("y");
        }
    }

    private static void tampilMahasiswa() {
        System.out.println("Biodata Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.println("Nama Lengkap: " + namaLengkap[i]);
            System.out.println("NIM: " + nim[i]);
            System.out.println("Jurusan: " + jurusan[i]);
            System.out.println("Prodi: " + prodi[i]);
            System.out.println("Jam Alfa: " + keputusan_jam_kompen[i]);
            System.out.println();
 }
}
}