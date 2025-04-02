
# Inventory Management System

An inventory management system that allows businesses to efficiently manage and track their inventory. It provides an API for performing operations like adding, updating, deleting, and retrieving inventory items, along with advanced features like categorization, filtering, and bulk operations.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Installation Guide](#installation-guide)

## Project Overview

The **Inventory Management System** is a comprehensive solution to manage inventory effectively. The system provides a RESTful API to interact with the inventory data, enabling users to perform CRUD operations, manage stock levels, and get filtered results based on different parameters like category, price, Stock and Sold count.

## Features

- **Add Items**: Add new items to the inventory with details like name, category, quantity, and price.
- **Update Item Quantity**: Modify the quantity and price of existing items.
- **Delete Items**: Remove items from the inventory.
- **View Items**: Retrieve items based on various filters like category, price range, status (available or not), and sold count.
- **Bulk Operations**: Add or delete multiple items in one request.
- **Low Stock Management**: Automatically update the item status based on stock levels (available or not).
- **Sort Items**: Retrieve items sorted by sold count or low stock levels.
- **Error Handling**: Custom exceptions for missing fields, item not found, and unavailable items.

## Installation Guide

### Prerequisites

- Java 17 or higher
- Spring Boot 3.x
- Maven for dependency management
- Database (MySQL)
- Intellij IDEA or Spring Tool Suit
- SQL WorkBench

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/Saikiran7798/InventoryManagement.git
   ```

2. Navigate to the project directory:
   ```bash
   cd InventoryManagement
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. By default, the application will run on `http://localhost:8080`.

**Please refer to Installation Guide and API Documents ("2 Documents) for installing and testing the API EndPoints**

## Usage

Once the application is running, you can interact with the API through any HTTP client like **Postman** or **cURL**. 




### Custom Error Responses

- **Item Missing Fields**: If any required fields are missing while adding or updating an item, the system will throw a custom error.
- **Item Not Found**: If an item does not exist when trying to retrieve it, an error will be returned.
- **Item Not Available**: If an item is out of stock, trying to sell or update it will result in an error.
