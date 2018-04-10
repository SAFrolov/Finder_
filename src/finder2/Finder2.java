
package finder2;

import java.io.File;

public class Finder2 {

    public static void main(String[] args) {
        
        String dir = "C:\\Programming\\00_Java\\NewProjects\\FolderForSearch";
        String ext = ".txt";
        
        File file = new File(dir);
        
        if(!file.exists()) 
            System.out.println("Папки не существует");
        else{
            FinderFiles ff = new FinderFiles(ext);
            ff.finderFiles(file); //находим все файлы в папке и подпапке
            ff.sorting();  //сортируем по алфовиту
            ff.printText(); //печатаем склееный текст из файлов
        }
    }
    
}
