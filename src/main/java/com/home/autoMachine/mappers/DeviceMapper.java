package com.home.autoMachine.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.home.autoMachine.models.Rooms;

public class DeviceMapper implements RowMapper<Rooms>{
	/**
	 * This method maps the device in models and uses the setter and getters and returns the Rooms
	 * @return Rooms
	 */
	@Override
	public Rooms mapRow(ResultSet rs,int rowNum) throws SQLException {
		Rooms r = new Rooms();
		try {
			r.setRoomId(rs.getInt("room_id"));
			r.setRoomName(rs.getString("room_name"));
			r.setDeviceId(rs.getInt("device_id"));
			r.setDeviceName(rs.getString("device_name"));
			r.setDeviceStatus(rs.getString("device_status"));
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
     
}
