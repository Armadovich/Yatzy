package edu.gorilas;


public class Yatzy {

    public static void main(String[] args) {
        System.out.println(two_pair(new int[]{3,3,5,4,5}));
    }

    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    static final int FIVE = 5;
    static final int SIX = 6;
    static final int YATZY_SCORE = 50;
    static final int NULL_SCORE = 0;
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
        for (int i = 6; i > 0; i--) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == 2) return i * 2;
            }
            contador = 0;
        }
        return NULL_SCORE;
    }

    public static int two_pair(int[] nums) {
        int contador = 0;
        int score = 0;
        for (int i = 6; i > 0; i--) {
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
        for (int i = 6; i > 0; i--) {
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
        for (int i = 6; i > 0; i--) {
            for (int num : nums) {
                if (num == i) contador++;
                if (contador == FOUR) return i * FOUR;
            }
            contador = 0;
        }
        return NULL_SCORE;
    }



    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
        {
            int[] tallies;
            tallies = new int[6];
            tallies[d1-1] += 1;
            tallies[d2-1] += 1;
            tallies[d3-1] += 1;
            tallies[d4-1] += 1;
            tallies[d5-1] += 1;
            if (tallies[0] == 1 &&
                    tallies[1] == 1 &&
                    tallies[2] == 1 &&
                    tallies[3] == 1 &&
                    tallies[4] == 1)
                return 15;
            return 0;
        }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
        {
            int[] tallies;
            tallies = new int[6];
            tallies[d1-1] += 1;
            tallies[d2-1] += 1;
            tallies[d3-1] += 1;
            tallies[d4-1] += 1;
            tallies[d5-1] += 1;
            if (tallies[1] == 1 &&
                    tallies[2] == 1 &&
                    tallies[3] == 1 &&
                    tallies[4] == 1
                    && tallies[5] == 1)
                return 20;
            return 0;
        }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
        {
            int[] tallies;
            boolean _2 = false;
            int i;
            int _2_at = 0;
            boolean _3 = false;
            int _3_at = 0;




            tallies = new int[6];
            tallies[d1-1] += 1;
            tallies[d2-1] += 1;
            tallies[d3-1] += 1;
            tallies[d4-1] += 1;
            tallies[d5-1] += 1;

            for (i = 0; i != 6; i += 1)
                if (tallies[i] == 2) {
                    _2 = true;
                    _2_at = i+1;
                }

            for (i = 0; i != 6; i += 1)
                if (tallies[i] == 3) {
                    _3 = true;
                    _3_at = i+1;
                }

            if (_2 && _3)
                return _2_at * 2 + _3_at * 3;
            else
                return 0;
        }
    }

