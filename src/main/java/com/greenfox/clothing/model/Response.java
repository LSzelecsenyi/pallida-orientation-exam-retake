package com.greenfox.clothing.model;

import java.util.List;

public class Response {
    String result;
    List<Warehouse> clothes;

    public Response() {
    }

    public Response(String result, List<Warehouse> data) {

        this.result = result;
        this.clothes = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Warehouse> getClothes() {
        return clothes;
    }

    public void setClothes(List<Warehouse> clothes) {
        this.clothes = clothes;
    }
}
