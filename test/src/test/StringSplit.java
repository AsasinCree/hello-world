package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;



public class StringSplit {
public static void main(String[] args) {
	int lastIndexBeforeName = 0;
String iconUrl = "http://192.168.50.6:8080/image_appuser\\20160825142424128_lala4.jpg";
System.out.println(iconUrl);
//if(iconUrl.lastIndexOf("/") > lastIndexBeforeName)
//	lastIndexBeforeName = iconUrl.lastIndexOf("/"); x
//if(iconUrl.lastIndexOf() > lastIndexBeforeName)
//		lastIndexBeforeName = iconUrl.lastIndexOf("\\");
//System.out.println(iconUrl.substring(iconUrl.lastIndexOf("/") + 1, iconUrl.lastIndexOf(".")));
//}
if(iconUrl.lastIndexOf("/") > lastIndexBeforeName)
	lastIndexBeforeName = iconUrl.lastIndexOf("/"); 
if(iconUrl.lastIndexOf("\\") > lastIndexBeforeName)
	lastIndexBeforeName = iconUrl.lastIndexOf("\\");
System.out.println( iconUrl.substring(lastIndexBeforeName + 1, iconUrl.length()));

}
}
