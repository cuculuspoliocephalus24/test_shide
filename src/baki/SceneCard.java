package baki;

public class SceneCard {

private int id;
private String name;

public SceneCard(int id,String name) {
	this.id = id;
	this.name = name;
	
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

@Override
public String toString() {
	return name;
}
	
}
