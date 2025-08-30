package com.home.autoMachine.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.home.autoMachine.dao.DevicesDao;
@Repository
public class DevicesDaoImp implements DevicesDao{
	
	@Autowired
	JdbcTemplate jdbctemp;
	/**
	 * This method updates the device status by using deivice status ,room id and deiceId and returns the int 
	 * @param deviceStatus
	 * @param roomId
	 * @param deviceId
	 * @return int 
	 */
	@Override
	public int updateDeviceStatusByDeviceId(String deviceStatus, int roomId,int deviceId) {
	    String Query = "UPDATE devices SET device_status = ? WHERE room_id = ? AND device_id = ?";	   
		
	    return jdbctemp.update(Query,deviceStatus,roomId,deviceId);
	}
    /**
     * This method deletes the device using deice name
     * @param deviceName
     * @return void
     */
	@Override
	public void deleteDeviceByDeviceName(int deviceName) {
		// TODO Auto-generated method stub
		
	}
    /**
     * This method add the deive using devicename and room id 
     * @param deviceName
     * @param roomId
     * @return int 
     */
	@Override
	public int addDevice(String deviceName,int roomId ) {
		String query1 = "SELECT count(*) FROM devices Where room_id = ? AND device_name = ?";
		int count = jdbctemp.queryForObject(query1,Integer.class, roomId,deviceName);
		if(count > 0 ) {
			return -1;
		}
		
		String Query2 = "INSERT INTO devices (device_name,room_id) VALUES (?,?)";
		return jdbctemp.update(Query2,deviceName,roomId);
	}
    /**
     * This method delete the device using the deiveid
     * @param deviceId
     * @return int
     */
	@Override
	public int deleteDevice(int deviceId) {
		String Query = "DELETE FROM devices WHERE device_id = ?";
		
		return jdbctemp.update(Query,deviceId);
	}

	

	

}
