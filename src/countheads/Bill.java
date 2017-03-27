/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countheads;

//Brian Radomski

//class that represents a paper bill

//Class that represents a bill

public class Bill extends Money
{
  public final static int [] DENOMINATION_VALUE = {1, 2, 5, 10, 20, 50, 100};
  public final static String [] DENOMINATION_NAME = {"WASHINGTON", "JEFFERSON", "LINCOLN",
          "HAMILTON", "JACKSON", "GRANT", "FRANKLIN"};
  public final static int NUMBER_OF_DENOMINATION = 7;

    //Constructor

     public Bill()
    {
        super(NUMBER_OF_DENOMINATION);
    }

    //gets value of each bill

    public double getValue()
    {

    return this.DENOMINATION_VALUE[getDenomination()];
    }

   // String containing the value of each bill
     public String toString()
     {

     return this.DENOMINATION_NAME[getDenomination()];
     }




}
