package idea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateStudent {
	  
	  int xuehao;
      String name,major,sex;
//      String path2="E:\\abc\\ceshi";
      CreateFiles cr=new CreateFiles();
      
      public void SubmitWork() throws IOException{
    	  System.out.println("请先填写以下个人信息再提交作业");
    	  Scanner sc=new Scanner(System.in);
    	  FileWriter fw=new FileWriter("E:\\abc\\ceshi\\TextA.txt");
    	 
    	  try{
    		  fw.write("学生基本信息"+"\r\n");
    		  System.out.println("学号："); 
    		  xuehao=sc.nextInt();
        	  fw.write("学号："+String.valueOf(xuehao)+"\r\n");//若写入int型数据一次只能写进去一个 需要将其转化 成String类型
        	  System.out.println("姓名：");
        	  fw.write("姓名："+sc.next()+"\r\n");
        	  System.out.println("性别：");
        	  fw.write("性别："+sc.next()+"\r\n");
        	  System.out.println("专业：");
        	  fw.write("专业："+sc.next()+"\r\n");
        	  fw.write("作业："+"\r\n");
        	  
        	  fw.flush();
    	      fw.close();
    	      System.out.println("请输入要提交的文件：");
        	  String n;
        	  n=sc.next();
//        	  System.out.println(n);   
        	  if(n.equals("TextB")){
        		  cr.createFileB();
        		  cr.readFile();  
        		System.out.println("提交成功！（可在TextA文件中查阅批改信息）");  	    		
        	  }else{
        		  System.out.println("文件提交错误！请重新运行程序！");   
        	  }
        	  
         }catch(Exception e){
        	 System.out.println("格式错误，重新开始！");  
    	  }
    	 
      }
}
