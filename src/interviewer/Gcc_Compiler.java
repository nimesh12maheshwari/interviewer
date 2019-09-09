/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewer;
import java.io.*;
import java.util.*;
/**
 *
 * @author Aayush
 */
public class Gcc_Compiler 
{
    String ans;
    String compileCFile(String filePath,String fileName)
    {
        ans="";
        String tmp="";
        String compileFileCommand = "gcc " + filePath+"\\"+fileName+" -o a.out";
        System.out.println(compileFileCommand);
        try
        {
            System.out.println("checkpoint2");
            tmp+="Compiling C File\n";
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
    String runCFile(String dirPath) throws Exception
    {
        String smp="";
        if(ans!="")
        {
            return ans;
        }
        String filePath=dirPath+"\\input.c";
        String arg_first=dirPath+"\\a.out";
        int cnt=0,i;
        File file=new File(filePath);
        Scanner sc=new Scanner(file);
        while(sc.hasNext())
        {
            cnt++;
            sc.next();
        }

        String runFileCommand[]=new String[cnt+1];
        runFileCommand[0]=arg_first;
        file=new File(filePath);
        sc=new Scanner(file);
        for(i=1;i<=cnt && sc.hasNext();i++)
        {
            runFileCommand[i]=sc.next();
        }
        smp+="Running C File\n";
        ans+="Running C File\n";
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
        String fileName="q1.c";
        s=compileCFile(path,fileName);
         System.out.println("STRIGN RETURNED IS"+s);
        return s; 
    }
    String run() throws Exception
    {
        String res="";
        String path = System.getProperty("user.dir");
        String s=compileCFile(path,"q1.c");
        res=runCFile(path);
        return res;
    }
}
