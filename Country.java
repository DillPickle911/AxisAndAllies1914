public class Country
{
   private String name, capital;
   private int production, credits;
   boolean isAI, isCentralPower;
   
   public Country()
   {
      name = "none";
      production = 0;
      credits = 0;
      capital = "none";
      isAI = true;
      isCentralPower = true;
   }
   
   public Country(String n, int p, String cap, boolean ai, boolean cp)
   {
      name = n;
      production = p;
      credits = p;
      capital = cap;
      isAI = ai;
      isCentralPower = cp;
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getProduction()
   {
      return production;
   }
   
   public void changeProduction(int amt)
   {
      production += amt;
   }
   
   public int getCredits()
   {
      return credits;
   }
   
   public void changeCredits(int amt)
   {
      credits += amt;
   }
   
   public String getCapital()
   {
      return capital;
   }
   
   public boolean isAI()
   {
      return isAI;
   }

   public boolean isCentralPower()
   {
      return isCentralPower;
   }

   public void setCentralPower(boolean x)
   {
      isCentralPower = x;
   }
}
