# CIT300 Mini Hospital Emergency Management System

## Student Information

- **Student Name:** U.G. Damith
- **Student ID:** 23DA2-0075
- **Module:** CIT300 - Data Structures and Algorithms
- **Assignment:** Individual Mid Assignment

## Project Overview

This project is a Java-based console application developed to manage the main activities of a mini hospital emergency unit. It demonstrates the manual implementation and practical use of four data structures: a Binary Search Tree, Queue, Stack, and Singly Linked List.

The system allows users to register patients, manage an emergency queue, store completed treatment records, and maintain a separate visit history for each patient.

## System Type

- Java 17 console application
- Data is stored temporarily in memory
- No database or external libraries are used
- No web interface or graphical user interface is required

## Main Features

1. Register a new patient
2. Search for a patient
3. Delete a patient
4. Display patients in ascending Patient ID order
5. Add a patient to the emergency queue
6. Treat the next emergency patient
7. Display the emergency queue
8. Add a completed treatment record
9. Remove the latest treatment record
10. Display completed treatment history
11. Add a patient visit
12. Search for a patient visit
13. Remove a patient visit
14. Display a patient's visit history

## Data Structures Used

| Requirement | Data Structure | Implementation |
|---|---|---|
| Patient records | Binary Search Tree | Patients are stored using Patient ID as the key. The system supports insertion, search, deletion, and in-order traversal. |
| Emergency patients | Queue | Patients are processed according to the First-In-First-Out principle. |
| Completed treatments | Stack | The most recently completed treatment is accessed first according to the Last-In-First-Out principle. |
| Patient visit history | Singly Linked List | Every patient maintains a separate linked list containing previous hospital visits. |

All data structures were implemented manually without using Java collection classes.

## Project Structure

```text
CIT300-Mini-Hospital-Emergency-System/
|
|-- src/
|   `-- hospital/
|       |-- HospitalManagementSystem.java
|       |-- Patient.java
|       |-- PatientNode.java
|       |-- PatientBST.java
|       |-- EmergencyQueueNode.java
|       |-- EmergencyPatientQueue.java
|       |-- TreatmentRecord.java
|       |-- TreatmentStackNode.java
|       |-- TreatmentHistoryStack.java
|       |-- Visit.java
|       |-- VisitNode.java
|       `-- VisitHistoryList.java
|
|-- screenshots/
|-- .gitignore
`-- README.md
```

## How to Run the System

### Using Visual Studio Code

1. Install Java 17 or a newer compatible JDK.
2. Install the Extension Pack for Java in Visual Studio Code.
3. Open the project folder in Visual Studio Code.
4. Open `src/hospital/HospitalManagementSystem.java`.
5. Click **Run Java**.
6. Enter the required menu option in the terminal.

### Using PowerShell

Run the following commands from the project root directory:

```powershell
javac -d out src/hospital/*.java
java -cp out hospital.HospitalManagementSystem
```

## Validation and Testing

The system was tested for the following operations:

- Registering multiple patients
- Rejecting duplicate Patient IDs
- Searching for existing and unavailable patients
- Deleting patients from the Binary Search Tree
- Displaying patients in ascending Patient ID order
- Processing emergency patients in FIFO order
- Handling an empty emergency queue
- Processing completed treatments in LIFO order
- Handling an empty treatment stack
- Adding, searching, removing, and displaying patient visits
- Rejecting duplicate Visit IDs
- Validating required text and numeric input
- Closing the system successfully

## Evidence Screenshots

| Screenshot | Description |
|---|---|
| `01_BST_Search_And_InOrder.png` | BST search and in-order traversal |
| `02_BST_Deletion_Result.png` | BST patient deletion result |
| `03_Emergency_Queue_FIFO.png` | Emergency queue FIFO operation |
| `04_Emergency_Queue_Empty_Handling.png` | Empty emergency queue handling |
| `05_Treatment_Stack_LIFO.png` | Treatment stack LIFO operation |
| `06_Treatment_Stack_Empty_Handling.png` | Empty treatment stack handling |
| `07_Visit_History_Add_And_Search.png` | Adding and searching patient visits |
| `08_Visit_History_Remove_And_Empty.png` | Removing visits and empty history handling |
| `09_Final_Main_Menu.png` | Final interactive system menu |
| `10_Final_Patient_Display.png` | Final patient registration and display |
| `11_Final_Emergency_Queue_FIFO.png` | Final integrated emergency queue |
| `12_Final_Treatment_Stack_LIFO.png` | Final integrated treatment stack |
| `13_Final_Visit_History_Linked_List.png` | Final integrated patient visit history |

## Important Note

The application stores information only while it is running. All records are reset when the program is closed because a database or file-storage system is outside the scope of this assignment.

## GitHub Repository

[View the project repository](https://github.com/23da2-0075-ops/CIT300-Mini-Hospital-Emergency-System)

## Author

**U.G. Damith**  
**Student ID: 23DA2-0075**