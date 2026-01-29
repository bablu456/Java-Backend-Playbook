import javax.xml.crypto.Data;

public class DatabaseConnection {

    private static volatile DatabaseConnection instance;

    private String connectionString;

    private DatabaseConnection(){
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println(" Connected to DataBase! ");
    }

    public static DatabaseConnection getInstance(){
        if(instance == null ){
            synchronized (DatabaseConnection.class){
                if(instance == null){
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    public void executeQuery(String query){
        System.out.println("Executing: "+query);
    }
}

class MainApp{
    public static void main(String[] args){
        DatabaseConnection db1 = DatabaseConnection.getInstance();

        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Are both object same? "+(db1 == db2));
    }
}
