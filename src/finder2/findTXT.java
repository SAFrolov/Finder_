/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder2;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author s.frolov
 */
public class findTXT implements FilenameFilter{

    private String ext;
    
    public findTXT (String exp) {
        this.ext = exp.toLowerCase();
    }
   
    @Override
    public boolean accept(File dir, String name) {
        boolean flag = false;
        flag=name.toLowerCase().endsWith(ext);
        return flag; 
    }
    
}
