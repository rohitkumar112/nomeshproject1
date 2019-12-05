package com.example.nomeshproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class Clientdebitlist {
    @SerializedName("get")
    @Expose
    private List<Get> get = null;

    public List<Get> getGet() {
        return get;
    }

    public void setGet(List<Get> get) {
        this.get = get;
    }

    public class Get {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("debit")
        @Expose
        private Integer debit;
        @SerializedName("credit")
        @Expose
        private Integer credit;
        @SerializedName("date")
        @Expose
        private String date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getDebit() {
            return debit;
        }

        public void setDebit(Integer debit) {
            this.debit = debit;
        }

        public Integer getCredit() {
            return credit;
        }

        public void setCredit(Integer credit) {
            this.credit = credit;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
