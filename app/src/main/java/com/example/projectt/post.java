package com.example.projectt;

public class post {
    public String Title;
    public String description;

    public  post(String Title,String description){

            this.Title = Title;
            this.description = description;


    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
