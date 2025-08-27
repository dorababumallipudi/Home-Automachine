package com.home.autoMachine.daoImp;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.home.autoMachine.dao.RoomsDao;
import com.home.autoMachine.mappers.DeviceMapper;
import com.home.autoMachine.models.Rooms;
@Repository
public class RoomsDaoImp implements RoomsDao{
	
	@Autowired
    JdbcTemplate jdbct;
	/**
	 * This method return the users and its rooms ,devices,devoceStatus and contoller in list 
	 * @param userid
	 * @return List<Rooms>
	 */
	@Override
	public List<Rooms> getRoomsByUserid(int userId) {
		String Query = "SELECT rooms.room_name,rooms.room_id,devices.device_id,devices.device_name,devices.device_status " +
                "FROM rooms " +
                "left JOIN 	devices ON rooms.room_id = devices.room_id " +
                "WHERE rooms.user_id = ?";
		 return jdbct.query(Query,new DeviceMapper(),userId);
	}
    /**
     * This method return the users and its rooms ,devices,devoceStatus and contoller in list
     * @param id
     * @return Rooms
     */
	@Override
	public Rooms getRoomById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * this method used to add the rooms do two thing one is checks rooms already exits and insert the new room 
     * @param roomName
     * @param userId
     * @return int
     */
	@Override
	public int addRoom(String roomName ,int  userId) {
		
		String Query1 = "SELECT count(*) FROM rooms WHERE room_name = ? AND user_id = ?";
		
		Integer count = jdbct.queryForObject(Query1,Integer.class, roomName,userId);
		if(count != null && count > 0) {
			return -1;
		}
		
        String Query2 = "INSERT INTO rooms (room_name, user_id) VALUES (?,?)"; 
        
		return jdbct.update(Query2,roomName,userId);
           
	}
    /**
     * this method deletes the room  and device in the room using room id
     * @param RoomId
     * @return int 
     */
	@Override
	public int deleteRoom(int roomId) {
		
		String Query1 = "DELETE FROM devices WHERE room_id = ?";
		
	    jdbct.update(Query1,roomId);
		
		String Query2 = "DELETE FROM rooms WHERE room_id = ?";
		
		return jdbct.update(Query2,roomId);
		
		
		
		
	}

}
