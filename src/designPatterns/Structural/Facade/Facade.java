package designPatterns.Structural.Facade;

public class Facade {
    public static void connectToFetchTable() {
        DBConnection dbConnection = new DBConnection();
        dbConnection.connect();
        TableQuery tableQuery = new TableQuery();
        tableQuery.queryForFetching(dbConnection);

        ModifyContents modifyContents = new ModifyContents();
        modifyContents.modifyData();
    }
}
