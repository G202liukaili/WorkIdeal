package idea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateStudent {
	  
	  int xuehao;
      String name,major,sex;
      String path2="E:\\abc\\ceshi";
      CreateFiles cr=new CreateFiles();
      
      public void SubmitWork() throws IOException{
    	  System.out.println("������д���¸�����Ϣ���ύ��ҵ");
    	  Scanner sc=new Scanner(System.in);
    	  FileWriter fw=new FileWriter("E:\\abc\\ceshi\\TextA.txt");
    	 
    	  try{
    		  fw.write("ѧ��������Ϣ"+"\r\n");
    		  System.out.println("ѧ�ţ�"); 
    		  xuehao=sc.nextInt();
        	  fw.write("ѧ�ţ�"+String.valueOf(xuehao)+"\r\n");//��д��int������һ��ֻ��д��ȥһ�� ��Ҫ����ת�� 
        	  System.out.println("������");
        	  fw.write("������"+sc.next()+"\r\n");
        	  System.out.println("�Ա�");
        	  fw.write("�Ա�"+sc.next()+"\r\n");
        	  System.out.println("רҵ��");
        	  fw.write("רҵ��"+sc.next()+"\r\n");
        	  fw.write("��ҵ��"+"\r\n");
        	  
        	  fw.flush();
    	      fw.close();
    	      System.out.println("������Ҫ�ύ���ļ���");
        	  String n;
        	  n=sc.next();
//        	  System.out.println(n);   
        	  if(n.equals("TextB")){
        		  cr.createFileB();
        		  cr.readFile();  
        		System.out.println("�ύ�ɹ���������TextA�ļ��в���������Ϣ��");  	    		
        	  }else{
        		  System.out.println("�ļ��ύ�������������г���");   
        	  }
        	  
         }catch(Exception e){
        	 System.out.println("��ʽ�������¿�ʼ��");  
    	  }
    	 
      }
}
