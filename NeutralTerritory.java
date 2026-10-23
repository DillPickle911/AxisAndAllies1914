public class NeutralTerritory extends Territory
{
   private Country alignment, controller;
   private boolean mobilized;

   public NeutralTerritory(Country a, boolean mob, String n, int i, String[] nei)
   {
      super(n, a, false, i, nei);
      alignment = a;
      mobilized = mob;
      controller = new Country();
   }
   
   @Override
   public Country getController()
   {
      return controller;
   }
   
   public Country getAlignment()
   {
      return alignment;
   }

   public void setAlignment(Country c)
   {
      alignment = c;
   }

   public boolean getMobilizationStatus()
   {
      return mobilized;
   }

   public void friendlyMobilize(Army mobilizer) //Mobilizer is the country moving into an unmobilized neutral territory, this is when an aligned territory is mobilized by its assigned power
   {
      mobilizer.addTroops(0, 2*getIPC()-1);
      mobilizer.addTroops(1, 1);
      mobilized = true;
   }

   public void enemyMobilize(Country c)
   {
      addTroops(c, 0, 2*getIPC()-1);
      addTroops(c, 1, 1);
      mobilized = true;
   }
}