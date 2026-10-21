import java.util.ArrayList;

public class SeaZone extends Territory
{
   private ArrayList<Fleet> centralPowers, alliedPowers;
    public SeaZone(int n, String[] nei)
    {
      super("Sea Zone " + n, new Country(), false, 0, nei);
      centralPowers = null;
      alliedPowers = null;
    }
    
    public SeaZone(String n, String[] nei)
    {
      super(n, new Country(), false, 0, nei);
    }
    
    public SeaZone()
    {
      super("none", new Country(), false, 0, new String[0]);
    }

    public ArrayList<Fleet> getAlliedNaval()
    {
      return alliedPowers;
    }

    public ArrayList<Fleet> getCentralNaval()
    {
      return centralPowers;
    }

    public Fleet getAttackerNaval(Country cur)
    {
      if(cur.isCentralPower())
      {
         for(int i = 0; i < centralPowers.size(); i++)
         {
            if(centralPowers.get(i).getController().equals(cur))
               return centralPowers.get(i);
         }
      }
      else
      {
         for(int i = 0; i < centralPowers.size(); i++)
         {
            if(alliedPowers.get(i).getController().equals(cur))
               return alliedPowers.get(i);
         }
      }
      return null;
    }
    
    @Override
    public void addTroops(Country c, int type, int amt)
   {
      boolean countryFound = false;
      if(c.isCentralPower())
      {
         for(int i = 0; i < centralPowers.size(); i++)
         {
            if(centralPowers.get(i).getController().equals(c))
            {
               centralPowers.get(i).addTroops(type, amt);
               countryFound = true;
            }
         }
         if(!countryFound)
         {
            centralPowers.add(new Fleet(c, this));
            centralPowers.get(centralPowers.size() - 1).addTroops(type, amt);
         }
      }
      else
      {
         for(int i = 0; i < alliedPowers.size(); i++)
         {
            if(alliedPowers.get(i).getController().equals(c))
            {
               alliedPowers.get(i).addTroops(type, amt);
               countryFound = true;
            }
         }
         if(!countryFound)
         {
            alliedPowers.add(new Fleet(c, this));
            alliedPowers.get(alliedPowers.size() - 1).addTroops(type, amt);
         }
      }
   }
}
