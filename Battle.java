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

    if(current.isCentralPower())
    {
      Army attacker = battleSite.getCentralPower(current);  
      ArrayList<Army> defender = battleSite.getAlliedPowers();

      int aair = attacker.getPlanes(); // Start of air battles
      int dair = 0;
      for(int i = 0; i < defender.length; i++)
      {
        dair += defender.get(i).getPlanes();
      }

      while(aair != 0 && dair != 0)
      {
        int attackerHits = 0;
        int defenderHits = 0;
        for(int i = 0; i < aair; i++)
        {
          int roll = (int)(Math.random()*6+1);
          if(roll<=2)
            attackerHits++;
        }
        for(int i = 0; i < dair; i++)
        {
          int roll = (int)(Math.random()*6+1);
          if(roll<=2)
            defenderHits++;
        }
        System.out.println("The attackers have scored " + 
      }
    }
    else
    {
      Army attacker = battleSite.getAlliedPower(current);
      ArrayList<Army> defender = battleSite.getCentralPowers();
    }
  }
}
