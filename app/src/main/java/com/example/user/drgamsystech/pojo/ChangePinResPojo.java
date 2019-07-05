package com.example.user.drgamsystech.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangePinResPojo
{
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("statusCode")
        @Expose
        private Integer statusCode;
        @SerializedName("isSucess")
        @Expose
        private Boolean isSucess;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public Boolean getIsSucess() {
            return isSucess;
        }

        public void setIsSucess(Boolean isSucess) {
            this.isSucess = isSucess;
        }


}
