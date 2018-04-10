
package finder2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FinderFiles {
private final ArrayList<File> FilesAll= new ArrayList<>();    

public String ext;

    public FinderFiles(String ext) {
        this.ext = ext;
    }


public void finderFiles(File file){ //поиск всей файлов txt
    File[] listFiles = file.listFiles(); 
    for (File lFile : listFiles) {
        if (lFile.isDirectory()) 
            finderFiles(lFile);
    }

    for (File lFile : listFiles) {
        if (lFile.isFile() && (lFile.getName().endsWith(ext))) 
            FilesAll.add(lFile);
    } 
}

public void printArray(){ //печать названия файлов и путь. Для проверки
    for (File file : FilesAll) {
        System.out.println(file.getName()+ " путь " + file.getAbsolutePath());
    }
}

public void sorting(){ //сортировка файлов по алфовиту
    FilesAll.sort(new Comparator<File>(){
        @Override
        public int compare(File o1, File o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
}

public void printText(){ //склеиваем текст из файлов и печатаем это содержимое
    StringBuilder sbAll= new StringBuilder();
    for (File file : FilesAll) {        
       BufferedReader br;
       StringBuilder sb = new StringBuilder();       
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Cp1251"));
            String line = br.readLine();
            while (line!=null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line=br.readLine();
            }          
        br.close();            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }
        sbAll.append(sb.toString());
    }    
    //записываем в файл
    try {
        FileWriter fw = new FileWriter("all.txt");
        fw.write(sbAll.toString());
        fw.close();
    } catch (IOException ex) {
        ex.getMessage();
    }
    //печатаем в консоле 
    System.out.println("Печатаем внутрености:");
    System.out.println(sbAll.toString());
    
    
}

}
