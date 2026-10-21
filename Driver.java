import java.util.Scanner;
import java.util.ArrayList;

public class Driver
{
   public static final int INFANTRY = 0;
   public static final int ARTILLERY = 1;
   public static final int TANK = 2;
   public static final int FIGHTER = 3;
   public static final int BATTLESHIP = 4;
   public static final int CRUISER = 5;
   public static final int SUBMARINE = 6;
   public static final int TRANSPORT = 7;

   public static final int[] PRICES = {3, 4, 6, 6, 12, 9, 6, 6};

   public static final int ALLIED = 0;
   public static final int CENTRAL = 1;

   public static final String[] TURN_START_TEXT = new String[]{"It is Austria-Hungary's turn.", "It is the Russian Empire's turn.", "It is Germany's turn.", "It is France's turn.", "It is the British Empire's turn.", "It is the Ottoman Empire's turn.", "It is Italy's turn.", "It is the United States' turn."};

   public static void main(String[] args)
   {
    
      Country GERMANY = new Country("German Empire", 35, "Berlin", true, true);
      Country AUSTRIA_HUNGARY = new Country("Austria-Hungary", 26, "Vienna", true, true);
      Country OTTOMAN_EMPIRE = new Country("Ottoman Empire", 16, "Constantinople", true, true);
      Country UK = new Country("United Kingdom", 30, "London", true, false);
      Country FRANCE = new Country("France", 24, "Paris", true, false);
      Country RUSSIA = new Country("Russian Empire", 25, "Moscow", true, false);
      Country ITALY = new Country("Kingdom of Italy", 14, "Rome", true, false);
      Country USA = new Country("United States of America", 20, "Washington", true, false);
      Country NEUTRAL = new Country("None", 0, "None", false, false);
   
      Country[] TURN_ORDER = new Country[]{AUSTRIA_HUNGARY, RUSSIA, GERMANY, FRANCE, UK, OTTOMAN_EMPIRE, ITALY, USA};
      
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
      
      Territory TRI = new Territory("Trieste", AUSTRIA_HUNGARY, false, 4, new String[]{"Vienna", "Tyrolia", "Budapest", "Venice", "Albania", "Serbia", "Sea Zone 18"});
      TRI.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
      TRI.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory BUD = new Territory("Budapest", AUSTRIA_HUNGARY, false, 6, new String[]{"Vienna", "Trieste", "Galicia", "Romania", "Serbia"});
      BUD.addTroops(AUSTRIA_HUNGARY, INFANTRY, 12);
      BUD.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
      Territory GAL = new Territory("Galicia", AUSTRIA_HUNGARY, false, 3, new String[]{"Vienna", "Bohemia", "Budapest", "Poland", "Ukraine", "Romania", "Silesia"});
      GAL.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
      GAL.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
   
      
        // RUSSIA
      Territory FIN = new Territory("Finland", RUSSIA, false, 2, new String[]{"Karelia", "Norway", "Sweden", "Sea Zone 6", "Sea Zone 12"});
      FIN.addTroops(RUSSIA, INFANTRY, 1);
      
      Territory KAR = new Territory("Karelia", RUSSIA, false, 2, new String[]{"Finland", "Moscow", "Livonia", "Sea Zone 6", "Sea Zone 12"});
      KAR.addTroops(RUSSIA, INFANTRY, 1);
      
      Territory LIV = new Territory("Livonia", RUSSIA, false, 2, new String[]{"Karelia", "Moscow", "Belarus", "Poland", "Sea Zone 12"});
      LIV.addTroops(RUSSIA, INFANTRY, 3);
      LIV.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory POL = new Territory("Poland", RUSSIA, false, 3, new String[]{"Livonia", "Belarus", "Ukraine", "Galicia", "Prussia", "Silesia", "Sea Zone 12"});
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
      
      Territory TAT = new Territory("Tatarstan", RUSSIA, false, 1, new String[]{"Moscow", "Ukraine", "Sevastopol", "Kazakhstan", "Sea Zone 30"});
      TAT.addTroops(RUSSIA, INFANTRY, 3);
      TAT.addTroops(RUSSIA, ARTILLERY, 1);
      
      Territory SEV = new Territory("Sevastopol", RUSSIA, false, 3, new String[]{"Tatarstan", "Ukraine", "Romania", "Mesopotamia", "Persia", "Sea Zone 21", "Sea Zone 30"});
      SEV.addTroops(RUSSIA, INFANTRY, 3);
      SEV.addTroops(RUSSIA, ARTILLERY, 2);
      
      Territory KAZ = new Territory("Kazakhstan", RUSSIA, false, 1, new String[]{"Tatarstan", "Persia", "Afghanistan", "Sea Zone 30"});
      KAZ.addTroops(RUSSIA, INFANTRY, 1);
   
   
        // GERMANY
      Territory BER = new Territory("Berlin", GERMANY, true, 8, new String[]{"Kiel", "Prussia", "Silesia", "Hanover", "Sea Zone 11"});
      BER.addTroops(GERMANY, INFANTRY, 13);
      BER.addTroops(GERMANY, ARTILLERY, 3);
      BER.addTroops(GERMANY, FIGHTER, 1);
      
      Territory KIE = new Territory("Kiel", GERMANY, false, 2, new String[]{"Denmark", "Berlin", "Hanover", "Ruhr", "Holland", "Sea Zone 10"});
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
      
      Territory PRU = new Territory("Prussia", GERMANY, false, 3, new String[]{"Silesia", "Berlin", "Poland", "Sea Zone 11"});
      PRU.addTroops(GERMANY, INFANTRY, 6);
      PRU.addTroops(GERMANY, ARTILLERY, 3);
      
      Territory TOG = new Territory("Togoland", GERMANY, false, 1, new String[]{"Gold Coast", "Nigeria", "Sea Zone 23"});
      TOG.addTroops(GERMANY, INFANTRY, 1);
      
      Territory KAM = new Territory("Kamerun", GERMANY, false, 1, new String[]{"Nigeria", "French Equatorial Africa", "Belgian Congo", "Sea Zone 24"});
      KAM.addTroops(GERMANY, INFANTRY, 1);
      
      Territory GEA = new Territory("German East Africa", GERMANY, false, 1, new String[]{"Belgian Congo", "British East Africa", "Portugese East Africa", "Rhodesia", "Sea Zone 26"});
      GEA.addTroops(GERMANY, INFANTRY, 1);
      
      Territory SWA = new Territory("South West Africa", GERMANY, false, 1, new String[]{"Angola", "Union of South Africa", "Sea Zone 24"});
      SWA.addTroops(GERMANY, INFANTRY, 1);
      SWA.addTroops(GERMANY, ARTILLERY, 1);
   
   
        // FRANCE
      Territory PAR = new Territory("Paris", FRANCE, true, 6, new String[]{"Brest", "Picardy", "Burgundy", "Bordeaux"});
      PAR.addTroops(FRANCE, INFANTRY, 6);
      PAR.addTroops(FRANCE, ARTILLERY, 2);
      PAR.addTroops(FRANCE, FIGHTER, 1);
   
      Territory PIC = new Territory("Picardy", FRANCE, false, 2, new String[]{"Brest", "Paris", "Burgundy", "Lorraine", "Belgium", "Sea Zone 8", "Sea Zone 9"});
      PIC.addTroops(FRANCE, INFANTRY, 6);
      PIC.addTroops(FRANCE, ARTILLERY, 2);
   
      Territory BRE = new Territory("Brest", FRANCE, false, 2, new String[]{"Brest", "Picardy","Bordeaux", "Sea Zone 8", "Sea Zone 15"});
      BRE.addTroops(FRANCE, INFANTRY, 1);
   
      Territory BOR = new Territory("Bordeaux", FRANCE, false, 2, new String[]{"Brest", "Paris", "Burgundy", "Marseilles", "Spain", "Sea Zone 15"});
      BOR.addTroops(FRANCE, INFANTRY, 1);
   
      Territory BUR = new Territory("Burgundy", FRANCE, false, 2, new String[]{"Picardy", "Paris", "Bordeaux", "Marseilles", "Lorraine", "Switzerland", "Piedmont"});
      BUR.addTroops(FRANCE, INFANTRY, 6);
      BUR.addTroops(FRANCE, ARTILLERY, 2);
   
      Territory LOR = new Territory("Lorraine", FRANCE, false, 2, new String[]{"Burgundy", "Picardy", "Belgium", "Alsace", "Switzerland"});
      LOR.addTroops(FRANCE, INFANTRY, 6);
      LOR.addTroops(FRANCE, ARTILLERY, 2);
   
      Territory MAR = new Territory("Marseilles", FRANCE, false, 2, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont", "Sea Zone 16"});
   
      Territory MOR = new Territory("Morocco", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont", "Sea Zone 14"});
      MOR.addTroops(FRANCE, INFANTRY, 1);
   
      Territory ALG = new Territory("Algeria", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont", "Sea Zone 16"});
      ALG.addTroops(FRANCE, INFANTRY, 1);
   
      Territory TUN = new Territory("Tunisia", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont", "Sea Zone 16"});
      TUN.addTroops(FRANCE, INFANTRY, 1);
   
      Territory FWA = new Territory("French West Africa", FRANCE, false, 1, new String[]{"Spain", "Bordeaux", "Burgundy", "Piedmont", "Sea Zone 22", "Sea Zone 23"});
      FWA.addTroops(FRANCE, INFANTRY, 1);
      
      Territory MAD = new Territory("Madagascar", FRANCE, false, 1, new String[]{"Sea Zone 26"});
   
   
        // BRITAIN
      Territory LON = new Territory("London", UK, true, 6, new String[]{"Wales", "Yorkshire", "Sea Zone 9"});
      LON.addTroops(UK, INFANTRY, 6);
      LON.addTroops(UK, ARTILLERY, 2);
      
      Territory WAL = new Territory("Wales", UK, false, 3, new String[]{"London", "Yorkshire", "Sea Zone 8"});
      WAL.addTroops(UK, INFANTRY, 4);
      WAL.addTroops(UK, ARTILLERY, 1);
      
      Territory YOR = new Territory("Yorkshire", UK, false, 2, new String[]{"Wales", "London", "Scotland", "Sea Zone 8", "Sea Zone 9"});
      YOR.addTroops(UK, INFANTRY, 1);
      
      Territory SCO = new Territory("Scotland", UK, false, 2, new String[]{"Yorkshire", "Sea Zone 4", "Sea Zone 8", "Sea Zone 9"});
      SCO.addTroops(UK, INFANTRY, 1);
      
      Territory IRE = new Territory("Ireland", UK, false, 1, new String[]{"Sea Zone 3", "Sea Zone 7", "Sea Zone 8"});
      
      Territory CAN = new Territory("Canada", UK, false, 4, new String[]{"United States of America", "Sea Zone 2"});
      CAN.addTroops(UK, INFANTRY, 6);
      CAN.addTroops(UK, ARTILLERY, 2);
      
      Territory IND = new Territory("India", UK, true, 4, new String[]{"Afghanistan", "Persia", "Sea Zone 29"});
      IND.addTroops(UK, INFANTRY, 6);
      IND.addTroops(UK, ARTILLERY, 2);
      
      Territory EGY = new Territory("Egypt", UK, false, 2, new String[]{"Anglo-Egyptian Sudan", "Libya", "Trans-Jordan", "Sea Zone 19", "Sea Zone 28"});
      EGY.addTroops(UK, INFANTRY, 6);
      EGY.addTroops(UK, ARTILLERY, 2);
      
      Territory AES = new Territory("Anglo-Egyptian Sudan", UK, false, 1, new String[]{"Egypt", "Empire of Ethiopia", "British East Africa", "Belgian Congo", "French Equatorial Africa", "Sea Zone 28"});
      AES.addTroops(UK, INFANTRY, 1);
      
      Territory BEA = new Territory("British East Africa", UK, false, 1, new String[]{"Anglo-Egyptian Sudan", "Empire of Ethiopia", "Somaliland", "German East Africa", "Belgian Congo", "Sea Zone 26"});
      BEA.addTroops(UK, INFANTRY, 1);
      
      Territory RHO = new Territory("Rhodesia", UK, false, 1, new String[]{"Union of South Africa", "Angola", "Belgian Congo", "German East Africa", "Portugese East Africa"});
      RHO.addTroops(UK, INFANTRY, 1);
      
      Territory UNI = new Territory("Union of South Africa", UK, false, 1, new String[]{"South West Africa", "Angola", "Rhodesia", "Portugese East Africa", "Sea Zone 25"});
      UNI.addTroops(UK, INFANTRY, 1);
      UNI.addTroops(UK, ARTILLERY, 1);
      
      Territory GC = new Territory("Gold Coast", UK, false, 1, new String[]{"French West Africa", "Togoland", "Sea Zone 23"});
      
      Territory NIG = new Territory("Nigeria", UK, false, 1, new String[]{"Togoland", "Kamerun", "Sea Zone 24"});
      
      
        // OTTOMAN EMPIRE
      Territory CON = new Territory("Constantinople", OTTOMAN_EMPIRE, true, 6, new String[]{"Bulgaria", "Greece", "Ankara", "Smyrna", "Sea Zone 20", "Sea Zone 20A"});
      CON.addTroops(OTTOMAN_EMPIRE, INFANTRY, 6);
      CON.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 2);
      
      Territory SMY = new Territory("Smyrna", OTTOMAN_EMPIRE, false, 2, new String[]{"Constantinople", "Ankara", "Syrian Desert", "Trans-Jordan", "Sea Zone 19"});
      SMY.addTroops(OTTOMAN_EMPIRE, INFANTRY, 6);
      SMY.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
      Territory ANK = new Territory("Ankara", OTTOMAN_EMPIRE, false, 3, new String[]{"Constantinople", "Smyrna", "Syrian Desert", "Mesopotamia", "Sea Zone 20"});
      ANK.addTroops(OTTOMAN_EMPIRE, INFANTRY, 6);
      ANK.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
      Territory MES = new Territory("Mesopotamia", OTTOMAN_EMPIRE, false, 3, new String[]{"Ankara", "Syrian Desert", "Arabia", "Persia", "Sea Zone 20"});
      MES.addTroops(OTTOMAN_EMPIRE, INFANTRY, 2);
      MES.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
      Territory SYR = new Territory("Syrian Desert", OTTOMAN_EMPIRE, false, 1, new String[]{"Trans-Jordan", "Constantinople", "Ankara", "Mesopotamia", "Arabia"});
      SYR.addTroops(OTTOMAN_EMPIRE, INFANTRY, 1);
      
      Territory TRA = new Territory("Trans-Jordan", OTTOMAN_EMPIRE, false, 1, new String[]{"Egypt", "Smyrna", "Syrian Desert", "Arabia", "Sea Zone 19", "Sea Zone 28"});
      TRA.addTroops(OTTOMAN_EMPIRE, INFANTRY, 2);
      TRA.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
      
        // ITALY
      Territory PIE = new Territory("Piedmont", ITALY, false, 6, new String[]{"Marseilles", "Burgundy", "Switzerland", "Venice", "Tuscany", "Sea Zone 17"});
      PIE.addTroops(ITALY, INFANTRY, 6);
      PIE.addTroops(ITALY, ARTILLERY, 2);
      
      Territory VEN = new Territory("Venice", ITALY, false, 3, new String[]{"Tuscany", "Piedmont", "Switzerland", "Tyrolia", "Trieste", "Sea Zone 18"});
      VEN.addTroops(ITALY, INFANTRY, 6);
      VEN.addTroops(ITALY, ARTILLERY, 2);
      
      Territory TUS = new Territory("Tuscany", ITALY, false, 3, new String[]{"Piedmont", "Venice", "Rome", "Sea Zone 17", "Sea Zone 18"});
      TUS.addTroops(ITALY, INFANTRY, 1);
      
      Territory ROM = new Territory("Rome", ITALY, true, 3, new String[]{"Tuscany", "Naples", "Sea Zone 17"});
      ROM.addTroops(ITALY, INFANTRY, 6);
      ROM.addTroops(ITALY, ARTILLERY, 2);
      
      Territory NAP = new Territory("Naples", ITALY, false, 3, new String[]{"Rome", "Sea Zone 17"});
      NAP.addTroops(ITALY, INFANTRY, 1);
      
      Territory LIB = new Territory("Libya", ITALY, false, 3, new String[]{"Tunisia", "Egypt", "Sea Zone 17"});
      LIB.addTroops(ITALY, INFANTRY, 1);
      LIB.addTroops(ITALY, ARTILLERY, 1);
      
      Territory SOM = new Territory("Somaliland", ITALY, false, 3, new String[]{"British East Africa", "Empire of Ethiopia", "Sea Zone 27"});
      SOM.addTroops(ITALY, INFANTRY, 1);
      
      
        // USA
      Territory WAS = new Territory("Washington", USA, true, 20, new String[]{"Canada", "Sea Zone 1"});
      WAS.addTroops(USA, INFANTRY, 6);
      WAS.addTroops(USA, ARTILLERY, 2);
      
      
        // NEUTRALS
      Territory NOR = new NeutralTerritory(NEUTRAL, false, "Norway", 4, new String[]{"Sweden", "Finland", "Sea Zone 5", "Sea Zone 10"});
      Territory SWE = new NeutralTerritory(NEUTRAL, false, "Sweden", 4, new String[]{"Norway", "Finland", "Sea Zone 11", "Sea Zone 12"});
      Territory DEN = new NeutralTerritory(NEUTRAL, false, "Denmark", 2, new String[]{"Kiel", "Sea Zone 10", "Sea Zone 11"});
      Territory HOL = new NeutralTerritory(NEUTRAL, false, "Holland", 2, new String[]{"Belgium", "Ruhr", "Kiel", "Sea Zone 10"});
      Territory SWI = new NeutralTerritory(NEUTRAL, false, "Switzerland", 1, new String[]{"Alsace", "Munich", "Tyrolia", "Venice", "Piedmont", "Burgundy", "Lorraine"});
      Territory SPA = new NeutralTerritory(NEUTRAL, false, "Spain", 4, new String[]{"Portugal", "Bordeaux", "Marseilles", "Sea Zone 7", "Sea Zone 14", "Sea Zone 15", "Sea Zone 16"});
      Territory SPM = new NeutralTerritory(NEUTRAL, false, "Spanish Morocco", 1, new String[]{"Morocco", "Algeria", "Sea Zone 14", "Sea Zone 16"});
      Territory ETH = new NeutralTerritory(NEUTRAL, false, "Empire of Ethiopia", 1, new String[]{"Somaliland", "British East Africa", "Anglo-Egyptian Sudan", "Sea Zone 28"});
      Territory GRE = new NeutralTerritory(NEUTRAL, false, "Greece", 2, new String[]{"Albania", "Serbia", "Bulgaria", "Constantinople", "Sea Zone 17", "Sea Zone 20A"});
      Territory PER = new NeutralTerritory(NEUTRAL, false, "Persia", 2, new String[]{"Mesopotamia", "Sevastopol", "Kazakhstan", "Afghanistan", "India", "Sea Zone 29", "Sea Zone 30"});
      Territory AFG = new NeutralTerritory(NEUTRAL, false, "Afghanistan", 1, new String[]{"Persia", "Kazakhstan", "India"});
      Territory BLG = new NeutralTerritory(FRANCE, false, "Belgium", 2, new String[]{"Picardy", "Lorraine", "Alsace", "Ruhr", "Holland", "Sea Zone 9"});
      Territory POR = new NeutralTerritory(FRANCE, false, "Portugal", 2, new String[]{"Spain", "Sea Zone 14"});
      Territory ALB = new NeutralTerritory(ITALY, false, "Albania", 2, new String[]{"Trieste", "Serbia", "Greece", "Sea Zone 17"});
      Territory SER = new NeutralTerritory(RUSSIA, false, "Serbia", 2, new String[]{"Greece", "Albania", "Trieste", "Budapest", "Romania", "Bulgaria"});
      Territory RMN = new NeutralTerritory(RUSSIA, false, "Romania", 3, new String[]{"Bulgaria", "Serbia", "Budapest", "Galicia", "Ukraine", "Sevastopol", "Sea Zone 21"});
      Territory BUL = new NeutralTerritory(OTTOMAN_EMPIRE, false, "Bulgaria", 3, new String[]{"Constantinople", "Greece", "Serbia", "Romania", "Sea Zone 21"});
      Territory ARA = new NeutralTerritory(UK, false, "Arabia", 1, new String[]{"Picardy", "Lorraine", "Alsace", "Ruhr", "Holland", "Sea Zone 27", "Sea Zone 28", "Sea Zone 29"});
      
      // SEA ZONES
      SeaZone SZ1 = new SeaZone(1, new String[]{"Washington", "Sea Zone 2", "Sea Zone 13"});
      SeaZone SZ2 = new SeaZone(2, new String[]{"Canada", "Sea Zone 1", "Sea Zone 3", "Sea Zone 7", "Sea Zone 13", "Sea Zone 14"});
      SeaZone SZ3 = new SeaZone(3, new String[]{"Ireland", "Sea Zone 2", "Sea Zone 4", "Sea Zone 7", "Sea Zone 8"});
      SeaZone SZ4 = new SeaZone(4, new String[]{"Scotland", "Sea Zone 3", "Sea Zone 5", "Sea Zone 8", "Sea Zone 9"});
      SeaZone SZ5 = new SeaZone(5, new String[]{"Norway", "Sea Zone 4", "Sea Zone 6", "Sea Zone 9", "Sea Zone 10"});
      SeaZone SZ6 = new SeaZone(6, new String[]{"Karelia", "Sea Zone 5"});
      SeaZone SZ7 = new SeaZone(7, new String[]{"Ireland", "Spain", "Sea Zone 2", "Sea Zone 3", "Sea Zone 8", "Sea Zone 14", "Sea Zone 15"});
      SeaZone SZ8 = new SeaZone(8, new String[]{"Ireland", "Wales", "Yorkshire", "Scotland", "Brest", "Picardy", "Sea Zone 3", "Sea Zone 4", "Sea Zone 7", "Sea Zone 9", "Sea Zone 15"});
      SeaZone SZ9 = new SeaZone(9, new String[]{"Scotland", "Yorkshire", "London", "Picardy", "Belgium", "Sea Zone 4", "Sea Zone 5", "Sea Zone 8", "Sea Zone 10"});
      SeaZone SZ10 = new SeaZone(10, new String[]{"Holland", "Kiel", "Denmark", "Norway", "Sea Zone 5", "Sea Zone 9", "Sea Zone 11"});
      SeaZone SZ11 = new SeaZone(11, new String[]{"Sweden", "Denmark", "Berlin", "Prussia", "Sea Zone 10", "Sea Zone 12"});
      SeaZone SZ12 = new SeaZone(12, new String[]{"Sweden", "Finland", "Karelia", "Livonia", "Poland", "Sea Zone 11"});
      SeaZone SZ13 = new SeaZone(13, new String[]{"Sea Zone 1", "Sea Zone 2", "Sea Zone 7", "Sea Zone 14", "Sea Zone 22"});
      SeaZone SZ14 = new SeaZone(14, new String[]{"Morocco", "Spanish Morocco", "Portugal", "Spain", "Sea Zone 2", "Sea Zone 7", "Sea Zone 13", "Sea Zone "});
      SeaZone SZ15 = new SeaZone(15, new String[]{"Spain", "Brest", "Bordeaux", "Sea Zone 7", "Sea Zone 8"});
      SeaZone SZ16 = new SeaZone(16, new String[]{"Spain", "Spanish Morocco", "Algeria", "Tunisia", "Marseilles", "Sea Zone 14"});
      SeaZone SZ17 = new SeaZone(17, new String[]{"Libya", "Egypt", "Piedmont", "Tuscany", "Rome", "Naples", "Albania", "Greece", "Sea Zone 18", "Sea Zone 16", "Sea Zone 20A", "Sea Zone 19"});
      SeaZone SZ18 = new SeaZone(18, new String[]{"Tuscany", "Venice", "Trieste", "Sea Zone 17"});
      SeaZone SZ19 = new SeaZone(19, new String[]{"Egypt", "Trans-Jordan", "Smyrna", "Sea Zone 28"});
      SeaZone SZ20 = new SeaZone(20, new String[]{"Constantinople", "Ankarra", "Mesopotamia", "Sea Zone 20A", "Sea Zone 21"});
      SeaZone SZ20A = new SeaZone("Sea Zone 20A", new String[]{"Greece", "Constantinople", "Sea Zone 20"});
      SeaZone SZ21 = new SeaZone(21, new String[]{"Sevastopol", "Bulgaria", "Romania", "Sea Zone 20"});
      SeaZone SZ22 = new SeaZone(22, new String[]{"French West Africa", "Sea Zone 13", "Sea Zone 14", "Sea Zone 23"});
      SeaZone SZ23 = new SeaZone(23, new String[]{"French West Africa", "Gold Coast", "Togoland", "Sea Zone 22", "Sea Zone 24"});
      SeaZone SZ24 = new SeaZone(24, new String[]{"Nigeria", "Kamerun", "Belgian Congo", "Angola", "South West Africa", "Sea Zone 23", "Sea Zone 25"});
      SeaZone SZ25 = new SeaZone(25, new String[]{"Union of South Africa", "Sea Zone 24", "Sea Zone 26"});
      SeaZone SZ26 = new SeaZone(26, new String[]{"Madagascar", "Portugese East Africa", "German East Africa", "British East Africa", "Sea Zone 25", "Sea Zone 27"});
      SeaZone SZ27 = new SeaZone(27, new String[]{"Somaliland", "Arabia", "Sea Zone 29", "Sea Zone 26", "Sea Zone 28"});
      SeaZone SZ28 = new SeaZone(28, new String[]{"Trans-Jordan", "Arabia", "Empire of Ethiopia", "Anglo-Egyptian Sudan", "Egypt", "Sea Zone 27", "Sea Zone 19"});
      SeaZone SZ29 = new SeaZone(29, new String[]{"Arabia", "Mesopotamia", "Persia", "India", "Sea Zone 27"});
      SeaZone SZ30 = new SeaZone(30, new String[]{"Sevastopol", "Persia", "Kazakhstan", "Tatarstan"});
      
      Territory PRDL = new Territory("Production Zone", NEUTRAL, false, 0, new String[]{});
      SeaZone PRDS = new SeaZone("Production Zone", new String[]{});
   
      Territory[] board = new Territory[]{VIE, BOH, TYR, TRI, BUD, GAL, 
                                          FIN, KAR, LIV, POL, BEL, MOS, UKR, TAT, SEV, KAZ, 
                                          BER, KIE, RUH, ALS, MUN, HAN, SIL, PRU, TOG, KAM, GEA, SWA, 
                                          PAR, PIC, BRE, BOR, BUR, LOR, MOR, ALG, TUN, FWA, MAR, 
                                          LON, WAL, YOR, IRE, SCO, CAN, IND, AES, BEA, RHO, UNI, GC, NIG, 
                                          CON, SMY, ANK, MES, SYR, TRA, 
                                          PIE, VEN, TUS, ROM, NAP, LIB, SOM, 
                                          WAS, 
                                          NOR, SWE, DEN, HOL, SWI, SPA, SPM, ETH, GRE, PER, AFG, BLG, POR, ALB, SER, RMN, BUL, ARA,
                                          SZ1, SZ2, SZ3, SZ4, SZ5, SZ6, SZ7, SZ8, SZ9, SZ10, SZ11, SZ12, SZ13, SZ14, SZ15, 
                                          SZ16, SZ17, SZ18, SZ19, SZ20, SZ20A, SZ21, SZ22, SZ23, SZ24, SZ25, SZ26, SZ27, SZ28, SZ29, SZ30};
   
   
      Scanner input = new Scanner(System.in);
        
      int alliedCapsTaken = 0;
      int centralCapsTaken = 0;
      int winner = -1;
   
      Country curr = AUSTRIA_HUNGARY;
   
      while(winner == -1) // while there is no winner
      {
         for(int i = 0; i < TURN_ORDER.length; i++) // for each player's turn
         {
            curr = TURN_ORDER[i]; // set current player to the next player in the list
            System.out.println(TURN_START_TEXT[i]); // text for turn start i.e. "It is Austria-Hungary's turn."
            
            // phase 1: purchase and repair units
            // repair battleships
            
            // purchase units
            int unit = -2;
            Army producedUnits = new Army(curr, PRDL);
            Fleet producedShips = new Fleet(curr, PRDS);
            while(curr.getCredits() > 0) // building units
            {    
               System.out.println("You have " + curr.getCredits() + " IPCs left. What would you like to build? [-1 - stop, 0 - infantry (3 IPCs), 1 - artillery (4 IPCs), 2 - tank (6 IPCs), 3 - fighter (6 IPCs), 4 - battleship (12 IPCs), 5 - cruiser (9 IPCs), 6 - submarine (6 IPCs), 7 - transport (6 IPCs)]");
               unit = input.nextInt();
               if(unit < -1 || unit > 7)
                  continue;
               if(unit == -1)
                  break;
               if(unit < 4) // ground unit
                  producedUnits.addTroops(unit, 1);
               else
                  producedShips.addTroops(unit, 1);
               curr.changeCredits(-1 * PRICES[unit]); // subtracts the price
            }
            input.nextLine();
            
            // phase 2: movement
            String end = "";
            Territory loc = new Territory();
            ArrayList<Territory> newlyContested = new ArrayList<Territory>();
            while(true)
            {
               System.out.println("Type the name of the location that you want to move to, or type 'stop' to stop.");
               end = input.nextLine().toLowerCase();
               if(end.equals("stop"))
                  break;
               else
               {
                  for(int j = 0; j < board.length; j++)
                  {
                     if(board[j].getName().toLowerCase().equals(end))
                     {
                        loc = board[j];
                        break;
                     }
                  }
                  String[] nei = loc.getNeighbors();
                  ArrayList<String> temp = new ArrayList();
                  for(int j = 0; j < nei.length; j++)
                  {
                        // turn string into territory
                     Territory c = new Territory();
                     for(int k = 0; k < board.length; k++)
                     {
                        if(board[k].getName().toLowerCase().equals(nei[j].toLowerCase()))
                        {
                           c = board[k];
                           break;
                        }
                     }
                        // figure out which army list we're looking through
                     ArrayList<Army> armies = new ArrayList<Army>();
                     if(curr.isCentralPower())
                        armies = c.getCentralPowers();
                     else
                        armies = c.getAlliedPowers();
                        
                     for(int k = 0; k < armies.size(); k++)
                     {
                        if(armies.get(k).getController().equals(curr))
                        {
                           temp.add(nei[j] + ":\n" + armies.get(k));
                        }
                     }
                  }
                  boolean moving = true;
                  if(temp.size() > 0)
                  {
                     System.out.println("Here are the troops you can move into " + loc.getName() + ":");
                     for(int x = 0; x < temp.size(); x++)
                        System.out.println(temp.get(x));
                  }
                  else
                  {
                     System.out.println("None of your troops can reach " + loc.getName() + ".");
                     moving = false;
                  }
                  
                  while(moving)
                  {
                     String start = "";
                     System.out.println("Where would you like to move troops into " + loc.getName() + " from? ('stop' to stop)");
                     start = input.nextLine();
                     if(start.equals("stop"))
                        break;
                  // turn string into territory
                     Territory ploc = new Territory();
                     for(int k = 0; k < board.length; k++)
                     {
                        if(board[k].getName().toLowerCase().equals(start.toLowerCase()))
                        {
                           ploc = board[k];
                           break;
                        }
                     }
                  // find out which army object we're looking at
                     ArrayList<Army> armies = new ArrayList<Army>();
                     Army theArmy = null;
                     if(curr.isCentralPower())
                        armies = ploc.getCentralPowers();
                     else
                        armies = ploc.getAlliedPowers();
                        
                     for(int k = 0; k < armies.size(); k++)
                     {
                        if(armies.get(k).getController().equals(curr))
                        {
                           theArmy = armies.get(k);
                        }
                     }
                  
                  // figure out how many of each unit are moving
                     int infantry = -1;
                     int artillery = -1;
                     int tanks = -1;
                     int fighters = -1;
                     
                     String ans = "some really stupid thing that not even the craziest person would ever type in this program to satisfy this particular prerequisite";
                     boolean furtherInput = true;
                     while(!ans.equals("y") && !ans.equals("n"))
                     {
                        System.out.println("Would you like to move all of your troops in " + ploc.getName() + " to " + loc.getName() + "? (y/n)");
                        ans = input.nextLine().toLowerCase();
                     }
                     if(ans.equals("y"))
                     {
                        furtherInput = false;
                        infantry = theArmy.getInfantry();
                        artillery = theArmy.getArtillery();
                        tanks = theArmy.getTanks();
                        fighters = theArmy.getFighters();
                     }
                     if(furtherInput)
                     {
                        if(theArmy.getInfantry() > 0)
                        {
                           while(infantry < 0 || infantry > theArmy.getInfantry())
                           {
                              System.out.println("How many infantry would you like to move? (up to " + theArmy.getInfantry() + ")");
                              infantry = input.nextInt();
                           }
                           if(infantry == theArmy.getInfantry())
                           {
                              artillery = theArmy.getArtillery();
                              tanks = theArmy.getTanks();
                              fighters = theArmy.getFighters();
                              System.out.println("Since you have chosen to move all of your infantry in " + ploc.getName() + ", the rest of your troops there will be moved automatically.");
                           }
                        }
                        if(theArmy.getArtillery() > 0)
                        {
                           while(artillery < 0 || artillery > theArmy.getArtillery())
                           {
                              System.out.println("How many artillery would you like to move? (up to " + theArmy.getArtillery() + ")");
                              artillery = input.nextInt();
                           }
                        }
                        if(theArmy.getTanks() > 0)
                        {
                           while(tanks < 0 || tanks > theArmy.getTanks())
                           {
                              System.out.println("How many tanks would you like to move? (up to " + theArmy.getTanks() + ")");
                              tanks = input.nextInt();
                           }
                        }
                        if(theArmy.getFighters() > 0)
                        {
                           while(fighters < 0 || fighters > theArmy.getFighters())
                           {
                              System.out.println("How many fighters would you like to move? (up to " + theArmy.getFighters() + ")");
                              fighters = input.nextInt();
                           }
                        }
                        input.nextLine();
                        if(infantry < 0)
                           infantry = 0;
                        if(artillery < 0)
                           artillery = 0;
                        if(tanks < 0)
                           tanks = 0;
                        if(fighters < 0)
                           fighters = 0;
                     }
                  
                     // remove troops from starting location
                     ploc.addTroops(curr, INFANTRY, -1 * infantry);
                     ploc.addTroops(curr, ARTILLERY, -1 * artillery);
                     ploc.addTroops(curr, TANK, -1 * tanks);
                     ploc.addTroops(curr, FIGHTER, -1 * fighters);
                  
                     // add troops to end location
                     loc.addTroops(curr, INFANTRY, infantry);
                     loc.addTroops(curr, ARTILLERY, artillery);
                     loc.addTroops(curr, TANK, tanks);
                     loc.addTroops(curr, FIGHTER, fighters);
                     // set the territory to be contested if needed
                     if(loc.getAlliedPowers().size() > 0 && loc.getCentralPowers().size() > 0 && !loc.isContested())
                     {
                        loc.setContested(true);
                        System.out.println(loc.getName() + " is now contested.");
                        newlyContested.add(loc);
                     }
                     
                     // mobilize a neutral territory if needed
                     if(loc.getController().getName().equals("none"))
                     {
                        ArrayList<Army> armies2 = new ArrayList<Army>();
                        if(!curr.isCentralPower())
                           armies2 = loc.getAlliedPowers();
                        else
                           armies2 = loc.getCentralPowers();
                        
                        for(int a = 0; a < armies2.size(); a++)
                        {
                           if(armies2.get(a).getController().equals(curr))
                           {
                              NeutralTerritory temp2 = (NeutralTerritory)(loc);
                              temp2.friendlyMobilize(armies2.get(a));
                              break;
                           }
                        }
                     }
                  }
               }
            }
            
            // phase 3: conduct combat
            // for each territory on the board
            for(int x = 0; x < board.length; x++) 
            {
               // figure out if this territory contains the current player's troops
               ArrayList<Army> armies = new ArrayList<Army>();
               boolean containsTroops = false;
               if(curr.isCentralPower())
                  armies = board[x].getCentralPowers();
               else
                  armies = board[x].getAlliedPowers();
                        
               for(int k = 0; k < armies.size(); k++)
               {
                  if(armies.get(k).getController().equals(curr))
                  {
                     containsTroops = true;
                     break;
                  }
               }
               // if this territory is contested and contains the current player's troops
               if(board[x].isContested() && containsTroops)
               {
                  // figure out if this territory became contested this turn
                  boolean isNewlyContested = false;
                  for(int j = 0; j < newlyContested.size(); j++)
                  {
                     if(newlyContested.get(j).equals(board[x]))
                     {
                        isNewlyContested = true;
                        break;
                     }
                  }
                  if(isNewlyContested)
                  {
                     Battle carnage = new Battle(loc, curr);
                     carnage.landBattle();
                     loc.removeEmptyArmies();
                  }
                  else
                  {
                     String combatOccurs = "";
                     while(true)
                     {
                        System.out.println("Would you like combat to happen in " + board[i].getName() + "? (y/n)");
                        combatOccurs = input.next().toLowerCase();
                        if(combatOccurs.equals("y"))
                        {
                           Battle carnage = new Battle(loc, curr);
                           carnage.landBattle();
                           loc.removeEmptyArmies();
                           break;
                        }
                        else if(combatOccurs.equals("n"))
                           break;
                        // else - ask again until the answer is 'y' or 'n'
                     }
                  }
               }
            }
            
            // phase 4: mobilize new units
            // add the troops to this country's capital
            if(curr.equals(AUSTRIA_HUNGARY))
            {
               if(!producedUnits.isEmpty())
               {
                  VIE.addTroops(curr, INFANTRY, producedUnits.getInfantry());
                  VIE.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
                  VIE.addTroops(curr, TANK, producedUnits.getTanks());
                  VIE.addTroops(curr, FIGHTER, producedUnits.getFighters());
                  System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Vienna.");
               }
               if(!producedShips.isEmpty())
               {
                  SZ18.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP));
                  SZ18.addTroops(curr, CRUISER, producedShips.getShip(CRUISER));
                  SZ18.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE));
                  SZ18.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT));
                  System.out.println(producedShips.getShip(BATTLESHIP) + " battleships, " + producedShips.getShip(CRUISER) + " cruisers, " + producedShips.getShip(SUBMARINE) + " submarines, and " + producedShips.getShip(TRANSPORT) + " transports produced in Sea Zone 18.");
               }
            }
            if(curr.equals(RUSSIA))
            {
               if(!producedUnits.isEmpty())
               {
                  MOS.addTroops(curr, INFANTRY, producedUnits.getInfantry());
                  MOS.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
                  MOS.addTroops(curr, TANK, producedUnits.getTanks());
                  MOS.addTroops(curr, FIGHTER, producedUnits.getFighters());
                  System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Moscow.");
               }
               if(!producedShips.isEmpty())
               {
                  // SZ6 or SZ12 or SZ21
                  int battleships6 = -1;
                  int cruisers6 = -1;
                  int submarines6 = -1;
                  int transports6 = -1;
                  int battleships12 = -1;
                  int cruisers12 = -1;
                  int submarines12 = -1;
                  int transports12 = -1;
                  System.out.println("Choose which troops will be produced in Sea Zone 6.");
                  int battleshipsMax = producedShips.getShip(BATTLESHIP);
                  int cruisersMax = producedShips.getShip(CRUISER);
                  int submarinesMax = producedShips.getShip(SUBMARINE);
                  int transportsMax = producedShips.getShip(TRANSPORT);
                  if(battleshipsMax > 0)
                  {
                     while(battleships6 < 0 || battleships6 > battleshipsMax)
                     {
                        System.out.println("How many battleships will be produced in Sea Zone 6? (max " + battleshipsMax + ")");
                        battleships6 = input.nextInt();
                     }
                     battleshipsMax -= battleships6;
                  }
                  if(cruisersMax > 0)
                  {
                     while(cruisers6 < 0 || cruisers6 > cruisersMax)
                     {
                        System.out.println("How many cruisers will be produced in Sea Zone 6? (max " + cruisersMax + ")");
                        cruisers6 = input.nextInt();
                     }
                     cruisersMax -= cruisers6;
                  }
                  if(submarinesMax > 0)
                  {
                     while(submarines6 < 0 || submarines6 > submarinesMax)
                     {
                        System.out.println("How many submarines will be produced in Sea Zone 6? (max " + submarinesMax + ")");
                        submarines6 = input.nextInt();
                     }
                     submarinesMax -= submarines6;
                  }
                  if(transportsMax > 0)
                  {
                     while(transports6 < 0 || transports6 > transportsMax)
                     {
                        System.out.println("How many transports will be produced in Sea Zone 6? (max " + transportsMax + ")");
                        transports6 = input.nextInt();
                     }
                     transportsMax -= transports6;
                  }
                  if(battleshipsMax > 0 || cruisersMax > 0 || submarinesMax > 0 || transportsMax > 0)
                  {
                     System.out.println("Now choose which troops will be produced in Sea Zone 12.");
                     if(battleshipsMax > 0)
                     {
                        while(battleships12 < 0 || battleships12 > battleshipsMax)
                        {
                           System.out.println("How many battleships will be produced in Sea Zone 12? (max " + battleshipsMax + ")");
                           battleships12 = input.nextInt();
                        }
                        battleshipsMax -= battleships12;
                     }
                     if(cruisersMax > 0)
                     {
                        while(cruisers12 < 0 || cruisers12 > cruisersMax)
                        {
                           System.out.println("How many cruisers will be produced in Sea Zone 12? (max " + cruisersMax + ")");
                           cruisers12 = input.nextInt();
                        }
                        cruisersMax -= cruisers12;
                     }
                     if(submarinesMax > 0)
                     {
                        while(submarines12 < 0 || submarines12 > submarinesMax)
                        {
                           System.out.println("How many submarines will be produced in Sea Zone 12? (max " + submarinesMax + ")");
                           submarines12 = input.nextInt();
                        }
                        submarinesMax -= submarines12;
                     }
                     if(transportsMax > 0)
                     {
                        while(transports12 < 0 || transports12 > transportsMax)
                        {
                           System.out.println("How many transports will be produced in Sea Zone 12? (max " + transportsMax + ")");
                           transports12 = input.nextInt();
                        }
                        transportsMax -= transports12;
                     }
                  }
                  if(battleships6 < 0)
                     battleships6 = 0;
                  if(cruisers6 < 0)
                     cruisers6 = 0;
                  if(submarines6 < 0)
                     submarines6 = 0;
                  if(transports6 < 0)
                     transports6 = 0;
                  if(battleships12 < 0)
                     battleships12 = 0;
                  if(cruisers12 < 0)
                     cruisers12 = 0;
                  if(submarines12 < 0)
                     submarines12 = 0;
                  if(transports12 < 0)
                     transports12 = 0;
                  
                  SZ6.addTroops(curr, BATTLESHIP, battleships6);
                  SZ6.addTroops(curr, CRUISER, cruisers6);
                  SZ6.addTroops(curr, SUBMARINE, submarines6);
                  SZ6.addTroops(curr, TRANSPORT, transports6);
                  System.out.println(battleships6 + " battleships, " + cruisers6 + " cruisers, " + submarines6 + " submarines, and " + transports6 + " transports produced in Sea Zone 6.");
                  
                  SZ12.addTroops(curr, BATTLESHIP, battleships12);
                  SZ12.addTroops(curr, CRUISER, cruisers12);
                  SZ12.addTroops(curr, SUBMARINE, submarines12);
                  SZ12.addTroops(curr, TRANSPORT, transports12);
                  System.out.println(battleships12 + " battleships, " + cruisers12 + " cruisers, " + submarines12 + " submarines, and " + transports12 + " transports produced in Sea Zone 12.");
                  
                  SZ21.addTroops(curr, BATTLESHIP, battleshipsMax);
                  SZ21.addTroops(curr, CRUISER, cruisersMax);
                  SZ21.addTroops(curr, SUBMARINE, submarinesMax);
                  SZ21.addTroops(curr, TRANSPORT, transportsMax);
                  System.out.println(battleshipsMax + " battleships, " + cruisersMax + " cruisers, " + submarinesMax + " submarines, and " + transportsMax + " transports produced in Sea Zone 21.");
               }
               
            }
            if(curr.equals(GERMANY))
            {
               if(!producedUnits.isEmpty())
               {
                  BER.addTroops(curr, INFANTRY, producedUnits.getInfantry());
                  BER.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
                  BER.addTroops(curr, TANK, producedUnits.getTanks());
                  BER.addTroops(curr, FIGHTER, producedUnits.getFighters());
                  System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Berlin.");
               }
               // SZ10 or SZ11
               if(!producedShips.isEmpty())
               {
                  int battleships = -1;
                  int cruisers = -1;
                  int submarines = -1;
                  int transports = -1;
                  System.out.println("Choose which troops will be produced in Sea Zone 10, the rest will be produced in Sea Zone 11.");
                  int battleshipsMax = producedShips.getShip(BATTLESHIP);
                  int cruisersMax = producedShips.getShip(CRUISER);
                  int submarinesMax = producedShips.getShip(SUBMARINE);
                  int transportsMax = producedShips.getShip(TRANSPORT);
                  if(battleshipsMax > 0)
                  {
                     while(battleships < 0 || battleships > battleshipsMax)
                     {
                        System.out.println("How many battleships will be produced in Sea Zone 10? (max " + battleshipsMax + ")");
                        battleships = input.nextInt();
                     }
                     battleshipsMax -= battleships;
                  }
                  if(battleshipsMax > 0)
                  {
                     while(cruisers < 0 || cruisers > cruisersMax)
                     {
                        System.out.println("How many cruisers will be produced in Sea Zone 10? (max " + cruisersMax + ")");
                        cruisers = input.nextInt();
                     }
                     cruisersMax -= cruisers;
                  }
                  if(submarinesMax > 0)
                  {
                     while(submarines < 0 || submarines > submarinesMax)
                     {
                        System.out.println("How many submarines will be produced in Sea Zone 10? (max " + submarinesMax + ")");
                        submarines = input.nextInt();
                     }
                     submarinesMax -= submarines;
                  }
                  if(transportsMax > 0)
                  {
                     while(transports < 0 || transports > transportsMax)
                     {
                        System.out.println("How many transports will be produced in Sea Zone 10? (max " + transportsMax + ")");
                        transports = input.nextInt();
                     }
                     transportsMax -= transports;
                  }
                  if(battleships < 0)
                     battleships = 0;
                  if(cruisers < 0)
                     cruisers = 0;
                  if(submarines < 0)
                     submarines = 0;
                  if(transports < 0)
                     transports = 0;
                  
                  SZ10.addTroops(curr, BATTLESHIP, battleships);
                  SZ10.addTroops(curr, CRUISER, cruisers);
                  SZ10.addTroops(curr, SUBMARINE, submarines);
                  SZ10.addTroops(curr, TRANSPORT, transports);
                  System.out.println(battleships + " battleships, " + cruisers + " cruisers, " + submarines + " submarines, and " + transports + " transports produced in Sea Zone 10.");
               
                  SZ11.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP) - battleships);
                  SZ11.addTroops(curr, CRUISER, producedShips.getShip(CRUISER) - cruisers);
                  SZ11.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE) - submarines);
                  SZ11.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT) - transports);
                  System.out.println((producedShips.getShip(BATTLESHIP) - battleships) + " battleships, " + (producedShips.getShip(CRUISER) - cruisers) + " cruisers, " + (producedShips.getShip(SUBMARINE) - submarines) + " submarines, and " + (producedShips.getShip(TRANSPORT) - transports) + " transports produced in Sea Zone 11.");
               }
            }
            if(curr.equals(FRANCE))
            {
               if(!producedUnits.isEmpty())
               {
                  PAR.addTroops(curr, INFANTRY, producedUnits.getInfantry());
                  PAR.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
                  PAR.addTroops(curr, TANK, producedUnits.getTanks());
                  PAR.addTroops(curr, FIGHTER, producedUnits.getFighters());
                  System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Paris.");
               }
               // SZ15 or SZ16
               int battleships = -1;
               int cruisers = -1;
               int submarines = -1;
               int transports = -1;
               System.out.println("Choose which troops will be produced in Sea Zone 15, the rest will be produced in Sea Zone 16.");
               while(battleships < 0 || battleships > producedShips.getShip(BATTLESHIP))
               {
                  System.out.println("How many battleships will be produced in Sea Zone 15? (max " + producedShips.getShip(BATTLESHIP) + ")");
                  battleships = input.nextInt();
               }
               while(cruisers < 0 || cruisers > producedShips.getShip(CRUISER))
               {
                  System.out.println("How many cruisers will be produced in Sea Zone 15? (max " + producedShips.getShip(CRUISER) + ")");
                  cruisers = input.nextInt();
               }
               while(submarines < 0 || submarines > producedShips.getShip(SUBMARINE))
               {
                  System.out.println("How many submarines will be produced in Sea Zone 15? (max " + producedShips.getShip(SUBMARINE) + ")");
                  submarines = input.nextInt();
               }
               while(transports < 0 || transports > producedShips.getShip(TRANSPORT))
               {
                  System.out.println("How many transports will be produced in Sea Zone 15? (max " + producedShips.getShip(TRANSPORT) + ")");
                  transports = input.nextInt();
               }
               if(battleships < 0)
                  battleships = 0;
               if(cruisers < 0)
                  cruisers = 0;
               if(submarines < 0)
                  submarines = 0;
               if(transports < 0)
                  transports = 0;
               SZ15.addTroops(curr, BATTLESHIP, battleships);
               SZ15.addTroops(curr, CRUISER, cruisers);
               SZ15.addTroops(curr, SUBMARINE, submarines);
               SZ15.addTroops(curr, TRANSPORT, transports);
               System.out.println(battleships + " battleships, " + cruisers + " cruisers, " + submarines + " submarines, and " + transports + " transports produced in Sea Zone 15.");
               
               SZ16.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP) - battleships);
               SZ16.addTroops(curr, CRUISER, producedShips.getShip(CRUISER) - cruisers);
               SZ16.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE) - submarines);
               SZ16.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT) - transports);
               System.out.println((producedShips.getShip(BATTLESHIP) - battleships) + " battleships, " + (producedShips.getShip(CRUISER) - cruisers) + " cruisers, " + (producedShips.getShip(SUBMARINE) - submarines) + " submarines, and " + (producedShips.getShip(TRANSPORT) - transports) + " transports produced in Sea Zone 16.");
            }
            if(curr.equals(UK))
            {
               // LON or IND
               int inf = -1;
               int art = -1;
               int tank = -1;
               int fig = -1;
               System.out.println("Choose which troops will be produced in London, the rest will be produced in Bombay (India).");
               while(inf < 0 || inf > producedUnits.getInfantry())
               {
                  System.out.println("How many infantry will be produced in London? (max " + producedUnits.getInfantry() + ")");
                  inf = input.nextInt();
               }
               while(art < 0 || art > producedUnits.getArtillery())
               {
                  System.out.println("How many artillery will be produced in London? (max " + producedUnits.getArtillery() + ")");
                  art = input.nextInt();
               }
               while(tank < 0 || tank > producedUnits.getTanks())
               {
                  System.out.println("How many tanks will be produced in London? (max " + producedUnits.getTanks() + ")");
                  tank = input.nextInt();
               }
               while(fig < 0 || fig > producedUnits.getFighters())
               {
                  System.out.println("How many fighters will be produced in London? (max " + producedUnits.getFighters() + ")");
                  fig = input.nextInt();
               }
               LON.addTroops(curr, INFANTRY, inf);
               LON.addTroops(curr, ARTILLERY, art);
               LON.addTroops(curr, TANK, tank);
               LON.addTroops(curr, FIGHTER, fig);
               System.out.println(inf + " infantry, " + art + " artillery, " + tank + " tanks, and " + fig + " fighters produced in London.");
               
               IND.addTroops(curr, INFANTRY, producedUnits.getInfantry() - inf);
               IND.addTroops(curr, ARTILLERY, producedUnits.getArtillery() - art);
               IND.addTroops(curr, TANK, producedUnits.getTanks() - tank);
               IND.addTroops(curr, FIGHTER, producedUnits.getFighters() - fig);
               System.out.println((producedUnits.getInfantry() - inf) + " infantry, " + (producedUnits.getArtillery() - art) + " artillery, " + (producedUnits.getTanks() - tank) + " tanks, and " + (producedUnits.getFighters() - fig) + " fighters produced in Bombay (India).");
               // SZ8 or SZ9
               int battleships = -1;
               int cruisers = -1;
               int submarines = -1;
               int transports = -1;
               System.out.println("Choose which troops will be produced in Sea Zone 8, the rest will be produced in Sea Zone 9.");
               while(battleships < 0 || battleships > producedShips.getShip(BATTLESHIP))
               {
                  System.out.println("How many battleships will be produced in Sea Zone 8? (max " + producedShips.getShip(BATTLESHIP) + ")");
                  battleships = input.nextInt();
               }
               while(cruisers < 0 || cruisers > producedShips.getShip(CRUISER))
               {
                  System.out.println("How many cruisers will be produced in Sea Zone 8? (max " + producedShips.getShip(CRUISER) + ")");
                  cruisers = input.nextInt();
               }
               while(submarines < 0 || submarines > producedShips.getShip(SUBMARINE))
               {
                  System.out.println("How many submarines will be produced in Sea Zone 8? (max " + producedShips.getShip(SUBMARINE) + ")");
                  submarines = input.nextInt();
               }
               while(transports < 0 || transports > producedShips.getShip(TRANSPORT))
               {
                  System.out.println("How many transports will be produced in Sea Zone 8? (max " + producedShips.getShip(TRANSPORT) + ")");
                  transports = input.nextInt();
               }
               if(battleships < 0)
                  battleships = 0;
               if(cruisers < 0)
                  cruisers = 0;
               if(submarines < 0)
                  submarines = 0;
               if(transports < 0)
                  transports = 0;
               SZ8.addTroops(curr, BATTLESHIP, battleships);
               SZ8.addTroops(curr, CRUISER, cruisers);
               SZ8.addTroops(curr, SUBMARINE, submarines);
               SZ8.addTroops(curr, TRANSPORT, transports);
               System.out.println(battleships + " battleships, " + cruisers + " cruisers, " + submarines + " submarines, and " + transports + " transports produced in Sea Zone 8.");
               
               SZ9.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP) - battleships);
               SZ9.addTroops(curr, CRUISER, producedShips.getShip(CRUISER) - cruisers);
               SZ9.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE) - submarines);
               SZ9.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT) - transports);
               System.out.println((producedShips.getShip(BATTLESHIP) - battleships) + " battleships, " + (producedShips.getShip(CRUISER) - cruisers) + " cruisers, " + (producedShips.getShip(SUBMARINE) - submarines) + " submarines, and " + (producedShips.getShip(TRANSPORT) - transports) + " transports produced in Sea Zone 9.");
            }
            if(curr.equals(OTTOMAN_EMPIRE))
            {
               CON.addTroops(curr, INFANTRY, producedUnits.getInfantry());
               CON.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
               CON.addTroops(curr, TANK, producedUnits.getTanks());
               CON.addTroops(curr, FIGHTER, producedUnits.getFighters());
               System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Constantinople.");
               // SZ20 or SZ20A
               int battleships = -1;
               int cruisers = -1;
               int submarines = -1;
               int transports = -1;
               System.out.println("Choose which troops will be produced in Sea Zone 20, the rest will be produced in Sea Zone 20A.");
               while(battleships < 0 || battleships > producedShips.getShip(BATTLESHIP))
               {
                  System.out.println("How many battleships will be produced in Sea Zone 20? (max " + producedShips.getShip(BATTLESHIP) + ")");
                  battleships = input.nextInt();
               }
               while(cruisers < 0 || cruisers > producedShips.getShip(CRUISER))
               {
                  System.out.println("How many cruisers will be produced in Sea Zone 20? (max " + producedShips.getShip(CRUISER) + ")");
                  cruisers = input.nextInt();
               }
               while(submarines < 0 || submarines > producedShips.getShip(SUBMARINE))
               {
                  System.out.println("How many submarines will be produced in Sea Zone 20? (max " + producedShips.getShip(SUBMARINE) + ")");
                  submarines = input.nextInt();
               }
               while(transports < 0 || transports > producedShips.getShip(TRANSPORT))
               {
                  System.out.println("How many transports will be produced in Sea Zone 20? (max " + producedShips.getShip(TRANSPORT) + ")");
                  transports = input.nextInt();
               }
               if(battleships < 0)
                  battleships = 0;
               if(cruisers < 0)
                  cruisers = 0;
               if(submarines < 0)
                  submarines = 0;
               if(transports < 0)
                  transports = 0;
               SZ8.addTroops(curr, BATTLESHIP, battleships);
               SZ8.addTroops(curr, CRUISER, cruisers);
               SZ8.addTroops(curr, SUBMARINE, submarines);
               SZ8.addTroops(curr, TRANSPORT, transports);
               System.out.println(battleships + " battleships, " + cruisers + " cruisers, " + submarines + " submarines, and " + transports + " transports produced in Sea Zone 20.");
               
               SZ9.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP) - battleships);
               SZ9.addTroops(curr, CRUISER, producedShips.getShip(CRUISER) - cruisers);
               SZ9.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE) - submarines);
               SZ9.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT) - transports);
               System.out.println((producedShips.getShip(BATTLESHIP) - battleships) + " battleships, " + (producedShips.getShip(CRUISER) - cruisers) + " cruisers, " + (producedShips.getShip(SUBMARINE) - submarines) + " submarines, and " + (producedShips.getShip(TRANSPORT) - transports) + " transports produced in Sea Zone 20A.");
            }
            if(curr.equals(ITALY))
            {
               ROM.addTroops(curr, INFANTRY, producedUnits.getInfantry());
               ROM.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
               ROM.addTroops(curr, TANK, producedUnits.getTanks());
               ROM.addTroops(curr, FIGHTER, producedUnits.getFighters());
               System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Rome.");
               // SZ17
               SZ17.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP));
               SZ17.addTroops(curr, CRUISER, producedShips.getShip(CRUISER));
               SZ17.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE));
               SZ17.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT));
               System.out.println(producedShips.getShip(BATTLESHIP) + " battleships, " + producedShips.getShip(CRUISER) + " cruisers, " + producedShips.getShip(SUBMARINE) + " submarines, and " + producedShips.getShip(TRANSPORT) + " transports produced in Sea Zone 17.");
            }
            if(curr.equals(USA))
            {
               WAS.addTroops(curr, INFANTRY, producedUnits.getInfantry());
               WAS.addTroops(curr, ARTILLERY, producedUnits.getArtillery());
               WAS.addTroops(curr, TANK, producedUnits.getTanks());
               WAS.addTroops(curr, FIGHTER, producedUnits.getFighters());
               System.out.println(producedUnits.getInfantry() + " infantry, " + producedUnits.getArtillery() + " artillery, " + producedUnits.getTanks() + " tanks, and " + producedUnits.getFighters() + " fighters produced in Washington.");
               // SZ1
               SZ1.addTroops(curr, BATTLESHIP, producedShips.getShip(BATTLESHIP));
               SZ1.addTroops(curr, CRUISER, producedShips.getShip(CRUISER));
               SZ1.addTroops(curr, SUBMARINE, producedShips.getShip(SUBMARINE));
               SZ1.addTroops(curr, TRANSPORT, producedShips.getShip(TRANSPORT));
               System.out.println(producedShips.getShip(BATTLESHIP) + " battleships, " + producedShips.getShip(CRUISER) + " cruisers, " + producedShips.getShip(SUBMARINE) + " submarines, and " + producedShips.getShip(TRANSPORT) + " transports produced in Sea Zone 1.");
            }
            // remove the troops from producedUnits and producedShips
            producedUnits.addTroops(INFANTRY, -1 * producedUnits.getInfantry());
            producedUnits.addTroops(ARTILLERY, -1 * producedUnits.getArtillery());
            producedUnits.addTroops(TANK, -1 * producedUnits.getTanks());
            producedUnits.addTroops(FIGHTER, -1 * producedUnits.getFighters());
            
            producedShips.addTroops(BATTLESHIP, -1 * producedShips.getShip(BATTLESHIP));
            producedShips.addTroops(CRUISER, -1 * producedShips.getShip(CRUISER));
            producedShips.addTroops(SUBMARINE, -1 * producedShips.getShip(SUBMARINE));
            producedShips.addTroops(TRANSPORT, -1 * producedShips.getShip(TRANSPORT));
            
            // phase 5: collect income
            boolean capitalControlled = false;
            if(curr.equals(AUSTRIA_HUNGARY) && VIE.getController().equals(AUSTRIA_HUNGARY)) // if this country controls the capital they started with
               capitalControlled = true; // IPCs are produced at the very end of the turn.
            else if(curr.equals(RUSSIA) && MOS.getController().equals(RUSSIA))
               capitalControlled = true;
            else if(curr.equals(GERMANY) && BER.getController().equals(GERMANY))
               capitalControlled = true;
            else if(curr.equals(FRANCE) && PAR.getController().equals(FRANCE))
               capitalControlled = true;
            else if(curr.equals(UK) && LON.getController().equals(UK))
               capitalControlled = true;
            else if(curr.equals(OTTOMAN_EMPIRE) && CON.getController().equals(OTTOMAN_EMPIRE))
               capitalControlled = true;
            else if(curr.equals(ITALY) && ROM.getController().equals(ITALY))
               capitalControlled = true;
            else if(curr.equals(USA) && WAS.getController().equals(USA))
               capitalControlled = true;
            
            if(capitalControlled)
               curr.changeCredits(curr.getProduction());
            System.out.println("You produced " + curr.getProduction() + " IPCs. You have " + curr.getCredits() + " IPCs total.\n\n");
         } // end of a round (each country takes their turn)
      
            // win conditions
         if(centralCapsTaken >= 2 && !BER.getController().isCentralPower()) // 2+ central caps are taken and one of them is Berlin
         {
            winner = ALLIED;
            break;
         }
         else if(alliedCapsTaken >= 2 && (LON.getController().isCentralPower() || PAR.getController().isCentralPower())) // 2+ allied caps are taken and one of them is London or Paris
         {
            winner = CENTRAL;
            break;
         }
      }
   }
}
