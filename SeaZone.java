import java.util.ArrayList;

public class SeaZone extends Territory
{

    public SeaZone(int n, String[] nei)
    {
      super("Sea Zone " + n, new Country(), false, 0, nei);
    }
    
    public SeaZone(String n, String[] nei)
    {
      super(n, new Country(), false, 0, nei);
    }
    
    public SeaZone()
    {
      super("none", new Country(), false, 0, new String[0]);
    }
    
    @Override
    public void addTroops(Country c, int type, int amt)
   {
      ArrayList<Army> centralPowers = super.getCentralPowers();
      ArrayList<Army> alliedPowers = super.getAlliedPowers();
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
