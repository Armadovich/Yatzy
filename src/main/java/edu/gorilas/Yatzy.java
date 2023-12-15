package edu.gorilas;


import java.util.Arrays;

public class Yatzy {


    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    static final int FIVE = 5;
    static final int SIX = 6;
    static final int YATZY_SCORE = 50;
    static final int NULL_SCORE = 0;
    static final int SMALL_STRAIGHT_SCORE = 15;
    static final int LARGE_STRAIGHT_SCORE = 20;

    public static int chance(int[] nums) {
        int score = 0;
        for (int num : nums) {
            score += num;
        }
        return score;
    }

    public static int yatzy(int[] nums) {
        int startValue = nums[0];
        for (int num : nums) {
            if (num != startValue) return NULL_SCORE;
        }
        return YATZY_SCORE;
    }
    public static int ones(int[] nums) {
        int score = 0;
        for (int num : nums) {
            if (num == ONE) score += ONE;
        }
        return score;
    }

    public static int twos(int[] nums)  {
        int score = 0;
        for (int num : nums) {
            if (num == TWO) score += TWO;
        }
        return score;
    }

    public static int threes(int[] nums) {
        int score = 0;
        for (int num : nums) {
            if (num == THREE) score += THREE;
        }
        return score;
        }


    public static int fours(int[] nums) {
        int score = 0;
        for (int num : nums) {
            if (num == FOUR) score += FOUR;
        }
        return score;
        }

    public static int fives(int[] nums) {
        int score = 0;
        for (int num : nums) {
            if (num == FIVE) score += FIVE;
        }
        return score;

    }

    public static int sixes(int[] nums) {
        int score = 0;
        for (int num : nums) {
            if (num == SIX) score += SIX;
        }
        return score;
    }

    public static int score_pair(int[] nums) {
        int contador = 0;
        for (int i = SIX; i > 0; i--) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == TWO) return i * TWO;
            }
            contador = 0;
        }
        return NULL_SCORE;
    }

    public static int two_pair(int[] nums) {
        int contador = 0;
        int score = 0;
        for (int i = SIX; i > 0; i--) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == TWO) {
                    score += (i * TWO);
                    contador = 0;
                }
            }
            contador = 0;
        }
        return score;
    }

    public static int three_of_a_kind(int[] nums) {
        int contador = 0;
        for (int i = SIX; i > 0; i--) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == THREE) return i * THREE;
            }
            contador = 0;
        }
        return NULL_SCORE;
    }

    public static int four_of_a_kind(int[] nums) {
        int contador = 0;
        for (int i = SIX; i > 0; i--) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == FOUR) return i * FOUR;
            }
            contador = 0;
        }
        return NULL_SCORE;
    }



    public static int smallStraight(int[] nums) {
        int contador = ONE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == contador) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return NULL_SCORE;
            flag = false;
            contador++;
        }
        return SMALL_STRAIGHT_SCORE;
    }

    public static int largeStraight(int[] nums) {
        int contador = TWO;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == contador) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return NULL_SCORE;
            flag = false;
            contador++;
        }
        return LARGE_STRAIGHT_SCORE;
    }

    public static int fullHouse(int[] nums) {
        int startingDice = nums[0];
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != startingDice) {
                flag = false;
                break;
            }
        }
        if (flag) return NULL_SCORE;

        if (three_of_a_kind(nums) != 0 && score_pair(nums) != 0) {
            if (three_of_a_kind(nums)/THREE == score_pair(nums)/TWO){
                if (findLowerPair(nums) != score_pair(nums)) return findLowerPair(nums) + three_of_a_kind(nums);
            } else if (three_of_a_kind(nums)/THREE != score_pair(nums)/TWO) return score_pair(nums) + three_of_a_kind(nums);
        }
        return NULL_SCORE;
    }

    public static int findLowerPair(int[] nums){
        int contador = 0;
        for (int i = 0; i <= SIX; i++) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == TWO) return i * TWO;
            }
            contador = 0;
        }
        return NULL_SCORE;
    }
}

