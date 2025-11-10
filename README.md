# 🖼️ Virtual Art Gallery Management
**Java Swing Application**

---

## 🏫 Project Information
**Université Ibn Zohr – Faculté des Sciences, Agadir**  
**Licence d’Excellence en Ingénierie Logicielle**  
**Encadré par : Pr. Jaafar IDRAIS**  
**Réalisé par : Aya ABOUNACER, Zainab ERROSSAFI, Dounia KRITET**  
**Année universitaire : 2023–2024**

---

## 🎨 Overview
The **Virtual Art Gallery Management System** is a desktop application developed using **Java Swing**.  
It simplifies and automates the operations of a digital art gallery by allowing administrators to manage **artists, artworks, exhibitions, and transactions** through an intuitive graphical interface.  

This project showcases the practical application of **object-oriented programming** and **GUI design principles** using **Java Swing** and **MySQL integration**.

---

## 🎯 Objectives
- Manage artworks, artists, and exhibitions  
- Maintain records of art transactions  
- Import/export data using XML files  
- Provide a clean and responsive UI for administrators  
- Offer search and CRUD (Create, Read, Update, Delete) functionalities for every entity  

---

## ⚙️ Functional Requirements
- **CRUD Operations**: Add, modify, delete, and view entries (artists, artworks, exhibitions, transactions)  
- **Search**: Filter by ID, name, or attributes  
- **Statistics**: Display counts of registered artists, artworks, and exhibitions  
- **XML Import/Export**: Load and save data externally  
- **Authentication**: Secure admin login and logout system  

---

## 🧩 Non-Functional Requirements
- **Performance**: Fast interface even with large datasets  
- **Usability**: Simple and ergonomic design  
- **Portability**: Cross-platform Java application  
- **Maintainability**: Modular and well-structured (MVC-inspired design)  

---

## 🧱 Architecture & Design
The system is based on a **single admin role** responsible for all CRUD actions.  

UML diagrams used:  
- **Use Case Diagram** – Interaction between admin and system
  <img width="898" height="701" alt="image" src="https://github.com/user-attachments/assets/e6c608d6-d65d-445b-bf45-989d083a4c01" />

- **Class Diagram** – Entities: Artist, Artwork, Exhibition, Transaction
  <img width="1022" height="688" alt="image" src="https://github.com/user-attachments/assets/9ed96494-b185-4bcf-86f9-2a86e7a855c0" />


---

## 🧰 Technologies & Tools
| Tool | Purpose |
|------|----------|
| Java Swing | GUI development |
| NetBeans IDE | Development environment |
| MySQL + JDBC | Database management |
| XAMPP | Local MySQL server |
| XML | Data import/export |
| LaTeX | Documentation |
| JCalendar / TimingFramework | UI Components (date pickers, animations) |

---

## 🖥️ Application Features

### 🔐 Login
Admin authentication before accessing the dashboard.

### 📊 Dashboard
Displays quick statistics (total artists, artworks, exhibitions) and navigation to CRUD sections.

### 👩‍🎨 Artists Management
Add, edit, delete, or search artists. Includes a quick search by name, nationality, or ID.

### 🖼️ Artworks Management
Manage artworks (title, artist, year, etc.).  
Features: XML export, search and filtering.

### 🏛️ Exhibitions
Create and organize exhibitions with names, dates, and venues.

### 💵 Transactions
Track sales or purchases of artworks with search functionality.

### 📂 XML Import
Import data (e.g., `artistes.xml`) and display results in a table.

### 🔒 Logout
Securely return to the login screen.

---



- Login interface
  <img width="985" height="471" alt="image" src="https://github.com/user-attachments/assets/7a6dcb89-5a5f-4680-b6a8-7aecbd3ca83a" />

- Dashboard
  <img width="1439" height="764" alt="image" src="https://github.com/user-attachments/assets/32fc1340-b6b8-41b2-b29a-8fc69040ae3b" />

- Artist list view
  <img width="1423" height="761" alt="image" src="https://github.com/user-attachments/assets/eebd4762-90a4-468d-bb04-379f6b6c8819" />

- Add artist form
  <img width="1180" height="681" alt="image" src="https://github.com/user-attachments/assets/3a9fa6b0-7f5a-4e80-b25c-b0b7e7d8be7c" />
 
- XML import screen
  <img width="1142" height="600" alt="image" src="https://github.com/user-attachments/assets/d6b1b5fb-a518-490c-83f6-b3b958f33276" />


---

## 🧠 Lessons Learned
This project enhanced understanding of:
- Java Swing UI components (JFrame, JPanel, JTable, etc.)  
- MVC principles for desktop apps  
- JDBC connectivity with MySQL  
- Data handling using XML  
- GUI testing and UX design  

---

## 🏁 Conclusion
This project provided valuable hands-on experience in **Java GUI programming** and **database-driven application design**.  
It demonstrates how **object-oriented concepts**, **UML modeling**, and **Swing interfaces** combine to create a functional and user-friendly management system.



---

