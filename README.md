# WorkIdeal
### 计 G202 刘凯丽 2020322095
## 实验报告
### 一、实验目的
* 掌握字符串String及其方法的使用
* 掌握文件的读取/写入方法
* 掌握异常处理结构
### 二、业务要求
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。<br/>
>文件A包括两部分内容：
>>* 一是学生的基本信息；<br/>
>>* 二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：<br/>
1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”<br/>
2.允许提供输入参数，统计古诗中某个字或词出现的次数<br/>
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A<br/>
4.考虑操作中可能出现的异常，在程序中设计异常处理程序<br/>

**输入：** 汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续><br/>
**输出：**
汉皇重色思倾国，御宇多年求不得。<br/>
杨家有女初长成，养在深闺人未识。<br/>
天生丽质难自弃，一朝选在君王侧。<br/>
回眸一笑百媚生，六宫粉黛无颜色。<br/>
春寒赐浴华清池，温泉水滑洗凝脂。<br/>
侍儿扶起娇无力，始是新承恩泽时。<br/>
云鬓花颜金步摇，芙蓉帐暖度春宵。<br/>
春宵苦短日高起，从此君王不早朝。<br/>
…………<br/>
### 三、实验要求
* 设计学生类（可利用之前的）；<br/>
* 采用交互式方式实例化某学生；<br/>
* 设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。<br/>
### 四、实验过程
1.新建CreateStudent类，用于实现学生基本信息，我是自定义给学生赋予了学号、姓名、性别、专业这四个属性。<br/>

      int xuehao;
      String name,major,sex;
      
2.在CreateStudent类中定义SubmitWork()方法，即提交作业的方法。在此方法中使用Scanner构造器来实现键盘输入以及学生信息的获取，并且在此方法中使用Filewriter来创建一个txt文件TextA，将学生信息写入TextA中。

     Scanner sc=new Scanner(System.in);
     FileWriter fw=new FileWriter("E:\\abc\\ceshi\\TextA.txt");
     System.out.println("学号："); 
     xuehao=sc.nextInt();
     fw.write("学号："+String.valueOf(xuehao)+"\r\n");
     
> * 若写入int型数据一次只能写进去一个 需要将其转化成String类型。
     
3.新建CreateFiles类。在此类中写createFileB()方法用来新建txt文件TextB，并使用BufferedWriter将文本写入字符输出流，最终将内容写进TextB文件中。<br/>

     String path= "E:\\abc\\ceshi"; //所创建文件的路径 
     String fileName = "TextB.txt"; //文件名及类型 
     File file1 = new File("E:\\abc\\ceshi", "TextB.txt"); 
     
4.在CreateFiles类中写一个readFile()方法，读取txt文件TextB并且将其写入另一个txt文件TextA中，且不能覆盖原来文件内容。<br/>

    output0=new BufferedWriter(new OutputStreamWriter(
		                		new FileOutputStream(file0, true )));
                        
5.在CreateFiles类中的readFile()方法里继续使用for循环语句，实现每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”<br/>

     char[] str=line.toCharArray();
  
> *  注意将字符串转数组。

6.在CreateFiles类中的readFile()方法里继续实现统计某个字或词出现的次数使用while语句检索键盘接收的字符串str，并将检索到的次数写入TextA中。<br/>

    Scanner scan=new Scanner(System.in);
	  String str1= scan.next();
    output0.write("字符“"+str1+"”出现的次数为："+count+"\r\n"); 
7.在CreateStudent类中的SubmitWork()方法里接收完学生输入的信息之后，便可通过键盘键入需要提交的作业文件名TextB，此时实例化CreateFiles类的一个对象cr作为CreateStudent类的一个成员变量，通过cr调用createFileB()以及readFile()方法来提交文件。<br/>

     CreateFiles cr=new CreateFiles();

    if(n.equals("TextB")){
     cr.createFileB();
     cr.readFile();  
     System.out.println("提交成功！（可在TextA文件中查阅批改信息）"); }
     
> * 由于作业以保存在TextB中所以必须提交TextB，否则需重新提交作业。

    else{
       System.out.println("文件提交错误！请重新运行程序！");   }
       
8.由于CreateFiles类中的readFile()方法里写有可查询某字或某次出现次数的方法，所以学生提交作业后还可继续在键盘键入需要查询的字或词，做终会一同显示在Text文件A中。<br/>
 
    System.out.println("请输入需要统计出现次数的字或词：");  
	
9.新建Test测试类，在此类中实例化一个CreateStudent类的对象st，让其调用SubmitWork()方法，整个程序得以实现。<br/>

     CreateStudent st=new CreateStudent();
         st.SubmitWork();
         
### 五、核心代码
1.实现每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”

           for(char hz:str){
		                	output0.write(hz);       	
		                	if(i%7==0&&i%14!=0)
		                	output0.write(",");
		                	if(i%14==0)
		                 	output0.write("。"+"\r\n");
		                	i++;
		                }
 
 2.实现统计某个字或词出现的次数。<br/>
 
     while(line.indexOf(str1)!=-1){ 
			            	int c=line.indexOf(str1);
			            	line=line.substring(c+str1.length());
			            	count++;
			            }
                  
> * 检索键盘接收的字符串str，是否包含有字符串str1= " "，如果有则返回一个大于等于0的下标索引（这里注意是返回下标索引，下标索引是从0开始的），没有返回-1。

3.使用try{}catch(){},来控制学生键盘键入时必须是int型数据。<br/>

		catch(Exception e){
        	 System.out.println("格式错误，重新开始！");  
    	  }
	  
### 六、系统运行截图
![images](https://github.com/G202liukaili/WorkIdeal/blob/main/images/homework.jpg)
### 七、实验感想
1.本次实验是做的最完整的一次，所有功能均已实现。<br/>
2.一开始向TextA文件中写入定义为int型学号的时候老是失败，后来才知道通过字符流写入数据时int型数据一次只能写进去一个字符，只需使用String.valueOf(xuehao)将其转化成String类型就可写入。<br/>
3.最初向TextA中写入完学生基本信息之后，再读取另一个文件时的内容时，会将读取到的内容覆盖原来内容，后来发现在使用FileOutputStream(String name,boolean append)时,需要将append的值设为true，方可解决覆盖问题。<br/>
4.本次实验也加深了我对Scanner类的使用、try{}catch(){}、以及对于实例化类的运用。<br/>


