package controller.Logowanie;

import controller.MainController;
import java.sql.ResultSet;


public class RejestracjaController {
    private MainController main;

    public void init(MainController main){
        this.main = main;

        try{
		ResultSet rs=  this.main.stmt.executeQuery("select * from filmy");
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
