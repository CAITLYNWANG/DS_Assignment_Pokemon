package util;
import java.util.ArrayList;
import java.io.*;
public class ASCIIart {
    public static ArrayList<String> addASCIIArt(){
        ArrayList<String> asciiArts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String lineSeperator = System.lineSeparator();
        try(
                InputStream ips = new FileInputStream(Constants.ASCIIArtsPath);
                Reader isw = new InputStreamReader(ips);
                BufferedReader br = new BufferedReader(isw);
        ){
            String line;
            while ((line = br.readLine()) != null){
                if(line.equals(Constants.lineSeparatorBetweenArt)){
                    asciiArts.add(sb.toString());
                    sb = new StringBuilder();
                }
                else{
                    sb.append(line).append(lineSeperator);
                }
            }
            if(sb.length() > 0){//the last one hasnt been added
                asciiArts.add(sb.toString());
            }
        }catch (Exception e){
            System.out.println("Cannot Read ASCIIArts File.");
            e.printStackTrace();
        }
        return asciiArts;
    }
}

