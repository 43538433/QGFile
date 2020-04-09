package File01;

/*
读取已有文件的指定行数的内容
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Demo01 {

    //读取文件指定行
    static void read(File sourceFile,int lineNumber) throws IOException {
        FileReader in=new FileReader(sourceFile);
        LineNumberReader reader=new LineNumberReader(in);
        String s="";
        if(lineNumber<=0||lineNumber>getTotalLines(sourceFile)){
            System.out.println("不在文件的总行数内！请重新输入：");
        }else {
            int lines = 0;
            while (s != null) {
                lines++;
                s = reader.readLine();
                if ((lines - lineNumber) == 0) {
                    System.out.println("文件在该行的内容为：");
                    System.out.println(s);
                }
            }
        }
        reader.close();
        in.close();
    }
    //文件内容的总行数
    static int getTotalLines(File file) throws IOException {
        FileReader in=new FileReader(file);
        LineNumberReader reader=new LineNumberReader(in);
        String s=reader.readLine();
        int lines=0;
        while(s!=null){
            lines++;
            s=reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
    //读取文件指定行
    public static void main(String[] args) throws IOException {

        File sourceFile=new File("G:/Demo01.txt");

        if(!sourceFile.exists()){
            System.out.println("文件不存在，请先创建文件！");
            System.exit(0);
        }

        System.out.println("文件的总行数为"+getTotalLines(sourceFile));
        boolean flag=true;
        while(flag) {
            System.out.println("请输入需要读取文件的行数：(输入为“0”时退出程序)");
            //指定行数
            Scanner in = new Scanner(System.in);
            int lineNumber = in.nextInt();
            if(lineNumber==0){
                System.out.println("程序退出！");
                System.exit(0);
            }
            //读取指定行
            read(sourceFile, lineNumber);
        }
    }
}
