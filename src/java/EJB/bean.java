/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import java.security.MessageDigest;
import javax.inject.Named;

@Named(value="bean")
@Stateless
public class bean {
    public String hashFunction="";
    public String newText="";

    public String getHashFunction() {
        return hashFunction;
    }

    public void setHashFunction(String hashFunction) {
        this.hashFunction = hashFunction;
    }

    public String getNewText() {
        return newText;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }
    
    public String generateHash(String text){
        //computing message digest
        MessageDigest md = new BLAKE512();
        md.update(text.getBytes());
        byte[] digest = md.digest();
        //converting byte array to hexString
        StringBuffer hexString = new StringBuffer();
        for(int i = 0; i<digest.length;i++){
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        String HashHex = hexString.toString();
        setNewText(text);
        setHashFunction(HashHex);
        return HashHex;
    }
    
}
