package com.example.alhamdulillah;

public class KoranItemContent {
    private String title;
    private int numSure;
    private int pageNumber;

    public String getTitle() {
        return this.title;
    }

    public int getNumSure() {
        return this.numSure;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumSure(int numSure) {
        this.numSure = numSure;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public KoranItemContent(String title, int numSure, int pageNumber) {
        this.numSure = numSure;
        this.title = title;
        this.pageNumber = pageNumber;
    }
}
