package model;

public class HocLuc {
    public float MAX_MARK;
    public float MIN_MARK;

    public String hocLuctoString(float diem){
        String result= null;
        if (diem > 0 && diem <3){
            result = "Kém";
        }
        if (diem >= 3 && diem < 5){
            result = "Yếu";
        }
        if (diem >= 5 && diem < 6.5){
            result  = "Trung bình";
        }
        if(diem>= 6.5F && diem < 7.5){
            result ="Khá";
        }
        if(diem >=7.5 && diem <9){
            result =" Giỏi";
        }
        if(diem >9 && diem <=10){
            result ="Xuất sắc";
        }
        return result;
    }
    public HocLuc stringToHocLuc(String hocLuc){
        if (hocLuc.equals("kém") || hocLuc.equals("kém") ){
            this.MAX_MARK = 3;
            this.MIN_MARK = 0;
        }
        if (hocLuc.equals("yếu") || hocLuc.equals("Yếu") ){
            this.MAX_MARK = 5;
            this.MIN_MARK = 3;
        }
        if (hocLuc.equals("trung bình") || hocLuc.equals("Trung bình") ){
            this.MAX_MARK = 6.5F;
            this.MIN_MARK = 5;
        }
        if (hocLuc.equals("Khá") || hocLuc.equals("khá") ){
            this.MAX_MARK = 7.5F;
            this.MIN_MARK = 6.5F;
        }
        if (hocLuc.equals("Giỏi") || hocLuc.equals("giỏi") ){
            this.MAX_MARK = 9;
            this.MIN_MARK = 7.5F;
        }
        if (hocLuc.equals("Xuất sắc") || hocLuc.equals("xuất sắc") ){
            this.MAX_MARK = 11;
            this.MIN_MARK = 9;
        }
        return null;
    }

}

