package util;

public class Util {
	public static void swap(char[] arr, int idx1, int idx2) {
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	public static double min(double a, double b, double c) {
		return Math.min(Math.min(a, b), c);
	}

	public static float min(float a, float b, float c) {
		return Math.min(Math.min(a, b), c);
	}
}
