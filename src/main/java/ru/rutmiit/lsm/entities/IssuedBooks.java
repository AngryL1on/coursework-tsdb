package ru.rutmiit.lsm.entities;

public class IssuedBooks {
    private int bookID;
    private int memberID;
    private String issueTime;
    private int renewCount;

    public IssuedBooks(){

    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public void setRenewCount(Integer renewCount) {
        this.renewCount = renewCount;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public int getBookID() {
        return bookID;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public int getRenewCount() {
        return renewCount;
    }
}
