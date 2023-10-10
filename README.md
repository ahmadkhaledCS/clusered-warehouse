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


### Endpoints

You can interact with the Clustered Data Warehouse application using cURL commands. Below is an example of how to make a cURL request to submit a deal:

```bash
curl --location 'http://localhost:8080/api/v1/deals/save-deal' \
--header 'Content-Type: application/json' \
--data '{
    "id":"f41cfcf2-8726-405e-a5fe-594d41d6de57",
    "fromCurrency":"JOD",
    "toCurrency":"USD",
    "timestamp":"{{current_timestamp}}",
    "amount":20
}'
```
- Also you can find postman config here - [Collection](https://github.com/ahmadkhaledCS/clusered-warehouse/blob/master/Warehouse.postman_collection.json)

### Endpoints
- Logic of the service : If the request was invalid it will be saved in another collection just in case they are needed later if its valid then add it.
