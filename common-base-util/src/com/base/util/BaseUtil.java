package com.base.util;

import java.util.Arrays;

public class BaseUtil {
	public static void main(String[] args) {
//		int i = 1024;
//		System.out.println( Arrays.toString(intToByteArray(i)));
//		byte[] by = {0,0,4,0};
//		System.out.println(byteArrayToInt(by));
		
	}
	
	
	/**
	 * int ת���� byte���顣
	 * @param i
	 * @return
	 */
	public static byte[] intToByteArray(int i) {
		byte[] intBytes = new byte[4];
		intBytes[0] = (byte) (i >> 24 & 0xFF); //����24λ��Ȼ��ȡ��8λ
		intBytes[1] = (byte) (i >> 16 & 0xFF); //����16λ��Ȼ��ȡ��8λ,Ҳ����ȡ 17λ~24λ֮��� ����������
		intBytes[2] = (byte) (i >> 8 & 0xFF);
		intBytes[3] = (byte) (i & 0xFF);
		return intBytes;
	}
	
	/**
	 * 4Ϊ byte���� ת���� int��
	 * ��Ϊ{0,0,0,0} �򷵻�    0
	 * @param i
	 * @return
	 */
	public static int byteArrayToInt(byte[] by) {
		int ch1 = by[0];
		int ch2 = by[1];
		int ch3 = by[2];
		int ch4 = by[3];
		return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	}
}
