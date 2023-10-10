# Clustered Data Warehouse

This project is a data warehouse system developed to analyze FX deals. It accepts deal details and persists them into a database.

## Requirements

The project fulfills the following requirements:

- Accepts deal details including Deal Unique ID, From Currency ISO Code, To Currency ISO Code, Deal Timestamp, and Deal Amount in the ordering currency.
- Validates the row structure, handling missing fields and type format issues.
- Prevents the import of duplicate requests.
- Does not allow rollbacks; all imported rows are saved in the database.

## Technologies Used

- Database: [MongoDB]
- Build Tool: [Maven]
- Error/Exception Handling [business-Logic/Technical-Exceprions]
- Logging [SL4J]
- Unit Testing with Coverage [Mockito/SpringBootTest]
- Docker Compose for Deployment


### Prerequisites

- [Java 17, Docker, SpringBoot]


