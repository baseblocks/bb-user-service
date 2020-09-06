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
