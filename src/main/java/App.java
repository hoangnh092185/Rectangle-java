import java.io.Console;

public class App {
  public static void main(String[] args){
    Console myConsole = System.console();
    System.out.println("Enter the length of your rectangle:");
    String stringLength = myConsole.readLine();
    int intLength = Integer.parseInt(stringLength);
    System.out.println("Enter the width of your rectangle:");
    String stringWidth = myConsole.readLine();
    int intWidth = Integer.parseInt(stringWidth);
    Rectangle rectangle = new Rectangle(intLength, intWidth);
    boolean squareResult = rectangle.isSquare();
    System.out.println("Is your rectangle a square, too? "+ squareResult+ "!");
  }
}
