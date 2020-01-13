package utils;

public class WarriorStateUtils {
	private static final int[] MAX_HP = new int[91];
	private static final int[] MAX_MP = new int[91];

	static {
		int b = 0;
		int c = 0;
		for (int i = 1; i <= 90; i++) {
			b = b + 35 + (i - 1) * 2;
			MAX_HP[i] = b;
			c = c + 3 + (i - 1) / 14;
			MAX_MP[i] = c;
			//System.out.println("MAX_HP["+i+"] = "+ MAX_HP[i] +", MAX_MP["+i+"] = " + MAX_MP[i]);
		}
	}

	public static int[] getMaxHp() {
		return MAX_HP;
	}

	public static int[] getMaxMp() {
		return MAX_MP;
	}

	public static int getMaxHpByIndex(int index) {
		return MAX_HP[index];
	}

	public static int getMaxMpByIndex(int index) {
		return MAX_MP[index];
	}
}