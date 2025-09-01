# Home Automation Project

This is a **Spring Boot + JDBC + MySQL** project for controlling home devices.  
Users can log in, manage rooms, and control devices from a web interface.

## 📂 Project Structure
com.home.autoMachine
├── controllers
│ ├── DeviceController.java
│ ├── RoomController.java
│ └── UserController.java
├── dao
│ ├── DeviceDAO.java
│ ├── RoomDAO.java
│ └── UsersDAO.java
├── daoImplimentation
│ ├── DeviceDaoImpl.java
│ ├── RoomDaoImpl.java
│ └── UserDaoImpl.java
├── models
│ ├── Devices.java
│ ├── Room.java
│ └── Users.java









  Technologies Used
- Java (Spring Boot)
- MySQL (JDBC with JdbcTemplate)
- HTML, CSS, JavaScript
- Lombok

  Features
- User authentication (sign up & login)
- Users can create rooms
- Rooms can contain devices
- Web-based UI to manage everything

  How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/dorababumallipudi/homeautomechine.git
   cd homeautomechine
Added project README
