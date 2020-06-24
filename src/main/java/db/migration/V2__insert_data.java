package db.migration;

import com.opencsv.CSVReader;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;

public class V2__insert_data extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        FileReader dataFile = new FileReader(
                getClass().getClassLoader().getResource("db/migration/init_data.csv")
                        .getPath());

        CSVReader reader = null;
        reader = new CSVReader(dataFile);
        String[] line;

        reader.readNext(); // skip header line

        try (Statement statement = context.getConnection().createStatement()) {
            while ((line = reader.readNext()) != null) {
//                System.out.println("Country [id= " + line[0] + ", str1= " + line[1] + " , name=" + line[2] + "]");
                insertLine(statement, line);
            }
        }
    }

    private void insertLine(Statement statement, String[] row) throws SQLException {
        String insertSql = String.format("insert into product (id, product_name, position, store_department)" +
                        " values(%s, '%s', '%s', '%s')",
                row[0], row[1], row[2], row[3]);
        statement.execute(insertSql);

    }
}