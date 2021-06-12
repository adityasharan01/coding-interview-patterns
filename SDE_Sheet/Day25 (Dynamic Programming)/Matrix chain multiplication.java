1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.

Input Format
A number N
arr1
arr2.. N integers
Output Format
Check the sample output and 
question video and answer video in same link.: https://www.youtube.com/watch?v=pEYwLmGJcvs&list=TLGGU3WiV3bXWisxMjA2MjAyMQ&t=6s

import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr){
		int n = arr.length;
		int[][] dp  =new int[n][n];
		for(int gap = 2; gap < n; gap++){
			int si = 0, ei = gap;
			while(ei < n){
				dp[si][ei] = Integer.MAX_VALUE;
				for(int i = si + 1; i < ei; i++){
					dp[si][ei] = Math.min(dp[si][ei], dp[si][i] + dp[i][ei] + (arr[si] * arr[i] * arr[ei]));
				}
				si++;
				ei++;
			}
		}
		return dp[0][n - 1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}

	
}
