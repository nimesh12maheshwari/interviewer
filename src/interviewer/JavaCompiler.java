/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Aayush
 */
public class JavaCompiler 
{
    String ans;
    String compileJavaFile(String filePath,String fileName)
    {
        ans="";
        String tmp="";
        String compileFileCommand = "javac " + filePath+"\\"+fileName;
        System.out.println(compileFileCommand);
        try
        {
            System.out.println("checkpoint2");
            tmp+="Compiling Java File\n";
            Process processCompile = Runtime.getRuntime().exec(compileFileCommand);
            BufferedReader brCompileRun = new BufferedReader(new InputStreamReader(processCompile.getErrorStream()));
            String outputCompile = brCompileRun.readLine();
            while (outputCompile != null)
            {
                ans+=outputCompile+"\n";
                tmp+=outputCompile+"\n";
                outputCompile = brCompileRun.readLine();
                System.out.println("checkpoint3");
            }
            System.out.println("checkpoint4");
        } 
        catch (Exception e)
        {
            System.out.println("Exception ");
            System.out.println(e.getMessage());
        }
       return tmp;
    }
    String runJavaFile(String dirPath) throws Exception
    {
        String smp="";
        if(ans!="")
        {
            return ans;
        }
        String filePath=dirPath+"\\input.c";
        int cnt=0,i;
        File file=new File(filePath);
        Scanner sc=new Scanner(file);
        while(sc.hasNext())
        {
            cnt++;
            sc.next();
        }
        String runFileCommand[]=new String[cnt+2];
        runFileCommand[0]="java";
        runFileCommand[1]="q1";
        file=new File(filePath);
        sc=new Scanner(file);
        for(i=2;i<=cnt+1 && sc.hasNext();i++)
        {
            runFileCommand[i]=sc.next();
        }
        smp+="Running Java File\n";
        ans+="Running Java File\n";
        Process processRun = Runtime.getRuntime().exec(runFileCommand);
        BufferedReader brResult = new BufferedReader(new InputStreamReader(processRun.getInputStream()));
        String outputRun = brResult.readLine();
        while(outputRun != null)
        {
            ans+=outputRun+"\n";
            smp+=outputRun+"\n";
            outputRun = brResult.readLine();
        }
        System.out.println(ans);
        return smp;
    }
    String compile_only()
    {
        String s="";
        String path = System.getProperty("user.dir");
        String fileName="q1.java";
        s=compileJavaFile(path,fileName);
         System.out.println("STRIGN RETURNED IS"+s+"---");
        return s; 
    }
    String run() throws Exception
    {
        String res="";
        String path = System.getProperty("user.dir");
        String s=compileJavaFile(path,"q1.java");
        res=runJavaFile(path);
        return res;
    }
}
