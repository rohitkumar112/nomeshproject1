package com.example.nomeshproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class Clientdebitlist {
    @SerializedName("getdata")
    @Expose
    private List<Getdatum> getdata = null;

    public List<Getdatum> getGetdata() {
        return getdata;
    }

    public void setGetdata(List<Getdatum> getdata) {
        this.getdata = getdata;
    }

    public class Getdatum {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("debit")
        @Expose
        private int debit;
        @SerializedName("credit")
        @Expose
        private int credit;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDebit() {
            return debit;
        }

        public void setDebit(int debit) {
            this.debit = debit;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }
    }
}
