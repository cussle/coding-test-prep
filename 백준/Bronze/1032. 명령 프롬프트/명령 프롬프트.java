/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] inputs = new String[N];
		
		for (int i = 0; i < N; i++) {
		    inputs[i] = br.readLine();
		}
		
		char[] result = inputs[0].toCharArray();
		for (int i = 1; i < N; i++) {
		    int length = inputs[i].length();
		    for (int j = 0; j < length; j++) {
		        if (result[j] != inputs[i].charAt(j)) {
		            result[j] = '?';
		        }
		    }
		}
		
		System.out.println(String.valueOf(result));
	}
}