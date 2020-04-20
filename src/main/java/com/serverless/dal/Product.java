package com.serverless.dal;

@DynamoDBTable(tableName = "PLACEHOLDER_PRODUCTS_TABLE_NAME")
public class Product {

    private static final String PRODUCTS_TABLE_NAME = System.getenv("PRODUCTS_TABLE_NAME");

    private String id;
    private String name;
    private Float price;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBRangeKey(attributeName = "name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "price")
    public Float getPrice() {
        return this.price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
}
