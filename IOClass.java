package EOLS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * IO������
 * ����д�ļ�
 * @author Mr.Joker
 *
 */
public class IOClass {
	/**
	 * �����ַ������ļ�
	 * @param inPath
	 * @return
	 * @throws Exception
	 */
	public static String testBufferedReader(String inPath) throws Exception {
		BufferedReader bi = new BufferedReader(new InputStreamReader(new FileInputStream(inPath), "UTF-8"));
		StringBuffer sbr = new StringBuffer();
		String s = null;

		while((s = bi.readLine()) != null) {
			sbr.append(s);
		}
		s = sbr.toString();
		bi.close();
		
		return s;
	}
	
	/**
	 * �����ַ���д�ļ�
	 * @param outPath
	 * @param text
	 * @throws Exception
	 */
	public static void testBufferedWriter(String outPath, String text, boolean flag) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath, flag), "UTF-8"));
		bw.write(text);
		bw.flush();
		bw.close();	
	}
}
