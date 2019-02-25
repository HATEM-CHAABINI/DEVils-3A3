/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author acer
 */
public class upload_pdf_khalil {
    public String upload(String fich) throws Exception {
         String FileName ="";
  HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpPost httppost = new HttpPost("http://localhost/pdf/upload.php");
        File file = new File(fich);
        MultipartEntity mpEntity = new MultipartEntity();
        ContentBody contentFile = new FileBody(file);
        mpEntity.addPart("userfile", contentFile);
        httppost.setEntity(mpEntity);
        System.out.println("executing request " + httppost.getRequestLine());
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity(); 
 
      //  String userHome=System.getProperty("user.home");
      
        if(!(response.getStatusLine().toString()).equals("HTTP/1.1 200 OK")){
            // Successfully Uploaded

        }
        else{
                             
   // Did not upload. Add your logic here. Maybe you want to retry.
        }
        System.out.println(response.getStatusLine());
         if (resEntity != null) {
            FileName = EntityUtils.toString(resEntity);
            System.err.println(FileName);
            //System.out.println(EntityUtils.toString(resEntity));
        }
        if (resEntity != null) {
            resEntity.consumeContent();
        }
        httpclient.getConnectionManager().shutdown();
        return "www/pdf/"+FileName;
    }
    
}
