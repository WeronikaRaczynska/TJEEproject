
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style/css/styles.css">
        <title>Edit</title>
    </head>
    <body>
        <div id="baner">
            <h1>PAGE FOR EDITING TABLE</h1>              
        </div>
        <div id="delete">
            <form>
                    <h3>DELETE</h3>
                    <input class="intext" name="Del" placeholder="Text" value="text"  maxlength="20"><br/>
                    <input class="insubmit" type="submit" value="Delete"  maxlength="125" formaction="./Delete"/>
            </form>
        </div>
        <div id="update">       
            <form>
                    <h3>UPDATE</h3>
                    <input class="intext" name="Text" placeholder="Text" value="text" maxlength="20"><br/>
                    <input class="intext" name="Hash" placeholder="Hash" value="hash" maxlength="124"><br/>
                    <input class="insubmit" type="submit" value="Update" formaction="./Update"/>
            </form>
        </div>
    </body>
</html>
