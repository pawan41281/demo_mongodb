# demo_mongodb

**Run following commands**

1. mvn clean install -Dmaven.test.skip=true 

2. docker build -t pawan41281/employeeapi:latest .

3. docker network create employeeapi-network

4. docker run -d --name mongodb --network employeeapi-network -p 27017:27017 mongodb/mongodb-community-server:latest

5. docker run --rm --name employeeapi --network employeeapi-network -p 8081:8081 -v d:/data/mongodb:/data/db pawan41281/employeeapi:latest

**Create Following Permissions**

1. READ
2. WRITE

**Create Following Roles**

1. ROLE_ADMIN
2. ROLE_USER

**Create Users with above roles by signup operation**

**After that you can login and access the employee crud operations**

**Note: Admin role have all the permisions but User role and list and find operation permissions**
  
