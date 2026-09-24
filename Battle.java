import java.util.Scanner;
public class Battle
{
  Territory battleSite, Country current;
  public Battle(Territory t, Country curr)
  {
    battleSite = t;
    current = c;
  }
  public void fullBattle()
  {
    Scanner input = new Scanner(System.in);
    if(current.isCentralPower())
    {
      Army attacker = battleSite.getCentralPower(current);  
      ArrayList<Army> defender = battleSite.getAlliedPowers();

      int aair = attacker.getPlanes(); // Start of air battles
      ArrayList<Integer> indexOfAirPowers = new ArrayList<Integer>();
      int totalDefendingPlanes = 0;
      for(int i = 0; i < defender.size(); i++)
      {
        if(defender.get(i).getPlanes() != 0)
        {
          indexOfAirPowers.add(i);
          totalDefendingPlanes += defender.get(i).getPlanes();
        }
      }

      while(aair !<= 0 && indexOfAirPowers.size() !<= 0)
      {
        int attackerHits = 0;
        int defenderHits = 0;
        for(int i = 0; i < aair; i++)
        {
          int roll = (int)(Math.random()*6+1);
          if(roll<=2)
            attackerHits++;
        }
        for(int i = 0; i < totalDefendingPlanes; i++)
        {
          int roll = (int)(Math.random()*6+1);
          if(roll<=2)
            defenderHits++;
        }
        System.out.println("The attackers have scored " + attackerHits + " hits. The defenders have scored " + defenderHits + " hits.");
        aair -= defenderHits;
        if(totalDefendingPlanes - attackerHits <= 0)
        {
          for(int i = 0; i < indexOfAirPowers.size(); i++)
          {
            defender.get(indexOfAirPowers.get(i)).addTroops(3, -attackerHits);
          }
        }
        else if(indexOfAirPowers.size() == 1)
        {
          defender.get(indexOfAirPowers.get(0)).addTroops(3, -attackerHits);
        }
        else
        {
          System.out.println("You must choose which planes to eliminate.");
          int hitsToAssign = attackerHits;
          while(hitsToAssign > 0)
          {
            System.out.println("You have " + hitsToAssign + " hits to remove.");
            for(int i = 0; i < indexOfAirPowers.size(); i++)
            {
              System.out.println("How many of " + defender.get(indexOfAirPowers.get(i)).getController().getName() + "'s planes do you want to remove?")
              int remove = input.nextInt();
              if(defender.get(indexOfAirPowers.get(i)).getPlanes()-remove < 0)
                System.out.println("Invalid input, not registered.");
              else if(remove < 0)
                System.out.println("Nice try.");
              else
              {
                hitsToAssign -= remove;
                defender.get(indexOfAirPowers.get(i)).addTroops(3, -remove);
                if(defender.get(indexOfAirPowers.get(i)).getPlanes() <= 0)
                  indexOfAirPowers.remove(i);
              }
            }
          }
        }
      }
    }
    else
    {
      Army attacker = battleSite.getAlliedPower(current);
      ArrayList<Army> defender = battleSite.getCentralPowers();
    }
  }
}
