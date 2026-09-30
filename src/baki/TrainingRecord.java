package baki;

public class TrainingRecord {

	    private int id;
	    private Fighter fighter;
	 // ====================
	 // 育成開始時ステータス
	 // ====================

	 private int startStrength;
	 private int startStamina;
	 private int startTechnique;
	 private int startToughness;
	 private int startAgility;
	 private int startMental;

	    private int strength;
	    private int stamina;
	    private int technique;
	    private int toughness;
	    private int agility;
	    private int mental;

	    private int totalStatus;

	    private String note;
	    private String createdAt;

	    public TrainingRecord(
	            int id,
	            Fighter fighter,

	            int startStrength,
	            int startStamina,
	            int startTechnique,
	            int startToughness,
	            int startAgility,
	            int startMental,

	            int strength,
	            int stamina,
	            int technique,
	            int toughness,
	            int agility,
	            int mental,

	            int totalStatus,
	            String note,
	            String createdAt) {

	        this.id = id;
	        this.fighter = fighter;

	        
	        // 開始時
	        this.startStrength = startStrength;
	        this.startStamina = startStamina;
	        this.startTechnique = startTechnique;
	        this.startToughness = startToughness;
	        this.startAgility = startAgility;
	        this.startMental = startMental;

	        // 終了時
	        this.strength = strength;
	        this.stamina = stamina;
	        this.technique = technique;
	        this.toughness = toughness;
	        this.agility = agility;
	        this.mental = mental;

	        this.totalStatus = totalStatus;
	        this.note = note;
	        this.createdAt = createdAt;
	    }

	    public int getStartStrength() {
	        return startStrength;
	    }

	    public int getStartStamina() {
	        return startStamina;
	    }

	    public int getStartTechnique() {
	        return startTechnique;
	    }

	    public int getStartToughness() {
	        return startToughness;
	    }

	    public int getStartAgility() {
	        return startAgility;
	    }

	    public int getStartMental() {
	        return startMental;
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public Fighter getFighter() {
	        return fighter;
	    }

	    public int getStrength() {
	        return strength;
	    }

	    public int getStamina() {
	        return stamina;
	    }

	    public int getTechnique() {
	        return technique;
	    }

	    public int getToughness() {
	        return toughness;
	    }

	    public int getAgility() {
	        return agility;
	    }

	    public int getMental() {
	        return mental;
	    }

	    public int getTotalStatus() {
	        return totalStatus;
	    }

	    public String getNote() {
	        return note;
	    }

	    public String getCreatedAt() {
	        return createdAt;
	    }
	    public int getGainStrength() {
	        return strength - startStrength;
	    }

	    public int getGainStamina() {
	        return stamina - startStamina;
	    }

	    public int getGainTechnique() {
	        return technique - startTechnique;
	    }

	    public int getGainToughness() {
	        return toughness - startToughness;
	    }

	    public int getGainAgility() {
	        return agility - startAgility;
	    }

	    public int getGainMental() {
	        return mental - startMental;
	    }

	    public int getStartTotalStatus() {
	        return startStrength
	                + startStamina
	                + startTechnique
	                + startToughness
	                + startAgility
	                + startMental;
	    }

	    public int getGainTotalStatus() {
	        return totalStatus - getStartTotalStatus();
	    }
	    
	    @Override
	    public String toString() {

	        return "ID:" + id
	                + " / "
	                + fighter.getName()
	                + " / 総戦力:"
	                + totalStatus;
	    }
	}