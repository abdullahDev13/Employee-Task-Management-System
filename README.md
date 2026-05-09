📋 Employee Task Management System (ETMS)
A full-featured Employee Task Management System built with Java EE, JAX-WS Web Services, JPA (persistence), JSP, and HTML. It supports complete employee and task lifecycle management — from registering developers to assigning tasks, tracking task status, and managing passwords.
---

✨ Features
👤 Developer Registration & Management — Add, update, and delete developer profiles
🔐 Secure Login — Separate login flows for Employees and Managers
📝 Task Creation — Managers can create tasks and assign them to developers
📌 Task Assignment — Assign specific tasks to specific employees
🔄 Task Status Management — Track and update the status of tasks (e.g., Pending, In Progress, Done)
👁️ View Tasks — Employees and Managers can view all tasks and developer-task mappings
🔑 Password Management — Update and reset employee passwords
🌐 JAX-WS Web Services — Full backend exposed as SOAP-based web services
🗄️ JPA Persistence — Database operations managed via JPA (`persistence.xml`)
---
📁 Project Structure
```
Employee-Task-Management-System/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── com.etm.dao/
│       │   │   ├── EmployeeDao.java               # Data access for Employee entity
│       │   │   └── TaskDao.java                   # Data access for Task entity
│       │   │
│       │   ├── com.etm.entity/
│       │   │   ├── Employee.java                  # Employee JPA entity
│       │   │   ├── Status.java                    # Task status enum/entity
│       │   │   └── Task.java                      # Task JPA entity
│       │   │
│       │   └── com.etm.view/
│       │       ├── AddDeveloper.java               # Add developer web service
│       │       ├── AssignTask.java                 # Assign task to employee
│       │       ├── ChangeTaskStatus.java           # Update task status
│       │       ├── CreateTask.java                 # Create a new task
│       │       ├── DeleteDeveloper.java            # Delete developer record
│       │       ├── LoginEmployee.java              # Employee login handler
│       │       ├── RegisterManager.java            # Manager registration
│       │       ├── UpdateDeveloper.java            # Update developer info
│       │       ├── UpdatePassword.java             # Password update handler
│       │       ├── ViewAllDeveloperWithTask.java   # View developers with tasks
│       │       └── ViewTask.java                   # View individual tasks
│       │
│       └── resources/
│           └── META-INF/
│               └── persistence.xml               # JPA persistence configuration
│
├── webapp/
│   ├── WEB-INF/
│   ├── addDeveloper.html           # Add developer form
│   ├── assignTask.html             # Assign task to employee
│   ├── changeTaskStatus.html       # Change task status form
│   ├── createTask.html             # Create new task form
│   ├── deleteDeveloper.html        # Delete developer page
│   ├── developer.html              # Developer dashboard
│   ├── login.html                  # Login page
│   ├── manager.html                # Manager dashboard
│   ├── register.html               # Registration page
│   ├── updateDeveloper.jsp         # Update developer (JSP)
│   ├── updatePassword.html         # Update password form
│   ├── updation.html               # Update confirmation page
│   ├── viewAllDeveloper.jsp        # View all developers (JSP)
│   └── viewTask.jsp                # View tasks (JSP)
│
├── pom.xml                         # Maven build configuration
└── README.md
```
---

🛠 Tech Stack
Layer	Technology
Language	Java (JDK 8+)
Web Services	JAX-WS (SOAP)
ORM / DB	JPA (Java Persistence API)
Frontend	HTML5, JSP
Build Tool	Apache Maven
Architecture	DAO + Entity + View (3-Layer)
Server	Apache Tomcat / GlassFish
Deployment	WAR (Web Archive)
---

🚀 Getting Started
Prerequisites
Java JDK 8 or higher
Apache Maven 3.x
Apache Tomcat 9.x Server
A relational database ( PostgreSQL )
An IDE (Eclipse IDE)
---

💻 Usage
Manager Flow
Step	Action	Page
1	Register as Manager	`/register.html`
2	Login	`/login.html`
3	Add Developers	`/addDeveloper.html`
4	Create Tasks	`/createTask.html`
5	Assign Tasks to Developer	`/assignTask.html`
6	View All Developers+Tasks	`/viewAllDeveloper.jsp`
7	Change Task Status	`/changeTaskStatus.html`

Developer / Employee Flow
Step	Action	Page
1	Login	`/login.html`
2	View Assigned Tasks	`/viewTask.jsp`
3	Update Profile	`/updateDeveloper.jsp`
4	Change Password	`/updatePassword.html`
---

🌐 Web Services
The system's backend is fully exposed via JAX-WS SOAP Web Services.
After deployment, view WSDL at:
```

Service Class	Description
`AddDeveloper`	Registers a new developer
`DeleteDeveloper`	Removes a developer by ID
`UpdateDeveloper`	Updates developer profile
`LoginEmployee`	Authenticates an employee
`RegisterManager`	Registers a new manager
`CreateTask`	Creates a new task
`AssignTask`	Assigns a task to an employee
`ChangeTaskStatus`	Updates the status of a task
`ViewTask`	Retrieves task details
`ViewAllDeveloperWithTask`	Lists all developers with their tasks
`UpdatePassword`	Updates employee password
---

🗄️ Database & Persistence
This project uses JPA for all database interactions, configured via `persistence.xml`.
Entity Classes:
Entity	Description
`Employee`	Stores employee/developer information
`Task`	Stores task details
`Status`	Represents task status values
DAO Layer:
DAO	Responsibility
`EmployeeDao`	CRUD operations for Employee
`TaskDao`	CRUD operations for Task
---

👨‍💻 Author
Abdullah Ansari
GitHub: @abdullahDev13  
Email: aa48411000@gmail.com
---
> ⭐ If this project helped you, please consider giving it a star!
