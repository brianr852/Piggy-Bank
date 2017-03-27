/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countheads;

/**
 *
 * @author brian
 */
import java.text.DecimalFormat;
import java.util.*;

public class PiggyBank
{
    public BagInterface<Money> piggyBank;
    public int capacity;

//checks the capacity of the piggy bank
    public PiggyBank(int capacity, int noOfCoins)
    {
        this.capacity = capacity;
        this.piggyBank = new ResizableArrayBag<Money>(this.capacity);
        for (int i = 0; i < noOfCoins; i++)
        {
            boolean isCoin = new Random().nextBoolean();
            if (isCoin)
            {
                add(new Coin());
            }
            else
            {
                add(new Bill());
            }

        }

    }
//adds money to the piggy bank one at a time
//adding may fail if there is no more room in the piggy bank
    public void add(Money temp) throws PiggyBankFullException
    {
        if (this.piggyBank.getCurrentSize() == this.capacity)
        {
            throw new PiggyBankFullException("No more room in the piggy bank! - additional" +
                    "monies will not be saved in the piggy bank.");
        }
        else
        {
            this.piggyBank.add(temp);
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            System.out.print("Added $" + decimalFormat.format(temp.getValue()) +
                    " to your piggy bank\n");

        }

    }
//remove one
    public Money remove()
    {

      return this.piggyBank.remove();
    }
//checks whether the piggy bank is empty
    public boolean isEmpty()
    {
        return this.piggyBank.isEmpty();
    }

//checks how many coins/paper bills are in the bank
    public boolean isFull()
    {
        return this.piggyBank.getCurrentSize() == this.capacity;
    }

//checks the content fo the piggy bank
    public int getCapacity()
    {
     return this.capacity;
    }
//shakes the piggy bank to rearrange content randomly
    public void shake()
    {
        Object[] temp = this.piggyBank.toArray();
        Random random = new Random();
        for (int i = 0; i < temp.length; i++)
        {

            Money tempMoney;                          //from cryptogram project
            int pos = random.nextInt(temp.length);
            tempMoney = (Money) temp[i];
            temp[i] = temp[pos];
            temp[pos] = tempMoney;
            tempMoney.toss();

        }
        this.piggyBank.clear();
        for (int i = 0; i < temp.length; i++)
        {
            this.piggyBank.add((Money) temp[i]);

        }
    }
//empties the piggy bank and counts how many coins/paper bills landed HEADS
    public void emptyAndCountHeads()
    {
        int count = 0;
        int count2 = 0;
        double totalCount = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println("\nEmptying your piggy bank: ");
        for (int i = 0; i < this.capacity; i++)
        {
            Money tempMoney = this.piggyBank.remove();
            if (tempMoney != null)
            {
                count2++;
                System.out.print(tempMoney.toString() + " landed " );
                if (tempMoney.isHeads())
                {
                    System.out.println("HEADS");
                    count++;
                    totalCount += tempMoney.getValue();

                }
                else
                {
                    System.out.println("TAILS");
                }
            }

        }
     System.out.println("\n" + count + " out of " + count2 + " coins/bills landed \"HEADS\"");
     System.out.println("The total value of \"HEADS\" is: " + decimalFormat.format(totalCount));
    }

//String containing the value of coins/paper bills in piggy bank
    public String toString()
    {

        System.out.print("There are " + this.piggyBank.getCurrentSize() + " coins/bills " +
                " coins/bills in your piggy bank: [");
        Object[] temp = this.piggyBank.toArray();

        double totalCount = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        for (int i = 0; i < temp.length; i++)
        {

            if (temp[i] != null)
            {
                Money tempMoney = (Money)temp[i];
                System.out.print(tempMoney.toString() + " landed " );
                if (tempMoney.isHeads())
                {
                    System.out.print("HEADS, ");

                    totalCount += tempMoney.getValue();

                }
                else
                {
                    System.out.print("TAILS, ");
                }
                totalCount += tempMoney.getValue();
            }
        }

        System.out.println("]");

        DecimalFormat formatMoney = new DecimalFormat("#0.00");
        System.out.println("\nThe total of $" + formatMoney.format(totalCount));
        return "\nThe total of " + formatMoney.format(totalCount);
    }

}
