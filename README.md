<h1>Spring Advertiser Website</h1>

<p>This is a simple web application built with Spring, Hibernate, and PostgreSQL. The purpose of this project is to provide a platform where users can create and display advertisements, view other users' ads, and contact them via WhatsApp.</p>

<h2>Features</h2>

<ul>
  <li>User Registration and Login: Users can create an account and log in to the website.</li>
  <li>Advertisement Creation: Logged-in users can create multiple ads and provide details such as title, description, and contact information.</li>
  <li>Ad Display: All users, including guests, can view ads created by other users.</li>
  <li>WhatsApp Integration: Users can easily contact the ad creator via WhatsApp.</li>
</ul>

<h2>Technologies Used</h2>

<ul>
  <li><strong>Spring Framework:</strong> Used for building the web application, handling requests, and managing dependencies.</li>
  <li><strong>Hibernate:</strong> An ORM (Object-Relational Mapping) framework used for database persistence and mapping Java objects to database tables.</li>
  <li><strong>PostgreSQL:</strong> A powerful and open-source relational database management system used for storing user and ad-related data.</li>
  <li><strong>Thymeleaf:</strong> A Java-based templating engine used for rendering dynamic HTML pages.</li>
  <li><strong>Bootstrap:</strong> A popular CSS framework used for responsive and visually appealing user interfaces.</li>
</ul>

<h2>Setup Instructions</h2>

<p>To run the project locally, follow these steps:</p>

<ol>
  <li>Clone the repository: <code>git clone https://github.com/your-username/spring-advertiser.git</code></li>
  <li>Navigate to the project directory: <code>cd spring-advertiser</code></li>
  <li>Make sure you have Java Development Kit (JDK) installed (at least version 8) and set up on your machine.</li>
  <li>Ensure you have PostgreSQL installed and running. Create a new database for the project.</li>
  <li>Update the database configuration in <code>src/main/resources/application.properties</code> with your PostgreSQL credentials and database name.</li>
  <li>Build the project: <code>./mvnw clean package</code></li>
  <li>Run the application: <code>./mvnw spring-boot:run</code></li>
  <li>Access the website in your browser at <code>http://localhost:8080</code></li>
</ol>

<h2>Project Structure</h2>

<p>The project structure follows a standard Spring Boot application layout:</p>

<ul>
  <li><code>src/main/java</code>: Contains the Java source code.</li>
  <li><code>src/main/resources</code>: Contains the application configuration files and static resources.</li>
  <li><code>src/main/webapp</code>: Contains the HTML templates and front-end assets.</li>
  <li><code>src/test</code>: Contains the test classes.</li>
</ul>

<h2>Contributions</h2>

<p>Contributions to this project are welcome! If you find any issues or would like to suggest improvements, please feel free to create a pull request or submit an issue in the repository.</p>

<p><strong>Note:</strong> This README assumes basic familiarity with Java, Spring, Hibernate, and PostgreSQL. If you are new to these technologies, it is recommended to explore their respective documentation and resources to gain a better understanding.</p>
