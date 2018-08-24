package weatherPackage;

public class Weather {

	public Location location;
	public CurrentCondition currentCondition;
	public Temperature temperature;
	public Wind wind;
	public Clouds clouds;
	
	public Weather(Location l) {
		location = l;
		currentCondition = new CurrentCondition();
		temperature = new Temperature();
		wind = new Wind();
		clouds = new Clouds();
	}
 
	

}
