# 📘 Launching Multiple Instances of a Microservice Using JAR File

This guide explains how to generate a JAR file from a Spring Boot microservice project using IntelliJ IDEA and run multiple instances of the same service on different ports.

This approach is commonly used in microservices architecture to simulate multiple service instances for load balancing and service discovery testing.

---

# 🛠 Prerequisites

* IntelliJ IDEA installed
* Maven installed and configured
* Java (JDK 17 or 21 recommended)
* Spring Boot project

---

# 🚀 Step 1: Build the JAR File

To generate the executable JAR file from your Spring Boot project, follow the steps below:

1. Open your project in **IntelliJ IDEA**.
2. Go to the right-side panel and open the **Maven** tab.
3. Navigate to:

```
Lifecycle → clean
Lifecycle → install
```

4. First click on **clean**.
5. Then click on **install**.

When you execute `install`, Maven performs the following:

* Compiles the source code
* Runs tests
* Packages the application
* Generates a `.jar` file
* Places the JAR file inside the `target` folder

After successful build, you will find the JAR file here:

```
your-project-folder/target/
```

Example:

```
user-service-0.0.1-SNAPSHOT.jar
```

---

# 📂 Step 2: Open the JAR Location

1. Go to the `target` folder.
2. Right-click on the generated JAR file.
3. Select:

```
Open In → Explorer
```

Now you are inside the folder where the JAR file is located.

---

# 💻 Step 3: Open Command Prompt in That Location

1. Click on the address bar at the top of the folder window.
2. Type:

```
cmd
```

3. Press **Enter**.

This will open Command Prompt directly in that folder location.

---

# ▶ Step 4: Run the JAR with a Specific Port

Now execute the following command:

```bash
java -jar jar_file_name.jar --server.port=port_number
```

### Example:

```bash
java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8081
```

This starts one instance of the microservice on port 8081.

---

# 🔁 Step 5: Launch Multiple Instances

To run multiple instances:

1. Open another Command Prompt in the same folder.
2. Run the same JAR again but change the port number.

Example:

```bash
java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8082
java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8083
java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8084
```

If you repeat this process **N times**, you will have **N running instances** of the same microservice.

---

# 📌 What Happens Internally?

When you pass:

```
--server.port=8082
```

You are overriding the default port defined in `application.properties`.

Spring Boot reads this argument at runtime and starts the embedded server (Tomcat) on the specified port.

Each running instance:

* Has the same application code
* Runs independently
* Listens on a different port
* Can register separately in Eureka (if service discovery is enabled)

---

# 🎯 Use Case in Microservices

This approach is commonly used for:

* Load balancing testing
* Service discovery testing (Eureka)
* Scaling simulation
* Fault tolerance testing
* Demonstrating round-robin behavior with Feign Client

---

# ✅ Final Result

If you run the JAR file N times with different ports:

* You will have N active instances.
* Each instance will respond independently.
* If registered in Eureka, all instances will appear in the dashboard.
* Feign Client or LoadBalancer will distribute requests among them.

---
