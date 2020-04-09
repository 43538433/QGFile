package File02;

import java.io.*;
import java.util.Scanner;

/*
创建一个文件夹，在文件夹中增加文本，在控制台向文本添加内容更新并保存
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {

        Scanner input1 = new Scanner(System.in);
        System.out.println("请输入文件名称：（如：G:/Demo）");
        String str1 = input1.nextLine();
        File file = new File(str1);  //创建一个新文件夹
        checkDirExixts(file);        //检查文件是否存在

        System.out.println("请输入目录名：（如：aaa.txt）");
        String str2 = input1.nextLine();
        File f=new File(str1+"/"+str2);    //在该文件夹下创建一个txt文本
        f.createNewFile();
        System.out.println("目录创建成功！");
        System.out.println("请输入要保存到"+str1+"/"+str2+"的内容,当输入“end”时结束输入");
        userPrint(str1+"/"+str2);
        System.out.println("内容已保存到相应的文件，可根据路径到文件中查看！");
    }

    //向文件中添加内容并保存更新
    public static void userPrint(String filePath){
        BufferedReader br=null;
        BufferedWriter bw=null;
        try{
            br=new BufferedReader(new InputStreamReader(System.in));
            bw=new BufferedWriter(new FileWriter(filePath,true));//true表示是否追加
            String str=br.readLine();  //接收用户输入的信息
            while (!str.equals("end")){
                bw.write(str);   //将用户输入的字符串写入文件
                bw.newLine();    //换行
                bw.flush();      //刷新缓冲区，缓冲区的字符写入磁盘
                str=br.readLine();   //继续接收输入
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bw.close();//关闭对象前会调用bw.flush();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //判断文件夹是否存在
    public static void checkDirExixts(File file) throws IOException {
        if(file.exists()){
            if(file.isDirectory()){
                System.out.println("文件存在！");
            }else{
                System.out.println("同名文件存在，不能创建！");
            }
        }else{
            System.out.println("文件不存在，创建文件！");
            file.mkdirs();
        }
    }
}
