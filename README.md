## Supermarket

Employee management system and organization of supplying products in the supermarket

The main purpose of this system is to help supermarket employees be in control of the store's product inventory as well as management of store employees.
The system will save time and reduce resources by storing the information in a convenient way that will allow easy identification. In addition, the system will reduce human errors by providing accurate service with minimal possibility of errors.

The system is written according to the MVC model, in addition there are uses in additional design patterns such as Observer, Singleton and Factory.

This program uses SQLite database with queries. In addition there are reading and writing files.
____________________________________________________________________________________________________________________________________________________________
## Class Diagram

![model](https://user-images.githubusercontent.com/68790040/137127351-b7502539-fdc0-493b-b8b7-6f0ba66be50c.png)

![controller](https://user-images.githubusercontent.com/68790040/137127349-26c48946-ed25-4460-8e7d-8f11a07ccc32.png)

![mvc](https://user-images.githubusercontent.com/68790040/137127367-e5057af1-d4fe-4b09-b3f4-46090d470b5d.png)
____________________________________________________________________________________________________________________________________________________________
## App screens

#### Main Menu

![menu](https://user-images.githubusercontent.com/68790040/137127365-0533dac8-318d-4737-b2bb-1cfb4a98c990.JPG)

![login](https://user-images.githubusercontent.com/68790040/137127362-4e535183-cd3d-48c3-94f7-8991c2416ee2.JPG)

The main menu navigates each employee to his part of the system.
Each employee should press the button with his job and then a login window will open for him.
In the login window the employee is required to enter his employee number and according to this the system knows whether the employee has clicked on his real job.
____________________________________________________________________________________________________________________________________________________________
#### Manager

![manager](https://user-images.githubusercontent.com/68790040/137127366-170a62d4-e895-4cbc-a4d6-11e897e246b8.JPG)

The manager's job is to manage the employees in the supermarket.
When the manager enters the system with his details, a table appears with all the employees and their details (employee number, name, hourly wage, monthly hours).

Manager actions in the system:

- Issuing a salary report to employees

    ![salaryReport](https://user-images.githubusercontent.com/68790040/137127321-b11ef578-5109-42dd-88dc-f26e9c9ecdc9.JPG)
    
- Update employee details

    ![updateEmployee](https://user-images.githubusercontent.com/68790040/137127329-64101368-51ca-4a2e-9593-74435300bc6f.JPG)
    
- Adding an employee

    ![addEmployee](https://user-images.githubusercontent.com/68790040/137127348-5311b27c-62ba-43bd-bcbc-df00cfe6ab56.JPG)
    
- Deleting an employee

    ![deleteEmployee](https://user-images.githubusercontent.com/68790040/137127355-e8fbdd42-6a60-4a69-bbc6-85a4a6d18fa1.JPG)
    
____________________________________________________________________________________________________________________________________________________________
#### Storekeeper

![warehouse](https://user-images.githubusercontent.com/68790040/137127334-2c4f9738-d270-4c08-a39f-f359d1038575.JPG)

The warehouse worker's job is to manage the supply in the warehouse and deliver products to the store.
When the warehouse worker enters the system with his details, a table appears with all the products in the warehouse and their details (barcode, name, current quantity in the warehouse, maximum quantity that can be in the warehouse).

Warehouse worker actions in the system:

- Adding a new product to the warehouse

    ![wAddItem](https://user-images.githubusercontent.com/68790040/137127333-76076e84-44d1-4247-9022-16a45f266a6c.JPG)
    
- Update product details

    ![wUpdateItem](https://user-images.githubusercontent.com/68790040/137127347-473f8887-81d8-4b79-ad11-eb5b724c2dd9.JPG)
    
- Deleting a product from the warehouse

    ![wDeleteItem](https://user-images.githubusercontent.com/68790040/137127338-ca4face7-9895-4c54-a650-0cb7a9db95a7.JPG)
    
- Add to order list from supplier

    ![wOrderItem](https://user-images.githubusercontent.com/68790040/137127345-fcbbde31-ffb9-4ffd-9955-fb40322c01ba.JPG)
    
- Create an order report according to the order lists

    ![wCreate](https://user-images.githubusercontent.com/68790040/137127336-efd47876-e566-483d-b990-daa1523da3fb.JPG)
    
____________________________________________________________________________________________________________________________________________________________
#### Store Worker

![warehouse](https://user-images.githubusercontent.com/68790040/137127326-ccc4b961-fae1-4459-89c8-ff5054366d4f.JPG)

The job of the store employee is to manage the supplies in the store.
When the store employee enters the system with his details, a table appears with all the products in the store and their details (barcode, name, current quantity in the store, maximum quantity that can be in the store).

Store worker actions in the system:

- Update product details

    ![sUpdate](https://user-images.githubusercontent.com/68790040/137127328-a8acc8be-1993-493d-bc88-b2925dad43e5.JPG)
    
- Add to order list from warehouse

    ![sOrder](https://user-images.githubusercontent.com/68790040/137127345-fcbbde31-ffb9-4ffd-9955-fb40322c01ba.JPG)
    
- Create an order report from the warehouse

    ![sCreate](https://user-images.githubusercontent.com/68790040/137127323-32dfb15e-631d-4387-b497-1185ababace9.JPG)
    
____________________________________________________________________________________________________________________________________________________________
#### Important note:

In order to use the system for the first time without knowing the staff ids I made an admin manager for the system.

All you need to do is run the program, click Manager and then write "admin" in the id box, after that you can know all the staff ids and even creat new ones.

Another thing you need to know is if you want to change/order something from the tables you have to click it in the table and then select the option you want.
