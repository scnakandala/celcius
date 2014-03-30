package dataaccess;

import celcius.Config;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PillowProtectorDataAccess {

    private static Connection connect;
    private static Statement statement;
    private static PillowProtectorDataAccess instance;
    private ResultSet resultSet;

    private PillowProtectorDataAccess() throws SQLException {
        connect = (Connection) DriverManager.getConnection(Config.connectionString);

    }

    public static PillowProtectorDataAccess getInstance() throws SQLException {
        if (PillowProtectorDataAccess.instance == null) {
            PillowProtectorDataAccess.instance = new PillowProtectorDataAccess();
        }
        return PillowProtectorDataAccess.instance;
    }

    public String[] getProductRanges() throws SQLException {
        return new String[]{"Classic", "Super", "Other"};
    }

    public String[] getMaterialTypes() throws SQLException {
        statement = (Statement) connect.createStatement();
        resultSet = statement.executeQuery("select name from celcius.fabrics");
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("name"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }

    public String[] getMaterialTypes(String range) throws SQLException {
        statement = (Statement) connect.createStatement();
        if (range.equalsIgnoreCase("Classic") || range.equalsIgnoreCase("Super")) {
            resultSet = statement.executeQuery("select name from celcius.fabrics where " + range + " = true");
        } else {
            resultSet = statement.executeQuery("select name from celcius.fabrics");
        }
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("name"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }

    public String[] getPillowProtectorSizes() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select size from celcius.pillowprotectors";
        resultSet = statement.executeQuery(sql);
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("size"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }
    
    
    public String[] getTaffataTypes() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select name from celcius.taffatas";
        resultSet = statement.executeQuery(sql);
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("name"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }
    
    
    public String[] getPaddingTypes() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select name from celcius.paddings";
        resultSet = statement.executeQuery(sql);
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("name"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }

    public Double getMaterialPrice(String material) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.fabrics where name ='" + material + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getWidthShrinkage(String material) throws Exception {
        statement = (Statement) connect.createStatement();
        String sql = "select width_shrinkage from celcius.fabrics where name ='" + material + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("width_shrinkage"));
    }

    public Double getHeightShrinkage(String material) throws Exception {
        statement = (Statement) connect.createStatement();
        String sql = "select height_shrinkage from celcius.fabrics where name ='" + material + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("height_shrinkage"));
    }

    public Integer getMaterialWidth(String material) throws Exception {
        statement = (Statement) connect.createStatement();
        String sql = "select width from celcius.fabrics where name ='" + material + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Integer.parseInt(resultSet.getString("width"));
    }

    public Double getSMVValue(String size) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select smv from celcius.pillowprotectors where size ='" + size + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("smv"));
    }

    public Double getLableCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.pillowprotector_accessories where name ='Lable'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getTagCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.pillowprotector_accessories where name ='Tag'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getThreadCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.pillowprotector_accessories where name ='Tread'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getPEBagCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.pillowprotector_accessories where name ='PE Bag'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    
    public Double getZipperCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.pillowprotector_accessories where name ='Zipper'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    
    public Double getNonWovenCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.pillowprotector_accessories where name ='Non Woven'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getCostPerLabourMinute() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select value from celcius.parameters where name ='cost per labour minute'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("value"));
    }

    public Double getPOHValue() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select value from celcius.parameters where name ='POH per minute'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("value"));
    }

    public double[][] getSMVXYPairs() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select size,smv from celcius.pillowprotectors";
        resultSet = statement.executeQuery(sql);
        ArrayList<String> sizes = new ArrayList<String>();
        ArrayList<Double> smvs = new ArrayList<Double>();
        while (resultSet.next()) {
            sizes.add(resultSet.getString("size"));
            smvs.add(Double.parseDouble(resultSet.getString("smv")));
        }

        double[][] arr = new double[2][sizes.size() + 1];
        //smv value should be zero at 0
        arr[0][0] = arr[1][0] = 0.0;
        for (int i = 0; i < sizes.size(); i++) {
            arr[0][i + 1] = 2 * 3.141 * Double.parseDouble(sizes.get(i).split("X")[0])
                    + Double.parseDouble(sizes.get(i).split("X")[1]);
            arr[1][i + 1] = smvs.get(i);
        }
        return arr;
    }

    public String[] getFiberTypes() throws SQLException {
        statement = (Statement) connect.createStatement();
        resultSet = statement.executeQuery("select distinct name from celcius.fibers");
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("name"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }

    public String[] getFiberTypes(String range) throws SQLException {
        statement = (Statement) connect.createStatement();
        if (range.equalsIgnoreCase("Classic") || range.equalsIgnoreCase("Super")) {
            resultSet = statement.executeQuery("select distinct name from celcius.fibers where " + range.toLowerCase() + "=true");
        } else {
            resultSet = statement.executeQuery("select distinct name from celcius.fibers");
        }
        ArrayList<String> arr = new ArrayList<String>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("name"));
        }
        String[] arr2 = new String[arr.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }

    public Double getFiberPrice(String fiberType) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.fibers where name ='" + fiberType + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }
}
