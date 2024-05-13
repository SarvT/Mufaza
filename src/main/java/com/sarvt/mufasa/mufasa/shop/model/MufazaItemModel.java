package com.sarvt.mufasa.mufasa.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("MUFAZA")
public class MufazaItemModel {
    @Id
    private Integer id;

    @NotEmpty
    private String name;

    private String contentType;

    @JsonIgnore
    private byte[] data;

    public MufazaItemModel(){

    }
    public MufazaItemModel(String id, String name){
        this.id = Integer.valueOf(id);
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }
}
