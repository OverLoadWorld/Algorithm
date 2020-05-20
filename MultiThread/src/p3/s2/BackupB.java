package p3.s2;

public class BackupB extends Thread{
    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backUpB();
    }
}
