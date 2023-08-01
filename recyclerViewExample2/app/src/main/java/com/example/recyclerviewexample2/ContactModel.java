package com.example.recyclerviewexample2;

public class ContactModel {
    //Structure class
    /*Yaha par apko utna variable declare karna hai, jo apko Runtime mai us particular
      View mai set karna ka leya chahiya */
    int img;
    String name, number;

    //Use getter and setter or constructor
    public ContactModel(int img, String name, String number){
        this.img = img;
        this.name = name;
        this.number = number;
        /*jasa hi hum Array ka andar data set karanga, toh hum is class ka object call
        * karanga, jasa hi object call karanga toh woh humsa three chija manga ga
        * img, name, number*/
    }
}
