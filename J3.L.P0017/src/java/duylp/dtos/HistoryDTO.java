/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.dtos;

import java.sql.Timestamp;

/**
 *
 * @author Le Phuoc Duy
 */
public class HistoryDTO {
    
    private Timestamp historyDate;
    private int historyRank;
    private String userID;

    public HistoryDTO(Timestamp historyDate, int historyRank) {
        this.historyDate = historyDate;
        this.historyRank = historyRank;
    }

    public HistoryDTO(Timestamp historyDate, int historyRank, String userID) {
        this.historyDate = historyDate;
        this.historyRank = historyRank;
        this.userID = userID;
    }
    
    public Timestamp getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Timestamp historyDate) {
        this.historyDate = historyDate;
    }

    public int getHistoryRank() {
        return historyRank;
    }

    public void setHistoryRank(int historyRank) {
        this.historyRank = historyRank;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
