package com.example.demo.service.struct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author gaonan
 * @date 2022/8/22 下午8:29
 */
public class RedPacket {

    public static void main(String[] args) {
        List<BigDecimal> awardList = initAwardList(5, new BigDecimal("5"));
        for (int i = 0; i < 5; i++) {
            System.out.println(getRedPacketAmount(awardList, i));
        }
    }

    public static BigDecimal getRedPacketAmount(List<BigDecimal> awardList, int index) {
        return awardList.get(index);
    }

    public static List<BigDecimal> initAwardList(int n, BigDecimal totalAmount) {
        int totalCount = 0;
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = 1 + random.nextInt(n);
            randomList.add(a);
            totalCount += a;
        }

        List<BigDecimal> awardList = new ArrayList<>();
        BigDecimal usedAmount = BigDecimal.ZERO;
        for (int j = 0; j < randomList.size(); j++) {
            if (j == randomList.size() - 1) {
                awardList.add(totalAmount.subtract(usedAmount));
            }
            BigDecimal randomRate = new BigDecimal(randomList.get(j)).divide(new BigDecimal(totalCount), 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal randomAmount = totalAmount.multiply(randomRate).setScale(2, BigDecimal.ROUND_HALF_UP);
            awardList.add(randomAmount);
            usedAmount = usedAmount.add(randomAmount);
        }
        return awardList;
    }
}
