package com.home.autoMachine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.autoMachine.daoImp.DevicesDaoImp;
import com.home.autoMachine.models.Devices;

@RestController
@RequestMapping("/devices")
public class DevicesControllers {
	
	@Autowired
	DevicesDaoImp DDI;
	/**
	 * This method call the DDI.addDevice(request.getDeviceName(), request.getRoomId() and add the deivce 
	 * using user name and room id
	 * @param request
	 * @return boolean
	 */
	@PostMapping("/add")
	public boolean addDevice(@RequestBody Devices request) {
		return DDI.addDevice(request.getDeviceName(), request.getRoomId())>0;
		
	}
	/**
	 * This method call the DDI.deleteDevice(deviceIdBtn) and deletes the device using the device id btn
	 * @param deviceIdBtn
	 * @return ResponseEntity<String> successfully device deleted or device not deleted
	 */
	@DeleteMapping("/deletedevice/{deviceIdBtn}")
	public ResponseEntity<String> deleteDevice(@PathVariable int deviceIdBtn) {

		if(DDI.deleteDevice(deviceIdBtn) > 0) {
			return ResponseEntity.ok("successfully device deleted");
		}
		return ResponseEntity.ok("device not deleted");
	}
	/**
	 * This method call the DDI.updateDeviceStatusByDeviceId(device.getDeviceStatus(), device.getRoomId(), device.getDeviceId())
	 * put the device status 
	 * @param device
	 * @return ResponseEntity<String> device Updated Successfully
	 */
	@PutMapping("/deviceStatusUpdate")
	public ResponseEntity<String> deviceControl(@RequestBody Devices device) {
		DDI.updateDeviceStatusByDeviceId(device.getDeviceStatus(), device.getRoomId(), device.getDeviceId());
		return ResponseEntity.ok("device Updated Successfully");
	}
	
}
