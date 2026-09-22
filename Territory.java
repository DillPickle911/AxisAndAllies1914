public class Territory
{
   
   private String name;
   private Country controller, originalController;
   private ArrayList<Army> centralPowers, alliedPowers;
   private boolean contested, isCity;
   private int ipc;
   
   public Territory(String n, Country c, boolean city, int i)
   {
      name = n;
      controller = c;
      originalController = c;
      centralPowers = new ArrayList<Army>;
      troopsAtk = new ArrayList<Army>;
      contested = false;
      isCity = city;
      ipc = i;
   }
   
   public String getName()
   {
      return name;
   }
   
   public Country getController()
   {
      return controller;
   }
   
   public void setController(Country c)
   {
      controller = c;
   }
   
   public Country getOriginalController()
   {
      return originalController;
   }

   public int getIPC()
   {
      return ipc;
   }
   
   public ArrayList<Army> getCentralPowers()
   {
      return centralPowers;
   }
   
   public Army getCentralPowers(int index)
   {
      return centralPowers.get(index);
   }

   public ArrayList<Army> getAlliedPowers()
   {
      return alliedPowers;
   }
   
   public Army getAlliedPowers(int index)
   {
      if(index == 0)
         return alliedPowers.getInfantry();
      if(index == 1)
         return alliedPowers.getArtillery();
      if(index == 2)
         return alliedPowers.getTanks();
      if(index == 3)
         return alliedPowers.getPlanes();
   }

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
            centralPowers.add(new Army(c, this));
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
            centralPowers.add(new Army(0, 0, 0, 0, c, this));
            centralPowers.get(centralPowers.size() - 1).addTroops(type, amt);
         }
      }
   }
   
   public boolean isContested()
   {
      return contested;
   }
   
   public void setContested(boolean c)
   {
      contested = c;
   }
   
   public boolean isCity()
   {
      return isCity;
   }
   
   @Override
   public String toString()
   {
      return "Name: " + name + "\nController: " + controller.getName() + "\nOriginal Controller: " + originalController.getName() + "\nAllied Powers: " + alliedPowers.toString(); + "\n Central Powers: " + centralPowers.toString() + "\nContested?: " + contested + "\nCity?: " + isCity;
   }
}
