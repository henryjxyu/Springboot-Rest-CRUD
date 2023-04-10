# Springboot-Rest-CRUD
A demo project POC implementing a login page that contains users' and corresponding article information with Security Implementations and Rest CRUD.

## To use this project:
#### 1. Clone the project to your local environment and import it into your IDE (personally I use Eclipse). Right click on project in eclipse and then Maven -> Update Projects
#### 2. Update application.properties with your local database information.
```
spring.datasource.url=jdbc:mysql://localhost:3306/<yourdbname>
spring.datasource.username=root
spring.datasource.password=<yourpw>

spring.datasource.tomcat.max-wait=20000
spring.datasource.tomcat.max-active=50
spring.datasource.tomcat.max-idle=20
spring.datasource.tomcat.min-idle=15

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.id.new_generator_mappings = false
spring.jpa.properties.hibernate.format_sql = true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```
#### 3. Configure your MySQL database. Here are the lines I used
```
-- Dumping structure for table concretepage.articles
CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table concretepage.articles: ~3 rows (approximately)
INSERT INTO `articles` (`article_id`, `title`, `category`) VALUES
	(1, 'Java Concurrency', 'Java'),
	(2, 'Hibernate HQL ', 'Hibernate'),
	(3, 'Spring MVC with Hibernate', 'Spring');
  
-- Dumping structure for table concretepage.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table concretepage.users: ~2 rows (approximately)
INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
	('John', 'john1234', 'John Adams', 'ROLE_ADMIN', 'USA', 1),
	('Jane', 'jane1234', 'Jane Holland', 'ROLE_USER', 'USA', 1); 
```
#### 4. After finishing configuration, right click on the project and run as Spring Boot App.

## The following Endpoints can be called using POSTMAN
#### 1. To get the list of articles of the logged-in user, use following url with the `GET` request type in postman
```
http://localhost:8080/user/articles
```
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/article%20list.png)

#### 2. To lookup a specific article, use following url with the `GET` request type in postman
```
http://localhost:8080/user/article/<id>
```
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/lookup%20article.png)

#### 3. To create a new article, use following url with the `POST` request type in postman. Set content type as in header as `application/json` and set request body as raw with JSON payload
```
http://localhost:8080/user/article
```
#### Here are the JSON codes
```
{
	"title": "Springboot Introduction",
	"category": "Spring"
}
  ```
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/create%20article.png)
#### Check the updated list
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/new%20list.png)

#### 4. To update an existing article, use following url with the `PUT` request type in postman. Set content type as in header as `application/json` and set request body as raw with JSON payload
```
http://localhost:8080/user/article
```
#### Here are the JSON codes
```
{
	"articleId" : 5,
	"title": "Springboot Introduction",
	"category": "Spring"
}
```
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/update%20article.png)
#### Check the updated list
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/new%20list%202.png)

#### 5. To delete an article, use following url with the `DELETE` request type in postman.
```
http://localhost:8080/user/article/<id>
```
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/delete%20article.png)
#### Check the updated list
![Screenshot](https://github.com/henryjxyu/Springboot-Rest-CRUD/blob/master/screenshots/new%20list%203.png)
