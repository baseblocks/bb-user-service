# bb-user-service
How to`s project

# How-to #1. Data encryption.
## Requirements
1. Data should be stored encrypted in the database.
2. Encryption should happen when data stored in the database.
3. Decryption should happen each time we get data from the database.

## Tech solution
There are different ways how to implement this. We will focus on one specific now. 
Hibernate converters are going to be used for the solution.

# How-to #2. Audit trail using envers
## Requirements
1. Changes in tables are tracked automatically whenever we call save, update or delete operations on our repository level;
2. Ability to easily query audit trail.

## Tech solution
Spring Data has the mechanism called Spring Data Envers which allow access to entity revisions managed by Hibernate Envers. 
It will automatically write entities snapshots of the User entity on the update, save and delete operation into separate table(user_history in our case).
