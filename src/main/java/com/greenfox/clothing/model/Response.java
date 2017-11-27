package com.greenfox.clothing.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Response {
    String result;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    List<Product> clothes;

    public Response() {
    }

    public Response(String result) {
        this.result = result;
    }

    public Response(String result, List<Product> data) {

        this.result = result;
        this.clothes = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Product> getClothes() {
        return clothes;
    }

    public void setClothes(List<Product> clothes) {
        this.clothes = clothes;
    }
}
