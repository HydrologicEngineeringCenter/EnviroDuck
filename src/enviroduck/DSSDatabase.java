package enviroduck;

import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecPairedData;
import hec.heclib.dss.HecTimeSeries;
import hec.heclib.util.HecTime;
import hec.hecmath.DSS;
import hec.io.TimeSeriesContainer;

import java.util.Arrays;

public class DSSDatabase {

    public HecTimeSeries ts;
    public HecPairedData pd;
    //public HecTime startTime;
    //public HecTime endTime;
    private String[] stageDataStr;
    private javax.swing.JTable jStageTable;
    private javax.swing.table.DefaultTableModel stagePathsModel;

    public String fileName;

    public DSSDatabase(String dssFileName, String[] stageDataStr, javax.swing.JTable jStageTable,
                       javax.swing.table.DefaultTableModel stagePathsModel) {
        this.fileName = dssFileName;
        this.stageDataStr = stageDataStr;
        this.jStageTable = jStageTable;
        this.stagePathsModel = stagePathsModel;

        // close the old time series if one exists
        closeDSSFile();

        // make a new time series
        ts = new HecTimeSeries();
        pd = new HecPairedData();

        // open the interfaces to the dss file
        ts.setDSSFileName(dssFileName, true);
        pd.setDSSFileName(dssFileName, true);
    }

    public void loadDSSFile() {
        // close the old time series if one exists
        closeDSSFile();

        // make a new time series
        ts = new HecTimeSeries();
        pd = new HecPairedData();

        // open the interfaces to the dss file
        ts.setDSSFileName(fileName, true);
        pd.setDSSFileName(fileName, true);


        for (int j = 0; j < stageDataStr.length; ++j) {

            CondensedReference[] cr = ts.getCondensedCatalog("/*/*/" + stageDataStr[j] + "/*/*/*/");

            for (int i = 0; i < cr.length; i++) {
                CondensedReference r = cr[i];
                stagePathsModel.addRow(r.toString().substring(1).split("/"));
            }
        }

        jStageTable.clearSelection();

        if (jStageTable.getRowCount() > 0) {
            jStageTable.addRowSelectionInterval(0, 0);
        }
    }

    public void closeDSSFile() {
        if (ts != null) {
            // tell the dss library that io with this file is done
            ts.done();

            //c lose the file
            ts.close();

            // remove the reference
            ts = null;
        }

        if (pd != null) {
            // tell the dss library that io with this file is done
            pd.done();

            //c lose the file
            pd.close();

            // remove the reference
            pd = null;
        }

        // clear the path display list
        stagePathsModel.setRowCount(0);
    }

    public void CreateStageDataStrings() {
        for (int j = 0; j < stageDataStr.length; ++j) {

            CondensedReference[] cr = ts.getCondensedCatalog("/*/*/" + stageDataStr[j] + "/*/*/*/");

            for (int i = 0; i < cr.length; i++) {
                CondensedReference r = cr[i];
                stagePathsModel.addRow(r.toString().substring(1).split("/"));
            }
        }

        jStageTable.clearSelection();

        if (jStageTable.getRowCount() > 0) {
            jStageTable.addRowSelectionInterval(0, 0);
        }
    }


    public void readTimeSeries(String currentPath, int exhaustionDays, int startYear,
                               String startDate, String stopDate) {

        String partD = startDate + (startYear);
        String path = GetRecordPath(currentPath,partD);

        // get the window start time
        HecTime startTime = new HecTime(partD);
        // set the time to 8 am
        startTime.increment(8,60);
        // set the window back exhaustionDays days
        startTime.increment(-exhaustionDays,1440);

        // get the window stop time
        String tmp = stopDate + (startYear);
        HecTime stopTime = null;
        if ( DifferentYears(partD, tmp) )
        {
            tmp = stopDate + (startYear+1);
            stopTime = new HecTime(tmp, "0800");
        } else
        {
            stopTime = new HecTime(tmp, "0800");
        }

        ts = new HecTimeSeries(fileName);

        ts.setPathname(path);
        //dssFile.startTime = startTime;
        //dssFile.endTime = stopTime;
        ts.setTimeWindow(startTime,stopTime);
        TimeSeriesContainer c = new TimeSeriesContainer();

        int status = ts.ztsRetrieve(c,ts.pathname(),
                startTime,stopTime,false,0);

    }

    /*
     check if ending month is in a different year that staring month
     */
    private static boolean DifferentYears(String startDate, String endDate) {
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        int startMonthIndex = -1;
        int endMonthIndex = -1;
        String startMonth = startDate.substring(2, 5);
        String endMonth = endDate.substring(2, 5);
        startMonthIndex = Arrays.asList(months).indexOf(startMonth);
        endMonthIndex = Arrays.asList(months).indexOf(endMonth);

        return startMonthIndex > endMonthIndex;
    }

    private static String GetRecordPath(String currentPath, String partD) {
        String path;
        int pos1, pos2;

        pos1 = currentPath.indexOf("/",1);    // 2nd /
        pos1 = currentPath.indexOf("/",pos1+1); // 3rd /
        pos1 = currentPath.indexOf("/",pos1+1); // 4th /
        pos2 = currentPath.indexOf("/",pos1+1); // 5th /

        // make the path for the current year
        path = currentPath.substring(0,pos1+1)+ partD+currentPath.substring(pos2);
        return path;
    }

}
