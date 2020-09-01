/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial01;

/**
 *
 * @author muham
 */
public class Tarikh {
    private int day, month, year;

    public Tarikh(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    @Override
    public String toString(){
        String str = "";
        if(day<10){
            str+="0"+day+"/";
        }
        else{
            str+=day +"/";
        }
        if(month<10){
            str+="0"+month +"/";
        }
        else{
            str+=month +"/";
        }
        return str+=year;
    }
}
