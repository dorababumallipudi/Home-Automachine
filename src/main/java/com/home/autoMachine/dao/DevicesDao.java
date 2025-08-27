package com.home.autoMachine.dao;





public interface DevicesDao {
	  /**
	   * This method add the devices
	   * @param deviceName
	   * @param deviceId
	   * @return int
	   */
      int addDevice(String deviceName,int deviceId);
      /**
       * This method update the device status using the deivce status , room id and device id
       * @param deviceStatus
       * @param roomId
       * @param deviceId
       * @return int 
       */
      int updateDeviceStatusByDeviceId(String deviceStatus,int roomId,int deviceId);
      /**
       * This method delete the device by using deivce id 
       * @param deviceId
       * @return void
       */
      void deleteDeviceByDeviceName(int deviceId);
      /**
       * This method delete the device using deivice id 
       * @param deviceId
       * @return int
       */
      int deleteDevice(int deviceId);
}
