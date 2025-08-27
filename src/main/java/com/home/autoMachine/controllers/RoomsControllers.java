package com.home.autoMachine.controllers;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.home.autoMachine.daoImp.RoomsDaoImp;
import com.home.autoMachine.models.Rooms;

import jakarta.servlet.http.HttpSession;

@RestController
public class RoomsControllers {
    @Autowired
    private RoomsDaoImp RDI;
    
    /**
     * This method call the RDI.getRoomsByUserid(userId) and returns the user rooom details
     * @param userId
     * @param session
     * @return List<Rooms>
     */
    @GetMapping("/rooms/{userId}")
    public List<Rooms> getRoomsName(@PathVariable int userId, HttpSession session) {
    	   
      	session.setAttribute("userId", userId);
      	session.setAttribute("Rooms", RDI);
      	return RDI.getRoomsByUserid(userId);
    }
    /**
     * this method call the RDI.addRoom(roomName,userId and add the rooms
     * @param payload
     * @return String Room added successfully or Room already exists
     */
    @PostMapping("/rooms/add")
    public String addRoomByUsername(@RequestBody Map<String, Object> payload ) {
    	     String roomName = (String)payload.get("roomName");
    	     int userId = Integer.parseInt(payload.get("userId").toString());
    	     
    	     int result = RDI.addRoom(roomName,userId);
    	     
    	     return result > 0 ? "Room added successfully" : "Room already exists";
    }
    /**
     * This method call the RDI.deleteRoom(roomIdToBtn) and deletes the room and devices in room using roomid
     * @param roomIdToBtn
     * @return ResponseEntity<String> successfully room deleted or room not deleted
     */
    @DeleteMapping("/rooms/delete/{roomIdToBtn}")
    public ResponseEntity<String> deleteRoom(@PathVariable int roomIdToBtn){
    	  
    	 
    	  int res = RDI.deleteRoom(roomIdToBtn);
    	  
    	  if(res>0) {
    		  return ResponseEntity.ok("successfully room deleted");	  
    	  }else {
    		  return ResponseEntity.ok("room not deleted"); 
    	  }
    }
    
}
