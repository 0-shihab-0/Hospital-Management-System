package model;


public class Room {
private String roomId;
private String type;
private boolean occupied;


public Room(String roomId, String type) {
this.roomId = roomId;
this.type = type;
this.occupied = false;
}


public String getRoomId() { return roomId; }
public String getType() { return type; }
public boolean isOccupied() { return occupied; }
public void setOccupied(boolean occupied) { this.occupied = occupied; }
}