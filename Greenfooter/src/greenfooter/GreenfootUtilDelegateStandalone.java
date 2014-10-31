package greenfooter;

import bluej.Config;
import greenfoot.GreenfootImage;
import greenfoot.UserInfo;
import greenfoot.platforms.GreenfootUtilDelegate;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreenfootUtilDelegateStandalone implements GreenfootUtilDelegate {

    @Override
    public URL getResource(String relativeFileUri) {

        try {
            // Greenfoot have hardcoded it image path
            String absoluteFileUri = relativeFileUri.substring("images/".length());
            File absoluteFile = new File(absoluteFileUri);

            // If the relativeFileUri is a absoluteFileUri, then return that file
            if (absoluteFile.exists()) {
                return absoluteFile.toURI().toURL();
            }
            
            // We want to have the same splitter
            relativeFileUri = relativeFileUri.replace("/", "\\");
            
            // Get the current working path
            String path = new File(".").getAbsolutePath();
            
            // When using `new File(".")` it adds a "." to the end of the path
            path = path.substring(0, path.length() - 1);
            
            // Get the file uri
            String fileUri = path + relativeFileUri;

            // Get the file
            File file = new File(fileUri);

            // If the file exists then return it url
            if (file.exists()) {
                return file.toURI().toURL();
            }

            // Nothing have been return, so the file is not found
            throw new Exception("File not found {" + fileUri + "}");
        } catch (IOException ex) {
            Logger.getLogger(GreenfootUtilDelegateStandalone.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GreenfootUtilDelegateStandalone.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Iterable<String> getSoundFiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGreenfootLogoPath() {
        return "C:\\Users\\priva_000\\Documents\\CPH Business\\Datamatiker\\Greenfoot\\AngryBull\\images\\igloo.png";
    }

    @Override
    public void displayMessage(Component cmpnt, String string) {
        System.out.println(string);
    }

    @Override
    public boolean isStorageSupported() {
        return false;
    }

    @Override
    public UserInfo getCurrentUserInfo() {
        return null;
    }

    @Override
    public boolean storeCurrentUserInfo(UserInfo ui) {
        return false;
    }

    @Override
    public List<UserInfo> getTopUserInfo(int i) {
        return null;
    }

    @Override
    public GreenfootImage getUserImage(String string) {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public List<UserInfo> getNearbyUserInfo(int i) {
        return null;
    }

}
