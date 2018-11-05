package com.example.megha.sensordataapp_a4_mt18100;

public class SensorClass
{

        private int ID;
        private int XValue;
        private int YValue;
        private int ZValue;
        private String Timestamp;

        public SensorClass()
        {
            ID=0;
            XValue=0;
            YValue=0;
            ZValue=0;
            Timestamp="";
        }

    public SensorClass(int xValue,int yValue,int zValue,String timestamp)
    {
        XValue=xValue;
        YValue=yValue;
        ZValue=zValue;
        Timestamp=timestamp;

    }

        public int getID(){ return ID; }
        public int getX()
        {
            return XValue;
        }
        public int getY()
        {
            return YValue;
        }
        public int getZ()
        {
            return ZValue;
        }
        public String getTimestamp(){ return Timestamp; }

        public void setX(int xValue) {  XValue= xValue;    }

        public void setY(int yValue) {  YValue= yValue;    }

        public void setZ(int zValue){   ZValue= zValue; }

        public void setTimestamp(String timestamp){ Timestamp=timestamp; }


    }
