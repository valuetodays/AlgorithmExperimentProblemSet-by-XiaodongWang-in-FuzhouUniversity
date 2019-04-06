package com.leften.advanced.algorithm.ch1.prog11;

import java.util.Arrays;

/**
 * @author lei.liu
 * @since 2019-04-04 18:19
 */
public class Prog1 {

    public int[] cal(int pageNumber) {
        int[] number = new int[10];
        Arrays.fill(number, 0);

        int page_temp = 0;

// as following: you can use "choice one" or "choice two",
// I used choice two.
//
//  ======CHOICE ONE begings======
// 	for(i = pageNumber; i > 0; i--)
// 	{
// 		page_temp = i;
//
// 		while(page_temp > 0)
// 		{
// 			number[page_temp % 10]++;
// 			page_temp /= 10;
// 		}
// 	}
//
//  ======CHOICE ONE ends======

//  ======CHOICE TWO begings======
        while (pageNumber > 0) {
            page_temp = pageNumber;

            while (page_temp > 0) {
                number[page_temp % 10]++;
                page_temp /= 10;
            }

            pageNumber--;
        }
//  ======CHOICE TWO ends======

        return number;
    }

}

