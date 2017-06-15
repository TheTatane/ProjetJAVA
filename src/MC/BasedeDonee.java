package MC;

import java.sql.*;

/**
 * Created by steph on 15/06/2017.
 */
public class BasedeDonee {
    private Connection connection=null;

    public BasedeDonee(){
    }

    public void connect(){
        try {
            String url = "jdbc:mysql://www.budbud.ovh:3306/iatic3";
            Class.forName ("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "iatic3", "iatic3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Add_player(String pseudo) throws SQLException {
        connect();
        try{
            Statement stmt = connection.createStatement();
            String sql_add="INSERT INTO Joueur (`Pseudo`, `NbWin`, `NbLoose`) VALUES ('"+pseudo+"',0,0);";
            stmt.executeUpdate(sql_add);
        }catch (Exception e){
            e.printStackTrace();
        }
        connection.close();
    }
    public boolean playerexist(String name) throws SQLException {
        connect();
        try{
            Statement stmt =connection.createStatement();
            String sql="SELECT Pseudo FROM Joueur WHERE Pseudo ='"+ name+ "';" ;
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                connection.close();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        connection.close();
        return false;
    }

    public void updateWin(String name){
        connect();
        try{
            int nb=0;
            Statement stmt=connection.createStatement();
            String sql="SELECT NbWin FROM Joueur WHERE Pseudo ='"+name+"';";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                nb=rs.getInt("NbWin");
                nb=nb+1;
            }
            String sql_update="UPDATE Joueur SET NbWin="+nb+" WHERE Pseudo='"+name+"'";
            stmt.executeUpdate(sql_update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLoose(String name){
        connect();
        try{
            int nb=0;
            Statement stmt=connection.createStatement();
            String sql="SELECT NbLoose FROM Joueur WHERE Pseudo ='"+name+"';";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                nb=rs.getInt("NbLoose");
                nb=nb+1;
            }
            String sql_update="UPDATE Joueur SET NbLoose="+nb+" WHERE Pseudo='"+name+"'";
            stmt.executeUpdate(sql_update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
