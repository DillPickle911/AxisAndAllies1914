public class Territory
{
   public static final INFANTRY = 0;
   public static final ARTILLERY = 1;
   public static final FIGHTER = 2;
   public static final TANK = 3;
   
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
      return alliedPowers.get(index);
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
      return "Name: " + name + "\nController: " + controller.getName() + "\nOriginal Controller: " + originalController.getName() + "\nInfantry: " + troops[0] + "\nArtillery: " + troops[1] + "\nTanks: " + troops[2] + "\nFighters: " + troops[3] + "\nBattleships: " + troops[4] + "\nCruisers: " + troops[5] + "\nSubmarine: " + troops[6] + "\nTransports: " + troops[7] + "\nContested?: " + contested + "\nCity?: " + isCity;
   }
}
