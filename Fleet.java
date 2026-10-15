import java.util.*;

public class AmphibiousAssault extends Battle
{
    private ArrayList<SeaZone> landingSeaZones = new ArrayList();
    boolean navalFightFirst;
    private Territory turf;
    private Country current;
    public AmphibiousAssault(Territory terr, Country curr, ArrayList<SeaZone> landing, boolean naval)
    {
        super(terr, curr);
        turf = terr;
        current = curr;
        landingSeaZones = landing;
        navalFightFirst = naval;
    }

    public void amphAssault()
    {
        ArrayList<Army> attacker;
        ArrayList<Army> defender;
        if(current.isCentralPower())
        {
            attacker = turf.getCentralPower(current);
            defender = turf.getAlliedPowers();
        }
        else
        {
            defender = turf.getCentralPowers();
            attacker = turf.getAlliedPower(current);
        }
        if(!navalFightFirst)
        {
            bombardmentHits = 0;
            if(!curr.isCentralPower())
            {
                for(int i = 0; i < landingSeaZones.size(); i++)
                {
                    for(int j = 0; j < landingSeaZones.get(i).getAlliedPower(curr).getShip(4)+landingSeaZones.get(i).getAlliedPower(curr).getShip(5); j++)
                    {
                            if(Math.random()*6+1 <= 4)
                                bombardmentHits++;
                    }
                }
            }
            else
            {
                for(int i = 0; i < landingSeaZones.size(); i++)
                {
                    for(int j = 0; j < landingSeaZones.get(i).getCentralPower(curr).getShip(4)+landingSeaZones.get(i).getAlliedPower(curr).getShip(5); j++)
                    {
                            if(Math.random()*6+1 <= 4)
                                bombardmentHits++;
                    }
                }
            }
            System.out.println("The attacker has scored " + bombardmentHits + " hits from bombardment. The defender must remove these units.");
            while(bombardmentHits > 0)
            {
                System.out.println("The defender(s) have hits to assign.");
                System.out.println("The following countries have defenders in the battle: ");
                for(int i = 0; i < defender.size(); i++)
                {
                    System.out.println(defender.get(i).getController().getName());
                }
                System.out.println("What country's army would you like to assign some hits to?");
                String nombre = input.nextLine();
                for(int i = 0; i < defender.size(); i++)
                {
                    if(nombre.equals(defender.get(i).getController().getName()))
                    {
                        System.out.println("Input 0 to remove infantry, 1 to remove artillery, 2 to remove tanks, and 3 to remove planes."); 
                        int type = input.nextInt();
                        System.out.println("How many of that troop would you like to remove?");
                        int remove = input.nextInt();
                        if(remove > defender.get(i).getTroop(type))
                            System.out.println("You cannot remove more troops than you have. Please try again.");
                        else
                        {
                            defender.get(i).addTroops(type, -remove);
                            attackerHits -= remove;
                            if(defender.get(i).getInfantry() == 0 && (defender.get(i).getFighters() !=0 || defender.get(i).getArtillery() != 0 || defender.get(i).getTanks() != 0))
                            {
                                System.out.println("You cannot lose ALL of your infantry before other units; at least one must remain. We will remove all but one.");
                                attackerHits++;
                                defender.get(i).addTroops(0, 1);
                            }
                        }
                        break;
                    }
                }
            }
        }
        landingHits = 0;
        if(!turf.isContested())
        {
            for(int i = 0; i < defender.size(); i++)
            {
                for(int j = 0; j < defender.get(i).getArtillery(); j++)
                {
                    if((int)Math.random()*6 + 1 <= 3)
                        landingHits++;
                }
            }
        }
    }
}
