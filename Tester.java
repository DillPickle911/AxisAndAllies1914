import java.util.Scanner;

public class Tester
{
   public static final int INFANTRY = 0;
   public static final int ARTILLERY = 1;
   public static final int TANK = 2;
   public static final int FIGHTER = 3;
   public static final int BATTLESHIP = 4;
   public static final int CRUISER = 5;
   public static final int SUBMARINE = 6;
   public static final int TRANSPORT = 7;

   public static final int ALLIED = 0;
   public static final int CENTRAL = 1;
   
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
      
      // AUSTRIA_HUNGARY
      Territory VIE = new Territory("Vienna", AUSTRIA_HUNGARY, true, 6, new String[]{"Bohemia", "Tyrolia", "Trieste", "Budapest", "Galicia"});
      VIE.addTroops(AUSTRIA_HUNGARY, INFANTRY, 12);
      VIE.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory BOH = new Territory("Bohemia", AUSTRIA_HUNGARY, false, 3, new String[]{"Vienna", "Tyrolia", "Galicia", "Silesia", "Hanover", "Munich"});
      BOH.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
      BOH.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory TYR = new Territory("Tyrolia", AUSTRIA_HUNGARY, false, 4, new String[]{"Vienna", "Trieste", "Bohemia", "Munich", "Switzerland", "Venice"});
      TYR.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
      TYR.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory TRI = new Territory("Trieste", AUSTRIA_HUNGARY, false, 4, new String[]{"Vienna", "Tyrolia", "Budapest", "Venice", "Albania", "Serbia"});
      TRI.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
      TRI.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory BUD = new Territory("Budapest", AUSTRIA_HUNGARY, false, 6, new String[]{"Vienna", "Trieste", "Galicia", "Romania", "Serbia"});
      BUD.addTroops(AUSTRIA_HUNGARY, INFANTRY, 12);
      BUD.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory GAL = new Territory("Galicia", AUSTRIA_HUNGARY, false, 3, new String[]{"Vienna", "Bohemia", "Budapest", "Poland", "Ukraine", "Romania", "Silesia"});
      GAL.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
      GAL.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      /*Territory SZ18 = new Territory("Sea Zone 18", AUSTRIA_HUNGARY, false);
      SZ18.addTroops(AUSTRIA_HUNGARY, BATTLESHIP, 1);
      SZ18.addTroops(AUSTRIA_HUNGARY, CRUISER, 1);
      SZ18.addTroops(AUSTRIA_HUNGARY, TRANSPORT, 1);*/

      
      // RUSSIA
      Territory FIN = new Territory("Finland", RUSSIA, false, 2, new String[]{"Karelia", "Norway", "Sweden"});
      FIN.addTroops(RUSSIA, INFANTRY, 1);
      
      Territory KAR = new Territory("Karelia", RUSSIA, false, 2, new String[]{"Finland", "Moscow", "Livonia"});
      KAR.addTroops(RUSSIA, INFANTRY, 1);
      
      Territory LIV = new Territory("Livonia", RUSSIA, false, 2, new String[]{"Karelia", "Moscow", "Belarus", "Poland"});
      LIV.addTroops(RUSSIA, INFANTRY, 3);
      LIV.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory POL = new Territory("Poland", RUSSIA, false, 3, new String[]{"Livonia", "Belarus", "Ukraine", "Galicia", "Prussia", "Silesia"});
      POL.addTroops(RUSSIA, INFANTRY, 6);
      POL.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory BEL = new Territory("Belarus", RUSSIA, false, 2, new String[]{"Livonia", "Moscow", "Poland", "Ukraine"});
      BEL.addTroops(RUSSIA, INFANTRY, 6);
      BEL.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory MOS = new Territory("Moscow", RUSSIA, true, 6, new String[]{"Karelia", "Livonia", "Belarus", "Ukraine", "Tatarstan"});
      MOS.addTroops(RUSSIA, INFANTRY, 6);
      MOS.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory UKR = new Territory("Ukraine", RUSSIA, false, 3, new String[]{"Poland", "Belarus", "Moscow", "Tatarstan", "Sevastopol", "Romania", "Galicia"});
      UKR.addTroops(RUSSIA, INFANTRY, 6);
      UKR.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory TAT = new Territory("Tatarstan", RUSSIA, false, 1, new String[]{"Moscow", "Ukraine", "Sevastopol", "Kazakhstan"});
      TAT.addTroops(RUSSIA, INFANTRY, 3);
      TAT.addTroops(RUSSIA, ARTILLERY, 1);
      
