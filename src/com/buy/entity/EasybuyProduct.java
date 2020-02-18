package com.buy.entity;

public class EasybuyProduct {
    private int id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int categoryLovel1Id;
    private int categoryLovel2Id;
    private int categoryLovel3Id;
    private String fileName;
    private int isDelete;

    public EasybuyProduct(int id, String name, String description, float price, int stock, int categoryLovel1Id, int categoryLovel2Id, int categoryLovel3Id, String fileName, int isDelete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryLovel1Id = categoryLovel1Id;
        this.categoryLovel2Id = categoryLovel2Id;
        this.categoryLovel3Id = categoryLovel3Id;
        this.fileName = fileName;
        this.isDelete = isDelete;
    }

    public EasybuyProduct() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoryLovel1Id() {
        return categoryLovel1Id;
    }

    public void setCategoryLovel1Id(int categoryLovel1Id) {
        this.categoryLovel1Id = categoryLovel1Id;
    }

    public int getCategoryLovel2Id() {
        return categoryLovel2Id;
    }

    public void setCategoryLovel2Id(int categoryLovel2Id) {
        this.categoryLovel2Id = categoryLovel2Id;
    }

    public int getCategoryLovel3Id() {
        return categoryLovel3Id;
    }

    public void setCategoryLovel3Id(int categoryLovel3Id) {
        this.categoryLovel3Id = categoryLovel3Id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
