/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countheads;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author brian
 */
public class CountHeads
{
    public static void main(String args []) {



        Scanner scan = new Scanner(System.in);
        System.out.println("How many coins/bills can fit in your piggy bank?");
        int capInput = scan.nextInt();

        int addInput = 0;
        do {
            System.out.println("How many coins/bills do you want to add to your bank?");
            addInput = scan.nextInt();
        }
        while (capInput < addInput);
        PiggyBank bank = new PiggyBank(capInput, addInput);
        bank.toString();
        int newCoins = 2;
        for (int i = 0; i < newCoins; i++)
        {
            boolean isCoin = new Random().nextBoolean();
            if (isCoin)
            {
                bank.add(new Coin());
            }
            else
            {
                bank.add(new Bill());
            }

        }
            bank.shake();
            bank.emptyAndCountHeads();

    }

    }
