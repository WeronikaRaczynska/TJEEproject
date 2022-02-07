package restful;

import EJB.bean;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("newhash")
public class Hash {

    @Context
    private UriInfo context;

    @EJB
    bean newbean;
    public Hash() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postHtml(@FormParam("text") String t) {
        String hash=newbean.generateHash(t);
        return "<div style=\"height:100%; width:100%; position: relative; font-family: Chalkduster, fantasy; background-image: linear-gradient(144deg,#020024, #354550 50%,#020024);\">"
                +"<div style=\"text-align: center; border-radius: 50px; background-color:whitesmoke; position: absolute; height: 350px; width: 79%;padding:1%; top:30%; left:10%;\">"
                +"<h1 style=\"font-size: 3em;\">RESTful web service</h1>"
                +"<h3 style=\"font-size: 2em; word-break: break-all;\">Generated hash: "+hash+"</h3>"
                + "<form>"
                +"<input type=\"submit\" value=\"Back\" formaction=\"/Final1/\" "
                +"style=\"background-image: linear-gradient(144deg,#020024, #354550 50%,#020024);color:white; box-sizing:border-box; width:140px; padding: 19px 24px; border-radius: 8px; font-size: 20px;\">"
                +"</form></div></div>";
 
    }
}
