public class Territory
{
   private String name;
   private Country controller, originalController;
   private int[] troopsDef,troopsAtk;
   private boolean contested, isCity;
   
   public Territory(String n, Country c, boolean city)
   {
      name = n;
      controller = c;
      originalController = c;
      troopsDef = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
      troopsAtk = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
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
   
   public int[] getTroopsDef()
   {
      return troopsDef;
   }
   
   public int getTroopsDef(int index)
   {
      return troopsDef[index];
   }
   
   public void addTroopsDef(int index, int amt)
   {
      troopsDef[index] += amt;
   }
   
   public int[] getTroopsAtk()
   {
      return troopsAtk;
   }
   
   public int getTroopsAtk(int index)
   {
      return troopsAtk[index];
   }
   
   public void addTroopsAtk(int index, int amt)
   {
      troopsAtk[index] += amt;
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