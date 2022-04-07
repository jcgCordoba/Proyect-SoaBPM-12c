package com.test.mock.model;

public class Response {
    
    private int code;
    private String description;
    private Person person;

    public Response() {
    }

    public Response(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Response(int code, String description, Person person) {
        this.code = code;
        this.description = description;
        this.person =person;
    }
    
    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
