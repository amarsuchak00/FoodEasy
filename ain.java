
import java.util.Random;

public class ain {
	public static int block = 190;
	public static int[] eta = new int[200];
	public static int[] ttf = new int[200];

	public static int[] pr = new int[200];

	public static void main(String[] args) {
		valueset(block);
		alg1(eta, ttf);
		int b = numWeightAlg(block);
		int c = numWeight(block);
		System.out.print("\nOut of " + block + " people, " + b
				+ " will have to wait for there order as apposed to " + c);
	}

	public static int valueset(int block) {
		for (int i = 0; i < block; i++) {
			eta[i] = ((RANDOM.nextInt() & Integer.MAX_VALUE) * (RANDOM
					.nextInt() & Integer.MAX_VALUE)) % 120;
			ttf[i] = ((RANDOM.nextInt() & Integer.MAX_VALUE) * (RANDOM
					.nextInt() & Integer.MAX_VALUE)) % 15;
		}
		return 0;
	}

	public static int alg1(int[] eta, int[] ttf) {
		for (int i = 0; i < block; i++) {
			pr[i] = (int) (Math.pow(eta[i], 2) / ttf[i]);
			System.out.print(" " + pr[i] + " ");
		}
		System.out.println();
		return 0;
	}

	public static int alg2(int[] pr) {
		int lowest = 0;
		int test = 1;
		for (int i = 0; i < block; i++) {
			if (pr[lowest] < pr[test]) {
				lowest = lowest;
				test++;
			} else {
				lowest = test;
				test++;
			}
			System.out.print(" " + pr[i] + " ");
		}
		System.out.println();
		return lowest;
	}

	public static int numWeightAlg(int block) {
		int weighting = 0;
		int time = 0;
		for (int i = 0; i < block; i++) {
			int a = alg2(pr);
			time = time + ttf[a];
			if (time > eta[a]) {
				weighting++;
			} else {
				weighting = weighting;
			}
			pr[a] = 100;
			alg2(pr);
		}
		return weighting;
	}

	public static int numWeight(int block) {
		int weighting = 0;
		int time = 0;
		for (int i = 0; i < block; i++) {
			time = time + ttf[i];
			if (time > eta[i]) {
				weighting++;
			} else {
				weighting = weighting;
			}
		}
		return weighting;
	}

	public final static Random RANDOM = new Random(1);
}
