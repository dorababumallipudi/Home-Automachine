package com.home.autoMachine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * creates the setter and  getters
 * creates the no ag constructer and all arg constructer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Devices {
    private int roomId;
    private int deviceId;
    private String deviceName;
    private String deviceStatus;
    private int userId;
}