      Territory SEV = new Territory("Sevastopol", RUSSIA, false, 3, new String[]{"Tatarstan", "Ukraine", "Romania", "Mesopotamia", "Persia"});
      SEV.addTroops(RUSSIA, INFANTRY, 3);
      SEV.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory KAZ = new Territory("Kazakhstan", RUSSIA, false, 1, new String[]{"Tatarstan", "Persia", "Afghanistan"});
      KAZ.addTroops(RUSSIA, INFANTRY, 1);
      
      /*Territory SZ12 = new Territory("Sea Zone 12", RUSSIA, false);
      SZ12.addTroops(RUSSIA, BATTLESHIP, 1);
      
      Territory SZ21 = new Territory("Sea Zone 21", RUSSIA, false);
      SZ12.addTroops(RUSSIA, CRUISER, 2);*/


      // GERMANY
      Territory BER = new Territory("Berlin", GERMANY, true, 8, new String[]{"Kiel", "Prussia", "Silesia", "Hanover"});
      BER.addTroops(GERMANY, INFANTRY, 13);
      BER.addTroops(GERMANY, ARTILLERY, 3);
      BER.addTroops(GERMANY, FIGHTER, 1);
      
      Territory KIE = new Territory("Kiel", GERMANY, false, 2, new String[]{"Denmark", "Berlin", "Hanover", "Ruhr", "Holland"});
      KIE.addTroops(GERMANY, INFANTRY, 3);
      KIE.addTroops(GERMANY, ARTILLERY, 4);
      
      Territory RUH = new Territory("Ruhr", GERMANY, false, 6, new String[]{"Holland", "Kiel", "Hanover", "Munich", "Alsace", "Belgium"});
      RUH.addTroops(GERMANY, INFANTRY, 7);
      RUH.addTroops(GERMANY, ARTILLERY, 3);
      
      Territory ALS = new Territory("Alsace", GERMANY, false, 3, new String[]{"Ruhr", "Munich", "Switzerland", "Lorraine", "Belgium"});
      ALS.addTroops(GERMANY, INFANTRY, 7);
      ALS.addTroops(GERMANY, ARTILLERY, 3);
      
      Territory MUN = new Territory("Munich", GERMANY, false, 4, new String[]{"Alsace", "Ruhr", "Hanover", "Bohemia", "Tyrolia", "Switzerland"});
      MUN.addTroops(GERMANY, INFANTRY, 11);
      MUN.addTroops(GERMANY, ARTILLERY, 3);
      
      Territory HAN = new Territory("Hanover", GERMANY, false, 2, new String[]{"Munich", "Ruhr", "Kiel", "Berlin", "Silesia", "Bohemia"});
      HAN.addTroops(GERMANY, INFANTRY, 6);
      
      Territory SIL = new Territory("Silesia", GERMANY, false, 3, new String[]{"Hanover", "Berlin", "Prussia", "Poland", "Galicia", "Bohemia"});
      SIL.addTroops(GERMANY, INFANTRY, 6);
      SIL.addTroops(GERMANY, ARTILLERY, 3);
      
      Territory PRU = new Territory("Prussia", GERMANY, false, 3, new String[]{"Silesia", "Berlin", "Poland"});
      PRU.addTroops(GERMANY, INFANTRY, 6);
      PRU.addTroops(GERMANY, ARTILLERY, 3);
      
      Territory TOG = new Territory("Togoland", GERMANY, false, 1, new String[]{"Gold Coast", "Nigeria"});
      TOG.addTroops(GERMANY, INFANTRY, 1);
      
      Territory KAM = new Territory("Kamerun", GERMANY, false, 1, new String[]{"Nigeria", "French Equatorial Africa", "Belgian Congo"});
      KAM.addTroops(GERMANY, INFANTRY, 1);
      
      Territory GEA = new Territory("German East Africa", GERMANY, false, 1, new String[]{"Belgian Congo", "British East Africa", "Portugese East Africa", "Rhodesia"});
      GEA.addTroops(GERMANY, INFANTRY, 1);
      
