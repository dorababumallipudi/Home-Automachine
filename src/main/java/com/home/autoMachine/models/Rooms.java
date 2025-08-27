package com.home.autoMachine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * creates the setters and getters 
 * creates the no argsconstructer
 * creates all arg constructes
 * for the room object data types
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {
	private int roomId;
	private int deviceId;
	private String roomName;
    private String deviceName;
    private String deviceStatus;
}
