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
	 String path= "E:\\abc\\ceshi"; //所创建文件的路径 
//     String path2="E:\\abc\\ceshi";
     
     String fileName = "TextB.txt"; //文件名及类型 
//     String fileName2="TextA.txt";
      
     File file1 = new File(path, "TextB.txt"); 
     File file0 = new File(path, "TextA.txt");
     
      
	public void createFileB() throws IOException{ 
	         
	       
	        String text = "汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王" +
	        		"侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新" +
	        		"承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专" +
	        		"夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心" +
	        		"不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九" +
	        		"重城阙烟尘生千乘万骑西南行";

	       
	        File f = new File(path); 
	         
	        if(!f.exists()){ 
	             
	            f.mkdirs(); //创建目录 
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
	        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
	        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
	        //不关闭文件会导致资源的泄露，读写文件都同理
	        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
	        BufferedWriter output0 = null;
	        try {
	        	FileReader reader = new FileReader(pathname);
	             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
	             String line;
		            //网友推荐更加简洁的写法
	                
		            while ((line = br.readLine()) != null) {
		                // 一次读入一行数据
		                output0=new BufferedWriter(new OutputStreamWriter(
		                		new FileOutputStream(file0, true )));//读取一个txt文件并且将其写入另一个txt文件，不能覆盖原来文件内容
//		                int num=0;
//		                num+=line.length();
//		                System.out.print(num);
//		                output0.write(String.valueOf(num));
//		                output0.write(line);
		                int i=1;
		                char[] str=line.toCharArray();//字符串转数组
		                for(char hz:str){
//		                	System.out.print(hz);
		                	output0.write(hz);
		                	
		                	if(i%7==0&&i%14!=0)
		                		output0.write(",");
//		                		System.out.print(",");
		                	if(i%14==0)
//		                		System.out.println(".");
		                		output0.write("。"+"\r\n");
		                	i++;
		                }
		                int count=0;
		                System.out.println("请输入需要统计出现次数的字或词：");  
		                Scanner scan=new Scanner(System.in);
			            String str1= scan.next();
			            while(line.indexOf(str1)!=-1){
			                //检索键盘接收的字符串str，是否包含有字符串str1= " "，
			                //如果有则返回一个大于等于0的下标索引
			                //（这里注意是返回下标索引，下标索引是从0开始的），没有返回-1。
			            	int c=line.indexOf(str1);
			            	line=line.substring(c+str1.length());
			            	count++;
			            }
			            output0.write("字符“"+str1+"”出现的次数为："+count+"\r\n");
		            }
		            
		            
	        output0.flush();
	        output0.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

