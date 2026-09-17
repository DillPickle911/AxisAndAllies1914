import java.util.Scanner;

public class Tester
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      Country GERMANY = new Country("German Empire", 30, "Austria", true);
      Country AUSTRIA_HUNGARY = new Country("Austria-Hungary", 30, "Austria", true);
      Country OTTOMAN_EMPIRE = new Country("Ottoman Empire", 30, "Austria", true);
      Country UK = new Country("United Kingdom", 30, "Austria", true);
      Country FRANCE = new Country("France", 30, "Austria", true);
      Country RUSSIA = new Country("Russian Empire", 30, "Austria", true);
      Country ITALY = new Country("Kingdom of Italy", 30, "Austria", true);
      Country USA = new Country("United States of America", 30, "Austria", true);
      //                              name       controller       isCity
      Territory AUS = new Territory("Austria", AUSTRIA_HUNGARY, true);
      System.out.println(AUS.toString() + "\n");
      AUS.addTroopsDef(0, 11);
      AUS.addTroopsDef(1, 8);
      System.out.println(AUS.toString() + "\n");
      AUS.setContested(true);
      AUS.addTroopsAtk(0, 20);
      AUS.addTroopsAtk(0, 15);
      System.out.println(AUS.toString() + "\n");
      AUS.setContested(false);
      AUS.setController(RUSSIA);
      AUS.conquer();
      System.out.println(AUS.toString() + "\n");
   }
}