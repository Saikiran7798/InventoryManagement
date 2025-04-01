# Inventory Management System

An inventory management system that allows businesses to efficiently manage and track their inventory. It provides an API for performing operations like adding, updating, deleting, and retrieving inventory items, along with advanced features like categorization, filtering, and bulk operations.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Installation Guide](#installation-guide)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The **Inventory Management System** is a comprehensive solution to manage inventory effectively. The system provides a RESTful API to interact with the inventory data, enabling users to perform CRUD operations, manage stock levels, and get filtered results based on different parameters like category, price, and stock count.

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

- Java 11 or higher
- Spring Boot 3.x
- Maven or Gradle for dependency management
- Database (H2 or MySQL recommended for production)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/inventory-management-system.git
