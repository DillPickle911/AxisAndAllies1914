public class SeaZone extends Territory
{

    public SeaZone(int n, Country cont, String[] nei)
    {
        super("Sea Zone " + n, cont, false, 0, nei);
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
