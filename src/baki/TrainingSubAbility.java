package baki;

public class TrainingSubAbility {

	    private int equipmentSlot;
	    private int abilitySlot;
	    private String abilityName;
	    private double abilityValue;

	    public TrainingSubAbility(
	            int equipmentSlot,
	            int abilitySlot,
	            String abilityName,
	            double abilityValue) {

	        this.equipmentSlot = equipmentSlot;
	        this.abilitySlot = abilitySlot;
	        this.abilityName = abilityName;
	        this.abilityValue = abilityValue;
	    }

	    public int getEquipmentSlot() {
	        return equipmentSlot;
	    }

	    public int getAbilitySlot() {
	        return abilitySlot;
	    }

	    public String getAbilityName() {
	        return abilityName;
	    }

	    public double getAbilityValue() {
	        return abilityValue;
	    }

	    @Override
	    public String toString() {

	        return "補助器具"
	                + equipmentSlot
	                + " / サブ"
	                + abilitySlot
	                + "："
	                + abilityName
	                + " "
	                + abilityValue;
	    }
	}

