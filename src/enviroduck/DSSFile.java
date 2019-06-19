package enviroduck;

import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecPairedData;
import hec.heclib.dss.HecTimeSeries;
import hec.hecmath.DSS;

public class DSSFile
{
    public DSSFile(java.io.File lastFile, String[] stageDataStr, javax.swing.JTable jStageTable, javax.swing.table.DefaultTableModel stagePathsModel)
    {
        this.lastFile = lastFile;
        this.stageDataStr = stageDataStr;
        this.jStageTable = jStageTable;
        this.stagePathsModel = stagePathsModel;

        // close the old time series if one exists
        closeDSSFile();

        // make a new time series
        ts = new HecTimeSeries();
        pd = new HecPairedData();

        // open the interfaces to the dss file
        ts.setDSSFileName(lastFile.getAbsolutePath(),true);
        pd.setDSSFileName(lastFile.getAbsolutePath(),true);
    }

    public void loadDSSFile()
    {
        // close the old time series if one exists
        closeDSSFile();

        // make a new time series
        ts = new HecTimeSeries();
        pd = new HecPairedData();

        // open the interfaces to the dss file
        ts.setDSSFileName(lastFile.getAbsolutePath(),true);
        pd.setDSSFileName(lastFile.getAbsolutePath(),true);


        for (int j = 0; j < stageDataStr.length; ++j) {

            CondensedReference[] cr = ts.getCondensedCatalog("/*/*/"+stageDataStr[j]+"/*/*/*/");

            for (int i = 0; i < cr.length; i++) {
                CondensedReference r = cr[i];
                stagePathsModel.addRow(r.toString().substring(1).split("/"));
            }
        }

        jStageTable.clearSelection();

        if ( jStageTable.getRowCount() > 0)
        {
            jStageTable.addRowSelectionInterval(0,0);
        }
    }

    public void closeDSSFile()
    {
        if ( ts != null )
        {
            // tell the dss library that io with this file is done
            ts.done();

            //c lose the file
            ts.close();

            // remove the reference
            ts = null;
        }

        if ( pd != null )
        {
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

    public void CreateStageDataStrings()
    {
        for (int j = 0; j < stageDataStr.length; ++j) {

            CondensedReference[] cr = ts.getCondensedCatalog("/*/*/"+stageDataStr[j]+"/*/*/*/");

            for (int i = 0; i < cr.length; i++) {
                CondensedReference r = cr[i];
                stagePathsModel.addRow(r.toString().substring(1).split("/"));
            }
        }

        jStageTable.clearSelection();

        if ( jStageTable.getRowCount() > 0)
        {
            jStageTable.addRowSelectionInterval(0,0);
        }
    }

    public HecTimeSeries ts;
    public HecPairedData pd;
    private java.io.File lastFile;
    private String[] stageDataStr;
    private javax.swing.JTable jStageTable;
    private javax.swing.table.DefaultTableModel stagePathsModel;
}
