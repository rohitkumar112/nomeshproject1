package com.example.nomeshproject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class debitcreditmodel {

        @SerializedName("debit")
        @Expose
        private int debit;
        @SerializedName("credit")
        @Expose
        private int credit;
        @SerializedName("name")
        @Expose
        private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String date;

    public debitcreditmodel(String name, int debit, int credit,String date) {
    this.name=name;
    this.debit=debit;
    this.credit=credit;
    this.date=date;
    }

    public debitcreditmodel() {

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}
