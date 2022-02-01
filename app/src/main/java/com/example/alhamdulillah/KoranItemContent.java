package com.example.alhamdulillah;

public class KoranItemContent {
    private String title;
    private int pageNumber;

    public String getTitle() {
        return this.title;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public KoranItemContent(String title, int pageNumber) {
        this.title = title;
        this.pageNumber = pageNumber;
    }
}
