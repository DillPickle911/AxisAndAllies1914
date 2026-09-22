public class NeutralTerritory extends Territory
{
  private Country alignment;
  private boolean mobilized;

  public NeutralTerritory(Country a, boolean mob, String n, Country c, nei)
  {
    super(n, c, false, nei);
    alignment = a;
    mobilized = mob;
  }

  public Country getAlignment()
  {
    return alignment;
  }

  public boolean getMobilizationStatus()
  {
    return mobilized;
  }

  public void mobilize(Army mobilizer) //Mobilizer is the country moving into an unmobilized neutral territory
  {
    if(alignment.equals(mobilizer.getCountry()))
    {
        mobilizer 
    }
  }
}
