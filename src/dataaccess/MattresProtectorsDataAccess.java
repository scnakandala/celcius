package dataaccess;

import celcius.Config;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MattresProtectorsDataAccess {

    private static Connection connect;
    private static Statement statement;
    private static MattresProtectorsDataAccess instance;
    private ResultSet resultSet;

    private MattresProtectorsDataAccess() throws SQLException {
        connect = (Connection) DriverManager.getConnection(Config.connectionString);

    }

    public static MattresProtectorsDataAccess getInstance() throws SQLException {
        if (MattresProtectorsDataAccess.instance == null) {
            MattresProtectorsDataAccess.instance = new MattresProtectorsDataAccess();
        }
        return MattresProtectorsDataAccess.instance;
    }

    public String[] getProductRanges() throws SQLException {
        return new String[]{"Classic", "Super"};
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
        resultSet = statement.executeQuery("select name from celcius.fabrics where " + range + " = true");
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
        resultSet = statement.executeQuery("select distinct name from celcius.paddings");
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

    public String[] getTaffataTypes() throws SQLException {
        statement = (Statement) connect.createStatement();
        resultSet = statement.executeQuery("select distinct name from celcius.taffatas");
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

    public String[] getMettressProtectorSizes() throws SQLException {
        statement = (Statement) connect.createStatement();
        resultSet = statement.executeQuery("select size from celcius.mattresprotectors");
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

    public Double getMaterialPrice(String material) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.fabrics where name ='" + material + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getPaddingPrice(String type) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.paddings where name ='" + type + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getTaffataPrice(String type) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.taffatas where name ='" + type + "'";
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
        String sql = "select smv from celcius.mattresprotectors where size ='" + size + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("smv"));
    }

    public Double getLableCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Lable'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getZipperHeadCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Zipper Head'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getZipperCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Zipper'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getTransparentSheetCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Transparent Sheet'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getTagCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Tag'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getThreadCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Thread'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getElasticCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Elastic'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getPipingCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Piping'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getNonWovenCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='Non Woven'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("price"));
    }

    public Double getPEBagCost() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select price from celcius.mattresprotector_accessories where name ='PE Bag'";
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

    //This method is used to get smv x,y pairs to find a regression model for fi
    //nding smv values for custom sizes
    public double[][] getSMVXYPairs() throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select size,smv from celcius.mattresprotectors";
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
            arr[0][i+1] = Double.parseDouble(sizes.get(i).split("X")[0])
                    + Double.parseDouble(sizes.get(i).split("X")[1]);
            arr[1][i+1] = smvs.get(i);
        }
        return arr;
    }

    public Double getTaffataWidth(String taffataType) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select width from celcius.taffatas where name ='" + taffataType + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("width"));
    }

    public Double getPaddingWidth(String paddingType) throws SQLException {
        statement = (Statement) connect.createStatement();
        String sql = "select width from celcius.paddings where name ='" + paddingType + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return Double.parseDouble(resultSet.getString("width"));
    }
}
