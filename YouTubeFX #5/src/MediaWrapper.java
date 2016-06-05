import java.io.*;
import java.awt.*;

public class MediaWrapper {
    static String decoded;
    static public boolean doSomething() {

        String[] exeCmd = {"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe", "-i", "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\short.avi", "-r", "24", "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\output.avi"};//, "-i", "short.avi" ,"-acodec", "copy", "-vcodec", "copy", "outputFile.avi"};




        ProcessBuilder pb = new ProcessBuilder(exeCmd);
        boolean exeCmdStatus = executeCMD(pb);

       return exeCmdStatus;
    }

    static private boolean executeCMD(ProcessBuilder pb)
    {
        pb.redirectErrorStream(true);
        Process p = null;
        byte[] b=new byte[999999];
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
            for (int i=1; i<10; i++) {
                p.getInputStream().read(b);
                decoded = new String(b);
                System.out.println(decoded);

                p.getErrorStream().read(b);
                decoded = new String(b);
                System.out.println(decoded);
            }
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
    public static void main (String args [])
    {
       /* Runtime rt = Runtime.getRuntime();
        //rt.exec("cmd.exe /c cd \""+new_dir+"\" & start cmd.exe /k \"java -flag -flag -cp terminal-based-program.jar\"");
        try {rt.exec("cmd.exe /c cd \"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\" & start cmd.exe /k \"C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe -i short.avi -r 24 output.avi\"");}//, "C:\\Users\\Wovch\\Desktop\\Player\\YouTubeFX #5\\ffmpeg.exe -i short.avi -r 24 output.avi"});}// /c cd \""+new_dir+"\" & start cmd.exe /k \"java -flag -flag -cp terminal-based-program.jar\"");
        catch (Exception e) { System.out.println("Error");};*/
        doSomething();
    }
}
