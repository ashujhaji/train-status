package io.tnine.trainstatus.Models.ModelPnrStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JourneyClass {

    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("code")
    @Expose
    private String code;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}