# Entity design

Created a SpringBoot application which manages the three entities described in the assigment: Price, with the fields in the example, and their related entities, Product and Brand, with only the ID and a field name.

# Development
Added Repositories to manage each entity. The PricesRepository has the Query to retrieve the pricings filter by Date, ProductID and Brand_ID. Allows pagination and sorting.

Defined a Service which uses the Repository to retrive the most prioritary price, by using the pagination (page 0 with size 1) and sort (by priority, descending)

Defined a Controller which uses the Service to obtain the information. Receives the data as queryParams, and returns a DTO with the requiered fields. A ModelMapper is used to map the Price entity to the DTO.

In case a price is not found, a custom Exception is returned, causing and HTTP 404.

# Documentation

Added OpenAPI Docs and swagger

# Testing

The requiered tests are included as a single ParametrizedTest, obtaining the different inputs and expected outputs from a CSV file. 
All fields in the response are validated to not be null, but for simplicity only price value is validated.

An additional test was included for the case a price was not found.
