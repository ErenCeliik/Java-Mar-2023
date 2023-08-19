package org.csystem.random.lottery;

import java.util.Random;

public class NumericLottery {
    public Random random;

    public boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];

        for (int i = 0; i < 6; ++i) {
            int val;

            while (true) {
                val = random.nextInt(1, 49);

                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    public int [] getNumbers(boolean [] flags)
    {
        int [] numbers = new int[6];
        int idx = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                numbers[idx++] = i;

        return numbers;
    }

    public NumericLottery(Random r)
    {
        random = r;
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }
}
