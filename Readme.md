# Transit Network Optimizer

A full-stack Java desktop application designed to model urban transit systems, store station and route data in a relational database, compute the most cost-effective network configuration using graph theory, and visualize the results via an interactive graphical user interface.

---

## 🚀 Features

* **Interactive Graphical User Interface (JavaFX):** View the entire transit network layout on a custom rendering canvas alongside an integrated management dashboard.
* **Full Station CRUD Operations:** Add new stations with custom coordinates, edit existing station details, and delete outdated nodes directly from the UI control panel.
* **Relational Database Backend (MySQL):** Persistent storage of stations and route weights managed cleanly via the **Data Access Object (DAO)** pattern and JDBC.
* **Algorithmic Route Optimization:** Computes the Minimum Spanning Tree (MST) of the transit network using **Kruskal's Algorithm** paired with an efficient **Disjoint Set (Union-Find)** data structure supporting path compression and union by rank ($O(\alpha(V))$).

---

## 🛠️ Technology Stack & Requirements

* **Language/Runtime:** Java (JDK 21)
* **Build Tool:** Apache Maven
* **UI Framework:** JavaFX (`17.0.6`)
* **Database Driver:** MySQL Connector/J (`8.3.0`)
* **Database:** MySQL Server

---

## 📂 Project Structure

```text
TransitNetworkOptimizer/
├── pom.xml
└── src/main/java/com/transitnetwork/
    ├── Main.java
    ├── dao/
    │   ├── DatabaseConnection.java
    │   ├── NetworkDAO.java
    │   └── MySQLNetworkDAO.java
    ├── model/
    │   ├── Station.java
    │   └── Route.java
    ├── algorithm/
    │   ├── UnionFind.java
    │   └── GraphOptimizer.java
    └── ui/
        └── MainView.java
```

---

## ⚙️ Setup & Installation

### 1. Clone the Repository
```bash
git clone https://github.com/MayankSarode/TransitNetworkOptimizer.git
cd TransitNetworkOptimizer
```

### 2. Configure the MySQL Database
Create a database named `TransitNetwork` in your local MySQL instance and set up your schema tables (`stations` and `routes`). Update your connection credentials inside `DatabaseConnection.java`.

### 3. Build and Run via Maven
Ensure you have JDK 21 and Maven installed. Run the application using:
```bash
mvn clean javafx:run
```
*(Alternatively, import the project into your favorite IDE such as IntelliJ IDEA or Eclipse and run `Main.java`)*

---

## 📜 License
This project is open-source and available under the MIT License.
