package baki;

public class SubAbility {
	private int id;
	private String name;
	private int minValue;
	private int maxValue;
	private String unit;
	
	public SubAbility(int id,String name, int minValue, int maxValue, String unit) {
		this.id = id;
		this.name = name;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.unit = unit;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public int getMinValue() {
		return minValue;
		
	}
	public int getMaxValue(){
		return maxValue;
	}
	public String getUnit() {
		return unit;
	}
	
	
		 @Override
		    public String toString() {
		        return name;
		    }
	

}
	


