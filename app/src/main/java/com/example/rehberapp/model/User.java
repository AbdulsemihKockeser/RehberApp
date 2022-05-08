package com.example.rehberapp.model;

public class User {
        private int ID;
        private String Ad;
        private String Soyad;
        private String TelefonNo;
        private String Fax;
        private String Adress;
        private int Foto;

        public User(int id, String ad, String soyad, String telefonNo, String fax, String adress, int foto) {
            ID = id;
            Ad = ad;
            Soyad = soyad;
            TelefonNo = telefonNo;
            Fax = fax;
            Adress = adress;
            Foto = foto;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getAd() {
            return Ad;
        }

        public void setAd(String ad) {
            Ad = ad;
        }

        public String getSoyad() {
            return Soyad;
        }

        public void setSoyad(String soyad) {
            Soyad = soyad;
        }

        public String getTelefonNo() {
            return TelefonNo;
        }

        public void setTelefonNo(String telefonNo) {
            TelefonNo = telefonNo;
        }

        public String getFax() {
            return Fax;
        }

        public void setFax(String fax) {
            Fax = fax;
        }

        public String getAdress() {
            return Adress;
        }

        public void setAdress(String adress) {
            Adress = adress;
        }

        public int getFoto() {
            return Foto;
        }

        public void setFoto(int foto) {
            Foto = foto;
        }
    }


