package io.tnine.trainstatus.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Train {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("dest")
    @Expose
    private Dest dest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Dest getDest() {
        return dest;
    }

    public void setDest(Dest dest) {
        this.dest = dest;
    }

}