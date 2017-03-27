/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countheads;

//Brian Radomski

import java.util.*;

//abstract class that represents each bill and coin

public abstract class Money
{
    public int denomination;
    public boolean heads;

//Money constructor generates the denomination randomly and sets the value for heads to false

    public Money(int numberOfDenomination)
    {
        this.denomination = new Random().nextInt(numberOfDenomination);
        this.heads = false;

    }

//returns the value of the denomination
    public int getDenomination()
    {
        return this.denomination;
    }


//returns the value of a coin or the value of paper bill
    public abstract double getValue();


//the coin/paper lands either heads up or tails up
    public void toss()
    {
        this.heads = new Random().nextBoolean();

    }
//returns true if a coin is heads up
    public boolean isHeads()
    {

        return this.heads;
    }

//String representation of Money
    public abstract String toString();



}

