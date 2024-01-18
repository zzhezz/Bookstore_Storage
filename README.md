# Bookstore Storage Management System 
**Objective:** To develop a comprehensive and efficient Bookstore Storage Management system that caters to the needs of both managerial and basic user roles, ensuring proper access control and real-time tracking of inventory.

### Video Illustration

  [http://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg)](https://youtu.be/KXK4x1ruUm4?si=c-NL1iMYk3znZmj2](https://youtu.be/KXK4x1ruUm4?si=kzMoSIRJV9BWMPJL)

### **Technological Stack:**

1. **Frontend:** LayUI for rapid and responsive UI development. LayUI is also super useful for form display.
2. **Backend:** Java Spring Boot, providing a robust and scalable foundation for the application's backend services.
3. **Data Persistence Layer:** MyBatis-Plus for efficient database operations.
4. **Database:** MySQL, offering a reliable and widely-used relational database system.
5. **Security**: Shiro, a robust security framework.

**Team Composition:** Solo Project - Meiyu Zhang

### **Functionalities & Features:**

1. **User Authentication:** 
   - Allow users to securely login using their account name and password.
   - Implementation of Shiro to ensure security.
2. **User Role Management:** 
   - **Super Administrator :**
     - Has the authority to add, delete, or modify user information.
     - Complete access to all system functionalities.
     - Can manage warehouse inventory, which includes adding, deleting, modifying quantity, renaming items.
   - **Guest:**
     - Can view all the books and its storages info. 
3. **Inventory Management:** 
   - Search functionality to quickly locate items in different categories in the bookstore.
   - Various parameters like item type, quantity, date added, etc.
4. **User Management:** 
   - Search functionality to quickly locate user by its username
   - Various parameters like item type, quantity, price etc.
5. **UI/UX:**
   - Using LayUI for quick and intuitive interface development.
   - Ensure a mobile-responsive design for accessibility on various devices. 
