package com.greenfox.clothing.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Response {
    String result;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    List<Warehouse> clothes;

    public Response() {
    }

    public Response(String result) {
        this.result = result;
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
