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

      //                             name, starting IPCs, cap name, isAi
      Country GERMANY = new Country("German Empire", 35, "Vienna", true);
      Country AUSTRIA_HUNGARY = new Country("Austria-Hungary", 26, "Austria", true);
      Country OTTOMAN_EMPIRE = new Country("Ottoman Empire", 16, "Austria", true);
      Country UK = new Country("United Kingdom", 30, "Austria", true);
      Country FRANCE = new Country("France", 24, "Austria", true);
      Country RUSSIA = new Country("Russian Empire", 25, "Austria", true);
      Country ITALY = new Country("Kingdom of Italy", 14, "Austria", true);
      Country USA = new Country("United States of America", 20, "Austria", true);

      Country curr = AUSTRIA_HUNGARY;
      
      //                              name       controller       isCity
      Territory VIE = new Territory("Vienna", AUSTRIA_HUNGARY, true);
      Territory BOH = new Territory("Bohemia", AUSTRIA_HUNGARY, false);
      Territory TYR = new Territory("Tyrolia", AUSTRIA_HUNGARY, false);
      Territory TRI = new Territory("Bohemia", AUSTRIA_HUNGARY, false);
      Territory BUD = new Territory("Bohemia", AUSTRIA_HUNGARY, false);
      Territory GAL = new Territory("Bohemia", AUSTRIA_HUNGARY, false);

      
      System.out.println(VIE.toString() + "\n");
      VIE.addTroops(curr, INFANTRY, 11);
      VIE.addTroops(curr, ARTILLERY, 8);
      System.out.println(VIE.toString() + "\n");
      curr = RUSSIA;
      VIE.setContested(true);
      VIE.addTroops(curr, INFANTRY, 20);
      VIE.addTroops(curr, ARTILLERY, 15);
      System.out.println(VIE.toString() + "\n");
      VIE.setContested(false);
      VIE.setController(curr);
      System.out.println(VIE.toString() + "\n");
   }
}
