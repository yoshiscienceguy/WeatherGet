package weatherPackage;

public class CurrentCondition {
	public int id;
	public String description;
	public String condition;
	public String icon;
	public int humidity;
	public int pressure;
	
	public void setWeatherId(int int1) {
		// TODO Auto-generated method stub
		id = int1;
	}

	public void setDescr(String string) {
		// TODO Auto-generated method stub
		description = string;
	}

	public void setCondition(String string) {
		// TODO Auto-generated method stub
		condition = string;
	}

	public void setIcon(String string) {
		// TODO Auto-generated method stub
		icon  = string;
	}

	public void setHumidity(int int1) {
		// TODO Auto-generated method stub
		humidity = int1;
	}

	public void setPressure(int int1) {
		// TODO Auto-generated method stub
		pressure = int1;
	}

	public String getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}

}
