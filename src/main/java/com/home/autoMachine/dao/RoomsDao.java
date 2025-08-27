package com.home.autoMachine.dao;

import java.util.List;

import com.home.autoMachine.models.Rooms;

public interface RoomsDao {
	/**
	 * this method return list of room using userid
	 * @param user_id
	 * @return List<Rooms>
	 */
    List<Rooms> getRoomsByUserid(int user_id);
    /**
     * this method return room list by room id
     * @param id
     * @return Rooms
     */
    Rooms getRoomById(int id);
    /**
     * This method add the room using room name and user id 
     * @param roomName
     * @param userId
     * @return addRoom
     */
    int addRoom(String roomName ,int userId);
    /**
     * This method deletes the room and devices in rooom using roomID
     * @param roomId
     * @return int
     */
    int deleteRoom(int roomId);
}
