package com.base.util.socket;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

import com.base.util.BaseUtil;


public class SocketUtil {
	

	/**
	 * ��ȡ ǰ4���ֶ�Ϊ ���ݳ��ȵ�  ����������
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readLengthValue(InputStream inputStream)
			throws IOException {
		byte[] lengthByte = new byte[4];
		int length = inputStream.read(lengthByte);// ��ȡǰ4λ��ǰ4λ������ ���ݵĳ��ȡ�
		if(length != 4)
			throw new EOFException();
		int receiveLength = BaseUtil.byteArrayToInt(lengthByte);
		int bufferSize = (receiveLength < 4096) ? receiveLength : 4096;
		byte[] read = read(inputStream, receiveLength, bufferSize);
		return read;
	}
	
	/**
	 * ��ȡָ�� ���ȵ� ���������ݡ�һ������ ֻ�ܶ�һ�Σ�ֻ��ͨ�� �ͻ��˹ر� �����������˲�������������
	 * @param inputStream
	 * @param bufferSize
	 * @return
	 * @throws IOException
	 */
	public static byte[] read(InputStream inputStream, int bufferSize)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[bufferSize];
		int num = inputStream.read(buffer);
		while (num != -1) {
			baos.write(buffer, 0, num);
			num = inputStream.read(buffer);
		}
		baos.flush();
		return baos.toByteArray();
	}

	/**
	 * ��bufferSizeΪ��λ����ȡlength�����ݡ�
	 * @param inputStream
	 * @param length
	 * @param bufferSize
	 * @return
	 * @throws IOException
	 */
	public static byte[] read(InputStream inputStream, int length,
			int bufferSize) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[bufferSize];
		int totalNum = 0;
		int num = 0;
		int readLength = bufferSize;
		while (totalNum < length) {
			num = inputStream.read(buffer, 0, readLength);
			if (num <= 0) {
				break;
			}
			baos.write(buffer, 0, num);
			totalNum += num;
			readLength = (length - totalNum > bufferSize) ? bufferSize : length - totalNum;
		}
		baos.flush();

		return baos.toByteArray();
	}

	/**
	 * ���� ǰ4���ֶ�Ϊ ���ݳ��ȵ�  ����
	 * @param outputStream
	 * @param sendBytes
	 * @throws IOException
	 */
	public static void sendLengthValue(OutputStream outputStream,
			byte[] sendBytes) throws IOException {
		byte[] sendxml=addLength(sendBytes);
		outputStream.write(sendxml);
		outputStream.flush();
	}
	public static byte[] addLength(byte[] bytes) {
		int totalLength = bytes.length + 4;
		byte[] lengthedArray = new byte[totalLength];
		System.arraycopy(BaseUtil.intToByteArray(bytes.length), 0, lengthedArray, 0, 4);
		System.arraycopy(bytes, 0, lengthedArray, 4, bytes.length);
		return lengthedArray;
	}
	
	
	public static Socket createNewSocket(String host, int port,int connectTimeout, int readTimeout) throws SocketException,
			IOException {
		Socket socket = new Socket();
		socket.setReuseAddress(true);
		socket.setSoLinger(true, 0);
		socket.setSoTimeout(readTimeout);
		socket.connect(new InetSocketAddress(host, port), connectTimeout);
		return socket;
	}
}
