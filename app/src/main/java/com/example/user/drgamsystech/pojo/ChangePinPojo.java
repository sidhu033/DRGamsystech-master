package com.example.user.drgamsystech.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ChangePinPojo
{

        @SerializedName("UserId")
        @Expose
        private Integer userId;
        @SerializedName("CurrentPin")
        @Expose
        private String currentPin;
        @SerializedName("NewPin")
        @Expose
        private String newPin;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getCurrentPin() {
            return currentPin;
        }

        public void setCurrentPin(String currentPin) {
            this.currentPin = currentPin;
        }

        public String getNewPin() {
            return newPin;
        }

        public void setNewPin(String newPin) {
            this.newPin = newPin;
        }


}
