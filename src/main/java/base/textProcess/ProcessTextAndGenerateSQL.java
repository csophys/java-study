package base.textProcess;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by csophys on 16/2/25.
 */
public class ProcessTextAndGenerateSQL {

    public static final int COLUMN_COUNT_MAX = 10;
    public static final int ROWS_COUNT_MAX = 60000;
    public static int dbStartId = 1000;

    public static void main(String[] args) throws Exception {
        execute();
    }

    public static void execute() throws IOException {
        FileReader fileReader = new FileReader("/Users/csophys/Desktop/1.csv");
        FileWriter fileWriter = new FileWriter("/Users/csophys/Desktop/1.sql");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String newLine;
        int index = 0;
        CaseType[][] caseTypes = new CaseType[COLUMN_COUNT_MAX][ROWS_COUNT_MAX];
        int rows_count = 0, columns_count = 0;
        //1.保存到二维数组
        while ((newLine = bufferedReader.readLine()) != null) {
            String[] columns = newLine.split(";");
            columns_count = columns.length;
            for (int i = 0; i < columns.length; i++) {
                caseTypes[i][index] = new CaseType();
                caseTypes[i][index].setTypeValue(columns[i]);
            }
            index++;
            rows_count = index;
        }
        //2. 生成sql
        for (int i = 0; i < columns_count; i++) {
            fileWriter.append(generateSQL(caseTypes, rows_count, i, columns_count, 11));
        }

        //3. 保存到file
        fileWriter.flush();
        fileWriter.close();
    }

    private static String generateSQL(CaseType[][] caseTypes, int rows_count, int currentColumn, int column_count, Integer departmentId) {
        List<CaseType> caseTypeList = new ArrayList<CaseType>();
        StringBuffer sqlResult = new StringBuffer();
        for (int i = 0; i < rows_count; i++) {
            CaseType caseType = caseTypes[currentColumn][i];
            if (!caseTypeList.contains(caseType)) {
                dbStartId++;
                caseType.setId(dbStartId);
                if (currentColumn + 1 < column_count) {
                    //++ 在前在后有区别
                    caseTypes[currentColumn + 1][i].setParentId(dbStartId);
                }
                caseTypeList.add(caseType);
                sqlResult.append("INSERT INTO CSC_CaseType" +
                        "        (ID,AddTime, TypeCode, TypeValue, Rank, parentID, ParentTypeCode, departmentID) VALUES " +
                        "        (" + caseType.getId() + ",now()," + caseType.getId() + "," + caseType.getTypeValue() + ",100," + caseType.getParentId() + "," + caseType.getParentId() + "," + departmentId + ");").append("\n");
            }else{
                caseType.setId(dbStartId);
                if (currentColumn + 1 < column_count) {
                    caseTypes[currentColumn + 1][i].setParentId(dbStartId);
                }
            }
        }
        return sqlResult.toString();
    }


}

@Data
class CaseType {
    private int id;
    private int parentId;
    private String typeValue;

    public boolean equals(Object obj) {
        return (this.parentId == ((CaseType) obj).getParentId() && this.typeValue.equals(((CaseType) obj).getTypeValue()));
    }
}