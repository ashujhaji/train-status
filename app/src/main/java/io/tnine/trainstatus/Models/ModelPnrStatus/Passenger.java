package io.tnine.trainstatus.Models.ModelPnrStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Passenger {

    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("booking_status")
    @Expose
    private String bookingStatus;
    @SerializedName("current_status")
    @Expose
    private String currentStatus;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

}