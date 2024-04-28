# Planty of Food

Welcome to my first Java project, an ecommerce platform designed for the imaginary organic food brand "Planty of Food".

This project represents the final step of Start2Impact's Java Basics class. As a newcomer to this language, creating a
complete project posed a challenge, but it allowed me to apply in a practical setting all the concepts I had been
studying.

## Context

### Client

Planty of Food offers a variety of organic products available for purchase through their online store.
They facilitate Group Buys to help customers save money on delivery costs and minimize emissions from transportation.

### Goal

The aim of this project is to develop an application that helps with sales management.

Interactions take place within the command-line interface, where users can select operations to execute and input
the required data.

## Built with

- [Java 21](https://www.oracle.com/it/java/technologies/downloads/#java21)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Apache Maven](https://maven.apache.org/)

## Getting started

### Prerequisites

Before running this program on your device, ensure you have the following installed:

- **Terminal / Command-line interface**: available on your system;
- **Git**: you might need it installed for cloning the repository;
- **Java** and **JDK**: ensure you have them installed on your device. This project is compatible with Java 21,
  and you can download it from [Java's official website](https://www.oracle.com/it/java/technologies/downloads/#java21);
- **Apache Maven**: you will need it to compile the code and create the package. You can download it 
  from [here](https://maven.apache.org/).

If you want to contribute, you will also need an IDE like IntelliJ IDEA or Eclipse.

### Installation and execution

#### Install

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/ilariaciavarella/pof_ecommerce.git
   ```

2. Navigate to the project directory `pof_ecommerce`;  
   **Note:** Make sure **not** to enter inside the `src` folder, otherwise it won't work.

#### Build

1. Ensure Apache Maven is installed on your device;

2. Create the jar package of the project by running the following command in your terminal:
   ```shell
   mvn package
   ```

#### Execute

1. Now you have a `target` folder containing the jar file named `Planty_Of_Food-Ecommerce.jar`;

2. To execute the program you can do either of the following:

    1. Stay in the current directory and run the following command:
       ```shell
       java -jar target/Planty_Of_Food-Ecommerce.jar
       ```

    2. Navigate to the target directory and run the program from there:
       ```shell
       cd target
       java -jar Planty_Of_Food-Ecommerce.jar
       ```

### Usage

The program offers the following operations:

> 1- Visualizza tutti i prodotti (_Display all products_)  
> 2- Acquista un prodotto esistente (_Buy an existing product_)  
> 3- Restituisci un prodotto (_Return a product you bought_)  
> 4-Aggiungi un nuovo utente (_Add a new user_)  
> 5- Esporta un file con i prodotti disponibili (_Export a file with list of the available products_)  
> 0- Esci dal programma (_Exit_)

To execute an operation, type the number corresponding to the desired action.


#### TYPE 1:

You will see a table displaying details of all products.

#### TYPE 2:

- Enter the ID of the product you wish to purchase. Ensure the item is available.
- Input your user ID, displayed during user creation (see "Type 4").
- After providing all requested data, your purchase will be added to the list.
- The new sale's ID is displayed both at the beginning and end of the operation.

#### TYPE 3:

- Enter the ID of the sale you wish to delete.
- Once confirmed, the sale will be cancelled.

#### TYPE 4:

- Provide necessary data for a user profile: name, surname, birthdate, address, and document.
- Upon completion, the account is added to the list.
- The new account's ID is displayed both at the beginning and end of the operation.

#### TYPE 5:

A text file containing the available products is exported to the `pof_ecommerce` directory.

#### TYPE 0:

Exit the program.

## Contributing

The project is structured as follows:

```text
pof_ecommerce/
|- src/
|   |- main/
|   |   |- java/
|   |   |   |- assets/
|   |   |   |   |- prodotti.csv
|   |   |   |   |- utenti.csv
|   |   |   |   |- vendite.csv
|   |   |   |- com.pof
|   |   |   |   |- controller/
|   |   |   |   |   |- Controller.java
|   |   |   |   |- exceptions/
|   |   |   |   |   |- FailedOperationException.java
|   |   |   |   |   |- InvalidInputException.java
|   |   |   |   |- model/
|   |   |   |   |   |- Product.java
|   |   |   |   |   |- Sale.java
|   |   |   |   |   |- User.java
|   |   |   |   |- service/
|   |   |   |   |   |- InputService.java
|   |   |   |   |   |- Service.java
|   |   |   |   |- util/
|   |   |   |   |   |- DataFormatter.java
|   |   |   |   |   |- FileManager.java
|   |   |   |   |- Main.java
|- .gitignore
|- pom.xml
|- README.md
```

The `Main.java` file represents the entry point of this project.  
The `pom.xml` is the Project Object Model for Maven's functioning.  
The `assets` folder contains the csv files with data to be loaded in the program.  
Inside the `com.pof` folder you will find all Java classes divided in the appropriate folders:
- `Controller` for interaction with the user
- `Exceptions` for custom exceptions
- `Model` for model classes
- `Service` for the business logic
- `Util` with utility classes

If you'd like to contribute to this project, please follow these steps:

- Fork the repository on GitHub;
- Create a new branch with a descriptive name;
- Make your changes and commit them with clear messages;
- Push your branch to your forked repository;
- Submit a pull request to the original repository.


## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

## Contact

Nice to meet you, I'm Ilaria!

Reach out to me anytime, here are the links:

[![GitHub][github-shield]][github-url]

[![LinkedIn][linkedin-shield]][linkedin-url]

[![Instagram][instagram-shield]][instagram-url]

<!-- LINKS & IMAGES -->

[github-shield]: https://img.shields.io/badge/GitHub-D91254?style=flat-square&label=See%20my%20work%20on&labelColor=1C1719

[github-url]: https://github.com/ilariaciavarella

[linkedin-shield]: https://img.shields.io/badge/LinkedIn-2FB6B2?style=flat-square&label=Connect%20with%20me%20on&labelColor=1C1719

[linkedin-url]: https://www.linkedin.com/in/ilaria-ciavarella/

[instagram-shield]: https://img.shields.io/badge/Instagram-D91254?style=flat-square&label=Follow%20me%20on&labelColor=1C1719

[instagram-url]: https://www.instagram.com/lil.ciavarella/