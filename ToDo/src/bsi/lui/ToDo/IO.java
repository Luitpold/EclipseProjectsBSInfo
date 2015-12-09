package bsi.lui.ToDo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO {
	public static void save(String data, File file){
		try{
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file), "UTF8"));
			System.out.println("Writing list content: \"" + data + "\" into file.");
			out.write(data);
			out.close();
			}catch(IOException e){
				System.out.println("Error writing list content: \"" + data + "\" into file.");
			}
	}
	
	public static String load(File file){
		String res = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file), "UTF8"));
			String tmpLine;
			while((tmpLine = in.readLine()) != null){
				res += tmpLine;
			}
		} catch (Exception e) {
			System.out.println("Could not find or load file!");
		}
		return res;
	}
}
