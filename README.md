# 🏥 Hospital Management System

A comprehensive Java Swing-based Hospital Management System that provides an intuitive GUI for managing hospital operations including patients, doctors, appointments, rooms, and billing.

## ✨ Features

- **Patient Management** - Add and view patient records
- **Doctor Management** - Manage doctor information and specializations
- **Room Management** - Track room availability and types
- **Appointment Scheduling** - Book appointments between patients and doctors
- **Billing System** - Generate and manage patient bills
- **User-Friendly Interface** - Clean and intuitive Swing-based GUI
- **Card Layout Navigation** - Smooth transitions between different modules

## 🛠️ Technologies Used

- **Java** - Core programming language
- **Swing** - GUI framework
- **MVC Architecture** - Model-View-Controller design pattern
- **Git** - Version control

## 📁 Project Structure
```
Hospital-Management-System/
├── src/
│   ├── model/
│   │   ├── Person.java           # Abstract base class
│   │   ├── Patient.java          # Patient entity
│   │   ├── Doctor.java           # Doctor entity
│   │   ├── Staff.java            # Staff entity
│   │   ├── Room.java             # Room management
│   │   ├── Appointment.java      # Appointment scheduling
│   │   ├── Billing.java          # Billing system
│   │   └── HospitalManager.java  # Main data manager
│   ├── view/
│   │   ├── MainFrame.java        # Main application window
│   │   ├── DashboardPanel.java   # Main dashboard
│   │   ├── PatientPanel.java     # Patient management UI
│   │   ├── DoctorPanel.java      # Doctor management UI
│   │   ├── RoomPanel.java        # Room management UI
│   │   ├── AppointmentPanel.java # Appointment scheduling UI
│   │   └── BillingPanel.java     # Billing management UI
│   ├── controller/
│   │   ├── UIController.java     # UI navigation controller
│   │   └── Validator.java        # Input validation
│   └── Main.java                 # Application entry point
└── README.md
```

## 🚀 How to Run

### Prerequisites

  - Java JDK 8 or higher
  - Git (for cloning the repository)

### Compilation and Execution

1.  **Clone the repository**

    ```bash
    git clone [https://github.com/0-shihab-0/Hospital-Management-System.git](https://github.com/0-shihab-0/Hospital-Management-System.git)
    cd Hospital-Management-System
    ```

2.  **Compile the project**

    ```bash
    cd src
    javac -d out model/*.java view/*.java controller/*.java Main.java
    ```

3.  **Run the application**

    ```bash
    java -cp out Main
    ```

### Alternative Compilation (Windows PowerShell)

```powershell
cd "Hospital-Management-System\src"
javac -d out model/*.java view/*.java controller/*.java Main.java
java -cp out Main
```

## 📋 System Modules

### 🎯 Dashboard

  - Central navigation hub
  - Quick access to all modules
  - Clean button-based interface

### 👥 Patient Management

  - Add new patients with ID, name, age, and disease
  - View all patient records in a scrollable list
  - Input validation for all fields

### 👨‍⚕️ Doctor Management

  - Register doctors with specialization
  - Track doctor information and availability
  - Professional management interface

### 🏨 Room Management

  - Add and manage hospital rooms
  - Track room occupancy status
  - Room type categorization

### 📅 Appointment System

  - Schedule appointments between patients and doctors
  - Date-based booking system
  - Automatic appointment ID generation

### 💰 Billing Module

  - Generate patient bills
  - Amount tracking and management
  - Bill ID auto-generation

## 🔧 Code Architecture

The project follows the **MVC (Model-View-Controller)** pattern:

  - **Model**: Data classes (`Patient`, `Doctor`, `Appointment`, etc.)
  - **View**: Swing UI components (`MainFrame`, `PatientPanel`, etc.)
  - **Controller**: Navigation and validation logic (`UIController`, `Validator`)

## 🎨 UI Features

  - **Card Layout** for smooth screen transitions
  - **Form Validation** for data integrity
  - **Responsive Design** with proper spacing and margins
  - **Professional Styling** with consistent fonts and colors
  - **Scrollable Lists** for data display

## 👨‍💻 Developer

**Ashraf Khan Shihab**

  - GitHub: [@0-shihab-0](https://github.com/0-shihab-0)





-----

⭐ Star this repository if you find it helpful\!

