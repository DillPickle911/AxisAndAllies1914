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
    Army attacker;
    ArrayList<Army> defender;
    if(current.isCentralPower())
    {
      Army attacker = battleSite.getCentralPower(current);  
      ArrayList<Army> defender = battleSite.getAlliedPowers();
    }
     else
    {
      Army attacker = battleSite.getAlliedPower(current);
      ArrayList<Army> defender = battleSite.getCentralPowers();
    }
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

      while(aair >= 0 && indexOfAirPowers.size() > 0)
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

      // Now begins the "main" battle - artillery, tanks, infantry, planes. Combat runs for only one round.
      int attackingInfantry = attacker.getInfantry();
      int attackingArtillery = attacker.getArtillery();
      int attackingTanks = attacker.getTanks();
      int supportRemaining = attackingArtillery;
      int attackerHits = 0;
      int defenderHits = 0;
      for(int i = 0; i < attackingInfantry; i++) // Attacking infantry
      {
          if(supportRemaining != 0)
          {
            int roll = (int)(Math.random()*6+1);
            if(roll<=3)
              attackerHits++;
            supportRemaining--;
          }
          else
          {
            int roll = (int)(Math.random()*6+1);
            if(roll<=2)
              attackerHits++;
          }
      }    
      if(aair > 0) // Attacking artillery
      {
        for(int i = 0; i < attackingArtillery; i++)
        {
          int roll = (int)(Math.random()*6+1);
            if(roll<=4)
              attackerHits++;
        }
      }
      else
      {
        for(int i = 0; i < attackingArtillery; i++)
        {
          int roll = (int)(Math.random()*6+1);
            if(roll<=3)
              attackerHits++;
        }
      }
      for(int i = 0; i < attackingTanks; i++) // Attacking tanks
      {
          if(supportRemaining != 0)
          {
            int roll = (int)(Math.random()*6+1);
            if(roll<=3)
              attackerHits++;
            supportRemaining--;
          }
          else
          {
            int roll = (int)(Math.random()*6+1);
            if(roll<=2)
              attackerHits++;
          }
      }
      for(int i = 0; i < aair; i++) // Attacking planes
      {
         int roll = (int)(Math.random()*6+1);
            if(roll<=2)
              attackerHits++;
      }

      for(int i = 0; i < defender.size(); i++)
      {
        for(int i = 0; i < defender.get(i).getInfantry(); i++) // defending infantry
        {
           int roll = (int)(Math.random()*6+1);
            if(roll<=3)
              defenderHits++;
        }
        if(defender.get(i).getPlanes() != 0) // Defending planes and artillery
        {
          for(int i = 0; i < defender.get(i).getArtillery(); i++)
          {
            int roll = (int)(Math.random()*6+1);
            if(roll<=4)
              defenderHits++;
          }

          for(int i = 0; i < defender.get(i).getPlanes(); i++)
          {
            int roll = (int)(Math.random()*6+1);
            if(roll<=2)
              defenderHits++;
          }
        }
        for(int i = 0; i < defender.get(i).getTanks(); i++) // defending tanks
        {
          int roll = (int)(Math.random()*6+1);
            if(roll<=1)
              defenderHits++;
        }
      }
      defenderHits -= attacker.getTanks();
      if(defenderHits < 0)
        defenderHits = 0;

      System.out.println("The attackers have scored " + attackerHits + ". The defenders have scored " + defenderHits + ".");
      while(defenderHits != 0)
      {
        System.out.println("The attacker has hits to assign.");
        if(attackingInfantry + attackingArtillery + attackingTanks + aair - defenderHits <= 0)
        {
          attacker.addTroops(0, -defenderHits);
          attacker.addTroops(1, -defenderHits);
          attacker.addTroops(2, -defenderHits);
          attacker.addTroops(3, -defenderHits);
          System.out.println("The attacking army has been wiped out.");
          defenderHits = 0;
        }
        else
        {
          System.out.println("Input 0 to remove infantry, 1 to remove artillery, 2 to remove tanks, and 3 to remove planes."); 
          int type = input.nextInt();
          System.out.println("How many of that troop would you like to remove?");
          int remove = input.nextInt();
          if(remove > attacker.getTroop(type))
            System.out.println("You cannot remove more troops than you have. Please try again.");
          else
          {
            attacker.addTroops(type, -remove);
            defenderHits -= remove
            if(attacker.getInfantry() == 0 && (attacker.getPlanes() !=0 || attacker.getArtillery() != 0 || attacker.getTanks() != 0))
            {
              System.out.println("You cannot lose ALL of your infantry before other units; at least one must remain. We will remove all but one.");
              defenderHits++;
              attacker.addTroops(0, 1);
            }
          }
        }
      }
      while(attackerHits != 0)
      {
        System.out.println("The defender(s) have hits to assign.");
        System.out.println("The following countries have defenders in the battle: ")
        for(int i = 0; i < defender.size(); i++)
        {
          System.out.println(defender.get(i).getController().getName());
        }
        System.out.println("W
      }
    }
  }
