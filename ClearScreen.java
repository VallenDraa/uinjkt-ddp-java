public abstract class ClearScreen {
  public static void run() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
}
