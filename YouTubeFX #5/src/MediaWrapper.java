import java.io.*;
import java.awt.*;
import java.util.Scanner;

public class MediaWrapper {
    static String currentp=null; // current path
    static public void execute(String[] exeCmd)
    {
        ProcessBuilder pb = new ProcessBuilder(exeCmd);
        pb.redirectErrorStream(true);
        Process p = null;
        try {
            p = pb.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
            p.destroy();
            return;
        }
        // wait until the process is done
        try {
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
           /* OutputStream s = p.getOutputStream();
            String str = new String("y");
            s.write(str.getBytes());*/
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
            p.destroy();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public static void main (String args [])
    {
       /* Runtime rt = Runtime.getRuntime();
        //rt.exec("cmd.exe /c cd \""+new_dir+"\" & start cmd.exe /k \"java -flag -flag -cp terminal-based-program.jar\"");
        try {rt.exec("cmd.exe /c cd \"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\" & start cmd.exe /k \"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe -i short.avi -r 24 output.avi\"");}//, "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe -i short.avi -r 24 output.avi"});}// /c cd \""+new_dir+"\" & start cmd.exe /k \"java -flag -flag -cp terminal-based-program.jar\"");
        catch (Exception e) { System.out.println("Error");};*/
        String cd=new File(".").getAbsolutePath(); // Пока в мейне. Потом переедет в кнструктор
        currentp=cd.substring(0, cd.length()-1);   // Пока в мейне. Потом переедет в кнструктор
        plus (new String (), new String ());
    }
    static String decoded;
    static public boolean doSomething() {

        String[] exeCmd = {"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe", "-i", "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\short.avi", "-r", "24", "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\output.avi"};//, "-i", "short.avi" ,"-acodec", "copy", "-vcodec", "copy", "outputFile.avi"};
        execute (exeCmd);



        ProcessBuilder pb = new ProcessBuilder(exeCmd);
        boolean exeCmdStatus = executeCMD(pb);

       return exeCmdStatus;
    }

    static private boolean executeCMD(ProcessBuilder pb)
    {
        pb.redirectErrorStream(true);
        Process p = null;
        byte[] b=new byte[99999];
        try {
            p = pb.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
            p.destroy();
            return false;
        }
// wait until the process is done
        try {


            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            InputStream eis = p.getErrorStream();
            InputStreamReader eisr = new InputStreamReader(eis);
            BufferedReader ebr = new BufferedReader(eisr);
            while ((line = ebr.readLine()) != null) {
                System.out.println(line);
            }


           /* for (int i=1; i<10; i++) {
                p.getInputStream().read(b);
                decoded = new String(b);
                System.out.println(decoded);

                b=new byte[999999];
                p.getErrorStream().read(b);
                decoded = new String(b);
                Scanner sc=new Scanner (System.in);
                sc.next ();
                //System.out.println("aasdf");
                System.out.println(decoded);
            }*/

            OutputStream s=p.getOutputStream();
            String str=new String ("y");
            System.out.println ("wrote");
            s.write (str.getBytes());

            System.out.println ("wrote");

            p.getInputStream().read (b);
            decoded = new String(b);
            System.out.println (decoded);

            p.getErrorStream().read (b);
            decoded = new String(b);
            System.out.println (decoded);
            p.waitFor();

            Thread.sleep(4000);

            p.getInputStream().read (b);
            decoded = new String(b);
            System.out.println (decoded);

            p.getErrorStream().read (b);
            decoded = new String(b);
            System.out.println (decoded);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error");
            p.destroy();
            return false;
        }
        catch (Exception e) {};
        return true;
    }


    static public void cut(String begin, String end)
    {
        String[] exeCmd = {"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe", "-i", "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\short.mp3", "-ss", "00:00:02", "-t", "00:00:03", "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\output.mp3"};
        ProcessBuilder pb = new ProcessBuilder(exeCmd);
        pb.redirectErrorStream(true);
        Process p = null;
        try {
            p = pb.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
            p.destroy();
            return;
        }
// wait until the process is done
        try {
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            /*OutputStream s = p.getOutputStream();
            String str = new String("y");
            s.write(str.getBytes());*/
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
            p.destroy();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

    }

    static public void plus(String begin, String end) // видео+аудио
    {
       // *.mkv? *.wav?
        String[] exeCmd = {currentp+ "ffmpeg", "-y",  "-i", currentp+"short.mp3",  "-ss", "0:0:5", "-i", currentp+"short.mpeg", currentp+"output.mpeg"};

        execute (exeCmd);
        String[] exeCmd2 = {currentp+ "ffmpeg", "-y",  "-t", "0:0:5", "-i", "short.mpeg", "-map", "0:0",  currentp+"tmp.mpeg"};
        execute (exeCmd2);
        String[] exeCmd3 = {currentp+ "ffmpeg", "-y",  "-i", "\"concat:"+currentp+"tmp.mpeg|"+currentp+"output.mpeg\"",  "-c", "copy", currentp+"output2.mpeg"};
        execute (exeCmd3);



    }
}