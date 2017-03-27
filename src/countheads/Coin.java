/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countheads;

//Brian Radomski

//Class that represents a coin

public class Coin extends Money
{
    public final static int [] DENOMINATION_VALUE = {1, 5, 10, 25, 50}; //Coin value stored in an array
    public final static String [] DENOMINATION_NAME = {"PENNY", "NICKEL", "DIME",
            "QUARTER", "HALF_DOLLAR"};                                   //Coin name stored in an array
    public final static int NUMBER_OF_DENOMINATION = 5;                  //number of coins

    //Constructor

    public Coin()
    {
    super(NUMBER_OF_DENOMINATION);
    }

    //  gets value of each coin

    public double getValue()
    {
      double centsConversion = 100.0;
      return this.DENOMINATION_VALUE[getDenomination()] / centsConversion;
    }

    //String containing the value of each coin

    public String toString()
    {

     return this.DENOMINATION_NAME [getDenomination()];
    }
}
