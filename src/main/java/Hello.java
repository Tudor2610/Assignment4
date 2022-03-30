import java.sql.*;

public class Hello {
    static String connectionUrl = "jdbc:mysql://localhost:3306/customers";
    static String username = "root";
    static String password = "Constanta2001";
    static Connection connection;
    public static void getConnect() throws SQLException{
        connection =  DriverManager.getConnection(connectionUrl, username, password);
    }
    public static void main(String[] args) throws SQLException {
        getConnect();

//        insert(new Customer( "Ionel_a", "Popescu", "Ionel", "071111111", "Bd Iuliu Maniu",
//                "Bucuresti", "648723", "Romania"));
//        insert(new Customer("Ionel_b", "Popescu", "Ionel", "071111111", "Bd Iuliu Maniu",
//                "Bucuresti", "648723", "Romania"));
//        insert(new Customer( "Ionel_c", "Popescu", "Ionel", "071111111", "Bd Iuliu Maniu",
//                "Bucuresti", "648723", "Romania"));
//        insert(new Customer( "Ionel_d", "Popescu", "Ionel", "071111111", "Bd Iuliu Maniu",
//                "Bucuresti", "648723", "Romania"));
//        insert(new Customer("Ionel_e", "Popescu", "Ionel", "071111111", "Bd Iuliu Maniu",
//                "Bucuresti", "648723", "Romania"));
//        getAll();
        getById(7);
//        update(7, new Customer("AndreiIONESCU", "Ionescu", "Andrei", "072222222", "Sos Virtutii",
//                "Bucuresti", "568429", "Romania"));
//        getById(7);
        addOrder(new Order(new Date(2022, 1, 10), new Date(2022, 1, 12), "In progress", "Expected to arrive in 3 days", 7));
//        addOrder(new Order(new Date(2021, 10, 10), new Date(2021, 10, 12), "Delivered", "-", 7));
//        addOrder(new Order(new Date(2021, 11, 15), new Date(2022, 11, 17), "Delivered", "Very good review", 7));
//        viewOrders(7);


    }

    public static void viewOrders(int id) throws SQLException{
        if(getById(id)){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `orders` WHERE `customer_id` = ?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for(int i = 1; i<= resultSetMetaData.getColumnCount(); i++){
                    System.out.print(resultSetMetaData.getColumnName(i) + ": ");

                    switch (resultSetMetaData.getColumnType(i)){
                        case Types.INTEGER -> System.out.println(resultSet.getInt(i));
                        case Types.VARCHAR -> System.out.println(resultSet.getString(i));
                        case Types.DATE -> System.out.println(resultSet.getDate(i));
                    }
                }
                System.out.println();
            }
        }
    }

    public static void addOrder(Order order) throws SQLException{
        PreparedStatement psw = connection.prepareStatement("INSERT INTO `orders` (`order_date`, `shipped_date`, `status`, `comments`, `customer_id`) VALUES (?, ?, ?, ?, ?);");
//        psw.setInt(1, customer.getID());
        psw.setDate(1, order.getOrder_date());
        psw.setDate(2, order.getShipped_date());
        psw.setString(3, order.getStatus());
        psw.setString(4, order.getComments());
        psw.setInt(5, order.getCustomer_id());
        psw.execute();
    }


    public static void update (int id, Customer customer) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `customers` SET `username` = ?," +
                " `last_name` = ?, " +
                " `first_name` = ?," +
                "`phone` = ?, " +
                " `address` = ?,"+
                " `city` = ?," +
                "`postalCode` = ?,"+
                " `country` = ? WHERE `id` = ?");

        preparedStatement.setString(1, customer.getUsername());
        preparedStatement.setString(2, customer.getLast_name());
        preparedStatement.setString(3, customer.getFirst_name());
        preparedStatement.setString(4, customer.getPhone());
        preparedStatement.setString(5, customer.getAddress());
        preparedStatement.setString(6, customer.getCity());
        preparedStatement.setString(7, customer.getPostalCode());
        preparedStatement.setString(8, customer.getCountry());
        preparedStatement.setInt(9, id);
        preparedStatement.executeUpdate();

    }

    public static boolean getById(int id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `customers` WHERE `id` = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + ": ");
                switch (resultSet.getMetaData().getColumnType(i)) {
                    case Types.INTEGER -> System.out.println(resultSet.getInt(i));
                    case Types.VARCHAR -> System.out.println(resultSet.getString(i));
                }
            }
            System.out.println();
            return true;
        }
        return false;
    }

    public static void getAll() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `customers`");

        while(resultSet.next()){
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for(int i = 1; i<= resultSetMetaData.getColumnCount(); i++){
                System.out.print(resultSetMetaData.getColumnName(i) + ": ");

                switch (resultSetMetaData.getColumnType(i)){
                    case Types.INTEGER -> System.out.println(resultSet.getInt(i));
                    case Types.VARCHAR -> System.out.println(resultSet.getString(i));
                }
            }
            System.out.println();
        }
    }

    public static void delete(int id) throws SQLException {
        PreparedStatement psw = connection.prepareStatement("DELETE FROM `customers` WHERE `id` = ?");
        psw.setInt(1, id);
        psw.execute();
    }


    public static void insert(Customer customer) throws SQLException {
        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalCode`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
//        psw.setInt(1, customer.getID());
        psw.setString(1, customer.getUsername());
        psw.setString(2, customer.getLast_name());
        psw.setString(3, customer.getFirst_name());
        psw.setString(4, customer.getPhone());
        psw.setString(5, customer.getAddress());
        psw.setString(6, customer.getCity());
        psw.setString(7, customer.getPostalCode());
        psw.setString(8, customer.getCountry());
        psw.execute();
    }
}
