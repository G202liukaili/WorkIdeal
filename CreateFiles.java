package idea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CreateFiles {
	 String path= "E:\\abc\\ceshi"; //�������ļ���·�� 
     String path2="E:\\abc\\ceshi";
     
     String fileName = "TextB.txt"; //�ļ��������� 
     String fileName2="TextA.txt";
      
     File file1 = new File("E:\\abc\\ceshi", "TextB.txt"); 
     static File file0 = new File("E:\\abc\\ceshi", "TextA.txt");
     
      
	public void createFileB() throws IOException{ 
	         
	       
	        String text = "������ɫ˼�����������󲻵������Ů���������������δʶ��������������һ��ѡ�ھ���" +
	        		"�����һЦ������������������ɫ������ԡ�������Ȫˮ��ϴ��֬�̶���������ʼ����" +
	        		"�ж���ʱ���޻��ս�ҡܽ����ů�ȴ�����������ո���Ӵ˾������糯�л���������Ͼ���Ӵ���ҹר" +
	        		"ҹ�󹬼�����ǧ����ǧ�谮��һ�����ױ�ɽ���ҹ��¥�����ʹ���õ��ֽ���ʿ����������Ż��������¸�ĸ��" +
	        		"������������Ů�깬�ߴ����������ַ�Ʈ�����Ż���������˿���վ�������������ܱ�Ķ���������������������" +
	        		"�س����̳���ǧ������������";

	       
	        File f = new File("E:\\abc\\ceshi"); 
	         
	        if(!f.exists()){ 
	             
	            f.mkdirs(); //����Ŀ¼ 
	        } 
	         
	       
	        if(!file1.exists()){ 
	             
	            try { 
	                file1.createNewFile(); 
	                
	            } catch (IOException e) { 
	                // TODO Auto-generated catch block 
	                e.printStackTrace(); 
	            } 
	            
	            BufferedWriter output = null;
		        try {
//		            File file = new File("example.txt");
		            output = new BufferedWriter(new FileWriter(file1));
		            output.write(text);
		        } catch ( IOException e ) {
		            e.printStackTrace();
		        } finally {
		            if ( output != null ) 
		            	output.flush();
		            	output.close();
		        }
	             
	        } 
	         
	    } 
	  public void readFile() {
	        String pathname = "E:\\abc\\ceshi\\TextB.txt";
	        // ����·�������·�������ԣ�д���ļ�ʱ��ʾ���·��,��ȡ����·����input.txt�ļ�
	        //��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw;
	        //���ر��ļ��ᵼ����Դ��й¶����д�ļ���ͬ��
	        //Java7��try-with-resources�������Źر��ļ����쳣ʱ�Զ��ر��ļ�����ϸ���https://stackoverflow.com/a/12665271
	        BufferedWriter output0 = null;
	        try {
	        	FileReader reader = new FileReader(pathname);
	             BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
	             String line;
		            //�����Ƽ����Ӽ���д��
	                
		            while ((line = br.readLine()) != null) {
		                // һ�ζ���һ������
		                output0=new BufferedWriter(new OutputStreamWriter(
		                		new FileOutputStream(file0, true )));//��ȡһ��txt�ļ����ҽ���д����һ��txt�ļ������ܸ���ԭ���ļ�����
//		                int num=0;
//		                num+=line.length();
//		                System.out.print(num);
//		                output0.write(String.valueOf(num));
//		                output0.write(line);
		                int i=1;
		                char[] str=line.toCharArray();//�ַ���ת����
		                for(char hz:str){
//		                	System.out.print(hz);
		                	output0.write(hz);
		                	
		                	if(i%7==0&&i%14!=0)
		                		output0.write(",");
//		                		System.out.print(",");
		                	if(i%14==0)
//		                		System.out.println(".");
		                		output0.write("��"+"\r\n");
		                	i++;
		                }
		                int count=0;
		                System.out.println("��������Ҫͳ�Ƴ��ִ������ֻ�ʣ�");  
		                Scanner scan=new Scanner(System.in);
			            String str1= scan.next();;
			            while(line.indexOf(str1)!=-1){
			                //�������̽��յ��ַ���str���Ƿ�������ַ���str1= " "��
			                //������򷵻�һ�����ڵ���0���±�����
			                //������ע���Ƿ����±��������±������Ǵ�0��ʼ�ģ���û�з���-1��
			            	int c=line.indexOf(str1);
			            	line=line.substring(c+str1.length());
			            	count++;
			            }
			            output0.write("�ַ���"+str1+"�����ֵĴ���Ϊ��"+count+"\r\n");
		            }
		            
		            
	        output0.flush();
	        output0.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

