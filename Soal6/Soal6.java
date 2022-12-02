import java.util.Scanner;

class Mahasiswa {
  public static final double PERSENSI_FORMATIF = 0.4;
  public static final double PERSENSI_UTS = 0.3;
  public static final double PERSENSI_UAS = 0.3;

  private String NIM;
  private String nama;
  private double nilaiFormatif;
  private double nilaiUTS;
  private double nilaiUAS;
  private double nilaiAkhir;
  private char nilaiMutu;

  public Mahasiswa(Scanner sc) {
    initData(sc);
  }

  public void initData(Scanner sc) {
    System.out.print("Masukkan Nama Mahasiswa: ");
    nama = sc.nextLine();
    
    System.out.printf("Masukkan NIM milik %s: ", nama);
    NIM = sc.nextLine();

    System.out.printf("Masukkan Nilai Formatif Milik %s: ", nama);
    nilaiFormatif = sc.nextDouble();
    sc.nextLine();
    
    System.out.printf("Masukkan Nilai UTS Milik %s: ", nama);
    nilaiUTS = sc.nextDouble();
    sc.nextLine();
    
    System.out.printf("Masukkan Nilai UAS Milik %s: ", nama);
    nilaiUAS = sc.nextDouble();
    sc.nextLine();
  }

  // method terkait nilai akhir
  public void hitungNilaiAkhir() {
    nilaiAkhir = (nilaiFormatif * PERSENSI_FORMATIF) + 
                 (nilaiUAS * PERSENSI_UAS) + 
                 (nilaiUTS * PERSENSI_UTS);
  }
  public double getNilaiAkhir() {
    return nilaiAkhir;
  }

  // method terkait nilai mutu
  public void hitungNilaiMutu() {
    if (nilaiAkhir >= 80) {
      nilaiMutu = 'A';
    } else if (nilaiAkhir >= 70) {
      nilaiMutu = 'B';
    } else if (nilaiAkhir >= 60) {
      nilaiMutu = 'C';
    } else if (nilaiAkhir >= 50) {
      nilaiMutu = 'D';
    } else if (nilaiAkhir >= 40){
      nilaiMutu = 'E';
    } else {
      nilaiMutu = 'F';
    }
  }
  public char getNilaiMutu() {
    return nilaiMutu;
  }

  public String getNIM() {
    return NIM;
  }

  public String getNama() {
    return nama;
  }
}

public class Soal6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Mahasiswa[] mahasiswa = new Mahasiswa[2];
    
    // menerima data dari user
    for (int i = 0; i < mahasiswa.length; i++) {
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
      System.out.println("Data Mahasiswa Ke - " + (i + 1));
      mahasiswa[i] = new Mahasiswa(sc);
      mahasiswa[i].hitungNilaiAkhir();
      mahasiswa[i].hitungNilaiMutu();
    }
    
    // menampilkan nilai akhir masing masing mahasiswa
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    System.out.println("List Nilai Akhir Mahasiswa");
    System.out.println("---------------------------");
    for (Mahasiswa mhs : mahasiswa) {
      System.out.printf("%s - %s: %.2f / %c\n", mhs.getNIM(), mhs.getNama(), mhs.getNilaiAkhir(), mhs.getNilaiMutu());
    }
  }
}
