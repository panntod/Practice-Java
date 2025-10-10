// Kontrak utama: semua DB harus bisa connect, disconnect, dan executeQuery
interface DatabaseConnection {
    void connect();

    void disconnect();

    void executeQuery(String query);
}

// Implementasi MySQL
class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL Database...");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL Database...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing on MySQL: " + query);
    }
}

// Implementasi PostgreSQL
class PostgreSQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL Database...");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL Database...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing on PostgreSQL: " + query);
    }
}

// Implementasi MongoDB
class MongoDBConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB Database...");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MongoDB Database...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing on MongoDB: " + query);
    }
}

// Factory untuk membuat koneksi (agar fleksibel)
class DatabaseFactory {
    public static DatabaseConnection getDatabase(String type) {
        switch (type.toLowerCase()) {
            case "mysql":
                return new MySQLConnection();
            case "postgresql":
                return new PostgreSQLConnection();
            case "mongodb":
                return new MongoDBConnection();
            default:
                throw new IllegalArgumentException("Database type not supported!");
        }
    }
}

public class DatabaseOOP {
    public static void main(String[] args) {
        // User tinggal pilih DB lewat factory
        DatabaseConnection db = DatabaseFactory.getDatabase("mysql");
        db.connect();
        db.executeQuery("SELECT * FROM users");
        db.disconnect();

        System.out.println("----");

        DatabaseConnection db2 = DatabaseFactory.getDatabase("mongodb");
        db2.connect();
        db2.executeQuery("{ find: 'users' }");
        db2.disconnect();
    }

    

}