      Territory SWA = new Territory("South West Africa", GERMANY, false, 1, new String[]{"Angola", "Union of South Africa"});
      SWA.addTroops(GERMANY, INFANTRY, 1);
      SWA.addTroops(GERMANY, ARTILLERY, 1);
      
      /*Territory SZ5 = new Territory("Sea Zone 5", GERMANY, false);
      SZ5.addTroops(GERMANY, SUBMARINE, 2);
      
      Territory SZ7 = new Territory("Sea Zone 7", GERMANY, false);
      SZ7.addTroops(GERMANY, SUBMARINE, 2);
      
      Territory SZ10 = new Territory("Sea Zone 10", GERMANY, false);
      SZ10.addTroops(GERMANY, BATTLESHIP, 1);
      SZ10.addTroops(GERMANY, CRUISER, 2);*/


      // FRANCE
      Territory PAR = new Territory("Paris", FRANCE, true, 6, new String[]{"Brest", "Picardy", "Burgundy", "Bordeaux"});
      PAR.addTroops(FRANCE, INFANTRY, 6);
      PAR.addTroops(FRANCE, ARTILLERY, 2);
      PAR.addTroops(FRANCE, FIGHTER, 1);

      Territory PIC = new Territory("Picardy", FRANCE, false, 2, new String[]{"Brest", "Paris", "Burgundy", "Lorraine", "Belgium"});
      PIC.addTroops(FRANCE, INFANTRY, 6);
      PIC.addTroops(FRANCE, ARTILLERY, 2);

      Territory BRE = new Territory("Brest", FRANCE, false, 2, new String[]{"Brest", "Picardy","Bordeaux"});
      BRE.addTroops(FRANCE, INFANTRY, 1);

      Territory BOR = new Territory("Bordeaux", FRANCE, false, 2, new String[]{"Brest", "Paris", "Burgundy", "Marseilles", "Spain"});
      BOR.addTroops(FRANCE, INFANTRY, 1);

      Territory BUR = new Territory("Burgundy", FRANCE, false, 2, new String[]{"Picardy", "Paris", "Bordeaux", "Marseilles", "Lorraine", "Switzerland", "Piedmont"});
      BUR.addTroops(FRANCE, INFANTRY, 6);
      BUR.addTroops(FRANCE, ARTILLERY, 2);

      Territory LOR = new Territory("Lorraine", FRANCE, false, 2, new String[]{"Burgundy", "Picardy", "Belgium", "Alsace", "Switzerland"});
      LOR.addTroops(FRANCE, INFANTRY, 6);
      LOR.addTroops(FRANCE, ARTILLERY, 2);

      Territory MAR = new Territory("Marseilles", FRANCE, false, 2, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont"});

      Territory MOR = new Territory("Morocco", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont"});
      MOR.addTroops(FRANCE, INFANTRY, 1);

      Territory ALG = new Territory("Algeria", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont"});
      ALG.addTroops(FRANCE, INFANTRY, 1);

      Territory TUN = new Territory("Tunisia", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont"});
      TUN.addTroops(FRANCE, INFANTRY, 1);

      Territory FWA = new Territory("French West Africa", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont"});
      FWA.addTroops(FRANCE, INFANTRY, 1);

      /*Territory SZ15 = new Territory("Sea Zone 15", FRANCE, false);
      SZ15.addTroops(FRANCE, BATTLESHIP, 1);
      SZ15.addTroops(FRANCE, TRANSPORT, 1);

      Territory SZ16 = new Territory("Sea Zone 15", FRANCE, false);
      SZ16.addTroops(FRANCE, BATTLESHIP, 1);
      SZ16.addTroops(FRANCE, CRUISER, 1);
      SZ16.addTroops(FRANCE, TRANSPORT, 2);*/

      
      System.out.println(VIE.toString() + "\n");
      curr = RUSSIA;
      VIE.setContested(true);
      VIE.addTroops(curr, INFANTRY, 15);
      VIE.addTroops(curr, ARTILLERY, 5);
      System.out.println(VIE.toString() + "\n");
      VIE.setContested(false);
      VIE.setController(curr);
      System.out.println(VIE.toString() + "\n");
   }
}
