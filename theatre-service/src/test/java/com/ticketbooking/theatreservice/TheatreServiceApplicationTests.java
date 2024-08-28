package com.ticketbooking.theatreservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TheatreServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	long possibleNumbers(long firstHalf, boolean isEven) {
		long resNum = firstHalf;
		if (!isEven) {
			firstHalf = firstHalf/10;
		}

		while (firstHalf > 0) {
			long d = firstHalf % 10;
			resNum = resNum*10 + d;
			firstHalf = firstHalf/10;
		}

		return resNum;
	}

	public String nearestPalindromic(String n) {
		int len = n.length(), mid = len/2;
		int firstHalfLen = len % 2 == 0 ? mid : mid +1;
		long firstHalf = Long.parseLong(n.substring(0, firstHalfLen+1));

		List<Long> possible = new ArrayList<>();
		possible.add(possibleNumbers(firstHalf, len % 2 == 0));
		possible.add(possibleNumbers(firstHalf+1, len % 2 == 0));
		possible.add(possibleNumbers(firstHalf-1, len % 2 == 0));

		// edge cases
		possible.add((long) (Math.pow(10, len-1)-1));
		possible.add((long) (Math.pow(10, len+1)+1));
		long diff = Long.MAX_VALUE;
		long res = Long.MAX_VALUE;
		long originalNum = Long.parseLong(n);

		for (long num : possible){
			if (num == originalNum)
				continue;
			if (Math.abs(num - originalNum) < diff) {
				diff = Math.abs(num - originalNum);
				res = num;
			} else if (Math.abs(num - originalNum) == diff) {
				res = Math.min(res, num);
			}
		}

		return String.valueOf(res);
	}

}
