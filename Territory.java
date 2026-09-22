public class Territory
{
   
   private String name;
   private Country controller, originalController;
   private ArrayList<Army> centralPowers, alliedPowers;
   private boolean contested, isCity;
   
   public Territory(String n, Country c, boolean city)
   {
      name = n;
      controller = c;
      originalController = c;
      centralPowers = new ArrayList<Army>;
      troopsAtk = new ArrayList<Army>;
      contested = false;
      isCity = city;
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

   public void addTroops(int power, int type, int amt)
   {
      if(power == 0)
         alliedPowers.addTroops(type, amt);
      else
         centralPowers.addTroops(type, amt);
   }
   
   public void conquer()
   {
      for(int i = 0; i < 8; i++)
      {
         troopsDef[i] = troopsAtk[i];
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
