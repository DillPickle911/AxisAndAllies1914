import java.util.Scanner;

public class Tester
{
   public static final INFANTRY = 0;
   public static final ARTILLERY = 1;
   public static final TANK = 2;
   public static final FIGHTER = 3;
   public static final BATTLESHIP = 4;
   public static final CRUISER = 5;
   public static final SUBMARINE = 6;
   public static final TRANSPORT = 7;

   public static final ALLIED = 0;
   public static final CENTRAL = 1;
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      Country GERMANY = new Country("German Empire", 35, "Austria", true);
      Country AUSTRIA_HUNGARY = new Country("Austria-Hungary", 26, "Austria", true);
      Country OTTOMAN_EMPIRE = new Country("Ottoman Empire", 16, "Austria", true);
      Country UK = new Country("United Kingdom", 30, "Austria", true);
      Country FRANCE = new Country("France", 24, "Austria", true);
      Country RUSSIA = new Country("Russian Empire", 25, "Austria", true);
      Country ITALY = new Country("Kingdom of Italy", 14, "Austria", true);
      Country USA = new Country("United States of America", 20, "Austria", true);
      //                              name       controller       isCity
      Territory AUS = new Territory("Austria", AUSTRIA_HUNGARY, true);
      System.out.println(AUS.toString() + "\n");
      AUS.addTroops(ALLIED, INFANTRY, 11);
      AUS.addTroops(ALLIED, ARTILLERY, 8);
      System.out.println(AUS.toString() + "\n");
      AUS.setContested(true);
      AUS.addTroops(CENTRAL, INFANTRY, 20);
      AUS.addTroops(CENTRAL, ARTILLERY, 15);
      System.out.println(AUS.toString() + "\n");
      AUS.setContested(false);
      AUS.setController(RUSSIA);
      AUS.conquer();
      System.out.println(AUS.toString() + "\n");
   }
}
