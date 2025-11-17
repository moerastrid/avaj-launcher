package ajav.model;

public abstract class Flyable {
	protected WeatherTower weatherTower = null;
	
	public abstract void updateConditions();
	
	public void registerTower(WeatherTower p_tower)	{
		//#TODO nullcheck op p_tower?
		// if (weatherTower != null)
		// 	weatherTower.unregister(this);
		weatherTower = p_tower;
		weatherTower.register(this);
	};
}
