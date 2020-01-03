package com.jbn.study;

import java.time.Instant;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * UnionFindPerformanceTest
 */
public class UnionFindPerformanceTest {


    private UF uo;
    private UF ut;
    private int size = 100000;
    private int m = 100000;

    @Before
    public void init() {
       uo = new UnionFindOne(size);
       ut = new UnionFindTwo(size);
    }

    public double calcTime(UF uf, int m) {
        long startTime = Instant.now().toEpochMilli();

        int size = uf.getSize();
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = Instant.now().toEpochMilli();
        return (endTime - startTime) / 1000.0;
    }


    @Test
    public void testPerformance() {
        double uoCost = calcTime(uo, m);
        System.out.println("UoCost cost: " + uoCost + " s");


        double utCost = calcTime(ut, m);
        System.out.println("UtCost cost: " + utCost + " s");
    }

}