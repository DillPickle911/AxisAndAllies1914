import java.util.Scanner;

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
      
        Territory TRI = new Territory("Trieste", AUSTRIA_HUNGARY, false, 4, new String[]{"Vienna", "Tyrolia", "Budapest", "Venice", "Albania", "Serbia"});
        TRI.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
        TRI.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
        Territory BUD = new Territory("Budapest", AUSTRIA_HUNGARY, false, 6, new String[]{"Vienna", "Trieste", "Galicia", "Romania", "Serbia"});
        BUD.addTroops(AUSTRIA_HUNGARY, INFANTRY, 12);
        BUD.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
        Territory GAL = new Territory("Galicia", AUSTRIA_HUNGARY, false, 3, new String[]{"Vienna", "Bohemia", "Budapest", "Poland", "Ukraine", "Romania", "Silesia"});
        GAL.addTroops(AUSTRIA_HUNGARY, INFANTRY, 6);
        GAL.addTroops(AUSTRIA_HUNGARY, ARTILLERY, 2);
      
        /*SeaZone SZ18 = new SeaZone(18, AUSTRIA_HUNGARY, new String[]{"Sea Zone 17"});
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


        // BRITAIN
        Territory LON = new Territory("London", UK, true, 6, new String[]{"Wales", "Yorkshire"});
        LON.addTroops(UK, INFANTRY, 6);
        LON.addTroops(UK, ARTILLERY, 2);
      
        Territory WAL = new Territory("Wales", UK, false, 3, new String[]{"London", "Yorkshire"});
        WAL.addTroops(UK, INFANTRY, 4);
        WAL.addTroops(UK, ARTILLERY, 1);
      
        Territory YOR = new Territory("Yorkshire", UK, false, 2, new String[]{"Wales", "London", "Scotland"});
        YOR.addTroops(UK, INFANTRY, 1);
      
        Territory SCO = new Territory("Scotland", UK, false, 2, new String[]{"Brest", "Picardy", "Burgundy", "Bordeaux"});
        SCO.addTroops(UK, INFANTRY, 1);
      
        Territory IRE = new Territory("Ireland", UK, false, 1, new String[]{"none"});
      
        Territory CAN = new Territory("Canada", UK, false, 4, new String[]{"United States of America"});
        CAN.addTroops(UK, INFANTRY, 6);
        CAN.addTroops(UK, ARTILLERY, 2);
      
        Territory IND = new Territory("India", UK, true, 4, new String[]{"Afghanistan", "Persia"});
        IND.addTroops(UK, INFANTRY, 6);
        IND.addTroops(UK, ARTILLERY, 2);
      
        Territory EGY = new Territory("Egypt", UK, false, 2, new String[]{"Anglo-Egyptian Sudan", "Libya", "Trans-Jordan"});
        EGY.addTroops(UK, INFANTRY, 6);
        EGY.addTroops(UK, ARTILLERY, 2);
      
        Territory AES = new Territory("Anglo-Egyptian Sudan", UK, false, 1, new String[]{"Egypt", "Empire of Ethiopia", "British East Africa", "Belgian Congo", "French Equatorial Africa"});
        AES.addTroops(UK, INFANTRY, 1);
      
        Territory BEA = new Territory("British East Africa", UK, false, 1, new String[]{"Anglo-Egyptian Sudan", "Empire of Ethiopia", "Somaliland", "German East Africa", "Belgian Congo"});
        BEA.addTroops(UK, INFANTRY, 1);
      
        Territory RHO = new Territory("Rhodesia", UK, false, 1, new String[]{"Union of South Africa", "Angola", "Belgian Congo", "German East Africa", "Portugese East Africa"});
        RHO.addTroops(UK, INFANTRY, 1);
      
        Territory UNI = new Territory("Union of South Africa", UK, false, 1, new String[]{"South West Africa", "Angola", "Rhodesia", "Portugese East Africa"});
        UNI.addTroops(UK, INFANTRY, 1);
        UNI.addTroops(UK, ARTILLERY, 1);
      
        Territory GC = new Territory("Gold Coast", UK, false, 1, new String[]{"French West Africa", "Togoland"});
      
        Territory NIG = new Territory("Nigeria", UK, false, 1, new String[]{"Togoland", "Kamerun"});
      
        /*Territory SZ2 = new Territory("Sea Zone 2", UK, false);
        SZ2.addTroops(UK, CRUISER, 1);
        SZ2.addTroops(UK, TRANSPORT, 1);
      
        Territory SZ9 = new Territory("Sea Zone 9", UK, false);
        SZ9.addTroops(UK, BATTLESHIP, 1);
        SZ9.addTroops(UK, CRUISER, 2);
        SZ9.addTroops(UK, TRANSPORT, 1);
      
        Territory SZ19 = new Territory("Sea Zone 19", UK, false);
        SZ19.addTroops(UK, CRUISER, 1);
        SZ19.addTroops(UK, TRANSPORT, 1);
      
        Territory SZ29 = new Territory("Sea Zone 29", UK, false);
        SZ29.addTroops(UK, BATTLESHIP, 1);
        SZ29.addTroops(UK, CRUISER, 1);
        SZ29.addTroops(UK, TRANSPORT, 1);*/
      
      
        // OTTOMAN EMPIRE
        Territory CON = new Territory("Constantinople", OTTOMAN_EMPIRE, true, 6, new String[]{"Bulgaria", "Greece", "Ankara", "Smyrna"});
        CON.addTroops(OTTOMAN_EMPIRE, INFANTRY, 6);
        CON.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 2);
      
        Territory SMY = new Territory("Smyrna", OTTOMAN_EMPIRE, false, 2, new String[]{"Constantinople", "Ankara", "Syrian Desert", "Trans-Jordan"});
        SMY.addTroops(OTTOMAN_EMPIRE, INFANTRY, 6);
        SMY.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
        Territory ANK = new Territory("Ankara", OTTOMAN_EMPIRE, false, 3, new String[]{"Constantinople", "Smyrna", "Syrian Desert", "Mesopotamia"});
        ANK.addTroops(OTTOMAN_EMPIRE, INFANTRY, 6);
        ANK.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
        Territory MES = new Territory("Mesopotamia", OTTOMAN_EMPIRE, false, 3, new String[]{"Ankara", "Syrian Desert", "Arabia", "Persia"});
        MES.addTroops(OTTOMAN_EMPIRE, INFANTRY, 2);
        MES.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
        Territory SYR = new Territory("Syrian Desert", OTTOMAN_EMPIRE, false, 1, new String[]{"Trans-Jordan", "Constantinople", "Ankara", "Mesopotamia", "Arabia"});
        SYR.addTroops(OTTOMAN_EMPIRE, INFANTRY, 1);
      
        Territory TRA = new Territory("Trans-Jordan", OTTOMAN_EMPIRE, false, 1, new String[]{"Egypt", "Smyrna", "Syrian Desert", "Arabia"});
        TRA.addTroops(OTTOMAN_EMPIRE, INFANTRY, 2);
        TRA.addTroops(OTTOMAN_EMPIRE, ARTILLERY, 1);
      
        /*Territory SZ20 = new Territory("Sea Zone 20", OTTOMAN_EMPIRE, false);
        SZ20.addTroops(OTTOMAN_EMPIRE, CRUISER, 2);
      
        Territory SZ20.5 = new Territory("Sea Zone 20.5", OTTOMAN_EMPIRE, false);*/
      
      
        // ITALY
        Territory PIE = new Territory("Piedmont", ITALY, false, 6, new String[]{"Marseilles", "Burgundy", "Switzerland", "Venice", "Tuscany"});
        PIE.addTroops(ITALY, INFANTRY, 6);
        PIE.addTroops(ITALY, ARTILLERY, 2);
      
        Territory VEN = new Territory("Venice", ITALY, false, 3, new String[]{"Tuscany", "Piedmont", "Switzerland", "Tyrolia", "Trieste"});
        VEN.addTroops(ITALY, INFANTRY, 6);
        VEN.addTroops(ITALY, ARTILLERY, 2);
      
        Territory TUS = new Territory("Tuscany", ITALY, false, 3, new String[]{"Piedmont", "Venice", "Rome"});
        TUS.addTroops(ITALY, INFANTRY, 1);
      
        Territory ROM = new Territory("Rome", ITALY, true, 3, new String[]{"Tuscany", "Naples"});
        ROM.addTroops(ITALY, INFANTRY, 6);
        ROM.addTroops(ITALY, ARTILLERY, 2);
      
        Territory NAP = new Territory("Naples", ITALY, false, 3, new String[]{"Rome"});
        NAP.addTroops(ITALY, INFANTRY, 1);
      
        Territory LIB = new Territory("Libya", ITALY, false, 3, new String[]{"Tunisia", "Egypt"});
        LIB.addTroops(ITALY, INFANTRY, 1);
        LIB.addTroops(ITALY, ARTILLERY, 1);
      
        Territory SOM = new Territory("Somaliland", ITALY, false, 3, new String[]{"British East Africa", "Empire of Ethiopia"});
        SOM.addTroops(ITALY, INFANTRY, 1);
      
        /*Territory SZ17 = new Territory("Sea Zone 17", ITALY, false);
        SZ17.addTroops(ITALY, BATTLESHIP, 1);
        SZ17.addTroops(ITALY, CRUISER, 1);
        SZ17.addTroops(ITALY, TRANSPORT, 1);*/
      
      
        // USA
        Territory WAS = new Territory("Washington", USA, true, 20, new String[]{"Canada"});
        WAS.addTroops(USA, INFANTRY, 6);
        WAS.addTroops(USA, ARTILLERY, 2);
      
        /*Territory SZ1 = new Territory("Sea Zone 1", US, false);
        SZ1.addTroops(US, BATTLESHIP, 1);
        SZ1.addTroops(US, CRUISER, 1);*/
      
      
        // NEUTRALS
        Territory NOR = new NeutralTerritory(NEUTRAL, "Norway", 4, new String[]{"Sweden", "Finland"});
        Territory SWE = new NeutralTerritory(NEUTRAL, "Sweden", 4, new String[]{"Norway", "Finland"});
        Territory DEN = new NeutralTerritory(NEUTRAL, "Denmark", 2, new String[]{"Kiel"});
        Territory HOL = new NeutralTerritory(NEUTRAL, "Holland", 2, new String[]{"Belgium", "Ruhr", "Kiel"});
        Territory SWI = new NeutralTerritory(NEUTRAL, "Switzerland", 1, new String[]{"Alsace", "Munich", "Tyrolia", "Venice", "Piedmont", "Burgundy", "Lorraine"});
        Territory SPA = new NeutralTerritory(NEUTRAL, "Spain", 4, new String[]{"Portugal", "Bordeaux", "Marseilles"});
        Territory SPM = new NeutralTerritory(NEUTRAL, "Spanish Morocco", 1, new String[]{"Morocco", "Algeria"});
        Territory ETH = new NeutralTerritory(NEUTRAL, "Empire of Ethiopia", 1, new String[]{"Somaliland", "British East Africa", "Anglo-Egyptian Sudan"});
        Territory GRE = new NeutralTerritory(NEUTRAL, "Greece", 2, new String[]{"Albania", "Serbia", "Bulgaria", "Constantinople"});
        Territory PER = new NeutralTerritory(NEUTRAL, "Persia", 2, new String[]{"Mesopotamia", "Sevastopol", "Kazakhstan", "Afghanistan", "India"});
        Territory AFG = new NeutralTerritory(NEUTRAL, "Afghanistan", 1, new String[]{"Persia", "Kazakhstan", "India"});
        Territory BLG = new NeutralTerritory(FRANCE, "Belgium", 2, new String[]{"Picardy", "Lorraine", "Alsace", "Ruhr", "Holland"});
        Territory POR = new NeutralTerritory(FRANCE, "Portugal", 2, new String[]{"Spain"});
        Territory ALB = new NeutralTerritory(ITALY, "Albania", 2, new String[]{"Trieste", "Serbia", "Greece"});
        Territory SER = new NeutralTerritory(RUSSIA, "Serbia", 2, new String[]{"Greece", "Albania", "Trieste", "Budapest", "Romania", "Bulgaria"});
        Territory RMN = new NeutralTerritory(RUSSIA, "Romania", 3, new String[]{"Bulgaria", "Serbia", "Budapest", "Galicia", "Ukraine", "Sevastopol"});
        Territory BUL = new NeutralTerritory(OTTOMAN_EMPIRE, "Bulgaria", 3, new String[]{"Constantinople", "Greece", "Serbia", "Romania"});
        Territory ARA = new NeutralTerritory(UK, "Arabia", 1, new String[]{"Picardy", "Lorraine", "Alsace", "Ruhr", "Holland"});




        Scanner input = new Scanner(System.in);
        
        int alliedCapsTaken = 0;
        int centralCapsTaken = 0;
        int winner = -1;

        Country curr = AUSTRIA_HUNGARY;

        while(winner == -1) // while there is no winner
        {
            for(int i = 0; i < TURN_ORDER.size(); i++)
            {
                curr = TURN_ORDER[i];
                System.out.println("It is Austria-Hungary's turn.");
                int unit = -2;
                Army producedUnits = new Army(curr, null);
                Fleet producedShips = new Fleet(curr, null);
                while(curr.getCredits() > 0)
                {    
                    System.out.println("You have " + curr.getCredits() + " IPCs left. What would you like to build? [-1 - stop, 0 - infantry (3 IPCs), 1 - artillery (4 IPCs), 2 - tank (6 IPCs), 3 - fighter (6 IPCs), 4 - battleship (12 IPCs), 5 - cruiser (9 IPCs), 6 - submarine (6 IPCs), 7 - transport (6 IPCs)]");
                    unit = input.nextInt();
                    if(unit == -1)
                        break;
                    if(unit < 4) // ground unit
                        producedUnits.addTroops(unit, 1);
                    else
                        producedShips.addTroops(unit, 1);
                    curr.changeCredits(-1 * PRICES[unit]); // subtracts the price
                }




                if(curr.equals(AUSTRIA_HUNGARY) && VIE.getController().equals(AUSTRIA_HUNGARY)) // if this country controls the capital they started with
                    curr.changeCredits(curr.getProduction()); // IPCs are produced at the very end of the turn.
            }

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
