// program ini akan mensimulasikan proses pembelian sepatu pada toko ABC
/*
 * ALUR PROGRAM
 * 1. user masuk ke menu utama
 * 2. kemudian user bisa langsung keluar dari program atau lanjut ke menu catalog sepatu
 * 3. pada menu catalog user bisa memilih sepatu yang ingin dibeli.
 * 4. kemudian user akan dipindahkan ke menu pembelian, dimana user bisa melihat ukuran yang tersedia berserta harganya
 * 5. ketika user sudah selesai memilih ukuran sepatu maka pembelian dianggap selesai
 * 6. kemudian user akan dikembalikan ke menu utama
 * 7. proses ini akan berulang sampai user keluar dari program di menu utama
 */

import java.util.*;

import BusinessLogic.TokoSepatu;

public class Soal5 {
  static Scanner sc = new Scanner(System.in);
  static TokoSepatu ABC = new TokoSepatu();

  static void menuUtama() {
    int input = 0;

    while (true) {
      System.out.println("Toko sepatu ABC");
      System.out.println("1. Beli Sepatu");
      System.out.println("2. Keluar Dari Program");
      System.out.println("Profit Sementara Toko: Rp." + ABC.getProfit());
      System.out.print("\nInput: ");

      input = sc.nextInt();
      sc.nextLine();

      // router menu
      if (input == 1) {
        menuCatalogSepatu();
      } else if (input == 2) {
        break;
      }
    }
  }

  static void menuCatalogSepatu() {
    int input = 0;

    for (int i = 0; i < TokoSepatu.merekTersedia.size(); i++) {
      System.out.printf("%d. %s\n", (i + 1), TokoSepatu.merekTersedia.get(i).nama);
    }

    while (true) {
      System.out.print("Masukkan merek sepatu yang ingin dibeli: ");
      input = sc.nextInt();
      sc.nextLine();
      
      if (input >= 1 && input <= TokoSepatu.merekTersedia.size()) {
        menuPembelian(TokoSepatu.merekTersedia.get(input - 1).nama, input - 1);
        break;
      }
    }
  }

  static void menuPembelian(String nama, int idxSepatu) {
    int input;
    System.out.println("Data sepatu merek " + nama);

    // mencetak dan meminta user untuk memasukkan ukuran yang diinginkan
    for (int i = 0; i < ABC.stok.get(nama).length; i++) {
      int size = ABC.stok.get(nama)[i].getSepatu().getSize();
      double harga = ABC.stok.get(nama)[i].getSepatu().getHarga();
      int qtySepatu = ABC.getStokSepatu(nama, size);

      System.out.printf("%d. size[%d] & stok[%d]: Rp.%.2f\n", (i + 1), size, qtySepatu, harga);      
    }
    
    while (true) {      
      System.out.print("Masukkan ukuran sepatu yang ingin dibeli: ");
      input = sc.nextInt();
      sc.nextLine();

      if (input - 1 < TokoSepatu.SIZE_TERSEDIA.size()) {
        int size = TokoSepatu.SIZE_TERSEDIA.get(input - 1);

        if (ABC.getStokSepatu(nama, size) > 0){
          ABC.kurangiStok(nama, size);
          ABC.tambahProfit(ABC.stok.get(nama)[input - 1].getSepatu().getHarga());
     
          System.out.print("Pembelian berhasil !");
          sc.nextLine();
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    menuUtama();
    sc.close();
  }
}
